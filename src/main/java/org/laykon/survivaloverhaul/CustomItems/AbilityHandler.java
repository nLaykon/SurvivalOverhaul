package org.laykon.survivaloverhaul.CustomItems;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.laykon.survivaloverhaul.Utils;

public class AbilityHandler implements Utils, Listener {
    @EventHandler
    public void onPlayerShootBow(EntityShootBowEvent event) {
        if(!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        //Bow
        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(plugin, "railgun"), PersistentDataType.STRING)){

            Integer damageLevel = event.getBow().getEnchantmentLevel(Enchantment.ARROW_DAMAGE);

            event.setCancelled(true);

            Location eyeLoc = player.getEyeLocation();
            Vector direction = eyeLoc.getDirection().normalize();
            RayTraceResult result = eyeLoc.getWorld().rayTraceEntities(eyeLoc, direction, 64d, 0.1, entity -> {
                if (!(entity == player)) {
                    return true;
                }
                return false;
            });

            if (result != null && result.getHitEntity() != null) {
                Entity hitEntity = result.getHitEntity();
                if (hitEntity instanceof Damageable) {
                    Damageable damageableEntity = (Damageable) hitEntity;

                    double damageAmount = (7.0 + (2.7*damageLevel)) * event.getForce();
                    damageableEntity.damage(damageAmount);
                    sendMessage(player, "dealt damage to " + hitEntity.getType() + ", new health: " + damageableEntity.getHealth());

                    if (damageableEntity.getHealth() <= 0) {

                    }
                }
            }
        }
        //Bow




    }
}
