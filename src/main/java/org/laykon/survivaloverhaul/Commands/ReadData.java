package org.laykon.survivaloverhaul.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.SurvivalOverhaul;
import org.laykon.survivaloverhaul.Utility.DataHandler;

public class ReadData implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return true;
        DataHandler data = new DataHandler(SurvivalOverhaul.getInstance());
        var dataValue = data.getConfig().get(args[0]);
        sender.sendMessage("Value: " + dataValue.toString());
        return true;
    }
}
