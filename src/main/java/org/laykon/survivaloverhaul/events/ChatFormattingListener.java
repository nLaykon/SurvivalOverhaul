package org.laykon.survivaloverhaul.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.laykon.survivaloverhaul.Utils;

import java.util.ArrayList;
import java.util.List;

public class ChatFormattingListener implements Listener, Utils {
    private List<String> codes = new ArrayList<>();
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        registerCodeList();

        for (String character : codes) {
            if (e.getMessage().endsWith("&"+character)) {
                e.setCancelled(true);
            }
        }
        e.setFormat(Colour(e.getPlayer().getName()+": "+e.getMessage()));

    }
    @EventHandler
    public void onServerCommand(ServerCommandEvent event) {
        if (event.getCommand().startsWith("say ")) {
            String formattedMessage = Colour("&b&lCONSOLE &8» " + event.getCommand().substring(4));
            Bukkit.broadcastMessage(formattedMessage);
            event.setCancelled(true);
        }
    }
    private void registerCodeList() {
        codes.add("a"); // LIME
        codes.add("b"); // LIGHT BLUE
        codes.add("c"); // LIGHT RED
        codes.add("d"); // PINK
        codes.add("e"); // YELLOW
        codes.add("f"); // WHITE
        codes.add("1"); // DARK BLUE
        codes.add("2"); // DARK GREEN
        codes.add("3"); // CYAN / TURQ
        codes.add("4"); // DARK RED
        codes.add("5"); // MAGENTA
        codes.add("6"); // GOLD
        codes.add("7"); // GRAY
        codes.add("8"); // DARK GRAY
        codes.add("9"); // BLUE
        codes.add("0"); // BLACK

        codes.add("l"); // BOLD
        codes.add("o"); // ITALICS
        codes.add("k"); // OBFUSCATED
        codes.add("r"); // RESET COLOUR
    }

}