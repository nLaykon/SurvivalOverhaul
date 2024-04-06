package org.laykon.survivaloverhaul;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.laykon.survivaloverhaul.Utility.TieredItemBuilder;

public class GiveCustomItem implements CommandExecutor, Utils {
    TieredItemBuilder tib = new TieredItemBuilder();


    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        if (!(sender instanceof Player)) return false;
        ItemStack item = tib.buildItem(Material.DIAMOND_SWORD, "Celestial", "Swift");
        Location loc = ((Player) sender).getLocation();
        ((Player) sender).setItemInHand(item);
        sendMessage(sender, item.getItemMeta().getDisplayName() + " Has been given");
        return true;
    }
}
