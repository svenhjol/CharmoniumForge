package svenhjol.charmonium;

import net.minecraftforge.fml.common.Mod;
import svenhjol.charm.base.handler.ModuleHandler;
import svenhjol.charmonium.base.CharmoniumSounds;
import svenhjol.charmonium.module.Music;
import svenhjol.charmonium.module.Sounds;

import java.util.Arrays;


@Mod(Charmonium.MOD_ID)
public class Charmonium {
    public static final String MOD_ID = "charmonium";

    public Charmonium() {
        CharmoniumSounds.init();

        ModuleHandler.INSTANCE.registerForgeMod(MOD_ID, Arrays.asList(
            Music.class,
            Sounds.class
        ));
    }
}
