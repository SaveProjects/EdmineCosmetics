package fr.edminecoreteam.cosmetics.entity.titres;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.cosmetics.Main;
import fr.edminecoreteam.cosmetics.data.CosmeticsData;

public class CustomTitreType 
{
	private static Main api = Main.getInstance();
	private Player p;
	
	public CustomTitreType(Player p) {
		this.p = p;
	}

	public void spawn() 
	{
		CosmeticsData data = new CosmeticsData(p);
		int getTitre = data.getActiveTitre();
		for (String articles : api.getConfig().getConfigurationSection("cosmetics.type.titres").getKeys(false))
        {
			if (api.getConfig().getInt("cosmetics.type.titres." + articles + ".referenceid") == getTitre)
			{
				Location customloc = new Location(Bukkit.getWorld(p.getWorld().getName()), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
		        ArmorStand armorStand = (ArmorStand)Bukkit.getWorld(p.getWorld().getName()).spawnEntity(customloc, EntityType.ARMOR_STAND);
		        armorStand.setSmall(true);
		        armorStand.setVisible(false);
		        armorStand.setCanPickupItems(false);
		        armorStand.setArms(false);
		        armorStand.setCustomName(encode(api.getConfig().getString("cosmetics.type.titres." + articles + ".title")));
		        armorStand.setCustomNameVisible(true);
		        armorStand.setGravity(false);
		        armorStand.setBasePlate(false);
		        armorStand.setMarker(true);
		        armorStand.setHelmet(null);
		        armorStand.setChestplate(null);
		        armorStand.setLeggings(null);
		        armorStand.setBoots(null);
		        armorStand.setMetadata("title_" + p.getName(), new FixedMetadataValue(api, "title_" + p.getName()));
		        
		        
		        new BukkitRunnable() {
		            int t = 0;
		            
					public void run() {
		            	
		            	if (!Bukkit.getOnlinePlayers().contains(p))
		            	{
		            		armorStand.remove();
		            		cancel();
		            	}
		            	
		            	Location loc = new Location(Bukkit.getWorld(p.getWorld().getName()), p.getLocation().getX(), p.getLocation().getY() + 2.2, p.getLocation().getZ());
		            	armorStand.teleport(loc);
		            	
		                ++t;
		                if (t == 10)
		                {
		                	t = 0;
		                }
		            }
		        }.runTaskTimer((Plugin)Main.getInstance(), 0L, 0L);
			}
        }
	}
	
	public void despawn()
	{
		ListenerTitre.despawnTitre(p);
		p.sendMessage("§9§lCosmétiques §8» §fVous avez désactivé votre §etitre§f.");
	}
	
	private String encode(String s) {
	    String encoded = s
	    		.replace("&", "§")
        		.replace("{e1}", "é")
        		.replace("{e2}", "è")
        		.replace("{e3}", "ê")
        		.replace("{e4}", "É")
        		.replace("{e5}", "È")
        		.replace("{e6}", "Ê")
        		.replace("{i1}", "î")
        		.replace("{i2}", "Î")
        		.replace("{a1}", "à")
        		.replace("{a2}", "â")
        		.replace("{a3}", "À")
        		.replace("{a4}", "Â")
        		.replace("{o1}", "ô")
        		.replace("{o2}", "Ô")
        		.replace("{love}", "❤")
        		.replace("{valide}", "✔")
        		.replace("{unvalid}", "✘")
        		.replace("{flocon}", "✵")
        		.replace("{eclats}", "❁")
        		.replace("{money}", "✪")
        		.replace("{star}", "✯")
        		.replace("{right}", "➡")
        		.replace("{left}", "⬅")
        		.replace("{up}", "⬆")
        		.replace("{down}", "⬇")
        		.replace("{right_select}", "➟")
        		.replace("{alert}", "⚠")
        		.replace("{separator}", "»")
        		.replace("{inverseseparator}", "«")
    			.replace("{player_name}", p.getName())
    			.replace("{euro}", "€");
	    
	    return encoded;
	}
}
