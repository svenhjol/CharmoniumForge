package svenhjol.charmonium.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import svenhjol.charm.base.helper.DimensionHelper;
import svenhjol.charmonium.base.CharmoniumSounds;

import javax.annotation.Nullable;

public class EndAmbientSounds extends BaseAmbientSounds {
    public EndAmbientSounds(PlayerEntity player, SoundHandler soundHandler) {
        super(player, soundHandler);
    }

    public boolean isValid() {
        if (world == null) return false;
        return DimensionHelper.isEnd(world);
    }

    @Override
    public int getShortSoundDelay() {
        return world.rand.nextInt(300) + 300;
    }

    @Nullable
    @Override
    public SoundEvent getLongSound() {
        return CharmoniumSounds.AMBIENCE_END_LONG;
    }

    @Nullable
    @Override
    public SoundEvent getShortSound() {
        return CharmoniumSounds.AMBIENCE_END_SHORT;
    }

    @Override
    public float getShortSoundVolume() {
        return 0.45F;
    }

    @Override
    public float getLongSoundVolume() {
        return 0.35F;
    }
}
