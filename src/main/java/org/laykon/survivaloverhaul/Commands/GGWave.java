package org.laykon.survivaloverhaul.Commands;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.SurvivalOverhaul;
import org.laykon.survivaloverhaul.Utility.GCHandler;
import org.laykon.survivaloverhaul.Utility.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

public class GGWave implements CommandExecutor, Utils, Listener, GCHandler {
    Plugin plugin = SurvivalOverhaul.getInstance();
    public static ArrayList<UUID> playerArray = new ArrayList<>();
    public static boolean ggActive = false;

    public boolean isGgActive(){
        return ggActive;
    }
    Random rng = new Random();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            if (!(hasPermission((Player) sender, "so.gg"))){
                sender.sendMessage("§cNo Permission");
                return true;
            }
        }
        if (ggActive) {
            sendMessage(sender, "GG Wave active!");
            return true;
        }
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            player.sendMessage("");
            player.sendMessage("§x§F§B§0§8§A§FG§x§F§6§0§7§B§5G §x§F§2§0§7§B§BW§x§E§D§0§6§C§1a§x§E§8§0§6§C§8v§x§E§4§0§5§C§Ee §x§D§F§0§4§D§4S§x§D§A§0§4§D§At§x§D§5§0§3§E§0a§x§D§1§0§2§E§6r§x§C§C§0§2§E§Dt§x§C§7§0§1§F§3e§x§C§3§0§1§F§9d§x§B§E§0§0§F§F!");
            player.sendMessage("§x§F§B§0§8§A§FT§x§F§8§0§8§B§3y§x§F§5§0§7§B§7p§x§F§2§0§7§B§Ae §x§E§F§0§6§B§E\"§x§E§C§0§6§C§2G§x§E§A§0§6§C§6G§x§E§7§0§5§C§A\" §x§E§4§0§5§C§DT§x§E§1§0§5§D§1o §x§D§E§0§4§D§5P§x§D§B§0§4§D§9a§x§D§8§0§3§D§Dr§x§D§5§0§3§E§1t§x§D§2§0§3§E§4i§x§C§F§0§2§E§8c§x§C§D§0§2§E§Ci§x§C§A§0§2§F§0p§x§C§7§0§1§F§4a§x§C§4§0§1§F§7t§x§C§1§0§0§F§Be§x§B§E§0§0§F§F!");
            player.sendMessage("");
        }
        ggActive = true;

        BukkitRunnable newTask = new BukkitRunnable() {
            @Override
            public void run() {
                Iterator<UUID> iterator = playerArray.iterator();
                while (iterator.hasNext()) {
                    UUID uuid = iterator.next();
                    iterator.remove();
                }
                for (Player player : plugin.getServer().getOnlinePlayers()){
                    player.sendMessage("");
                    player.sendMessage("§x§F§B§0§8§C§3G§x§F§6§0§8§C§6G §x§F§1§0§7§C§9W§x§E§C§0§7§C§Ca§x§E§7§0§6§C§Ev§x§E§2§0§6§D§1e §x§D§E§0§6§D§4i§x§D§9§0§5§D§7s §x§D§4§0§5§D§Ao§x§C§F§0§5§D§Dv§x§C§A§0§4§E§0e§x§C§5§0§4§E§2r§x§C§0§0§3§E§5, §x§B§B§0§3§E§8T§x§B§6§0§3§E§Bh§x§B§1§0§2§E§Ea§x§A§D§0§2§F§1n§x§A§8§0§2§F§4k §x§A§3§0§1§F§6y§x§9§E§0§1§F§9o§x§9§9§0§0§F§Cu§x§9§4§0§0§F§F!");
                    player.sendMessage("");
                }
                ggActive = false;
                System.out.println("Ran");
            }
        };

        newTask.runTaskLater(plugin, 10 * 20);

        return true;
    }

    @EventHandler
    public void onPlayerChat(AsyncChatEvent it){
        if (!isGgActive()){
            return;
        }
        UUID playerID = it.getPlayer().getUniqueId();
        if (playerArray.contains(playerID)){
            it.setCancelled(true);
            return;
        }
        it.setCancelled(true);
        int num = rng.nextInt(1, 5);
        addGC(it.getPlayer(), num);
        it.getPlayer().sendMessage("§x§0§8§F§B§5§4You have received " + num + " GC!");
        for (Player player : it.getPlayer().getServer().getOnlinePlayers()){
            player.sendMessage(gradString(it.getPlayer().getName() + ": GG! Thank you for supporting x Server", "#ff00aa", "#aa00ff"));
        }
        playerArray.add(playerID);
    }
}
