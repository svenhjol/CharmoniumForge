package svenhjol.charmonium.iface;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;

import javax.annotation.Nullable;

public interface IAmbientSounds {
    ClientWorld getWorld();

    PlayerEntity getPlayer();

    SoundHandler getSoundHandler();

    boolean isValid();

    @Nullable
    default SoundEvent getLongSound() {
        return null;
    }

    @Nullable
    default SoundEvent getShortSound() {
        return null;
    }
}
