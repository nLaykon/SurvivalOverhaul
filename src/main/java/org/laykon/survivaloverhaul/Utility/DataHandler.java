package org.laykon.survivaloverhaul.Utility;


import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class DataHandler {
    YamlConfiguration data;
    private final JavaPlugin plugin;

    public DataHandler(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    private void loadConfig() {
        File dataFile = new File(plugin.getDataFolder(), "data.yml");

        if (!dataFile.exists()) {
            plugin.saveResource("data.yml", false);
        }

        data = YamlConfiguration.loadConfiguration(dataFile);
    }
    public void reloadData() {
        File dataFile = new File(plugin.getDataFolder(), "data.yml");
        data = YamlConfiguration.loadConfiguration(dataFile);
        try {
            data.load(dataFile);
        } catch (IOException | InvalidConfigurationException e) {
            plugin.getLogger().warning("Failed to reload config.yml: " + e.getMessage());
        }
    }

    public YamlConfiguration getConfig() {
        return data;
    }

    public void addOrCreate(String path, Object... value) {
        if (value.length != 1) {
            throw new IllegalArgumentException("Only one value can be provided for addOrCreate method");
        }
        Object newValue = value[0];
        getConfig().set(path, newValue);

        try {
            getConfig().save(new File(plugin.getDataFolder(), "data.yml"));
        } catch (IOException e) {
            plugin.getLogger().warning("Failed to save data.yml: " + e.getMessage());
        }
    }

    public Object readValue(String path) {
        var value = getConfig().get(path);
        if (!(value == null)) {
            return value;
        }
        return null;
    }

    public String getLoaded() {
        return getConfig().getString("server.dataLoadedMessage");
    }
}
