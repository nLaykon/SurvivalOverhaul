package org.laykon.survivaloverhaul.CustomItems.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.laykon.survivaloverhaul.CustomItems.Gods;
import org.laykon.survivaloverhaul.CustomItems.OlympianSets;
import org.laykon.survivaloverhaul.Utils;

import java.util.ArrayList;
import java.util.List;

public class OlymianGiveCommand implements CommandExecutor, Utils {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) return false;
        if (args.length != 2){
            System.out.println("Invalid Usage");
            return true;
        }
        List<OlympianSets> olympianSets = new ArrayList<>(List.of(OlympianSets.values()));

        switch (args[1]){
            case "zeusHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.ZEUS));
                break;
            case "zeusChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.ZEUS));
                break;
            case "zeusLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.ZEUS));
                break;
            case "zeusBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.ZEUS));
                break;
            case "zeusItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.ZEUS));
                break;
            case "zeus":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.ZEUS));
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.ZEUS));
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.ZEUS));
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.ZEUS));
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.ZEUS));
                System.out.println("Check");
                break;
            case "heraHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.HERA));
                break;
            case "heraChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.HERA));
                break;
            case "heraLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.HERA));
                break;
            case "heraBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.HERA));
                break;
            case "heraItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.HERA));
                break;
            case "hera":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.HERA));
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.HERA));
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.HERA));
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.HERA));
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.HERA));
                break;
            case "poseidonHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.POSEIDON));
                break;
            case "poseidonChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.POSEIDON));
                break;
            case "poseidonLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.POSEIDON));
                break;
            case "poseidonBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.POSEIDON));
                break;
            case "poseidonItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.POSEIDON));
                break;
            case "poseidon":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.POSEIDON));
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.POSEIDON));
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.POSEIDON));
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.POSEIDON));
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.POSEIDON));
                break;
            case "demeterHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.DEMETER));
                break;
            case "demeterChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.DEMETER));
                break;
            case "demeterLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.DEMETER));
                break;
            case "demeterBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.DEMETER));
                break;
            case "demeterItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.DEMETER));
                break;
            case "athenaHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.ATHENA));
                break;
            case "athenaChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.ATHENA));
                break;
            case "athenaLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.ATHENA));
                break;
            case "athenaBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.ATHENA));
                break;
            case "athenaItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.ATHENA));
                break;
            case "apolloHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.APOLLO));
                break;
            case "apolloChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.APOLLO));
                break;
            case "apolloLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.APOLLO));
                break;
            case "apolloBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.APOLLO));
                break;
            case "apolloItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.APOLLO));
                break;
            case "artemisHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.ARTEMIS));
                break;
            case "artemisChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.ARTEMIS));
                break;
            case "artemisLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.ARTEMIS));
                break;
            case "artemisBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.ARTEMIS));
                break;
            case "artemisItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.ARTEMIS));
                break;
            case "aresHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.ARES));
                break;
            case "aresChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.ARES));
                break;
            case "aresLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.ARES));
                break;
            case "aresBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.ARES));
                break;
            case "aresItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.ARES));
                break;
            case "hephaestusHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.HEPHAESTUS));
                break;
            case "hephaestusChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.HEPHAESTUS));
                break;
            case "hephaestusLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.HEPHAESTUS));
                break;
            case "hephaestusBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.HEPHAESTUS));
                break;
            case "hephaestusItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.HEPHAESTUS));
                break;
            case "aphroditeHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.APHRODITE));
                break;
            case "aphroditeChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.APHRODITE));
                break;
            case "aphroditeLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.APHRODITE));
                break;
            case "aphroditeBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.APHRODITE));
                break;
            case "aphroditeItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.APHRODITE));
                break;
            case "hermesHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.HERMES));
                break;
            case "hermesChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.HERMES));
                break;
            case "hermesLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.HERMES));
                break;
            case "hermesBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.HERMES));
                break;
            case "hermesItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.HERMES));
                break;
            case "dionysusHelmet":
                target.getInventory().addItem(OlympianSets.HELMET.getItem(Gods.DIONYSUS));
                break;
            case "dionysusChestplate":
                target.getInventory().addItem(OlympianSets.CHESTPLATE.getItem(Gods.DIONYSUS));
                break;
            case "dionysusLeggings":
                target.getInventory().addItem(OlympianSets.LEGGINGS.getItem(Gods.DIONYSUS));
                break;
            case "dionysusBoots":
                target.getInventory().addItem(OlympianSets.BOOTS.getItem(Gods.DIONYSUS));
                break;
            case "dionysusItem":
                target.getInventory().addItem(OlympianSets.ITEM.getItem(Gods.DIONYSUS));
                break;
            default:
                System.out.println(args[1] + " Is not a valid item");
                return true;
        }
        return true;
    }
}
