package org.laykon.survivaloverhaul.Utility;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class itemBuilder {
    public static ItemStack buildItem(Material item, String name, String loreString, Enchantment[] enchantments, boolean randomizeEnchants) {
        ItemStack stack = new ItemStack(item);
        ItemMeta meta = stack.getItemMeta();


        if (meta != null) {
            meta.setDisplayName(name);
            if (loreString != null && !loreString.isEmpty()) {
                List<String> lore = Arrays.asList(loreString.split("\n"));
                meta.setLore(lore);
            }

            // Set enchantments
            if (enchantments != null && enchantments.length > 0) {
                if (item == Material.ENCHANTED_BOOK) {
                    EnchantmentStorageMeta bookMeta = (EnchantmentStorageMeta) meta;
                    for (Enchantment enchantment : enchantments) {
                        int level = randomizeEnchants ? getRandomEnchantmentLevel(enchantment) : enchantment.getMaxLevel();
                        bookMeta.addStoredEnchant(enchantment, level, true);
                    }
                } else {
                    for (Enchantment enchantment : enchantments) {
                        int level = randomizeEnchants ? getRandomEnchantmentLevel(enchantment) : enchantment.getMaxLevel();
                        meta.addEnchant(enchantment, level, true);
                    }
                }
            }

            stack.setItemMeta(meta);
        }

        return stack;
    }

    private static int getRandomEnchantmentLevel(Enchantment enchantment) {
        Random random = new Random();
        return random.nextInt(enchantment.getMaxLevel()) + 1;
    }
}
