package org.laykon.survivaloverhaul.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.laykon.survivaloverhaul.SurvivalOverhaul;
import org.laykon.survivaloverhaul.Utility.CreditHandler;
import org.laykon.survivaloverhaul.Utility.GCHandler;
import org.laykon.survivaloverhaul.Utility.GemHandler;

public class ScoreboardHandler implements Listener, GCHandler, GemHandler, CreditHandler {
    Plugin plugin = SurvivalOverhaul.getInstance();
    @EventHandler
    public void onPlayerJoin(PluginEnableEvent it) {
        new BukkitRunnable() {
            boolean toggle = false;

            @Override
            public void run() {
                for (Player player : plugin.getServer().getOnlinePlayers()) {
                    buildSidebar(player, toggle);
                }
                toggle = !toggle;
            }
        }.runTaskTimer(plugin, 0L, 60L);
    }

    @EventHandler
    public void onDisable(PluginDisableEvent it){
        for (Player player : plugin.getServer().getOnlinePlayers()){
            player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
        }
    }



    public void buildSidebar(Player player, boolean toggle) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("mySidebar", "dummy");
        obj.setDisplayName(ChatColor.LIGHT_PURPLE + player.getName());
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        obj.getScore("§6Credits: " + "§d$" + getCredits(player)).setScore(6);
        if (toggle) {
            obj.getScore("§6GC: " + "§d" + GC() + getGC(player)).setScore(5);
        }else {
            obj.getScore("§6Gems: " + "§d" + Gem() + getGems(player)).setScore(5);
        }
        obj.getScore("§6Exp: " + "§d◎" + player.getTotalExperience()).setScore(4);

        player.setScoreboard(board);
    }
}
