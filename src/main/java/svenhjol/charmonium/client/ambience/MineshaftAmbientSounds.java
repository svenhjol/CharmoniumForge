package svenhjol.charmonium.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import svenhjol.charm.client.PlayerStateClient;
import svenhjol.charmonium.base.CharmoniumSounds;

import javax.annotation.Nullable;

public class MineshaftAmbientSounds extends BaseAmbientSounds {
    public MineshaftAmbientSounds(PlayerEntity player, SoundHandler soundHandler) {
        super(player, soundHandler);
    }

    @Override
    public boolean isValid() {
        if (world == null) return false;
        return PlayerStateClient.INSTANCE.mineshaft;
    }

    @Override
    public int getShortSoundDelay() {
        return world.rand.nextInt(500) + 320;
    }

    @Nullable
    @Override
    public SoundEvent getShortSound() {
        return CharmoniumSounds.AMBIENCE_MINESHAFT_SHORT;
    }
}
