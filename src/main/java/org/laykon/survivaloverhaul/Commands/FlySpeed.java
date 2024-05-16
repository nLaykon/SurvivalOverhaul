package org.laykon.survivaloverhaul.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlySpeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (args.length != 1) {
            player.sendMessage("Usage: /flyspeed <speed>");
            return true;
        }

        try {
            float flySpeed = Float.parseFloat(args[0]);
            flySpeed = flySpeed/10;
            if (flySpeed < 0.0 || flySpeed > 10.0) {
                player.sendMessage("Fly speed must be between 0.0 and 10");
                return true;
            }
            player.setFlySpeed(flySpeed);

            player.sendMessage("Fly speed set to " + flySpeed*10);
        } catch (NumberFormatException e) {
            player.sendMessage("Invalid number format. Please enter a valid float value.");
        }
        return true;
    }
}
