package org.laykon.survivaloverhaul.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.Utility.Utils;

public class Feed implements CommandExecutor, Utils {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        ((Player) sender).setFoodLevel(20);
        ((Player) sender).setSaturation(20);
        sendMessage(sender, "You have been fed!");

        return true;
    }
}
