package org.laykon.survivaloverhaul;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor, Utils {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if (!(sender instanceof Player)) return false;
        if (((Player) sender).getGameMode() != GameMode.SURVIVAL){
            return false;
        }
        if (((Player) sender).getAllowFlight()== true){
            ((Player) sender).setAllowFlight(false);
            sendMessage(sender,"&cFly &4Disabled");
        }
        else if (((Player) sender).getAllowFlight() == false){
            ((Player) sender).setAllowFlight(true);
            sendMessage(sender,"&cFly &aEnabled");
        }
        return true;
    }
}
