package fr.edminecoreteam.cosmetics.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.cosmetics.Main;
import fr.edminecoreteam.cosmetics.data.CosmeticsData;
import fr.edminecoreteam.cosmetics.entity.MountListener;
import fr.edminecoreteam.cosmetics.entity.ballon.CustomBallonType;
import fr.edminecoreteam.cosmetics.entity.familier.CustomFamilierType;
import fr.edminecoreteam.cosmetics.entity.titres.CustomTitreType;

public class PlayerJoinListener implements Listener
{
	
	private static Main api = Main.getInstance();
	
	@EventHandler
	private void onJoin(PlayerJoinEvent e) 
	{
		Player p = e.getPlayer();
		CosmeticsData data = new CosmeticsData(p);
		
		data.createSettingCosmetics();
		
		int getMonture = data.getActiveMonture();
		if (getMonture != 0)
		{
			for (String articles : api.getConfig().getConfigurationSection("cosmetics.type.montures").getKeys(false))
            {
    			if (api.getConfig().getInt("cosmetics.type.montures." + articles + ".referenceid") == getMonture)
    			{
    				new BukkitRunnable() {
    		            int t = 0;
    					public void run() {
    			        	
    		                ++t;
    		                if (t == 2) {
    		                	MountListener mListener = new MountListener(p);
                				mListener.equip(api.getConfig().getString("cosmetics.type.montures." + articles + ".managemount"));
    		                    cancel();
    		                }
    		            }
    		        }.runTaskTimer((Plugin)api, 0L, 10L);
    			}
            }
		}
		
		CustomFamilierType fListener = new CustomFamilierType(p);
		fListener.spawn();
		
		CustomBallonType bListener = new CustomBallonType(p);
		bListener.spawn();
		
		CustomTitreType tListener = new CustomTitreType(p);
		tListener.spawn();
	}
}
