package svenhjol.charmonium.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import svenhjol.charm.client.PlayerStateClient;
import svenhjol.charmonium.base.CharmoniumSounds;
import svenhjol.charmonium.iface.IBiomeAmbience;

import javax.annotation.Nullable;

public class SwampAmbientSounds {
    public static class Day extends BaseAmbientSounds implements IBiomeAmbience {
        public Day(PlayerEntity player, SoundHandler soundHandler) {
            super(player, soundHandler);
        }

        @Nullable
        @Override
        public SoundEvent getLongSound() {
            return CharmoniumSounds.AMBIENCE_SWAMP_DAY_LONG;
        }

        @Override
        public float getLongSoundVolume() {
            return super.getLongSoundVolume() - 0.2F;
        }

        @Override
        public boolean validBiomeConditions(Biome.Category biomeCategory) {
            return biomeCategory == Biome.Category.SWAMP
                && isOutside()
                && PlayerStateClient.INSTANCE.isDaytime;
        }
    }

    public static class Night extends BaseAmbientSounds implements IBiomeAmbience {
        public Night(PlayerEntity player, SoundHandler soundHandler) {
            super(player, soundHandler);
        }

        @Nullable
        @Override
        public SoundEvent getLongSound() {
            return CharmoniumSounds.AMBIENCE_SWAMP_NIGHT_LONG;
        }

        @Override
        public boolean validBiomeConditions(Biome.Category biomeCategory) {
            return biomeCategory == Biome.Category.SWAMP
                && isOutside()
                && !PlayerStateClient.INSTANCE.isDaytime;
        }
    }
}
