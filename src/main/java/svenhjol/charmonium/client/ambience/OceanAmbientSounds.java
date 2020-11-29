package svenhjol.charmonium.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import svenhjol.charmonium.base.CharmoniumSounds;
import svenhjol.charmonium.iface.IBiomeAmbience;

import javax.annotation.Nullable;

public class OceanAmbientSounds extends BaseAmbientSounds implements IBiomeAmbience {
    public OceanAmbientSounds(PlayerEntity player, SoundHandler soundHandler) {
        super(player, soundHandler);
    }

    @Nullable
    @Override
    public SoundEvent getLongSound() {
        return CharmoniumSounds.AMBIENCE_OCEAN_LONG;
    }

    @Override
    public boolean validBiomeConditions(Biome.Category biomeCategory) {
        return biomeCategory == Biome.Category.OCEAN
            && isOutside();
    }
}
