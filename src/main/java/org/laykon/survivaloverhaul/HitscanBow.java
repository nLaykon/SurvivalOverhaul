package org.laykon.survivaloverhaul;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class HitscanBow implements CommandExecutor, Utils {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return false;
        }

        Player player = (Player) sender;

        ItemStack boots = new ItemStack(Material.BOW);
        ItemMeta meta = boots.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_RED + "Railgun");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "railgun"), PersistentDataType.STRING, "true");
        boots.setItemMeta(meta);

        player.getInventory().addItem(boots);
        player.sendMessage(ChatColor.GREEN + "You have received a Railgun!");

        return true;
    }

}
