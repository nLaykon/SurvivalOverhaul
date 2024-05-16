package org.laykon.survivaloverhaul.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.CustomItems.EventHandling.NamespacedKeys;
import org.laykon.survivaloverhaul.Utility.Utils;

public class PermissionSet implements CommandExecutor, Utils {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(args.length > 1)) return true;
        final var target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            System.err.printf("Invalid player: %s%n", args[0]);
            return false;
        }
        if (!(args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false"))){
            return false;
        }

        target.getPersistentDataContainer().set(NamespacedKeys.getKey(args[1]), PersistentDataType.STRING, args[2]);

        if (sender instanceof Player){
            sender.sendMessage("§a" + args[0] + " §cPermission for " + args[1] + " §cHas been set to: §a" + args[2]);
        }

        return true;
    }
}
