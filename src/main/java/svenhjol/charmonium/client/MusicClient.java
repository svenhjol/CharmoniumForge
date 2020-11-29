package svenhjol.charmonium.client;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import svenhjol.charm.base.CharmClientModule;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.helper.DimensionHelper;
import svenhjol.charm.client.MusicImprovementsClient;
import svenhjol.charm.client.MusicImprovementsClient.MusicCondition;
import svenhjol.charm.client.PlayerStateClient;
import svenhjol.charmonium.base.CharmoniumSounds;

public class MusicClient extends CharmClientModule {
    public MusicClient(CharmModule module) {
        super(module);
    }

    @Override
    public void init() {
        // play Þarna in overworld anywhere
        MusicImprovementsClient.getMusicConditions().add(new MusicCondition(CharmoniumSounds.MUSIC_THARNA, 1200, 3600, mc -> {
            if (mc.player == null || mc.player.world == null)
                return false;

            return mc.player.world.rand.nextFloat() < 0.08F
                && DimensionHelper.isDimension(mc.player.world, new ResourceLocation("overworld"));
        }));

        // play Mús in cold environments
        MusicImprovementsClient.getMusicConditions().add(new MusicCondition(CharmoniumSounds.MUSIC_MUS, 1200, 3600, mc ->
            mc.player != null
                && mc.player.world.getBiome(mc.player.getPosition()).getCategory() == Biome.Category.ICY
                && mc.player.world.rand.nextFloat() < 0.28F
        ));

        // play Undir in nether underground
        MusicImprovementsClient.getMusicConditions().add(new MusicCondition(CharmoniumSounds.MUSIC_UNDIR, 1200, 3600, mc -> {
            if (mc.player == null)
                return false;

            return mc.player.getPosition().getY() < 48
                && DimensionHelper.isDimension(mc.player.world, new ResourceLocation("the_nether"))
                && mc.player.world.rand.nextFloat() < 0.33F;
        }));

        // play Steinn and Draugur in ruins
        MusicImprovementsClient.getMusicConditions().add(new MusicCondition(CharmoniumSounds.MUSIC_RUIN, 1200, 2400, mc
            -> mc.player != null && PlayerStateClient.INSTANCE.ruin));
    }
}
