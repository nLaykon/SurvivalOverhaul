package org.laykon.survivaloverhaul.Utility;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class WeightedRandomItemPicker {
    private List<Tuple<ItemStack, Double>> itemList;

    public WeightedRandomItemPicker() {
        itemList = new ArrayList<>();
    }

    public void addItem(ItemStack item, double weight) {
        itemList.add(new Tuple<>(item, weight));
    }

    public ItemStack pickRandomItem() {
        if (itemList.isEmpty()) {
            throw new IllegalStateException("No items added.");
        }

        double totalWeight = itemList.stream().mapToDouble(Tuple::getSecond).sum();
        double randomValue = Math.random() * totalWeight;

        for (Tuple<ItemStack, Double> tuple : itemList) {
            randomValue -= tuple.getSecond();
            if (randomValue <= 0.0) {
                return tuple.getFirst();
            }
        }
        return itemList.get(itemList.size() - 1).getFirst();
    }
}

class Tuple<T, U> {
    private final T first;
    private final U second;

    public Tuple(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
