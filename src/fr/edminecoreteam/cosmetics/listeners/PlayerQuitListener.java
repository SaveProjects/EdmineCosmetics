package fr.edminecoreteam.cosmetics.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.edminecoreteam.cosmetics.entity.MountListener;
import fr.edminecoreteam.cosmetics.entity.ballon.CustomBallonType;
import fr.edminecoreteam.cosmetics.entity.familier.CustomFamilierType;
import fr.edminecoreteam.cosmetics.entity.titres.CustomTitreType;

public class PlayerQuitListener implements Listener
{
	
	@EventHandler
	private void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		MountListener mListener = new MountListener(p);
		mListener.despawn();
		
		CustomFamilierType fListener = new CustomFamilierType(p);
		fListener.despawn();
		
		CustomBallonType bListener = new CustomBallonType(p);
		bListener.despawn();
		
		CustomTitreType tListener = new CustomTitreType(p);
		tListener.despawn();
	}
}
