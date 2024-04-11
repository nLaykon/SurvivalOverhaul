package org.laykon.survivaloverhaul.CustomItems;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.laykon.survivaloverhaul.Utils;

import java.util.ArrayList;

public enum Gods implements Utils {
    ZEUS(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.DIAMOND_AXE, "&#FFC000&lThunderlord's ", "Crown", "Chestplate", "Leggings", "Boots", "&#FFC000&lThunderbolt Hammer", "zeus",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Grants immunity to lightning damage",
                    "&#C8C8C8and increases movement speed."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8When striking an enemy, it has a chance to summon",
                    "&#C8C8C8a lightning bolt to strike nearby enemies."}),

    HERA(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.DIAMOND_SWORD, "&#FF00C0&lDivine ", "Tiara", "Robes", "Thong", "Sandals", "&#FF00C0&lScepter of Matrimony", "hera",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Provides resistance to all status effects",
                    "&#C8C8C8and increases health regeneration."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8Can charm hostile mobs to",
                    "&#C8C8C8temporarily fight for the player."}),

    POSEIDON(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.TRIDENT, "&#00CAC3&lTriton's ", "Helm", "Chestplate", "Leggings", "Flip Flops", "&#00CAC3&lTrident of the Depths", "poseidon",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Allows the player to breathe underwater",
                    "&#C8C8C8indefinitely and swim faster."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8When thrown, it creates a whirlpool that .",
                    "&#C8C8C8damages and pulls enemies towards it"}),

    DEMETER(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.DIAMOND_HOE, "&#00CA39&lHarvest's ", "Crown", "Vestments", "Legguards", "Boots", "&#00CA39&lStaff of Growth", "demeter",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Automatically replants crops when",
                    "&#C8C8C8harvesting and increases crop yield."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8Causes plants and crops to instantly be",
                    "&#C8C8C8harvested in alarge area around the player."}),

    ATHENA(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.TRIDENT, "&#B4FBFF&lAegis ", "Helm", "Breastplate", "Legguards", "Boots", "&#B4FBFF&lSpear of Strategy", "athena",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Grants increased protection and reflects a portion",
                    "&#C8C8C8of incoming damage back to the attacker."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8When thrown, it homes in on enemies and has",
                    "&#C8C8C8a chance to disarm them temporarily."}),

    APOLLO(Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS, Material.BOW, "&#DD6D00&lRadiant ", "Helm", "Breastplate", "Leggings", "Boots", "&#DD6D00&lSolar Bow", "apollo",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Provides immunity to lava and fire damage and",
                    "&#C8C8C8increases attack damage during the day."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8Fires arrows that ignite enemies on fire",
                    "&#C8C8C8and deal increased damage during the day."}),

    ARTEMIS(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.BOW, "&#036F00&lHunter's ", "Cap", "Tunic", "Leggings", "Boots", "&#036F00&lMoonlit Bow", "artemis",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Grants increased movement speed and",
                    "&#C8C8C8allows the player to track nearby mobs."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8Shoots arrows that has increased",
                    "&#C8C8C8damage and accuracy at night."}),

    ARES(Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.IRON_SWORD, "&#710000&lWarlord's ", "Helm", "Chestplate", "Leggings", "Boots", "&#710000&lBlade of Chaos", "ares",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Provides increased melee damage",
                    "&#C8C8C8and resistance to knockback."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8Inflicts additional damage over time on enemies and has a",
                    "&#C8C8C8chance to cause chaos, making enemies attack each other."}),

    HEPHAESTUS(Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.IRON_PICKAXE, "&#626262&lMaster's ", "Helmet", "Chestplate", "Leggings", "Boots", "&#626262&lHammer of the Forge", "hephaestus",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Provides immunity to lava and fire damage,",
                    "&#C8C8C8and allows the player to smelt items faster."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8Grants the ability to break blocks",
                    "&#C8C8C8faster and smelts mined ores."}),

    APHRODITE(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.GOLDEN_SWORD, "&#C10000&lEnchanting ", "Cap", "Tunic", "Pants", "Boots", "Charm's Kiss", "aphrodite",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Increases the player's charm and persuasion",
                    "&#C8C8C8abilities with villagers and mobs."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8Can temporarily pacify hostile mobs and",
                    "&#C8C8C8make them neutral towards the player."}),

    HERMES(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.TRIDENT, "&#CABEFF&lWinged ", "Cap", "Tunic", "Pants", "Boots", "&#CABEFF&lCaduceus Staff", "hermes",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Grants increased movement speed and",
                    "&#C8C8C8allows the player to double jump."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8Allows the player to teleport short distances",
                    "&#C8C8C8and grants increased attack speed"}),

    DIONYSUS(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.GOLDEN_HOE, "&#80007E&lFestive ", "Cap", "Tunic", "Pants", "Boots", "&#80007E&lVine Whip", "dionysus",
            new String[]{" ", "&f&lSet Bonus:",
                    "&#C8C8C8Provides resistance to poison and",
                    "&#C8C8C8increases the potency of potions."},
            new String[]{" ", "&f&lAbility:",
                    "&#C8C8C8Releases a splash of wine that temporarily",
                    "&#C8C8C8disorients enemies and heals the player."});

    final Material helm;
    final Material chest;
    final Material legs;
    final Material feet;
    final Material item;
    final String prefix;
    final String helmSuffix;
    final String chestSuffix;
    final String legsSuffix;
    final String feetSuffix;
    final String itemName;
    final String key;
    final String[] Armour;
    final String[] Item;


    Gods(Material helm, Material chest, Material legs, Material feet, Material item, String prefix, String helmSuffix, String chestSuffix, String legsSuffix, String feetSuffix, String itemName, String key, String[] armour, String[] item1) {
        this.helm = helm;
        this.chest = chest;
        this.legs = legs;
        this.feet = feet;
        this.item = item;
        this.prefix = prefix;
        this.helmSuffix = helmSuffix;
        this.chestSuffix = chestSuffix;
        this.legsSuffix = legsSuffix;
        this.feetSuffix = feetSuffix;
        this.itemName = itemName;
        this.key = key;
        Armour = armour;
        Item = item1;
    }

    public ItemStack getItem(OlympianSets set) {
        if (set == OlympianSets.HELMET) {
            return buildCustomItem(helm, prefix + helmSuffix, key, Armour);
        }
        if (set == OlympianSets.CHESTPLATE) {
            return buildCustomItem(chest, prefix + chestSuffix, key, Armour);
        }
        if (set == OlympianSets.LEGGINGS) {
            return buildCustomItem(legs, prefix + legsSuffix, key, Armour);
        }
        if (set == OlympianSets.BOOTS) {
            return buildCustomItem(feet, prefix + feetSuffix, key, Armour);
        }
        if (set == OlympianSets.ITEM) {
            return buildCustomItem(item, itemName, key+"item", Item);
        }
        return null;
    }

    public ArrayList<ItemStack> getSet(OlympianSets set){
        if (set == null) return null;
        ArrayList<ItemStack> items = new ArrayList<>();
        items.add(buildCustomItem(helm, prefix + helmSuffix, key, Armour));
        items.add(buildCustomItem(chest, prefix + chestSuffix, key, Armour));
        items.add(buildCustomItem(legs, prefix + legsSuffix, key, Armour));
        items.add(buildCustomItem(feet, prefix + feetSuffix, key, Armour));
        items.add(buildCustomItem(item, itemName, key+"item", Item));

        return items;
    }
}
