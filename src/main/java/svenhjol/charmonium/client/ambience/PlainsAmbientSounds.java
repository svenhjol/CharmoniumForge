package svenhjol.charmonium.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import svenhjol.charm.client.PlayerStateClient;
import svenhjol.charmonium.base.CharmoniumSounds;
import svenhjol.charmonium.iface.IBiomeAmbience;

import javax.annotation.Nullable;

public class PlainsAmbientSounds {
    public static class Day extends BaseAmbientSounds implements IBiomeAmbience {
        public Day(PlayerEntity player, SoundHandler soundHandler) {
            super(player, soundHandler);
        }

        @Nullable
        @Override
        public SoundEvent getLongSound() {
            return CharmoniumSounds.AMBIENCE_PLAINS_DAY_LONG;
        }

        @Override
        public boolean validBiomeConditions(Biome.Category biomeCategory) {
            return (biomeCategory == Biome.Category.PLAINS
                || biomeCategory == Biome.Category.MUSHROOM
                || biomeCategory == Biome.Category.RIVER)
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
            return CharmoniumSounds.AMBIENCE_PLAINS_NIGHT_LONG;
        }

        @Nullable
        @Override
        public SoundEvent getShortSound() {
            return CharmoniumSounds.AMBIENCE_PLAINS_NIGHT_SHORT;
        }

        @Override
        public int getShortSoundDelay() {
            return world.rand.nextInt(500) + 200;
        }

        @Override
        public boolean validBiomeConditions(Biome.Category biomeCategory) {
            return (biomeCategory == Biome.Category.PLAINS
                || biomeCategory == Biome.Category.MUSHROOM
                || biomeCategory == Biome.Category.RIVER)
                && isOutside()
                && !PlayerStateClient.INSTANCE.isDaytime;
        }
    }
}
