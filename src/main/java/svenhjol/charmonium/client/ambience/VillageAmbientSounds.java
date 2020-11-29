package svenhjol.charmonium.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import svenhjol.charm.client.PlayerStateClient;
import svenhjol.charmonium.base.CharmoniumSounds;

import javax.annotation.Nullable;

public class VillageAmbientSounds extends BaseAmbientSounds {
    public VillageAmbientSounds(PlayerEntity player, SoundHandler soundHandler) {
        super(player, soundHandler);
    }

    @Override
    public boolean isValid() {
        if (world == null) return false;
        if (!world.canBlockSeeSky(player.getPosition())) return false;

        return PlayerStateClient.INSTANCE.village
            && PlayerStateClient.INSTANCE.isDaytime;
    }

    @Override
    public int getShortSoundDelay() {
        return world.rand.nextInt(500) + 320;
    }

    @Nullable
    @Override
    public SoundEvent getShortSound() {
        return CharmoniumSounds.AMBIENCE_VILLAGE_SHORT;
    }

    @Override
    public float getShortSoundVolume() {
        return super.getShortSoundVolume() - 0.1F;
    }
}
