package org.laykon.survivaloverhaul.CustomBosses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.laykon.survivaloverhaul.CustomItems.EventHandling.NamespacedKeys;

@AllArgsConstructor
@Getter
public enum Bosses {
    ENDERMAN(200, 10, 2, new ItemStack(Material.NETHERITE_HELMET), new ItemStack(Material.NETHERITE_CHESTPLATE), new ItemStack(Material.NETHERITE_LEGGINGS), new ItemStack(Material.NETHERITE_BOOTS), new ItemStack(Material.NETHERITE_SWORD), NamespacedKeys.getKey("endermanboss"));

    //final EntityType entityType;
    final double entityHealth;
    final double entityDamage;
    final double entitySpeed;
    final ItemStack armorHelmet;
    final ItemStack armorChestplate;
    final ItemStack armorLeggings;
    final ItemStack armorBoots;
    final ItemStack weapon;
    final NamespacedKey pbvData;

    public Bosses getBoss() {
        return ENDERMAN;
    }

    public static EntityType extendMobEntity(final EntityType entityType) {
        return entityType;
    }

}


