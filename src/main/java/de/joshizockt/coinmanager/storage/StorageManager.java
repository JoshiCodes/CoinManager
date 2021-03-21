package de.joshizockt.coinmanager.storage;

import de.joshizockt.coinmanager.CoinManager;
import de.joshizockt.coinmanager.event.PlayerCoinsAddEvent;
import de.joshizockt.coinmanager.event.PlayerCoinsRemoveEvent;
import de.joshizockt.coinmanager.event.PlayerCoinsSetEvent;
import org.bukkit.Bukkit;

import java.util.UUID;

public class StorageManager {

    private CoinManager plugin;
    private final StorageType type;
    private final StorageHandler handler;

    public final int DEFAULT_COINS;

    public StorageManager(CoinManager plugin, StorageType type) {
        this.plugin = plugin;
        if(type == null) type = StorageType.FILE;
        this.type = type;
        this.DEFAULT_COINS = plugin.getConfig().getInt("Config.Coins.DefaultCoins", 1000);
        this.handler = StorageHandler.get(type, this);
    }

    public void setCoins(UUID uuid, int coins) {
        int old = getCoins(uuid);
        PlayerCoinsSetEvent e = new PlayerCoinsSetEvent(uuid, old, coins);
        Bukkit.getPluginManager().callEvent(e);
        if(!e.isCancelled()) {
            handler.setCoins(uuid, coins);
        }
    }

    public int addCoins(UUID uuid, int coins) {
        int old = getCoins(uuid);
        PlayerCoinsAddEvent e = new PlayerCoinsAddEvent(uuid, old, old + coins);
        Bukkit.getPluginManager().callEvent(e);
        if(!e.isCancelled()) {
            return handler.addCoins(uuid, coins);
        }
        return getCoins(uuid);
    }

    public int removeCoins(UUID uuid, int coins) {
        int old = getCoins(uuid);
        PlayerCoinsRemoveEvent e = new PlayerCoinsRemoveEvent(uuid, old, old - coins);
        Bukkit.getPluginManager().callEvent(e);
        if(!e.isCancelled()) {
            return handler.removeCoins(uuid, coins);
        }
        return old;
    }

    public int getCoins(UUID uuid) {
        return handler.getCoins(uuid);
    }

    public StorageType getType() {
        return type;
    }

}
