package org.laykon.survivaloverhaul.CustomItems;


import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.laykon.survivaloverhaul.Utils;

import java.util.*;


public class LootTableHandler implements Utils, Listener {
    Random rng = new Random();

    List<ItemStack> cowDrops = new ArrayList<>(Arrays.asList(
            Gods.DEMETER.getItem(OlympianItem.HELMET),
            Gods.DEMETER.getItem(OlympianItem.CHESTPLATE),
            Gods.DEMETER.getItem(OlympianItem.LEGGINGS),
            Gods.DEMETER.getItem(OlympianItem.BOOTS),
            Gods.DEMETER.getItem(OlympianItem.ITEM)
    ));


    @EventHandler
    public void onEntityDeath (EntityDeathEvent it){
        Entity entity = it.getEntity();
        //Cow
        if (entity.getType() == EntityType.COW){
            if (rng.nextInt(50) == 0) {
                it.getDrops().add(cowDrops.get(rng.nextInt(cowDrops.size())));
            }
        }
        //Cow

    }



}
