package org.laykon.survivaloverhaul;


import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.*;
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
        if (player.getInventory().getItemInMainHand().isEmpty()) return false;
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

    default ItemStack buildCustomItem(final Material material, final String itemName, final String key, final int modelNum, final String... loreStrings) {
        var lore = new ArrayList<>(Arrays.stream(loreStrings).toList());
        lore.add(" ");
        lore.add("&#8000CA&lMYTHICAL");
        lore.replaceAll(this::hexColour);

        UUID uniqueItemID = UUID.randomUUID();

        var itemStack = new ItemStack(material);

        var meta = itemStack.getItemMeta();
        //Checks if its armor, if it is, adds armor and armor toughness
        if (isArmor(material)){
            AttributeModifier armorToughness = new AttributeModifier(UUID.randomUUID(), "random", 4.0, AttributeModifier.Operation.ADD_NUMBER, getArmorSlot(itemStack));
            meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, armorToughness);
            AttributeModifier armor = new AttributeModifier(UUID.randomUUID(), "random", 7.0, AttributeModifier.Operation.ADD_NUMBER, getArmorSlot(itemStack));
            meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        }

        meta.setDisplayName(hexColour(itemName));
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.setCustomModelData(modelNum);

        // This _needs_to be a String type
        var itemKey = new NamespacedKey(SurvivalOverhaul.getInstance(), key);
        meta.getPersistentDataContainer().set(itemKey, PersistentDataType.STRING, "true");
        meta.getPersistentDataContainer().set(new NamespacedKey(SurvivalOverhaul.getInstance(), "UniqueID"), PersistentDataType.STRING, uniqueItemID.toString());

        // Yes, you have to set it even though we called a get before with a pass on reference... #Minecraft
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
    default boolean isInWater(Player player) {
        Location loc = player.getLocation();
        Block block = loc.getBlock();
        return block.getType() == Material.WATER || block.getType() == Material.WATER;
    }
    default List<Block> getNearbyBlocks(Location location, int radius) {
        List<Block> nearbyBlocks = new ArrayList<>();
        World world = null;
        try {
            world = location.getWorld();
        }catch (Exception e){
            Bukkit.getLogger().info("World not found for 'getNearbyBlocks'");
        }


        if (world != null) {
            int minX = location.getBlockX() - radius;
            int minY = location.getBlockY() - radius;
            int minZ = location.getBlockZ() - radius;
            int maxX = location.getBlockX() + radius;
            int maxY = location.getBlockY() + radius;
            int maxZ = location.getBlockZ() + radius;
            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    for (int z = minZ; z <= maxZ; z++) {
                        Block block = world.getBlockAt(x, y, z);
                        nearbyBlocks.add(block);
                    }
                }
            }
        }
        return nearbyBlocks;
    }
    default Entity getNearestEntity(Player player) {
        double lowestDistance = 32;
        Entity closestEntity = null;

        for (Entity entity : player.getNearbyEntities(10, 10, 10)) {
            if (entity ==  (Entity) player) continue;
            double distance = entity.getLocation().distance(player.getLocation());
            if (distance < lowestDistance) {
                lowestDistance = distance;
                closestEntity = entity;
            }
        }

        return closestEntity;
    }
    default boolean hasClearLineOfSight(Location start, Location end) {
        World world = start.getWorld();
        if (world == null) return false;

        Vector direction = end.toVector().subtract(start.toVector()).normalize();
        double distance = start.distance(end);
        Location loc = start.clone();

        for (int i = 0; i < distance; i++) {
            loc.add(direction);
            Block block = loc.getBlock();
            //Bukkit.broadcastMessage("Checking block at " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + ": " + block.getType());
            if (!(block.isPassable())) {
                return false; // Solid block in the way
            }
        }

        return true; // No solid blocks in the way
    }
    default boolean isDupe(Inventory inventory, ItemStack itemPickedUp){
        if (!(itemPickedUp.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(SurvivalOverhaul.getInstance(), "uniqueid")))) return false;
        UUID uuid = UUID.fromString(Objects.requireNonNull(itemPickedUp.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(SurvivalOverhaul.getInstance(), "uniqueid"), PersistentDataType.STRING)));
        for (ItemStack itemStack : inventory){
            if (!(itemStack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(SurvivalOverhaul.getInstance(), "uniqueid")))) continue;

            if(itemPickedUp.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(SurvivalOverhaul.getInstance(), "uniqueid"), PersistentDataType.STRING) == itemStack.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(SurvivalOverhaul.getInstance(), "uniqueid"), PersistentDataType.STRING)){
                return true;
            }

        }
        return false;
    }

    default ItemStack smelt (ItemStack itemStack){
        switch (itemStack.getType()){
            case RAW_IRON -> itemStack.setType(Material.IRON_INGOT);
            case RAW_COPPER -> itemStack.setType(Material.COPPER_INGOT);
            case RAW_GOLD -> itemStack.setType(Material.GOLD_INGOT);
        }

        return itemStack;
    }

    default boolean isArmor (Material material){
        //Check if the material is an armor type, return true if it is, return false if it isnt
        String materialName = material.name();
        // Check if the material name contains "HELMET", "CHESTPLATE", "LEGGINGS", or "BOOTS"
        return materialName.endsWith("_HELMET") ||
                materialName.endsWith("_CHESTPLATE") ||
                materialName.endsWith("_LEGGINGS") ||
                materialName.endsWith("_BOOTS");
    }

    default EquipmentSlot getArmorSlot(ItemStack armorItem) {
        Material itemType = armorItem.getType();

        switch (itemType) {
            case DIAMOND_HELMET:
            case IRON_HELMET:
            case GOLDEN_HELMET:
            case LEATHER_HELMET:
            case TURTLE_HELMET:
            case NETHERITE_HELMET:
                return EquipmentSlot.HEAD;

            case DIAMOND_CHESTPLATE:
            case IRON_CHESTPLATE:
            case GOLDEN_CHESTPLATE:
            case LEATHER_CHESTPLATE:
            case NETHERITE_CHESTPLATE:
                return EquipmentSlot.CHEST;

            case DIAMOND_LEGGINGS:
            case IRON_LEGGINGS:
            case GOLDEN_LEGGINGS:
            case LEATHER_LEGGINGS:
            case NETHERITE_LEGGINGS:
                return EquipmentSlot.LEGS;

            case DIAMOND_BOOTS:
            case IRON_BOOTS:
            case GOLDEN_BOOTS:
            case LEATHER_BOOTS:
            case NETHERITE_BOOTS:
                return EquipmentSlot.FEET;

            default:
                return null;
        }
    }
    default boolean isAnimal(EntityType entityType){
        switch (entityType) {
            case CHICKEN:
            case COW:
            case DONKEY:
            case FOX:
            case HORSE:
            case LLAMA:
            case MUSHROOM_COW:
            case MULE:
            case PIG:
            case RABBIT:
            case SHEEP:
            case TURTLE:
                return true;
            default:
                return false;
        }
    }

}