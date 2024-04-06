package org.laykon.survivaloverhaul;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class GiveFlightBoots implements CommandExecutor, Listener {

    private final Plugin plugin;

    public GiveFlightBoots(Plugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return false;
        }

        Player player = (Player) sender;

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta meta = boots.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA + "Flight Boots");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "flightboots"), PersistentDataType.STRING, "true");
        boots.setItemMeta(meta);

        player.getInventory().addItem(boots);
        player.sendMessage(ChatColor.GREEN + "You have received flight boots!");

        return true;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getBoots() != null && player.getInventory().getBoots().getType() == Material.LEATHER_BOOTS) {
            ItemMeta meta = player.getInventory().getBoots().getItemMeta();
            if (meta != null && meta.getPersistentDataContainer().has(new NamespacedKey(plugin, "flightboots"), PersistentDataType.STRING)) {
                player.setAllowFlight(true);
                return;
            }
        }

        player.setAllowFlight(false);
        player.setFlying(false);
    }
}




