package de.joshizockt.coinmanager;

import de.joshizockt.coinmanager.commands.CoinsCommand;
import de.joshizockt.coinmanager.storage.StorageManager;
import de.joshizockt.coinmanager.storage.StorageType;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class CoinManager extends JavaPlugin {

    private static CoinManager instance;

    private StorageManager storageMananager;

    @Override
    public void onEnable() {

        instance = this;

        saveDefaultConfig();

        storageMananager = new StorageManager(this, StorageType.valueOf(getConfig().getString("Config.Storage.Type")));

        getCommand("coins").setExecutor(new CoinsCommand());

    }

    @Override
    public void onDisable() {

    }

    public StorageManager getStorageMananager() {
        return storageMananager;
    }

    public static CoinManager getInstance() {
        return instance;
    }

    public String getString(String path) {
        return ChatColor.translateAlternateColorCodes('&', getConfig().getString("Lang." + path))
                .replaceAll("%coin%", getCoinName())
                .replaceAll("%coins%", getCoinsName());
    }

    public String getCoinName() {
        return getConfig().getString("Lang.Coin", "Coin");
    }

    public String getCoinsName() {
        return getConfig().getString("Lang.Coins", "Coins");
    }

}
