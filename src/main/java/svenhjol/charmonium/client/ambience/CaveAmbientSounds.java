package svenhjol.charmonium.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import svenhjol.charm.base.helper.DimensionHelper;
import svenhjol.charmonium.base.CharmoniumSounds;

import javax.annotation.Nullable;

public class CaveAmbientSounds extends BaseAmbientSounds {
    public CaveAmbientSounds(PlayerEntity player, SoundHandler soundHandler) {
        super(player, soundHandler);
    }

    public static boolean isValidCave(ClientWorld world, PlayerEntity player) {
        if (world == null || !DimensionHelper.isDimension(world, new ResourceLocation("overworld"))) return false;
        if (player.canSwim()) return false;

        BlockPos pos = player.getPosition();
        int light = world.getLight(pos);

        if (!world.canBlockSeeSky(pos)
            && pos.getY() <= world.getSeaLevel()
        ) {
            return pos.getY() <= 44 || light <= 10;
        }

        return false;
    }

    @Override
    public boolean isValid() {
        return isValidCave(world, player);
    }

    @Override
    public int getShortSoundDelay() {
        return world.rand.nextInt(500) + 600;
    }

    @Override
    public float getLongSoundVolume() {
        return 0.35F;
    }

    @Nullable
    @Override
    public SoundEvent getLongSound() {
        return CharmoniumSounds.AMBIENCE_CAVE_LONG;
    }

    @Nullable
    @Override
    public SoundEvent getShortSound() {
        return CharmoniumSounds.AMBIENCE_CAVE_SHORT;
    }
}
