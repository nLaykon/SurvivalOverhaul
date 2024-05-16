package org.laykon.survivaloverhaul.Utility;

import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.laykon.survivaloverhaul.CustomItems.EventHandling.NamespacedKeys;
import org.laykon.survivaloverhaul.SurvivalOverhaul;

public interface CreditHandler {
    Plugin plugin = SurvivalOverhaul.plugin;


    default void setCredits(Player player, int num) {
        player.getPersistentDataContainer().set(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER, num);
    }

    default void addCredits(Player player, int num) {
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER) == null)) {
            Integer current = player.getPersistentDataContainer().get(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER);
            player.getPersistentDataContainer().set(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER, current + num);
        }
    }

    default void removeCredits(Player player, int num) {
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER) == null)) {
            if (player.getPersistentDataContainer().get(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER) >= num) {
                Integer current = player.getPersistentDataContainer().get(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER);
                player.getPersistentDataContainer().set(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER, current - num);
            }
        }
    }

    default int getCredits(Player player) {
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER) == null)) {
            Integer current = player.getPersistentDataContainer().get(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER);
            return current;
        }
        else {
            return 0;
        }
    }
    default void initCredits(Player player){
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER) == null)) {
            return;
        }
        player.getPersistentDataContainer().set(NamespacedKeys.getKey("Credits"), PersistentDataType.INTEGER, 0);
    }
}
