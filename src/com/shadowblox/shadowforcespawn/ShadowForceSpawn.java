package com.shadowblox.shadowforcespawn;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ShadowForceSpawn extends JavaPlugin implements Listener {
	

	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(this, this);

		File configFile = new File(this.getDataFolder().getAbsolutePath(),
				"config.yml");
		if (configFile.exists() == false) {
			configFile.mkdir();
			saveDefaultConfig();
		}
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {

		final Player player = event.getPlayer();
		if (getConfig().getBoolean("Enable-JoinMessage") == true) {
			player.sendMessage(ChatColor.GOLD + "Welcome to "
					+ (getConfig().getString("ServerName")) + ".");
		}
			event.getPlayer().teleport(
					getServer().getWorlds().get(0).getSpawnLocation());

		
			
		}
	

}
