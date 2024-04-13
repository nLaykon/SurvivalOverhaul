package org.laykon.survivaloverhaul;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.laykon.survivaloverhaul.CustomItems.Commands.OlympianGiveCommand;
import org.laykon.survivaloverhaul.CustomItems.EventHandling.AbilityHandler;
import org.laykon.survivaloverhaul.CustomItems.LootTableHandler;
import org.laykon.survivaloverhaul.Utility.ConfigManager;
import org.laykon.survivaloverhaul.events.ChatFormattingListener;
import org.laykon.survivaloverhaul.fishing.FishingListener;

public final class SurvivalOverhaul extends JavaPlugin implements Utils {
    private ConfigManager cfg;
    private static SurvivalOverhaul instance;

    public static SurvivalOverhaul getInstance() {
        return instance;
    }

    private BukkitRunnable myTask;

    @Override
    public void onEnable() {
        instance = this;
        cfg = new ConfigManager(this);
        cmd("fly", new Fly());
        cmd("dev/giveolympian", new OlympianGiveCommand());
        cmd("feed", new Feed());

        event(new FishingListener());
        event(new ChatFormattingListener());
        event(new AbilityHandler());
        event(new LootTableHandler());


        myTask = new MyTask();
        myTask.runTaskTimer(this, 0l, 100l);

        System.out.println(cfg.getLoaded());
    }

    private class MyTask extends BukkitRunnable {
        @Override
        public void run() {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (isSet(player, "hera"))
                    player.addPotionEffect(PotionEffectType.REGENERATION.createEffect(110, 0));

                if (isSet(player, "hermes"))
                    player.addPotionEffect(PotionEffectType.SPEED.createEffect(110, 0));

                if (isSet(player, "poseidon"))
                    player.setRemainingAir(player.getMaximumAir());

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

        myTask.cancel();

        cfg.reloadConfig();
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
