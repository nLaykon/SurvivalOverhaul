package org.laykon.survivaloverhaul.CustomItems;

import org.bukkit.Material;

public enum Gods {
    ZEUS(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.DIAMOND_AXE, "Thunderlord's ", "Crown", "Chestplate", "Leggings", "Boots", "Thunderbolt Hammer"),

    HERA(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.DIAMOND_SWORD, "Divine ", "Tiara", "Robes", "Thong", "Sandals", "Scepter of Matrimony"),

    POSEIDON(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS , Material.TRIDENT, "Triton's ", "Helm", "Chestplate", "Leggings", "Flip Flops", "Trident of the Depths"),

    DEMETER(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS , Material.DIAMOND_HOE, "Harvest's ", "Crown", "Vestments", "Legguards", "Boots", "Staff of Growth"),

    ATHENA(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS , Material.TRIDENT, "Aegis ", "Helm", "Breastplate", "Legguards", "Boots", "Spear of Strategy"),

    APOLLO(Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS, Material.BOW, "Radiant ", "Helm", "Breastplate", "Leggings", "Boots", "Solar Bow"),

    ARTEMIS(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.BOW, "Hunter's ", "Cap", "Tunic", "Leggings", "Boots", "Moonlit Bow"),

    ARES(Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.IRON_SWORD, "Warlord's ", "Helm", "Chestplate", "Leggings", "Boots", "Blade of Chaos"),

    HEPHAESTUS(Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.IRON_PICKAXE , "Master's ", "Helmet", "Chestplate", "Leggings", "Boots", "Hammer of the Forge"),

    APHRODITE(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS , Material.GOLDEN_SWORD, "Enchanting ", "Cap", "Tunic", "Pants", "Boots", "Charm's Kiss"),

    HERMES(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.TRIDENT, "Winged ", "Cap", "Tunic", "Pants", "Boots", "Caduceus Staff"),

    DIONYSUS(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS , Material.GOLDEN_HOE, "Festive ", "Cap", "Tunic", "Pants", "Boots", "Vine Whip");

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


    Gods(Material helm, Material chest, Material legs, Material feet, Material item, String prefix, String helmSuffix, String chestSuffix, String legsSuffix, String feetSuffix, String itemName) {
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
    }
}
