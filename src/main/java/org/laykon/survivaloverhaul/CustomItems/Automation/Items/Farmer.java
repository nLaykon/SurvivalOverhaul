package org.laykon.survivaloverhaul.CustomItems.Automation.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.CustomItems.EventHandling.NamespacedKeys;
import org.laykon.survivaloverhaul.Utility.Utils;

import java.util.UUID;

public class Farmer implements Utils {

    public static @NotNull ItemStack ItemStack(){
        ItemStack item = new ItemStack(Material.SHULKER_BOX);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.getPersistentDataContainer().set(NamespacedKeys.getKey("farmerbox"), PersistentDataType.STRING, "true");
        itemMeta.getPersistentDataContainer().set(NamespacedKeys.getKey(UUID.randomUUID().toString()), PersistentDataType.STRING, "true");
        itemMeta.setDisplayName("§x§F§F§C§6§0§0Farming Box");



        item.setItemMeta(itemMeta);
        return item;
    }
}
