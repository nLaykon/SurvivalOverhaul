package org.laykon.survivaloverhaul.Utility;

import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.laykon.survivaloverhaul.CustomItems.EventHandling.NamespacedKeys;
import org.laykon.survivaloverhaul.SurvivalOverhaul;

public interface GemHandler {
    Plugin plugin = SurvivalOverhaul.plugin;

    default String Gem(){
        return "\uD83D\uDC8E";
    }

    default void setGems(Player player, long num) {
        player.getPersistentDataContainer().set(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG, num);
    }

    default void addGems(Player player, int num) {
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG) == null)) {
            long current = player.getPersistentDataContainer().get(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG);
            player.getPersistentDataContainer().set(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG, current + num);
        }
    }

    default void removeGems(Player player, long num) {
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG) == null)) {
            if (player.getPersistentDataContainer().get(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG) >= num) {
                long current = player.getPersistentDataContainer().get(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG);
                player.getPersistentDataContainer().set(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG, current - num);
            }
        }
    }

    default long getGems(Player player) {
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG) == null)) {
            long current = player.getPersistentDataContainer().get(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG);
            return current;
        }
        else {
            return 0;
        }
    }
    default void initGems(Player player){
        if (!(player.getPersistentDataContainer().get(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG) == null)) {
            return;
        }
        player.getPersistentDataContainer().set(NamespacedKeys.getKey("Gems"), PersistentDataType.LONG, 0l);
    }
}
