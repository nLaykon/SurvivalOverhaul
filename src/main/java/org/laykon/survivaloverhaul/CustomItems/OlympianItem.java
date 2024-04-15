package org.laykon.survivaloverhaul.CustomItems;

import org.laykon.survivaloverhaul.Utility.Utils;

public enum OlympianItem implements Utils {
    HELMET,
    CHESTPLATE,
    LEGGINGS,
    BOOTS,
    ITEM;

    public static OlympianItem get(final String itemName) {
        return OlympianItem.valueOf(itemName.toUpperCase());
    }
}
