package fr.edminecoreteam.cosmetics.item;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener
{
	@EventHandler
	private void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		ItemsListener item = new ItemsListener(p);
		item.joinItem();
	}
}
