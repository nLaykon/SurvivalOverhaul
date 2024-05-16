package org.laykon.survivaloverhaul.CustomItems.Automation.Handlers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Crops;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.laykon.survivaloverhaul.CustomItems.EventHandling.NamespacedKeys;
import org.laykon.survivaloverhaul.SurvivalOverhaul;
import org.laykon.survivaloverhaul.Utility.Utils;

import java.util.List;

public class FactoryHandler implements Listener, Utils {
    @EventHandler
    public void onFactoryPlace(PlayerInteractEvent it) {
        if (it.getPlayer().getActiveItem() == null) {
            return;
        }
        if (it.getItem() == null) return;
        if (it.getItem().getItemMeta() == null) return;


        if (it.getItem().getItemMeta().getPersistentDataContainer().has(NamespacedKeys.getKey("Factory"), PersistentDataType.STRING)) {
            int speed = 60;
            Location armorLoc = it.getInteractionPoint();

            ArmorStand armorStand = armorLoc.getWorld().spawn(armorLoc.toCenterLocation().subtract(0, 0.7, 0), ArmorStand.class);

            armorStand.setArms(false);
            armorStand.setGravity(false);
            armorStand.setCustomName("Test");
            armorStand.setCustomNameVisible(true);
            armorStand.setVisible(false);

            armorStand.setHelmet(new ItemStack(Material.BEDROCK));
            armorStand.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);

            armorStand.getPersistentDataContainer().set(NamespacedKeys.getKey("Factory"), PersistentDataType.STRING, "true");

            armorStand.getPersistentDataContainer().set(NamespacedKeys.getKey("Speed"), PersistentDataType.INTEGER, speed);

            armorStand.getPersistentDataContainer().set(NamespacedKeys.getKey("WHEAT"), PersistentDataType.INTEGER, 0);
            armorStand.getPersistentDataContainer().set(NamespacedKeys.getKey("CARROTS"), PersistentDataType.INTEGER, 0);
            armorStand.getPersistentDataContainer().set(NamespacedKeys.getKey("POTATOES"), PersistentDataType.INTEGER, 0);
            armorStand.getPersistentDataContainer().set(NamespacedKeys.getKey("BEETROOTS"), PersistentDataType.INTEGER, 0);
            armorStand.getPersistentDataContainer().set(NamespacedKeys.getKey("NETHER_WART"), PersistentDataType.INTEGER, 0);
            armorStand.getPersistentDataContainer().set(NamespacedKeys.getKey("COCOA"), PersistentDataType.INTEGER, 0);




            it.setCancelled(true);

            BukkitRunnable newTask = new BukkitRunnable() {
                @Override
                public void run() {
                    List<Block> blocks = getSameLevelBlocks(armorLoc, 10);
                    for (Block block : blocks){
                        if (isCrop(block.getType())){
                            BlockState state = block.getState();
                            Crops crops = (Crops) state.getData();
                            int age = crops.getState().getData();
                            if (age == getMaxAge(block.getType())){
                                int dropCount = block.getDrops().size();
                                block.setType(block.getType());
                                armorStand.getPersistentDataContainer().set(NamespacedKeys.getKey(block.getType().toString()), PersistentDataType.INTEGER, armorStand.getPersistentDataContainer().get(NamespacedKeys.getKey(block.getType().toString()), PersistentDataType.INTEGER)+dropCount);
                                break;
                            }
                        }

                    }

                }
            };

            newTask.runTaskTimer(SurvivalOverhaul.getInstance(), 0, 60);


        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractAtEntityEvent it) {
        Inventory inventory = Bukkit.createInventory(null, 9, "§d§lFactory");
        ItemStack wheat = new ItemStack(Material.WHEAT);
        ItemStack carrots = new ItemStack(Material.CARROT);
        ItemStack potatoes = new ItemStack(Material.POTATO);
        ItemStack beetroots = new ItemStack(Material.BEETROOT);

        ItemMeta wheatMeta = wheat.getItemMeta();
        ItemMeta carrotsMeta = carrots.getItemMeta();
        ItemMeta potatoesMeta = potatoes.getItemMeta();
        ItemMeta beetrootsMeta = beetroots.getItemMeta();

        wheatMeta.setDisplayName("Wheat: " + it.getRightClicked().getPersistentDataContainer().get(NamespacedKeys.getKey("WHEAT"), PersistentDataType.INTEGER));
        carrotsMeta.setDisplayName("Carrots: " + it.getRightClicked().getPersistentDataContainer().get(NamespacedKeys.getKey("CARROTS"), PersistentDataType.INTEGER));
        potatoesMeta.setDisplayName("Potatoes: " + it.getRightClicked().getPersistentDataContainer().get(NamespacedKeys.getKey("POTATOES"), PersistentDataType.INTEGER));
        beetrootsMeta.setDisplayName("Beetroots: " + it.getRightClicked().getPersistentDataContainer().get(NamespacedKeys.getKey("BEETROOTS"), PersistentDataType.INTEGER));

        wheat.setItemMeta(wheatMeta);
        carrots.setItemMeta(carrotsMeta);
        potatoes.setItemMeta(potatoesMeta);
        beetroots.setItemMeta(beetrootsMeta);


        inventory.setItem(0, wheat);
        inventory.setItem(1, carrots);
        inventory.setItem(2, potatoes);
        inventory.setItem(3, beetroots);


        it.getPlayer().openInventory(inventory);
    }
}
