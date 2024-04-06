package org.laykon.survivaloverhaul;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.regex.*;

public interface Utils {
    default String Colour(String s) {
        s = ChatColor.translateAlternateColorCodes('&',s);
        return applyHexColor(s);
    }
    default String[] Colour(String[] s) {
        for (String s1 : s) {
            s = new String[]{ChatColor.translateAlternateColorCodes('&', s1)};
        }
        return s;
    }
    default List<String> Colour(List<String> s) {
        for (String s1 : s) {
            s = Collections.singletonList(ChatColor.translateAlternateColorCodes('&', s1));
        }
        return s;
    }
    default String getPrefix()
    {
        return Colour("");
    }
    default void sendMessage(Player player, String message)
    {
        player.sendMessage(getPrefix() + Colour(message));
    }
    default void sendMessage(CommandSender player, String message) {
        player.sendMessage(getPrefix() + Colour(message));
    }
    default void sendMessage(String message, CommandSender ... players) {
        for (CommandSender player : players) {
            player.sendMessage(getPrefix() + Colour(message));
        }
    }
    default void sendMessage(String message, Player ... players) {
        for (Player player : players) {
            player.sendMessage(getPrefix() + Colour(message));
        }
    }
    default void permissionError(Player player) {
        player.sendMessage(getPrefix() + Colour("&cNo Permission!"));
    }
    default void permissionError(CommandSender player) {
        player.sendMessage(getPrefix() + Colour("&cNo Permission!"));
    }
    default void ErrorMessage(CommandSender player) {
        player.sendMessage(getPrefix() + Colour("&ePlease message &cdank.1234 &eon discord with details."));
    }
    default void ErrorMessage(Player player) {
        player.sendMessage(getPrefix() + Colour("&ePlease message &cdank.1234 &eon discord with details."));
    }
    default String applyHexColor(String text) {
        Pattern hexColorPattern = Pattern.compile("#[0-9a-fA-F]{6}");
        Matcher matcher = hexColorPattern.matcher(text);

        if (matcher.find()) {
            String hexColor = matcher.group();
            text = text.replace(hexColor, net.md_5.bungee.api.ChatColor.of(hexColor) + "");
        }
        return text;
    }
    default ItemStack getItem(ItemStack item, String Name, String ... lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Colour(Name));
        meta.setLore(setLore(lore));
        item.setItemMeta(meta);
        return item;
    }
    default List<String> setLore(String ... s) {
        List<String> lore = new ArrayList<String>();
        for (String s1 : s) {
            lore.add(s1);
        }
        return Colour(lore);
    }

    default void addAttr(ItemMeta meta, String attribute, Double amount){
        meta.addAttributeModifier(Attribute.valueOf(attribute), new AttributeModifier(attribute, amount, AttributeModifier.Operation.ADD_NUMBER));

    }
    default String getNiceName(Material material) {
        String name = material.name().toLowerCase().replace("_", " ");
        return capitalizeWords(name);
    }

    default String capitalizeWords(String str) {
        StringBuilder result = new StringBuilder();
        String[] words = str.split("\\s");
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }

}