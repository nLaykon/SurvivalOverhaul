package org.laykon.survivaloverhaul.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.Utility.Utils;

public class Gradiant implements CommandExecutor, Utils {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        sender.sendMessage(gradString("Testing my String Gradiant", "#FF0000", "#00FF00"));
        System.out.println(gradString("Testing my String Gradiant", "#FF0000", "#00FF00"));
        return true;
    }
}
