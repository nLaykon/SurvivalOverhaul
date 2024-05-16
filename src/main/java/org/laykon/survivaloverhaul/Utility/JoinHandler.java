package org.laykon.survivaloverhaul.Utility;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinHandler implements Listener, GCHandler, GemHandler, CreditHandler {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent it){
        initGC(it.getPlayer());
        initCredits(it.getPlayer());
        initGems(it.getPlayer());
        if (it.getPlayer().isOp()){
            it.setJoinMessage("§4"+it.getPlayer().getName() + " §cHas Joined The Game!");
        }
    }
}
