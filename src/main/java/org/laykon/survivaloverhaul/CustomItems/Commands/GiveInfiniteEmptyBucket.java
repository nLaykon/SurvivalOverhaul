package org.laykon.survivaloverhaul.CustomItems.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.CustomItems.EventHandling.NamespacedKeys;
import org.laykon.survivaloverhaul.Utility.Utils;

public class GiveInfiniteEmptyBucket implements CommandExecutor, Listener, Utils {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(args.length == 1)) return true;
        final var target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            System.err.printf("Invalid player: %s%n", args[0]);
            return false;
        }
        ItemStack bucket = new ItemStack(Material.BUCKET);
        ItemMeta bucketMeta = bucket.getItemMeta();

        bucketMeta.getPersistentDataContainer().set(NamespacedKeys.getKey("InfiniteEmptyBucket"), PersistentDataType.STRING, "true");
        bucketMeta.setDisplayName("§a§lInfinite Empty Bucket");

        bucket.setItemMeta(bucketMeta);

        target.getLocation().getWorld().dropItemNaturally(target.getLocation(), bucket);
        sendMessage(target, "&6You have been given an &aInfinite Empty Bucket");
        return true;
    }

    @EventHandler
    public void useBucket(PlayerBucketFillEvent it){
        if (it.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(NamespacedKeys.getKey("InfiniteEmptyBucket"))){
            it.getBlock().setType(Material.AIR);
            it.setCancelled(true);
        }

    }


}
