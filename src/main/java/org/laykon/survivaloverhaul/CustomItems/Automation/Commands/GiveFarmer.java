package org.laykon.survivaloverhaul.CustomItems.Automation.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.CustomItems.Automation.Items.Farmer;
import org.laykon.survivaloverhaul.Utility.Utils;

public class GiveFarmer implements CommandExecutor, Utils {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        var player = Bukkit.getPlayer(args[0]);
        if (player == null) return true;

        player.getWorld().dropItemNaturally(player.getEyeLocation(), Farmer.ItemStack());
        return true;
    }
}
