package org.laykon.survivaloverhaul.CustomItems.EventHandling;

import org.bukkit.NamespacedKey;
import org.laykon.survivaloverhaul.SurvivalOverhaul;

import java.util.HashMap;
import java.util.Map;

public class NamespacedKeys {

    private static final Map<String, NamespacedKey> keys = new HashMap<>();
    public static NamespacedKey getKey(String id) {
        return keys.computeIfAbsent(id, key -> new NamespacedKey(SurvivalOverhaul.getInstance(), key));
    }


}
