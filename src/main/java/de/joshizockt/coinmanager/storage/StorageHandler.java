package de.joshizockt.coinmanager.storage;

import java.util.HashMap;
import java.util.UUID;

public abstract class StorageHandler {

    private StorageManager manager;

    private final int DEFAULT_COINS;

    public StorageHandler(StorageManager manager) {
        this.manager = manager;
        DEFAULT_COINS = manager.DEFAULT_COINS;
    }

    abstract void setCoins(UUID uuid, int coins);
    abstract int getCoins(UUID uuid);
    abstract boolean dataExists(UUID uuid);

    public void createDefaults(UUID uuid) {
        setCoins(uuid, DEFAULT_COINS);
    }

    public int addCoins(UUID uuid, int coins) {
        if(!dataExists(uuid)) createDefaults(uuid);
        final int newCoins = getCoins(uuid) + coins;
        setCoins(uuid, newCoins);
        return newCoins;
    }

    public int removeCoins(UUID uuid, int coins) {
        if(!dataExists(uuid)) createDefaults(uuid);
        final int newCoins = getCoins(uuid) - coins;
        setCoins(uuid, newCoins);
        return newCoins;
    }

    public int getDefaultCoins() {
        return DEFAULT_COINS;
    }

    public static StorageHandler get(StorageType type, StorageManager manager) {
        if(type == StorageType.FILE) {
            return new FileHandler(manager);
        } else if(type == StorageType.MYSQL) {
            return new SQLHandler(manager);
        }
        return new FileHandler(manager);
    }

}
