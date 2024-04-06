package org.laykon.survivaloverhaul;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.laykon.survivaloverhaul.Utility.ConfigManager;
import org.laykon.survivaloverhaul.events.ChatFormattingListener;
import org.laykon.survivaloverhaul.fishing.FishingListener;

public final class SurvivalOverhaul extends JavaPlugin {
    private ConfigManager cfg;
    private static SurvivalOverhaul instance;

    public static SurvivalOverhaul getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        cfg = new ConfigManager(this);
        cmd("fly", new Fly());
        cmd("givecustomitem", new GiveCustomItem());
        cmd("giveflightboots", new GiveFlightBoots(this));

        event(new FishingListener());
        event(new ChatFormattingListener());

        System.out.println(cfg.getLoaded());
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(new FishingListener());
        cfg.reloadConfig();
    }

    public void cmd(String name, CommandExecutor command){
        getCommand(name).setExecutor(command);
    }
    public static void executeCmd(String command){
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
        System.out.println("Command Executed: " + command);
    }
    public void event(Listener listener)
    {
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
