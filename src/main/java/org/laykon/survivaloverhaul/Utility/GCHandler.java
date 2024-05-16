package org.laykon.survivaloverhaul.Utility;

import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.laykon.survivaloverhaul.CustomItems.EventHandling.NamespacedKeys;
import org.laykon.survivaloverhaul.SurvivalOverhaul;

public interface GCHandler {
    Plugin plugin = SurvivalOverhaul.plugin;

    default String GC(){
        return "\uD83E\uDE99";
    }

    default void setGC(Player player, long num) {
        player.getPersistentDataContainer().set(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG, num);
    }

    default void addGC(Player player, int num) {
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG) == null)) {
            long current = player.getPersistentDataContainer().get(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG);
            player.getPersistentDataContainer().set(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG, current + num);
        }
    }

    default void removeGC(Player player, long num) {
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG) == null)) {
            if (player.getPersistentDataContainer().get(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG) >= num) {
                long current = player.getPersistentDataContainer().get(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG);
                player.getPersistentDataContainer().set(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG, current - num);
            }
        }
    }

    default long getGC(Player player) {
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG) == null)) {
            long current = player.getPersistentDataContainer().get(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG);
            return current;
        }
        else {
            return 0;
        }
    }
    default void initGC(Player player){
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG) == null)) {
            return;
        }
        player.getPersistentDataContainer().set(NamespacedKeys.getKey("GoldCoins"), PersistentDataType.LONG, 0L);
    }
}
