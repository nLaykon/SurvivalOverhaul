package org.laykon.survivaloverhaul.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.SurvivalOverhaul;
import org.laykon.survivaloverhaul.Utility.Utils;

import java.util.HashSet;
import java.util.Set;

public class Gag implements CommandExecutor, Utils, Listener {
    Plugin plugin = SurvivalOverhaul.getInstance();

    public static Set<Player> playerSet = new HashSet<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(args.length == 1)) return true;
        final var target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            System.err.printf("Invalid player: %s%n", args[0]);
            return false;
        }
        if (playerSet.contains(target)){
            playerSet.remove(target);
            System.out.println(playerSet);
        }else {
            playerSet.add(target);
            System.out.println(playerSet);
        }
        return true;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent it){
        var player = it.getPlayer();
        if (playerSet.isEmpty())return;
        if (!(playerSet.contains(player)))return;
        it.setCancelled(true);
        for (Player player2 : plugin.getServer().getOnlinePlayers()){
            sendMessage(player2, player.getName() + ": " + scramble(it.getMessage()));
        }
    }
}
