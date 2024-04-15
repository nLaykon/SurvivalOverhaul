package org.laykon.survivaloverhaul.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Dtn implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }
        if (args.length < 2) {
            sender.sendMessage("Usage: /dtn <number> <command>");
            return true;
        }

        int numExecutions;
        try {
            numExecutions = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            sender.sendMessage("Invalid number provided.");
            return true;
        }

        StringBuilder commandToExecute = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            commandToExecute.append(args[i]).append(" ");
        }

        for (int i = 0; i < numExecutions; i++) {
            ((Player) sender).performCommand(commandToExecute.toString());
        }

        return true;
    }
}
