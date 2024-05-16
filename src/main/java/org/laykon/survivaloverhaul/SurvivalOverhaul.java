package org.laykon.survivaloverhaul;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.laykon.survivaloverhaul.Commands.*;
import org.laykon.survivaloverhaul.CustomBosses.Commands.SpawnBoss;
import org.laykon.survivaloverhaul.CustomItems.Automation.Commands.GiveFactory;
import org.laykon.survivaloverhaul.CustomItems.Automation.Commands.GiveFarmer;
import org.laykon.survivaloverhaul.CustomItems.Automation.Handlers.FactoryHandler;
import org.laykon.survivaloverhaul.CustomItems.Automation.Handlers.FarmerHandler;
import org.laykon.survivaloverhaul.CustomItems.Commands.GiveInfiniteEmptyBucket;
import org.laykon.survivaloverhaul.CustomItems.Commands.OlympianGiveCommand;
import org.laykon.survivaloverhaul.CustomItems.EventHandling.AbilityHandler;
import org.laykon.survivaloverhaul.CustomItems.LootTableHandler;
import org.laykon.survivaloverhaul.events.ChatFormattingListener;
import org.laykon.survivaloverhaul.events.ScoreboardHandler;
import org.laykon.survivaloverhaul.fishing.FishingListener;
import org.laykon.survivaloverhaul.Utility.ConfigManager;
import org.laykon.survivaloverhaul.Utility.DataHandler;
import org.laykon.survivaloverhaul.Utility.JoinHandler;
import org.laykon.survivaloverhaul.Utility.Utils;

public final class SurvivalOverhaul extends JavaPlugin implements Utils {
    private ConfigManager cfg;
    private DataHandler data;
    private static SurvivalOverhaul instance;

    public static SurvivalOverhaul getInstance() {
        return instance;
    }

    private BukkitRunnable myTask;

    @Override
    public void onEnable() {
        instance = this;
        cfg = new ConfigManager(this);
        data = new DataHandler();
        cmd("fly", new Fly());
        cmd("dev/giveolympian", new OlympianGiveCommand());
        cmd("feed", new Feed());
        cmd("dtn", new Dtn());
        cmd("spawnboss", new SpawnBoss());
        cmd("dev/data/write", new WriteData());
        cmd("dev/data/read", new ReadData());
        cmd("dev/automation/givefarmer", new GiveFarmer());
        cmd("dev/flyspeed", new FlySpeed());
        cmd("dev/ggwave", new GGWave());
        cmd("dev/gc/give", new AddGC());
        cmd("dev/gc/remove", new RemoveGC());
        cmd("dev/gc/set", new SetGC());
        cmd("dev/gc/get", new GetGC());
        cmd("dev/grad", new Gradiant());
        cmd("dev/padd", new PermissionSet());
        cmd("dev/gag", new Gag());
        cmd("dev/givefactory", new GiveFactory());
        cmd("dev/give/infiniteemptybucket", new GiveInfiniteEmptyBucket());

        event(new JoinHandler());
        event(new FishingListener());
        event(new ChatFormattingListener());
        event(new AbilityHandler());
        event(new LootTableHandler());
        event(new FarmerHandler());
        event(new GGWave());
        event(new ScoreboardHandler());
        event(new Gag());
        event(new FactoryHandler());
        event(new GiveInfiniteEmptyBucket());


        myTask = new MyTask();
        myTask.runTaskTimer(this, 0l, 100l);

        System.out.println(cfg.getLoaded());
        System.out.println(data.getLoaded());
    }

    private class MyTask extends BukkitRunnable {
        @Override
        public void run() {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (isSet(player, "hera"))
                    player.addPotionEffect(PotionEffectType.REGENERATION.createEffect(110, 0));

                if (isSet(player, "hermes"))
                    player.addPotionEffect(PotionEffectType.SPEED.createEffect(110, 0));

                if (isSet(player, "poseidon")) {
                    player.setRemainingAir(player.getMaximumAir());
                    player.addPotionEffect(PotionEffectType.DOLPHINS_GRACE.createEffect(110, 0));
                }

                if (isSet(player, "apollo"))
                    player.addPotionEffect(PotionEffectType.INCREASE_DAMAGE.createEffect(110, 0));

                if (isSet(player, "ares"))
                    player.addPotionEffect(PotionEffectType.INCREASE_DAMAGE.createEffect(110, 1));

                if (isItem(player, "hephaestusitem"))
                    player.addPotionEffect(PotionEffectType.FAST_DIGGING.createEffect(110, 1));

                if (isSet(player, "aphrodite"))
                    player.addPotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE.createEffect(110, 0));

                if (isItem(player, "hermesitem")){
                    player.addPotionEffect(PotionEffectType.FAST_DIGGING.createEffect(110, 1));
                }
            }
        }
    }
    @Override
    public void onDisable() {
        HandlerList.unregisterAll(new ChatFormattingListener());
        HandlerList.unregisterAll(new FishingListener());
        HandlerList.unregisterAll(new AbilityHandler());
        HandlerList.unregisterAll(new LootTableHandler());
        HandlerList.unregisterAll(new FarmerHandler());
        HandlerList.unregisterAll(new ScoreboardHandler());
        HandlerList.unregisterAll(new Gag());
        HandlerList.unregisterAll(new FactoryHandler());
        HandlerList.unregisterAll(new GiveInfiniteEmptyBucket());

        myTask.cancel();

        cfg.reloadConfig();
        data.reloadData();
    }


    public void cmd(String name, CommandExecutor command) {
        getCommand(name).setExecutor(command);
    }

    public static void executeCmd(String command) {
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
        System.out.println("Command Executed: " + command);
    }

    public void event(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
