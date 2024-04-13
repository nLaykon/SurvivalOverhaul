package org.laykon.survivaloverhaul.CustomItems.EventHandling;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.material.Crops;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.laykon.survivaloverhaul.CustomItems.Gods;
import org.laykon.survivaloverhaul.CustomItems.OlympianItem;
import org.laykon.survivaloverhaul.SurvivalOverhaul;
import org.laykon.survivaloverhaul.Utils;

import java.util.*;

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

    List<ItemStack> cropDrops = new ArrayList<>(Arrays.asList(
            Gods.DEMETER.getItem(OlympianItem.HELMET),
            Gods.DEMETER.getItem(OlympianItem.CHESTPLATE),
            Gods.DEMETER.getItem(OlympianItem.LEGGINGS),
            Gods.DEMETER.getItem(OlympianItem.BOOTS),
            Gods.DEMETER.getItem(OlympianItem.ITEM)
    ));

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

        //Athena
        if (damaged instanceof Player) {
            if (isSet((Player) damaged, "athena")) {
                it.setCancelled(true);
                double taken = (it.getDamage() * 0.75);
                double reflection = (it.getDamage() / 4);
                ((Player) damaged).damage(taken);
                try {
                    ((LivingEntity) damager).damage(reflection, damaged);
                } catch (Exception e) {
                }
            }
        }
        //Athena

        //Ares
        if (damager instanceof Player) {
            Player player = (Player) damager;
            if (isItem(player, "aresitem")) {
                List<Entity> entityList = player.getNearbyEntities(5, 4, 5);
                for (Entity entity : entityList) {
                    if (entity == player) continue;
                    if (!(entity instanceof Damageable)) continue;
                    ((Damageable) entity).damage(it.getDamage());
                }
                if (rng.nextInt(10) == 0) {
                    player.damage(it.getDamage() / 2);
                }
            }
        }


        //Ares

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

        //Dionysus
        if (isSet(player, "dionysus")) {
            try {
                if (it.getNewEffect().getType() == null) return;
                if (it.getNewEffect().getType().equals(PotionEffectType.POISON)) ;
                it.setCancelled(true);
            } catch (Exception e) {
            }

        }

        if (isItem(player, "dionysusitem")) {
            try {
                if (it.getNewEffect().getType().equals(PotionEffectType.CONFUSION)) {
                    player.setHealth(player.getMaxHealth());
                    it.setCancelled(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        //Dionysus


    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent it) {
        Player player = it.getPlayer();
        Block block = it.getBlock();

        //Demeter
        if (isSet(player, "demeter")) {
            if (!(player.isSneaking())) {
                if (isCrop(block.getType())) {
                    BlockState state = block.getState();
                    Crops crops = (Crops) state.getData();
                    int age = crops.getState().getData();
                    Location loc = block.getLocation();
                    if (age == getMaxAge(block.getType())) {
                        Collection<ItemStack> droppedItems = block.getDrops();
                        if (rng.nextInt(100) == 0) {
                            droppedItems.add(cropDrops.get(rng.nextInt(cropDrops.size())));
                        }

                        for (ItemStack item : droppedItems) {
                            loc.getWorld().dropItemNaturally(loc, item);
                        }
                        block.setType(block.getType());
                        it.setCancelled(true);
                    } else {
                        it.setCancelled(true);
                    }
                }
            }
        }
        //Demeter

        //Hephaestus
        if (isItem(player, "hephaestusitem")) {
            Location blockLoc = it.getBlock().getLocation();
            Collection<ItemStack> drops = it.getBlock().getDrops(it.getPlayer().getInventory().getItemInMainHand());
            for (ItemStack item : drops) {
                blockLoc.getWorld().dropItemNaturally(blockLoc, smelt(item));
            }
        }
        //Hephaestus

    }

    final Set<UUID> aphroditeCharm = new HashSet<>();
    final List<LivingEntity> charmedMob = new ArrayList<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent it) {

        Location loc = it.getInteractionPoint();
        if (it.getAction().isRightClick()) {

            Player player = it.getPlayer();
            //Artemis
            if (isSet(player, "artemis")) {
                if (glowAura.contains(player.getUniqueId())) {
                    return;
                }
                List<Entity> nearbyEntities = player.getNearbyEntities(65, 25, 65);

                for (Entity entity : nearbyEntities) {
                    if (entity == player) return;
                    entity.setGlowing(true);
                }
                Bukkit.getScheduler().runTaskLater(SurvivalOverhaul.getInstance(), () -> {
                    for (Entity entity : nearbyEntities)
                        entity.setGlowing(false);
                }, 10L * 20);
                glowAura.add(player.getUniqueId());
                Bukkit.getScheduler().runTaskLater(SurvivalOverhaul.getInstance(), () -> glowAura.remove(player.getUniqueId()), 60L * 20);

            }
            //Artemis

            //Demeter
            if (isItem(player, "demeterItem")) {
                if (demeterHarvest.contains(player.getUniqueId())) return;
                List<Block> blocks = getNearbyBlocks(loc, 4);
                if (isSet(player, "demeter")) {
                    for (Block block : blocks) {
                        if (isCrop(block.getType())) {
                            BlockState state = block.getState();
                            Crops crops = (Crops) state.getData();
                            int age = crops.getState().getData();
                            if (age == getMaxAge(block.getType())) {
                                Collection<ItemStack> droppedItems = block.getDrops();
                                if (rng.nextInt(250) == 0) {
                                    droppedItems.add(cropDrops.get(rng.nextInt(cropDrops.size())));
                                }
                                for (ItemStack item : droppedItems) {
                                    loc.getWorld().dropItemNaturally(loc, item);
                                }
                                block.setType(block.getType());
                            }
                        }
                    }
                } else {
                    for (Block block : blocks) {
                        if (isCrop(block.getType())) {
                            BlockState state = block.getState();
                            Crops crops = (Crops) state.getData();
                            int age = crops.getState().getData();
                            if (age == getMaxAge(block.getType()))
                                block.breakNaturally(player.getInventory().getItemInMainHand());
                        }
                    }
                }
                demeterHarvest.add(player.getUniqueId());
                Bukkit.getScheduler().runTaskLater(SurvivalOverhaul.getInstance(), () -> demeterHarvest.remove(player.getUniqueId()), 100L);
            }
            //Demeter

            //Aphrodite
            if (isItem(player, "aphroditeitem")) {
                if (aphroditeCharm.contains(player.getUniqueId())) return;
                List<Entity> entityList = player.getNearbyEntities(10, 5, 10);
                for (Entity entity : entityList) {
                    if (!(entity instanceof LivingEntity)) continue;
                    if (entity == player) continue;
                    LivingEntity livingEntity = (LivingEntity) entity;
                    if (!(livingEntity.hasAI())) continue;
                    charmedMob.add(livingEntity);
                    livingEntity.setAI(false);

                }


                Bukkit.getScheduler().runTaskLater(SurvivalOverhaul.getInstance(), () -> {
                    Iterator<LivingEntity> iterator = charmedMob.iterator();
                    while (iterator.hasNext()) {
                        LivingEntity livingEntity1 = iterator.next();
                        try {
                            livingEntity1.setAI(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        iterator.remove();
                    }
                }, 5 * 20);

                //Add Cooldown
                aphroditeCharm.add(player.getUniqueId());
                Bukkit.getScheduler().runTaskLater(SurvivalOverhaul.getInstance(), () -> aphroditeCharm.remove(player.getUniqueId()), 100L * 20);
            }
            //Aphrodite

            // Hermes
            if (isItem(player, "hermesitem")) {
                if (hermesCooldown.contains(player.getUniqueId())) return;

                Location playerLocation = player.getLocation();
                Vector direction = playerLocation.getDirection().normalize();

                Location pickedLoc = playerLocation.add(direction.multiply(30));
                if (!pickedLoc.getBlock().isPassable())
                    player.teleport(pickedLoc.getWorld().getHighestBlockAt(pickedLoc).getLocation().add(0, 1, 0));
                else player.teleport(pickedLoc);
                hermesCooldown.add(player.getUniqueId());
                Bukkit.getScheduler().runTaskLater(SurvivalOverhaul.getInstance(), () -> hermesCooldown.remove(player.getUniqueId()), 5L * 20);
            }
            //Hermes

            //Dionysus
            if (isItem(player, "dionysusitem")) {
                it.setCancelled(true);
                if (dionysusCooldown.contains(player.getUniqueId())) return;
                World world = player.getWorld();
                Location location = player.getEyeLocation();
                Player shooter = it.getPlayer();

                ItemStack potion = new ItemStack(Material.SPLASH_POTION);

                PotionMeta meta = (PotionMeta) potion.getItemMeta();
                meta.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 400, 4), true); // 200 ticks, potency 1
                potion.setItemMeta(meta);

                ThrownPotion thrownPotion = world.spawn(shooter.getEyeLocation(), ThrownPotion.class);

                thrownPotion.setItem(potion);

                Vector direction = shooter.getEyeLocation().getDirection().multiply(1.5);
                thrownPotion.setVelocity(direction);
                dionysusCooldown.add(player.getUniqueId());
                Bukkit.getScheduler().runTaskLater(SurvivalOverhaul.getInstance(), () -> dionysusCooldown.remove(player.getUniqueId()), 30L * 20);

            }
            //Dionysus
        }

    }

    private final Set<UUID> doubleJumpers = new HashSet<>();
    private final Set<UUID> demeterHarvest = new HashSet<>();
    private final Set<UUID> glowAura = new HashSet<>();
    private final Set<UUID> hermesCooldown = new HashSet<>();
    private final Set<UUID> dionysusCooldown = new HashSet<>();

    @EventHandler
    public void onPlayerJump(PlayerJumpEvent it) {

    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location from = event.getFrom();
        Location to = event.getTo();

        //Hermes
        if (isSet(player, "hermes")) {
            if (from != null && to != null && to.getY() > from.getY()) {
                if (!player.isOnGround() && !doubleJumpers.contains(player.getUniqueId())) {
                    if (!isInWater(player)) {
                        player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));
                        doubleJumpers.add(player.getUniqueId());
                    }
                }
            }
            if (to != null && player.isOnGround()) {
                doubleJumpers.remove(player.getUniqueId());
            }
        }
        //Hermes
    }

    @EventHandler
    public void onDamage(EntityDamageEvent it) {
        Player player;

        if (it.getEntity() instanceof Player) {
            player = (Player) it.getEntity();
            //Hermes
            if (isSet(player, "hermes")) {
                if (it.getCause() == EntityDamageEvent.DamageCause.FALL) it.setCancelled(true);
            }
            //Hermes

            //Apollo
            if (isSet(player, "apollo")) {
                if (it.getCause() == EntityDamageEvent.DamageCause.FIRE || it.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)
                    it.setCancelled(true);
            }
            //Apollo

            //Hephaestus
            if (isSet(player, "hephaestus")) {
                if (it.getCause() == EntityDamageEvent.DamageCause.FIRE || it.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK || it.getCause() == EntityDamageEvent.DamageCause.LAVA)
                    it.setCancelled(true);
            }
            //Hephaestus
        }


    }

    @EventHandler
    public void onTridentThrow(ProjectileLaunchEvent it) {
        if (!(it.getEntity().getShooter() instanceof Player)) return;
        Player player = (Player) it.getEntity().getShooter();


        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (!isItem(player, "athenaitem")) return;

        Location playerLoc = player.getEyeLocation();

        List<Entity> nearbyEntities = player.getNearbyEntities(20, 5, 20);

        for (Entity entity : nearbyEntities) {
            if (entity == player || !(entity instanceof Damageable) || entity.getType() == EntityType.ENDERMAN)
                continue;
            Location targetLoc = entity.getLocation().add(0, 0.5, 0);

            if (hasClearLineOfSight(playerLoc, targetLoc)) {
                it.setCancelled(true);
                Vector direction = (targetLoc.add(0, 0.5, 0)).toVector().subtract(playerLoc.toVector()).normalize();
                double speed = 5.5;
                Vector velocity = direction.multiply(speed);
                it.getEntity().setGravity(false);
                it.getEntity().setVelocity(velocity);

                it.getEntity().getWorld().spawnArrow(it.getEntity().getLocation(), velocity, 5, 0, Trident.class).setGravity(false);
                player.getInventory().setItemInMainHand(itemStack);
                Bukkit.getScheduler().runTaskLater(SurvivalOverhaul.getInstance(), () -> it.getEntity().remove(), 5L * 20);
                break;
            }
        }
        //Athena
    }


}
