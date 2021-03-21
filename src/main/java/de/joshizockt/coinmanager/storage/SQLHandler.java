package de.joshizockt.coinmanager.storage;

import java.util.UUID;

public class SQLHandler extends StorageHandler {

    public SQLHandler(StorageManager manager) {
        super(manager);
    }

    @Override
    void setCoins(UUID uuid, int coins) {

    }

    @Override
    int getCoins(UUID uuid) {
        return 0;
    }

    @Override
    boolean dataExists(UUID uuid) {
        return false;
    }

}
