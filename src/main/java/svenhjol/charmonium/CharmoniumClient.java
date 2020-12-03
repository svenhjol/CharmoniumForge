package svenhjol.charmonium;

import svenhjol.charm.base.handler.ClientHandler;

public class CharmoniumClient {
    public CharmoniumClient() {
        ClientHandler.INSTANCE.registerForgeMod(Charmonium.MOD_ID);
    }
}
