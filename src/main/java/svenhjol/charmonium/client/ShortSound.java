package svenhjol.charmonium.client;

import net.minecraft.client.audio.TickableSound;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import svenhjol.charm.mixin.accessor.TickableSoundAccessor;

public class ShortSound extends TickableSound {
    private final ClientPlayerEntity player;

    public ShortSound(ClientPlayerEntity player, SoundEvent sound, float volume) {
        super(sound, SoundCategory.AMBIENT);
        this.player = player;
        this.repeat = false;
        this.repeatDelay = 0;
        this.volume = volume;
        this.priority = true;
        this.global = true;
    }

    @Override
    public void tick() {
        if (!this.player.isAlive())
            ((TickableSoundAccessor)this).setDonePlaying(true);
    }
}
