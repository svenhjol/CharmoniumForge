package svenhjol.charmonium.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import svenhjol.charm.base.helper.DimensionHelper;
import svenhjol.charmonium.base.CharmoniumSounds;

import javax.annotation.Nullable;

public class DeepAmbientSounds extends BaseAmbientSounds {
    public DeepAmbientSounds(PlayerEntity player, SoundHandler soundHandler) {
        super(player, soundHandler);
    }

    @Override
    public boolean isValid() {
        if (world == null || !DimensionHelper.isDimension(world, new ResourceLocation("overworld"))) return false;
        BlockPos pos = player.getPosition();
        int light = world.getLight(pos);
        return !world.canBlockSeeSky(pos) && pos.getY() <= 32 && light < 10;
    }

    @Override
    public int getShortSoundDelay() {
        return world.rand.nextInt(400) + 1000;
    }

    @Override
    public float getLongSoundVolume() {
        return 0.65F;
    }

    @Nullable
    @Override
    public SoundEvent getLongSound() {
        return CharmoniumSounds.AMBIENCE_DEEP_LONG;
    }

    @Nullable
    @Override
    public SoundEvent getShortSound() {
        return CharmoniumSounds.AMBIENCE_DEEP_SHORT;
    }
}
