package org.laykon.survivaloverhaul.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.Utility.GCHandler;

public class GetGC implements CommandExecutor, GCHandler {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1) {
            System.out.println(args.length);
            return false;
        }

        final var target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            System.err.printf("Invalid player: %s%n", args[0]);
            return false;
        }

        getGC(target);
        System.out.println(target.getName() + " GC Value: " + getGC(target));
        if (sender instanceof Player) {
            sender.sendMessage(target.getName() + " GC Value: " + getGC(target));
        }
        return true;
    }
}

