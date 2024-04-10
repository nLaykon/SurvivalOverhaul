package org.laykon.survivaloverhaul.CustomItems.EventHandling;

import org.bukkit.potion.PotionEffectType;

public enum Potions {
    BAD(
            PotionEffectType.SLOW,
            PotionEffectType.SLOW_DIGGING,
            PotionEffectType.HARM,
            PotionEffectType.CONFUSION,
            PotionEffectType.BLINDNESS,
            PotionEffectType.HUNGER,
            PotionEffectType.WEAKNESS,
            PotionEffectType.POISON,
            PotionEffectType.WITHER,
            PotionEffectType.UNLUCK,
            PotionEffectType.BAD_OMEN,
            PotionEffectType.DARKNESS
            );

    private final PotionEffectType[] effectTypes;


    Potions(PotionEffectType... effectTypes) {
        this.effectTypes = effectTypes;
    }

    public PotionEffectType[] getEffectTypes() {
        return effectTypes;
    }
}


