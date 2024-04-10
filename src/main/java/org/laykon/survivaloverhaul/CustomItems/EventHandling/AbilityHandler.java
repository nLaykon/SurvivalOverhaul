package org.laykon.survivaloverhaul.CustomItems.EventHandling;

import org.bukkit.Bukkit;
import org.bukkit.CropState;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.laykon.survivaloverhaul.SurvivalOverhaul;
import org.laykon.survivaloverhaul.Utils;

import java.awt.image.CropImageFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AbilityHandler implements Utils, Listener {

    private BukkitRunnable newTask = new BukkitRunnable() {
        @Override
        public void run() {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (isSet(player, "hera")) {
                    player.setRemainingAir(player.getMaximumAir());
                }
            }
        }
    };

    Random rng = new Random();

    @EventHandler
    public void onPlayerShootBow(EntityShootBowEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        //Apollo
        //Fires arrows that ignite enemies on fire, deal increased damage during the day.
        if (isItem(player, "apolloitem")) {
            event.setCancelled(true);
            long time = player.getWorld().getTime();
            Integer damageLevel = event.getBow().getEnchantmentLevel(Enchantment.ARROW_DAMAGE);
            double damageAmount = (7.0 + (2.7 * damageLevel)) * event.getForce();

            if (time > 0 && time < 12000) {
                damageAmount = damageAmount * 2;
            }

            boolean hasInfinity = event.getBow().getEnchantmentLevel(Enchantment.ARROW_INFINITE) > 0;

            if (!hasInfinity) {
                ItemStack arrowStack = player.getInventory().getItem(player.getInventory().first(Material.ARROW));
                if (arrowStack != null && arrowStack.getAmount() > 0) {
                    if (arrowStack.getAmount() == 1) {
                        player.getInventory().remove(arrowStack);
                    } else {
                        arrowStack.setAmount(arrowStack.getAmount() - 1);
                    }
                }
            }


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

                    damageableEntity.damage(damageAmount);
                    damageableEntity.setFireTicks(60);
                    sendMessage(player, "dealt damage to " + hitEntity.getType() + ", new health: " + damageableEntity.getHealth());
                    sendMessage(player, "Damage Dealt: " + damageAmount);

                }
            }

        }

        //Apollo


        //Artemis
        //Shoots arrows that pierce through enemies, have increased accuracy at night.
        if (isItem(player, "artemisitem")) {
            event.setCancelled(true);
            long time = player.getWorld().getTime();
            Integer damageLevel = event.getBow().getEnchantmentLevel(Enchantment.ARROW_DAMAGE);
            double damageAmount = (7.0 + (2.7 * damageLevel)) * event.getForce();

            if (time < 24000 && time > 12000) {
                damageAmount = damageAmount * 2;
            }
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

                    damageableEntity.damage(damageAmount);
                    sendMessage(player, "dealt damage to " + hitEntity.getType() + ", new health: " + damageableEntity.getHealth());
                    sendMessage(player, "Damage Dealt: " + damageAmount);

                }
            }

        }
        //Artemis


    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent it) {
        Entity damaged = it.getEntity();
        Entity damager = it.getDamager();


        //Zeus
        if (it.getEntity() instanceof Player) {
            if (isSet((Player) damaged, "zeus")) {

                if (it.getDamager().getType().equals(EntityType.LIGHTNING)) {
                    it.setCancelled(true);
                }

            }
        }
        if (damager instanceof Player) {
            if (isItem((Player) damager, "zeusitem")) {
                if (rng.nextInt(4) == 0) {

                    List<Entity> entityList = damaged.getNearbyEntities(10, 10, 10);
                    for (Entity entity : entityList) {
                        if (entity == damager) continue;
                        if (entity instanceof Damageable) {
                            damaged.getWorld().strikeLightningEffect(entity.getLocation());
                            ((Damageable) entity).damage(5);
                        }
                    }


                    damaged.getWorld().strikeLightningEffect(damaged.getLocation());
                    ((Damageable) damaged).damage(5);
                }

            }

        }
        //Zeus
        //Hera
        if (damager instanceof Player) {
            if (isItem((Player) damager, "heraitem")) {
                if (rng.nextInt(5) == 0) {
                    if (!(damaged instanceof Player)) {
                        List<Entity> entityList = damaged.getNearbyEntities(10, 10, 10);
                        if (!entityList.isEmpty()) {
                            Random rng = new Random();
                            int randomIndex = rng.nextInt(entityList.size());
                            Entity randomEntity = entityList.get(randomIndex);

                            if (randomEntity instanceof LivingEntity && randomEntity != (Entity) damager) {
                                ((LivingEntity) damaged).attack(randomEntity);
                            }
                        }
                    }
                }
            }
        }
        //Hera

    }

    @EventHandler
    public void onEffect(EntityPotionEffectEvent it) {
        if (!(it.getEntity() instanceof Player)) return;
        Player player = (Player) it.getEntity();
        //Hera
        if (isSet(player, "hera")) {
            try {
                if (it.getNewEffect().getType() == null) return;
                if (Arrays.stream(Potions.BAD.getEffectTypes()).toList().contains(it.getNewEffect().getType())) {
                    it.setCancelled(true);
                }
            } catch (Exception e) {

            }
        }
        //Hera
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent it){
        Player player = it.getPlayer();
        Block block = it.getBlock();

        //Demeter
        if (isSet(player, "demeter")){
            if (isCrop(block.getType())){
                BlockState state = block.getState();
                Crops crops = (Crops) state.getData();
                int age = crops.getState().getData();
                Location loc = block.getLocation();
                if (age == getMaxAge(block.getType())){
                    Collection<ItemStack> droppedItems = block.getDrops();
                    for (ItemStack item : droppedItems){
                        loc.getWorld().dropItemNaturally(loc, item);
                        System.out.println(item.getItemMeta().getDisplayName());
                    }
                    block.setType(block.getType());
                    System.out.println(block.getDrops());
                    sendMessage(player, "Get Farmed BITCH");
                    it.setCancelled(true);
                }else {
                 it.setCancelled(true);
                }
            }
        }
        //Demeter

    }
    @EventHandler
    public void onInteract(PlayerInteractEvent it){

    }



}
