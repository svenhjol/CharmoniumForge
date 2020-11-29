package svenhjol.charmonium.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;
import svenhjol.charmonium.base.CharmoniumSounds;
import svenhjol.charm.base.helper.DimensionHelper;

import javax.annotation.Nullable;

public class HighAmbientSounds extends BaseAmbientSounds {
    public HighAmbientSounds(PlayerEntity player, SoundHandler soundHandler) {
        super(player, soundHandler);
    }

    @Override
    public boolean isValid() {
        return DimensionHelper.isDimension(world, new ResourceLocation("overworld"))
            && player.getPosition().getY() > 150
            && !player.canSwim();
    }

    @Nullable
    @Override
    public SoundEvent getLongSound() {
        return CharmoniumSounds.AMBIENCE_HIGH;
    }
}
