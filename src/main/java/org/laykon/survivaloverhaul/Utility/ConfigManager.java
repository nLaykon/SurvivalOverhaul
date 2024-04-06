package org.laykon.survivaloverhaul.Utility;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import org.bukkit.configuration.InvalidConfigurationException;
import java.io.IOException;

public class ConfigManager {
    private YamlConfiguration config;
    private final JavaPlugin plugin;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    private void loadConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            // If config file doesn't exist, copy the default config from resources
            plugin.saveResource("config.yml", false);
        }

        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void reloadConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(configFile);
        try {
            config.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            plugin.getLogger().warning("Failed to reload config.yml: " + e.getMessage());
        }
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public String getHelp() {
        return getConfig().getString("server.help");
    }

    public int getWeight(String fishingItem) {
        return getConfig().getInt("fishingTable." + fishingItem + ".weight");
    }

    public Object getCfgVal(String path){
        return getConfig().get(path);
    }





    public String getLoaded() {
        return getConfig().getString("server.configLoadedMessage");
    }
}


