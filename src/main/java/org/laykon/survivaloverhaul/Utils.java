package org.laykon.survivaloverhaul;


import net.kyori.adventure.util.Index;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Utils {
    JavaPlugin plugin = SurvivalOverhaul.getInstance();

    default String Colour(String s) {
        s = ChatColor.translateAlternateColorCodes('&', s);
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

    default String getPrefix() {
        return Colour("");
    }

    default void sendMessage(Player player, String message) {
        player.sendMessage(getPrefix() + Colour(message));
    }

    default void sendMessage(CommandSender player, String message) {
        player.sendMessage(getPrefix() + Colour(message));
    }

    default void sendMessage(String message, CommandSender... players) {
        for (CommandSender player : players) {
            player.sendMessage(getPrefix() + Colour(message));
        }
    }

    default void sendMessage(String message, Player... players) {
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

    default ItemStack getItem(ItemStack item, String Name, String... lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Colour(Name));
        meta.setLore(setLore(lore));
        item.setItemMeta(meta);
        return item;
    }

    default List<String> setLore(String... s) {
        List<String> lore = new ArrayList<String>();
        for (String s1 : s) {
            lore.add(s1);
        }
        return Colour(lore);
    }

    default void addAttr(ItemMeta meta, String attribute, Double amount) {
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

    default ItemStack nbtItem(String name, Material item, String key, String value) {
        JavaPlugin plugin = SurvivalOverhaul.getInstance();

        ItemStack itemStack = new ItemStack(item);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(name);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, key), PersistentDataType.STRING, value);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    default boolean isSet(Player player, String tag) {
        if (player.getInventory().getHelmet() == null) return false;
        if (player.getInventory().getChestplate() == null) return false;
        if (player.getInventory().getLeggings() == null) return false;
        if (player.getInventory().getBoots() == null) return false;

        if (!(player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(SurvivalOverhaul.getInstance(), tag), PersistentDataType.STRING)))
            return false;
        if (!(player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(SurvivalOverhaul.getInstance(), tag), PersistentDataType.STRING)))
            return false;
        if (!(player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(SurvivalOverhaul.getInstance(), tag), PersistentDataType.STRING)))
            return false;
        if (!(player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(SurvivalOverhaul.getInstance(), tag), PersistentDataType.STRING)))
            return false;

        return true;
    }

    default boolean isItem(Player player, String tag) {
        if (player.getInventory().getItemInMainHand() == null) return false;
        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(SurvivalOverhaul.getInstance(), tag), PersistentDataType.STRING)) {
            return true;
        }
        return false;
    }

    default String hexColour(String s) {
        final char altColorChar = '&';
        final StringBuilder b = new StringBuilder();
        final char[] mess = s.toCharArray();
        boolean color = false, hashtag = false, doubleTag = false;
        char tmp;
        for (int i = 0; i < mess.length; ) {
            final char c = mess[i];
            if (doubleTag) {
                doubleTag = false;
                final int max = i + 3;
                if (max <= mess.length) {
                    boolean match = true;
                    for (int n = i; n < max; n++) {
                        tmp = mess[n];
                        if (!((tmp >= '0' && tmp <= '9') || (tmp >= 'a' && tmp <= 'f') || (tmp >= 'A' && tmp <= 'F'))) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        b.append(ChatColor.COLOR_CHAR);
                        b.append('x');
                        for (; i < max; i++) {
                            tmp = mess[i];
                            b.append(ChatColor.COLOR_CHAR);
                            b.append(tmp);
                            // Double the color code
                            b.append(ChatColor.COLOR_CHAR);
                            b.append(tmp);
                        }
                        continue;
                    }
                }
                b.append(altColorChar);
                b.append("##");
            }
            if (hashtag) {
                hashtag = false;
                if (c == '#') {
                    doubleTag = true;
                    i++;
                    continue;
                }
                final int max = i + 6;
                if (max <= mess.length) {
                    boolean match = true;
                    for (int n = i; n < max; n++) {
                        tmp = mess[n];
                        if (!((tmp >= '0' && tmp <= '9') || (tmp >= 'a' && tmp <= 'f') || (tmp >= 'A' && tmp <= 'F'))) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        b.append(ChatColor.COLOR_CHAR);
                        b.append('x');
                        for (; i < max; i++) {
                            b.append(ChatColor.COLOR_CHAR);
                            b.append(mess[i]);
                        }
                        continue;
                    }
                }
                b.append(altColorChar);
                b.append('#');
            }
            if (color) {
                color = false;
                if (c == '#') {
                    hashtag = true;
                    i++;
                    continue;
                }
                if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || c == 'r' || (c >= 'k' && c <= 'o') || (c >= 'A' && c <= 'F') || c == 'R' || (c >= 'K' && c <= 'O')) {
                    b.append(ChatColor.COLOR_CHAR);
                    b.append(c);
                    i++;
                    continue;
                }
                b.append(altColorChar);
            }
            if (c == altColorChar) {
                color = true;
                i++;
                continue;
            }
            b.append(c);
            i++;
        }
        if (color) b.append(altColorChar);
        else if (hashtag) {
            b.append(altColorChar);
            b.append('#');
        } else if (doubleTag) {
            b.append(altColorChar);
            b.append("##");
        }
        return b.toString();
    }

    default ItemStack buildCustomItem(Material material, String name, String key, String... strings) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(hexColour(name));
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList<>();
        lore.addAll(Arrays.stream(strings).toList());
        lore.add(" ");
        lore.add("§x§8§0§0§0§C§A§lMYTHICAL");
        lore.replaceAll(this::hexColour);


        meta.setLore(lore);
        meta.getPersistentDataContainer().set(new NamespacedKey(SurvivalOverhaul.getInstance(), key), PersistentDataType.STRING, "true");
        itemStack.setItemMeta(meta);

        return itemStack;
    }

    default boolean isCrop(Material material) {
        return material == Material.WHEAT ||
                material == Material.CARROTS ||
                material == Material.POTATOES ||
                material == Material.BEETROOTS ||
                material == Material.NETHER_WART ||
                material == Material.COCOA;
    }
    default int getMaxAge(Material material){
        if (material == Material.WHEAT ||
            material == Material.CARROTS ||
            material == Material.POTATOES){
            return 7;
        }
        if (material == Material.BEETROOTS ||
            material == Material.NETHER_WART){
            return 3;
        }
        if (material == Material.COCOA){
            return 2;
        }
        return 0;
    }
    default void placeBlockAtLocation(Location location, Material material) {
        World world = location.getWorld();
        Block block = world.getBlockAt(location);
        block.setType(material);
    }
}