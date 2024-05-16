package org.laykon.survivaloverhaul.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.Utility.GCHandler;

public class SetGC implements CommandExecutor, GCHandler {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(args.length > 1)) return true;
        final var target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            System.err.printf("Invalid player: %s%n", args[0]);
            return false;
        }
        int num;
        try {
            num = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        setGC(target, num);
        System.out.println(target.getName() + " GC Value has been set to: " + getGC(target));
        if (sender instanceof Player) {
            sender.sendMessage(target.getName() + " GC Value has been set to: " + getGC(target));
        }
        return true;
    }
}
