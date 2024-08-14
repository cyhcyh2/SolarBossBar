package me.cyh2.solarbossbar.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.cyh2.solarbossbar.SolarBossBar.PublicBossBar;

public class OnPlayerJoin implements Listener {
    @EventHandler
    public void onJoin (PlayerJoinEvent event) {
        PublicBossBar.addPlayer(event.getPlayer());
    }
}
