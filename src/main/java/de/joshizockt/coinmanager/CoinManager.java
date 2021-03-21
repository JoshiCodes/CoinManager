package de.joshizockt.coinmanager;

import de.joshizockt.coinmanager.storage.StorageManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CoinManager extends JavaPlugin {

    private static CoinManager instance;

    private StorageManager storageMananager;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        storageMananager = new StorageManager();

    }

    @Override
    public void onDisable() {

    }

    public static CoinManager getInstance() {
        return instance;
    }

}
