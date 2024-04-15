package org.laykon.survivaloverhaul.CustomBosses.Commands;

import net.kyori.adventure.text.Component;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.laykon.survivaloverhaul.CustomBosses.Bosses;

import java.util.UUID;

public class SpawnBoss implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            return true;
        }

        var worlds = player.getWorld();
        var location = player.getLocation();
        LivingEntity entity = (LivingEntity) worlds.spawnEntity(location, Bosses.extendMobEntity(EntityType.ENDERMAN));
        entity.setCustomNameVisible(true);
        entity.customName(Component.text("Boobies"));
        var health = new AttributeModifier(UUID.randomUUID(), "random", Bosses.ENDERMAN.getEntityHealth()-entity.getHealth(), AttributeModifier.Operation.ADD_NUMBER);
        entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(health);
        entity.setHealth(200.0);
        entity.setAI(false);

        

        return true;
    }
}
