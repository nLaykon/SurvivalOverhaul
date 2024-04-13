package org.laykon.survivaloverhaul.CustomItems;


import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;
import org.laykon.survivaloverhaul.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class LootTableHandler implements Utils, Listener {
    Random rng = new Random();

    List<ItemStack> witchDrops = new ArrayList<>(Arrays.asList(
            Gods.DIONYSUS.getItem(OlympianItem.HELMET),
            Gods.DIONYSUS.getItem(OlympianItem.CHESTPLATE),
            Gods.DIONYSUS.getItem(OlympianItem.LEGGINGS),
            Gods.DIONYSUS.getItem(OlympianItem.BOOTS),
            Gods.DIONYSUS.getItem(OlympianItem.ITEM)
    ));
    List<ItemStack> chargedCreeperDrops = new ArrayList<>(Arrays.asList(
            Gods.ZEUS.getItem(OlympianItem.HELMET),
            Gods.ZEUS.getItem(OlympianItem.CHESTPLATE),
            Gods.ZEUS.getItem(OlympianItem.LEGGINGS),
            Gods.ZEUS.getItem(OlympianItem.BOOTS),
            Gods.ZEUS.getItem(OlympianItem.ITEM)
    ));
    List<ItemStack> villagerTradeDrops = new ArrayList<>(Arrays.asList(
            Gods.APHRODITE.getItem(OlympianItem.HELMET),
            Gods.APHRODITE.getItem(OlympianItem.CHESTPLATE),
            Gods.APHRODITE.getItem(OlympianItem.LEGGINGS),
            Gods.APHRODITE.getItem(OlympianItem.BOOTS),
            Gods.APHRODITE.getItem(OlympianItem.ITEM)
    ));
    List<ItemStack> blockBreakDrops = new ArrayList<>(Arrays.asList(
            Gods.HEPHAESTUS.getItem(OlympianItem.HELMET),
            Gods.HEPHAESTUS.getItem(OlympianItem.CHESTPLATE),
            Gods.HEPHAESTUS.getItem(OlympianItem.LEGGINGS),
            Gods.HEPHAESTUS.getItem(OlympianItem.BOOTS),
            Gods.HEPHAESTUS.getItem(OlympianItem.ITEM)
    ));
    List<ItemStack> wardenDrops = new ArrayList<>(Arrays.asList(
            Gods.ARES.getItem(OlympianItem.HELMET),
            Gods.ARES.getItem(OlympianItem.CHESTPLATE),
            Gods.ARES.getItem(OlympianItem.LEGGINGS),
            Gods.ARES.getItem(OlympianItem.BOOTS),
            Gods.ARES.getItem(OlympianItem.ITEM)
    ));
    List<ItemStack> witherDrops = new ArrayList<>(Arrays.asList(
            Gods.HERA.getItem(OlympianItem.HELMET),
            Gods.HERA.getItem(OlympianItem.CHESTPLATE),
            Gods.HERA.getItem(OlympianItem.LEGGINGS),
            Gods.HERA.getItem(OlympianItem.BOOTS),
            Gods.HERA.getItem(OlympianItem.ITEM)
    ));
    List<ItemStack> animalDrops = new ArrayList<>(Arrays.asList(
            Gods.ARTEMIS.getItem(OlympianItem.HELMET),
            Gods.ARTEMIS.getItem(OlympianItem.CHESTPLATE),
            Gods.ARTEMIS.getItem(OlympianItem.LEGGINGS),
            Gods.ARTEMIS.getItem(OlympianItem.BOOTS),
            Gods.ARTEMIS.getItem(OlympianItem.ITEM)
    ));
    List<ItemStack> enderDragonDrops = new ArrayList<>(Arrays.asList(
            Gods.ATHENA.getItem(OlympianItem.HELMET),
            Gods.ATHENA.getItem(OlympianItem.CHESTPLATE),
            Gods.ATHENA.getItem(OlympianItem.LEGGINGS),
            Gods.ATHENA.getItem(OlympianItem.BOOTS),
            Gods.ATHENA.getItem(OlympianItem.ITEM),
            Gods.APOLLO.getItem(OlympianItem.HELMET),
            Gods.APOLLO.getItem(OlympianItem.CHESTPLATE),
            Gods.APOLLO.getItem(OlympianItem.LEGGINGS),
            Gods.APOLLO.getItem(OlympianItem.BOOTS),
            Gods.APOLLO.getItem(OlympianItem.ITEM)
    ));
    List<ItemStack> endermanDrops = new ArrayList<>(Arrays.asList(
    Gods.HERMES.getItem(OlympianItem.HELMET),
            Gods.HERMES.getItem(OlympianItem.CHESTPLATE),
            Gods.HERMES.getItem(OlympianItem.LEGGINGS),
            Gods.HERMES.getItem(OlympianItem.BOOTS),
            Gods.HERMES.getItem(OlympianItem.ITEM)
    ));

    @EventHandler
    public void onBlockBreak(BlockBreakEvent it) {
        Block block = it.getBlock();
        if (block.getType() == Material.STONE) {
            if (rng.nextInt(200) == 0) {
                block.getWorld().dropItemNaturally(block.getLocation(), blockBreakDrops.get(rng.nextInt(blockBreakDrops.size())));
            }
        }
    }


    @EventHandler
    public void onEntityDeath(EntityDeathEvent it) {
        Entity entity = it.getEntity();
        //Witch
        if (entity.getType() == EntityType.WITCH) {
            if (rng.nextInt(25) == 0) {
                it.getDrops().add(witchDrops.get(rng.nextInt(witchDrops.size())));
            }
        }
        //Witch

        //Charged Creeper
        if (entity.getType() == EntityType.CREEPER) {
            Creeper creeper = (Creeper) entity;
            if (creeper.isPowered()) {
                if (rng.nextInt(2) == 0) {
                    it.getDrops().add(chargedCreeperDrops.get(rng.nextInt(chargedCreeperDrops.size())));
                }
            }
        }
        //Charged Creeper

        //Warden
        if (entity.getType() == EntityType.WARDEN) {
            if (rng.nextInt(3) == 0) {
                it.getDrops().add(wardenDrops.get(rng.nextInt(wardenDrops.size())));
            }
        }
        //Warden

        //Wither
        if (entity.getType() == EntityType.WITHER) {
            if (rng.nextInt(2) == 0) {
                it.getDrops().add(witherDrops.get(rng.nextInt(witherDrops.size())));
            }
        }
        //Wither

        //Animal
        if (isAnimal(entity.getType())) {
            if (rng.nextInt(200) == 0) {
                it.getDrops().add(animalDrops.get(rng.nextInt(animalDrops.size())));
            }
        }
        //Animal

        //Ender Dragon
        if (entity.getType() == EntityType.ENDER_DRAGON) {
            it.getDrops().add(enderDragonDrops.get(rng.nextInt(enderDragonDrops.size())));
        }
        //Ender Dragon

        //Enderman
        if (entity.getType() == EntityType.ENDERMAN) {
            if (rng.nextInt(200) == 0) {
                it.getDrops().add(endermanDrops.get(rng.nextInt(endermanDrops.size())));
            }
        }
        //Enderman
    }

    @EventHandler
    public void onVillagerTrade(PlayerTradeEvent it) {
        Player player = it.getPlayer();
        Villager villager = (Villager) it.getVillager();
        if (rng.nextInt(50) == 0) {
            player.getWorld().dropItemNaturally(villager.getLocation(), villagerTradeDrops.get(rng.nextInt(villagerTradeDrops.size())));
        }


    }

}
