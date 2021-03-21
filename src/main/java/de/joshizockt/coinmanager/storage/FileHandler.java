package de.joshizockt.coinmanager.storage;

import de.joshizockt.coinmanager.CoinManager;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileHandler extends StorageHandler {

    private final CoinManager plugin;
    private final File file;
    private final YamlConfiguration cfg;

    public FileHandler(StorageManager manager) {
        super(manager);
        this.plugin = CoinManager.getInstance();
        this.file = new File(plugin.getDataFolder(), plugin.getConfig().getString("Config.Storage.FILE.Filename", "coins.yml"));
        this.cfg = YamlConfiguration.loadConfiguration(file);
    }

    @Override
    void setCoins(UUID uuid, int coins) {
        cfg.set(uuid.toString() + ".coins", coins);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    int getCoins(UUID uuid) {
        if(!dataExists(uuid)) createDefaults(uuid);
        return cfg.getInt(uuid.toString() + ".coins", getDefaultCoins());
    }

    @Override
    boolean dataExists(UUID uuid) {
        return cfg.get(uuid.toString()) != null;
    }

}
