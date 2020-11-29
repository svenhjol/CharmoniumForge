package svenhjol.charmonium.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import svenhjol.charm.base.CharmClientModule;
import svenhjol.charm.base.CharmModule;
import svenhjol.charmonium.client.ambience.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoundsClient extends CharmClientModule {
    public Handler handler;

    public SoundsClient(CharmModule module) {
        super(module);
    }

    @SubscribeEvent
    public void onPlayerJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof PlayerEntity
            && event.getWorld().isRemote) {
            trySetupPlayerSoundHandler((PlayerEntity)event.getEntity());
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END
            && event.player.world.isRemote
            && handler != null)
            handler.tick();
    }

    public void trySetupPlayerSoundHandler(PlayerEntity player) {
        // we only care about ClientPlayerEntity (the actual player) not RemoteClientPlayerEntity (other players relative to the actual player)
        if (player instanceof ClientPlayerEntity) {
            Minecraft mc = Minecraft.getInstance();
            handler = new Handler(player, mc.getSoundHandler());
        }
    }

    public static class Handler {
        private final PlayerEntity player;
        private final List<BaseAmbientSounds> ambientSounds = new ArrayList<>();

        public Handler(PlayerEntity player, SoundHandler soundHandler) {
            this.player = player;

            ambientSounds.addAll(Arrays.asList(
                new DeepAmbientSounds(player, soundHandler),
                new MineshaftAmbientSounds(player, soundHandler),
                new VillageAmbientSounds(player, soundHandler),

                new CaveAmbientSounds(player, soundHandler),
                new EndAmbientSounds(player, soundHandler),
                new HighAmbientSounds(player, soundHandler),

                new BeachAmbientSounds(player, soundHandler),
                new DesertAmbientSounds.Day(player, soundHandler),
                new DesertAmbientSounds.Night(player, soundHandler),
                new ExtremeHillsAmbientSounds.Day(player, soundHandler),
                new ExtremeHillsAmbientSounds.Night(player, soundHandler),
                new ForestAmbientSounds.Day(player, soundHandler),
                new ForestAmbientSounds.Night(player, soundHandler),
                new IcyAmbientSounds.Day(player, soundHandler),
                new IcyAmbientSounds.Night(player, soundHandler),
                new JungleAmbientSounds.Day(player, soundHandler),
                new JungleAmbientSounds.Night(player, soundHandler),
                new OceanAmbientSounds(player, soundHandler),
                new PlainsAmbientSounds.Day(player, soundHandler),
                new PlainsAmbientSounds.Night(player, soundHandler),
                new SavannaAmbientSounds.Day(player, soundHandler),
                new SavannaAmbientSounds.Night(player, soundHandler),
                new SwampAmbientSounds.Day(player, soundHandler),
                new SwampAmbientSounds.Night(player, soundHandler),
                new TaigaAmbientSounds.Day(player, soundHandler),
                new TaigaAmbientSounds.Night(player, soundHandler)
            ));
        }

        public void tick() {
            if (!player.isAlive() || player.world == null) return;
            ambientSounds.forEach(BaseAmbientSounds::tick);
        }
    }
}
