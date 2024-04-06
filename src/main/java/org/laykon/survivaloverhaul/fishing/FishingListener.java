package org.laykon.survivaloverhaul.fishing;

import com.destroystokyo.paper.ParticleBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.laykon.survivaloverhaul.SurvivalOverhaul;
import org.laykon.survivaloverhaul.Utility.ConfigManager;
import org.laykon.survivaloverhaul.Utility.WeightedRandomItemPicker;
import org.laykon.survivaloverhaul.Utils;
import org.laykon.survivaloverhaul.Utility.itemBuilder;


import java.util.ArrayList;

public class FishingListener implements Listener, Utils {
    JavaPlugin plugin = SurvivalOverhaul.getInstance();
    private ConfigManager cfg = new ConfigManager(plugin);;



    ArrayList<Material> itemList = new ArrayList<>();


    @EventHandler
    public void onFish(PlayerFishEvent e) {

        int invOffset = 5;

        WeightedRandomItemPicker fishingTable = new WeightedRandomItemPicker();

        fishingTable.addItem(itemBuilder.buildItem(Material.COD, "§rCod", null, null, false), cfg.getWeight("cod"));
        fishingTable.addItem(itemBuilder.buildItem(Material.SALMON, "§rSalmon", null, null, false), cfg.getWeight("salmon"));
        fishingTable.addItem(itemBuilder.buildItem(Material.TROPICAL_FISH, "§rTropical Fish", null, null, false), cfg.getWeight("tropicalFish"));
        fishingTable.addItem(itemBuilder.buildItem(Material.PUFFERFISH, "§rPufferfish", null, null, false), cfg.getWeight("pufferfish"));

        fishingTable.addItem(itemBuilder.buildItem(Material.NAME_TAG, "§rName Tag", null, null, false), cfg.getWeight("nameTag"));
        fishingTable.addItem(itemBuilder.buildItem(Material.BOW, "§rBow", null, new Enchantment[]{Enchantment.ARROW_INFINITE}, false), cfg.getWeight("bow"));
        fishingTable.addItem(itemBuilder.buildItem(Material.ENCHANTED_BOOK, "§rEnchanted Book", null, new Enchantment[]{Enchantment.LUCK, Enchantment.LURE, Enchantment.LUCK, Enchantment.LURE}, true), cfg.getWeight("enchantedBook"));
        fishingTable.addItem(itemBuilder.buildItem(Material.ENCHANTED_GOLDEN_APPLE, "§rEnchanted Golden Apple", null, null, false), cfg.getWeight("enchantedGoldenApple"));
        fishingTable.addItem(itemBuilder.buildItem(Material.SADDLE, "§rSaddle", null, null, false), cfg.getWeight("saddle"));
        fishingTable.addItem(itemBuilder.buildItem(Material.FISHING_ROD, "§rFishing Rod", null, new Enchantment[]{Enchantment.LUCK}, true), cfg.getWeight("fishingRod"));
        fishingTable.addItem(itemBuilder.buildItem(Material.NAUTILUS_SHELL, "§rNautilus Shell", null, null, false), cfg.getWeight("nautilusShell"));
        fishingTable.addItem(itemBuilder.buildItem(Material.LILY_PAD, "§rLily Pad", null, null, false), cfg.getWeight("lilyPad"));
        fishingTable.addItem(itemBuilder.buildItem(Material.TRIPWIRE_HOOK, "§rTripwire Hook", null, null, false), cfg.getWeight("tripwireHook"));

        fishingTable.addItem(itemBuilder.buildItem(Material.BOWL, "§rBowl", null, null, false), cfg.getWeight("bowl"));
        fishingTable.addItem(itemBuilder.buildItem(Material.LEATHER_BOOTS, "§rLeather Boots", null, null, false), cfg.getWeight("leatherBoots"));
        fishingTable.addItem(itemBuilder.buildItem(Material.LEATHER, "§rLeather", null, null, false), cfg.getWeight("leather"));
        fishingTable.addItem(itemBuilder.buildItem(Material.LEATHER_CHESTPLATE, "§rLeather Chestplate", null, null, false), cfg.getWeight("leatherChestplate"));
        fishingTable.addItem(itemBuilder.buildItem(Material.LEATHER_HELMET, "§rLeather Helmet", null, null, false), cfg.getWeight("leatherHelmet"));
        fishingTable.addItem(itemBuilder.buildItem(Material.LEATHER_LEGGINGS, "§rLeather Leggings", null, null, false), cfg.getWeight("leatherLeggings"));
        fishingTable.addItem(itemBuilder.buildItem(Material.ROTTEN_FLESH, "§rRotten Flesh", null, null, false), cfg.getWeight("rottenFlesh"));
        fishingTable.addItem(itemBuilder.buildItem(Material.BONE, "§rBone", null, null, false), cfg.getWeight("bone"));
        fishingTable.addItem(itemBuilder.buildItem(Material.STRING, "§rString", null, null, false), cfg.getWeight("string"));
        fishingTable.addItem(itemBuilder.buildItem(Material.STICK, "§rStick", null, null, false), cfg.getWeight("stick"));

        fishingTable.addItem(itemBuilder.buildItem(Material.DIAMOND_SWORD, "§l§3Neptune's Fury", "§r§r§bForged in the depths of the ocean's heart,\n§r§r§bthis sword carries the wrath of Neptune himself,\n§r§r§bstriking foes with the force of crashing waves.§r", new Enchantment[]{Enchantment.DAMAGE_ALL, Enchantment.LOOT_BONUS_MOBS, Enchantment.MENDING, Enchantment.FIRE_ASPECT, Enchantment.SWEEPING_EDGE}, false), cfg.getWeight("diamondSword"));
        fishingTable.addItem(itemBuilder.buildItem(Material.DIAMOND_PICKAXE, "§l§3Triton's Pickaxe", "§r§r§bCrafted by the Ocean's Sentinel, \n§r§r§bthis pickaxe resonates with the power of the sea,\n§r§r§bbreaking through stone as effortlessly as the tide.§r", new Enchantment[]{Enchantment.DIG_SPEED, Enchantment.LOOT_BONUS_BLOCKS, Enchantment.MENDING, Enchantment.DURABILITY}, false), cfg.getWeight("diamondPickaxe"));
        fishingTable.addItem(itemBuilder.buildItem(Material.DIAMOND_AXE, "§l§3Poseidon's Axe", "§r§r§bForged from coral and imbued with the fury of ocean storms,\nthis axe cleaves through wood with the force of a crashing wave.§r", new Enchantment[]{Enchantment.DIG_SPEED, Enchantment.DAMAGE_ALL, Enchantment.MENDING, Enchantment.DURABILITY}, false), cfg.getWeight("diamondAxe"));
        fishingTable.addItem(itemBuilder.buildItem(Material.DIAMOND_SHOVEL, "§l§3Marine's Shovel", "§r§r§bBlessed by the spirits of sunken sailors, \n§r§r§bthis shovel uncovers treasures hidden beneath the sand and soil,\n§r§r§bguided by the whispers of the deep.§r", new Enchantment[]{Enchantment.DIG_SPEED, Enchantment.SILK_TOUCH, Enchantment.MENDING, Enchantment.DURABILITY}, false), cfg.getWeight("diamondShovel"));
        fishingTable.addItem(itemBuilder.buildItem(Material.DIAMOND_HELMET, "§l§3Tidal Helm", "§r§r§bWoven from strands of enchanted seaweed, \n§r§r§bthis helmet grants protection against the crushing pressure of the depths,\n§r§r§ballowing the wearer to breathe as freely as the ocean breeze.§r", new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.OXYGEN, Enchantment.THORNS, Enchantment.MENDING, Enchantment.DURABILITY}, false), cfg.getWeight("diamondHelmet"));
        fishingTable.addItem(itemBuilder.buildItem(Material.DIAMOND_CHESTPLATE, "§l§3Abyssal Plate", "§r§r§bForged from the scales of Leviathan, \n§r§r§bthis chestplate deflects blows as effortlessly as the current sways the kelp,\n§r§r§boffering unmatched protection beneath the waves.§r", new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.THORNS, Enchantment.MENDING, Enchantment.DURABILITY}, false), cfg.getWeight("diamondChestplate"));
        fishingTable.addItem(itemBuilder.buildItem(Material.DIAMOND_LEGGINGS, "§l§3Maelstrom Greaves", "§r§r§bCrafted from the heart of a whirlpool, \n§r§r§bthese leggings grant agility and resilience,\n§r§r§ballowing the wearer to dance amidst the chaos of battle as gracefully as a dolphin.§r", new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.THORNS, Enchantment.MENDING, Enchantment.DURABILITY}, false), cfg.getWeight("diamondLeggings"));
        fishingTable.addItem(itemBuilder.buildItem(Material.DIAMOND_BOOTS, "§l§3Siren's Stride", "§r§r§bFashioned from the scales of the ocean's guardians, \n§r§r§bthese boots enable the wearer to move through water with the grace of a mermaid,\n§r§r§bdancing upon the waves with unmatched speed.§r", new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DEPTH_STRIDER, Enchantment.SOUL_SPEED, Enchantment.MENDING, Enchantment.DURABILITY}, false), cfg.getWeight("diamondBoots"));

        fishingTable.addItem(itemBuilder.buildItem(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE, "§rSmithing Template", null, null, false), cfg.getWeight("netheriteSmithingUpgrade"));
        fishingTable.addItem(itemBuilder.buildItem(Material.HEART_OF_THE_SEA, "§rHeart of the Sea", null, null, false), cfg.getWeight("heartOfTheSea"));

        if (e.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {

            ItemStack pickedItem = fishingTable.pickRandomItem();

            e.getCaught().remove();

            for (int i = 0; i < e.getPlayer().getInventory().getSize() - invOffset; i++) {
                if (e.getPlayer().getInventory().getItem(i) != null) {
                    if (e.getPlayer().getInventory().getItem(i).getType().equals(pickedItem.getType()) && e.getPlayer().getInventory().getItem(i).getMaxStackSize() > 1) {
                        if (e.getPlayer().getInventory().getItem(i).getAmount() < e.getPlayer().getInventory().getItem(i).getMaxStackSize()) {
                            e.getPlayer().getInventory().getItem(i).setAmount(e.getPlayer().getInventory().getItem(i).getAmount() + 1);
                            e.getPlayer().sendMessage("You caught a §6" + pickedItem.getItemMeta().getDisplayName() + "§f!");
                            break;
                        }
                    }
                } else if (e.getPlayer().getInventory().getItem(i) == null) {
                    e.getPlayer().sendMessage("You caught a §6" + pickedItem.getItemMeta().getDisplayName() + "§f!");
                    e.getPlayer().getInventory().setItem(i, pickedItem);
                    break;
                }
                if (i >= (e.getPlayer().getInventory().getSize() - invOffset) - 1) {
                    e.getPlayer().sendMessage("Your inventory is full!");
                }
            }
        }


        if (e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) {
        }


        if (e.getState().equals(PlayerFishEvent.State.FAILED_ATTEMPT)) {
            ParticleBuilder particle = new ParticleBuilder(Particle.REDSTONE).color(Color.RED).location(e.getHook().getLocation().add(0, 0.5, 0)).count(10).receivers(25);
            particle.spawn();
        }


        if (e.getState().equals(PlayerFishEvent.State.BITE)) {
            e.getPlayer().playSound(e.getPlayer().getLocation(), "minecraft:block.amethyst_cluster.hit", 1, 1);
            ParticleBuilder particle = new ParticleBuilder(Particle.REDSTONE).color(Color.LIME).location(e.getHook().getLocation().add(0, 0.5, 0)).count(10).receivers(25);
            particle.spawn();
        }


        if (e.getState().equals(PlayerFishEvent.State.IN_GROUND)) {
        }


        if (e.getState().equals(PlayerFishEvent.State.REEL_IN)) {
        }


        if (e.getState().equals(PlayerFishEvent.State.FISHING)) {
        }
    }
}
