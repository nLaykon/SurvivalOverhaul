package org.laykon.survivaloverhaul.Utility;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.laykon.survivaloverhaul.SurvivalOverhaul;
import org.laykon.survivaloverhaul.Utils;

import java.util.List;


public class TieredItemBuilder implements Utils {
    JavaPlugin plugin = SurvivalOverhaul.getInstance();
    private ConfigManager cfg = new ConfigManager(plugin);;

    int myInt = 10;
    Double myDouble = Double.parseDouble(String.valueOf(myInt));


    public ItemStack buildItem(Material Item, String tier, String type) {

        ItemStack item = new ItemStack(Item);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(tier + " " + type + " " + getNiceName(Material.DIAMOND_SWORD));

        addAttr(meta, "GENERIC_MOVEMENT_SPEED", 10d);
        item.setItemMeta(meta);

        List<String> myAttr;


        return item;
    }

    public enum myAttrs{
        GENERIC_MOVEMENT_SPEED(),
        GENERIC_ATTACK_SPEED();
    }
}








