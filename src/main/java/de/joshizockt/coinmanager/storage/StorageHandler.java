package de.joshizockt.coinmanager.storage;

import java.util.UUID;

public abstract class StorageHandler {

    abstract void setCoins(UUID uuid, int coins);
    abstract int getCoins();

    public int addCoins(UUID uuid, int coins) {
        final int newCoins = getCoins() + coins;
        setCoins(uuid, newCoins);
        return newCoins;
    }

    public int removeCoins(UUID uuid, int coins) {
        final int newCoins = getCoins() - coins;
        setCoins(uuid, newCoins);
        return newCoins;
    }

}
