package org.laykon.survivaloverhaul.CustomItems.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.CustomItems.Gods;
import org.laykon.survivaloverhaul.CustomItems.OlympianItem;
import org.laykon.survivaloverhaul.Utils;


public class OlympianGiveCommand implements CommandExecutor, Utils {
    @Override
    public boolean onCommand(final @NotNull CommandSender commandSender, final @NotNull Command command, final @NotNull String label, final String[] args) {
        if (args.length != 2) {
            System.err.println("Invalid Usage: /give <username> <(kitItem|kit)>");
            return false;
        }

        final var target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            System.err.printf("Invalid player: %s%n", args[0]);
            return false;
        }

        final var userKitItemInput = args[1];
        final var firstCapitalLetterIndex = findFirstCapitalLetter(userKitItemInput);
        if (firstCapitalLetterIndex == -1) {
            final var kit = getGodsKit(userKitItemInput);
            if (kit == null) {
                System.err.printf("Kit %s is not defined%n", userKitItemInput);
                return false;
            }
            for (final var item : OlympianItem.values()) {
                target.getInventory().addItem(kit.getItem(item));
            }
        } else {
            final var userInputKit = userKitItemInput.substring(0, firstCapitalLetterIndex);
            final var userInputItem = userKitItemInput.substring(firstCapitalLetterIndex);

            final var kit = getGodsKit(userInputKit);
            if (kit == null) {
                System.err.printf("Kit %s is not defined%n", userInputKit);
                return false;
            }

            final var item = getOlympianItem(userInputItem);
            if (item == null) {
                System.err.printf("Item %s is not defined%n", userInputItem);
                return false;
            }

            target.getInventory().addItem(kit.getItem(item));
        }

        return true;
    }

    private static int findFirstCapitalLetter(final String string) {
        for (var index = 0; index < string.length(); index++) {
            if (Character.isUpperCase(string.charAt(index))) {
                return index;
            }
        }
        return -1;
    }

    private static Gods getGodsKit(final String kitName) {
        try {
            return Gods.get(kitName);
        } catch (final IllegalArgumentException ignore) {
            return null;
        }
    }

    private static OlympianItem getOlympianItem(final String itemName) {
        try {
            return OlympianItem.get(itemName);
        } catch (final IllegalArgumentException ignore) {
            return null;
        }
    }
}
