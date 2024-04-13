package org.laykon.survivaloverhaul.CustomItems;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.laykon.survivaloverhaul.Utils;


public enum Gods implements Utils {
    ZEUS(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.DIAMOND_AXE, "&#FFC000&lThunderlord's ", "Crown", "Chestplate", "Leggings", "Boots", "&#FFC000&lThunderbolt Hammer", "zeus", 1, 1
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Grants immunity to lightning damage",
                    "&#C8C8C8and increases movement speed."}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8When striking an enemy, it has a chance to summon",
                            "&#C8C8C8a lightning bolt to strike nearby enemies."}),

    HERA(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.DIAMOND_SWORD, "&#FF00C0&lDivine ", "Tiara", "Robes", "Thong", "Sandals", "&#FF00C0&lScepter of Matrimony", "hera", 2, 1
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Provides resistance to all status effects",
                    "&#C8C8C8and increases health regeneration."}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8Can charm hostile mobs to",
                            "&#C8C8C8temporarily fight for the player."}),

    POSEIDON(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.TRIDENT, "&#00CAC3&lTriton's ", "Helm", "Chestplate", "Leggings", "Flip Flops", "&#00CAC3&lTrident of the Depths", "poseidon", 3, 1
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Allows the player to breathe underwater",
                    "&#C8C8C8indefinitely and swim faster."}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8When thrown, it creates a whirlpool that .",
                            "&#C8C8C8damages and pulls enemies towards it"}),

    DEMETER(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.DIAMOND_HOE, "&#00CA39&lHarvest's ", "Crown", "Vestments", "Legguards", "Boots", "&#00CA39&lStaff of Growth", "demeter", 4, 1
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Automatically replants crops when",
                    "&#C8C8C8harvesting and increases crop yield."}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8Causes plants and crops to instantly be",
                            "&#C8C8C8harvested in alarge area around the player."}),

    ATHENA(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.TRIDENT, "&#B4FBFF&lAegis ", "Helm", "Breastplate", "Legguards", "Boots", "&#B4FBFF&lSpear of Strategy", "athena", 5, 2
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Grants increased protection and reflects a portion",
                    "&#C8C8C8of incoming damage back to the attacker."}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8When thrown, it homes in on enemies and has",
                            "&#C8C8C8a chance to disarm them temporarily."}),

    APOLLO(Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS, Material.BOW, "&#DD6D00&lRadiant ", "Helm", "Breastplate", "Leggings", "Boots", "&#DD6D00&lSolar Bow", "apollo", 1, 1
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Provides immunity to lava and fire damage and",
                    "&#C8C8C8increases attack damage during the day."}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8Fires arrows that ignite enemies on fire",
                            "&#C8C8C8and deal increased damage during the day."}),

    ARTEMIS(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.BOW, "&#036F00&lHunter's ", "Cap", "Tunic", "Leggings", "Boots", "&#036F00&lMoonlit Bow", "artemis", 1, 2
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Grants increased movement speed and",
                    "&#C8C8C8allows the player to track nearby mobs."}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8Shoots arrows that has increased",
                            "&#C8C8C8damage and accuracy at night."}),

    ARES(Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.IRON_SWORD, "&#710000&lWarlord's ", "Helm", "Chestplate", "Leggings", "Boots", "&#710000&lBlade of Chaos", "ares", 1, 1
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Provides increased melee damage."}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8Inflicts damage on all nearby enemies,",
                            "&#C8C8C8be aware. this could backfire."}),

    HEPHAESTUS(Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.IRON_PICKAXE, "&#626262&lMaster's ", "Helmet", "Chestplate", "Leggings", "Boots", "&#626262&lHammer of the Forge", "hephaestus", 2, 1
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Provides immunity to lava and fire damage,"}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8Grants the ability to break blocks",
                            "&#C8C8C8faster and smelts mined ores."}),

    APHRODITE(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.GOLDEN_SWORD, "&#C10000&lEnchanting ", "Cap", "Tunic", "Pants", "Boots", "&#C8C8C8Charm's Kiss", "aphrodite", 2, 1
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Increases the player's charm and persuasion",
                    "&#C8C8C8abilities with villagers and mobs."}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8Can temporarily pacify hostile mobs and",
                            "&#C8C8C8make them neutral towards the player."}),

    HERMES(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.TRIDENT, "&#CABEFF&lWinged ", "Cap", "Tunic", "Pants", "Boots", "&#CABEFF&lCaduceus Staff", "hermes", 3, 3
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Grants increased movement speed and",
                    "&#C8C8C8allows the player to double jump."}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8Allows the player to teleport short distances",
                            "&#C8C8C8and grants increased attack speed"}),

    DIONYSUS(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.GOLDEN_HOE, "&#80007E&lFestive ", "Cap", "Tunic", "Pants", "Boots", "&#80007E&lVine Whip", "dionysus", 4, 1
            ,
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Provides resistance to poison and",
                    "&#C8C8C8increases the potency of potions."}, new String[]{" ", "&f&lAbility:",
                            "&#C8C8C8Releases a splash of wine that temporarily",
                            "&#C8C8C8disorients enemies and heals the player."});

    final Material helmet;
    final Material chestplate;
    final Material legs;
    final Material feet;
    final Material handItem;

    final String prefix;
    final String helmSuffix;
    final String chestSuffix;
    final String legsSuffix;
    final String feetSuffix;
    final String itemName;
    final String key;
    final int armorModel;
    final int itemModel;

    final String[] Armour;
    final String[] Item;


    Gods(Material helm, Material chest, Material legs, Material feet, Material material, String prefix, String helmSuffix, String chestSuffix, String legsSuffix, String feetSuffix, String itemName, String key, int armorModel, int itemModel, String[] armour, String[] item1) {
        this.helmet = helm;
        this.chestplate = chest;
        this.legs = legs;
        this.feet = feet;
        this.handItem = material;
        this.prefix = prefix;
        this.helmSuffix = helmSuffix;
        this.chestSuffix = chestSuffix;
        this.legsSuffix = legsSuffix;
        this.feetSuffix = feetSuffix;
        this.itemName = itemName;
        this.key = key;
        this.armorModel = armorModel;
        this.itemModel = itemModel;
        this.Armour = armour;
        this.Item = item1;
    }

    public static Gods get(String value) {
        return valueOf(value.toUpperCase());
    }

    public ItemStack getItem(final OlympianItem set) {
        return switch (set) {
            case HELMET -> buildCustomItem(helmet, prefix + helmSuffix, key, armorModel, Armour);
            case CHESTPLATE -> buildCustomItem(chestplate, prefix + chestSuffix, key, armorModel, Armour);
            case LEGGINGS -> buildCustomItem(legs, prefix + legsSuffix, key, armorModel, Armour);
            case BOOTS -> buildCustomItem(feet, prefix + feetSuffix, key, armorModel,  Armour);
            case ITEM -> buildCustomItem(handItem, itemName, key + "item", itemModel, Item);
        };
    }
}
