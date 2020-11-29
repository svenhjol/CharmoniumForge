package svenhjol.charmonium.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import svenhjol.charm.base.handler.ModuleHandler;
import svenhjol.charm.client.PlayerStateClient;
import svenhjol.charm.module.SnowStorms;
import svenhjol.charmonium.base.CharmoniumSounds;
import svenhjol.charmonium.iface.IBiomeAmbience;

import javax.annotation.Nullable;

public class IcyAmbientSounds {
    public static class Day extends BaseAmbientSounds implements IBiomeAmbience {
        public Day(PlayerEntity player, SoundHandler soundHandler) {
            super(player, soundHandler);
        }

        @Nullable
        @Override
        public SoundEvent getLongSound() {
            return CharmoniumSounds.AMBIENCE_ICY_DAY_LONG;
        }

        @Nullable
        @Override
        public SoundEvent getShortSound() {
            return CharmoniumSounds.AMBIENCE_ICY_DAY_SHORT;
        }

        @Override
        public int getShortSoundDelay() {
            return world.rand.nextInt(400) + 500;
        }

        @Override
        public boolean validBiomeConditions(Biome.Category biomeCategory) {
            return biomeCategory == Biome.Category.ICY
                && PlayerStateClient.INSTANCE.isDaytime
                && isOutside();
        }
    }

    public static class Night extends BaseAmbientSounds implements IBiomeAmbience {
        public Night(PlayerEntity player, SoundHandler soundHandler) {
            super(player, soundHandler);
        }

        @Nullable
        @Override
        public SoundEvent getLongSound() {
            return CharmoniumSounds.AMBIENCE_ICY_NIGHT_LONG;
        }

        @Override
        public boolean validBiomeConditions(Biome.Category biomeCategory) {
            return biomeCategory == Biome.Category.ICY
                && isOutside()
                && !PlayerStateClient.INSTANCE.isDaytime;
        }
    }

    public static class Thunderstorm extends BaseAmbientSounds implements IBiomeAmbience {
        public Thunderstorm(PlayerEntity player, SoundHandler soundHandler) {
            super(player, soundHandler);
        }

        @Nullable
        @Override
        public SoundEvent getLongSound() {
            return CharmoniumSounds.AMBIENCE_ICY_THUNDERSTORM;
        }

        @Override
        public float getLongSoundVolume() {
            return super.getLongSoundVolume() + 0.25F;
        }

        @Override
        public boolean validBiomeConditions(Biome.Category biomeCategory) {
            return biomeCategory == Biome.Category.ICY
                && isOutside()
                && getWorld().isThundering()
                && ModuleHandler.enabled(SnowStorms.class);
        }
    }
}
