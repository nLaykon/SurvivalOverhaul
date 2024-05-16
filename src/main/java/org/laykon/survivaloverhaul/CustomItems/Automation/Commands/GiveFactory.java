package org.laykon.survivaloverhaul.CustomItems.Automation.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.CustomItems.Automation.Utils.FactoryUtils;
import org.laykon.survivaloverhaul.CustomItems.EventHandling.NamespacedKeys;
import org.laykon.survivaloverhaul.Utility.Utils;

public class GiveFactory implements CommandExecutor, Utils, FactoryUtils {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(args.length == 1)) return true;
        final var target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            System.err.printf("Invalid player: %s%n", args[0]);
            return false;
        }
        sendMessage(target, "§aYou Have Received a §dFactory §aItem!");

        ItemStack spawnEgg = new ItemStack(Material.COW_SPAWN_EGG);
        ItemMeta spawnEggMeta = spawnEgg.getItemMeta();
        spawnEggMeta.getPersistentDataContainer().set(NamespacedKeys.getKey("Factory"), PersistentDataType.STRING, "true");
        spawnEggMeta.setDisplayName("§d§lFactory");



        spawnEgg.setItemMeta(spawnEggMeta);
        addOrDrop(target, spawnEgg);



        return true;
    }
}
