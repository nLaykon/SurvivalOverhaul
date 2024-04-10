package org.laykon.survivaloverhaul.CustomItems;


import org.bukkit.inventory.ItemStack;
import org.laykon.survivaloverhaul.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum OlympianSets implements Utils{
    HELMET,
    CHESTPLATE,
    LEGGINGS,
    BOOTS,
    ITEM;

    final List<Gods> gods;


    OlympianSets() {
        List<Gods> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(Gods.values()));
        this.gods = arr;
    }

    public List<Gods> getGods() {
        return gods;
    }

    public ItemStack getItem(Gods god){
        return god.getItem(this);
    }
}
