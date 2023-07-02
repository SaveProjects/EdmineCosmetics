package fr.edminecoreteam.cosmetics.entity.ballon;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.cosmetics.Main;
import fr.edminecoreteam.cosmetics.data.CosmeticsData;
import fr.edminecoreteam.cosmetics.utils.SkullNBT;
import net.minecraft.server.v1_8_R3.NBTTagCompound;

public class CustomBallonType 
{
	private static Main api = Main.getInstance();
	private static ItemStack getSkull(String url) { return SkullNBT.getSkull(url); }
	private Player p;
	
	public CustomBallonType(Player p) {
		this.p = p;
	}

	public void spawn() 
	{
		CosmeticsData data = new CosmeticsData(p);
		int getBallon = data.getActiveBallon();
		for (String articles : api.getConfig().getConfigurationSection("cosmetics.type.ballons").getKeys(false))
        {
			if (api.getConfig().getInt("cosmetics.type.ballons." + articles + ".referenceid") == getBallon)
			{
				Location customloc = new Location(Bukkit.getWorld(p.getWorld().getName()), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
		        ArmorStand armorStand = (ArmorStand)Bukkit.getWorld(p.getWorld().getName()).spawnEntity(customloc, EntityType.ARMOR_STAND);
		        armorStand.setSmall(false);
		        armorStand.setVisible(false);
		        armorStand.setCanPickupItems(false);
		        armorStand.setArms(true);
		        armorStand.setCustomName("ballon_" + p.getName());
		        armorStand.setCustomNameVisible(false);
		        armorStand.setGravity(false);
		        armorStand.setBasePlate(false);
		        armorStand.setMarker(true);
		        armorStand.setHelmet(getSkull("http://textures.minecraft.net/texture/" + api.getConfig().getString("cosmetics.type.ballons." + articles + ".headurl")));
		        armorStand.setChestplate(null);
		        armorStand.setLeggings(null);
		        armorStand.setBoots(null);
		        ListenerBallon.runAction(p, "true");
		        
		        
		        PotionEffect invisibilityEffect = new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0, false, false);
		        PotionEffect potionEffect = new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 0, false, false);
		        Chicken chicken = (Chicken)Bukkit.getWorld(p.getWorld().getName()).spawnEntity(customloc, EntityType.CHICKEN);
		        net.minecraft.server.v1_8_R3.Entity znms1 = ((CraftEntity) chicken).getHandle();
		        NBTTagCompound ztag1 = new NBTTagCompound();
		        znms1.c(ztag1);
		        ztag1.setBoolean("Silent", true);
		        znms1.f(ztag1);
		        chicken.setCustomName("leach_" + p.getName());
		        chicken.setMetadata("leash_" + p.getName(), new FixedMetadataValue(api, "leash_" + p.getName()));
		        chicken.setCustomNameVisible(false);
		        chicken.addPotionEffect(invisibilityEffect);
		        chicken.addPotionEffect(potionEffect);
		        chicken.setBreed(false);
		        ListenerBallonLeash.runAction(p, "true");
		        
		        new BukkitRunnable() {
		            int t = 0;
		            
					public void run() {
		            	
		            	if (!Bukkit.getOnlinePlayers().contains(p))
		            	{
		            		chicken.remove();
		            		cancel();
		            	}
		            	
		            	chicken.setLeashHolder(p);
		            	
		                ++t;
		                if (t == 10)
		                {
		                	t = 0;
		                }
		            }
		        }.runTaskTimer((Plugin)Main.getInstance(), 0L, 10L);
			}
        }
	}
	
	public void despawn()
	{
		ListenerBallon.despawnBallon(p);
		ListenerBallonLeash.despawnLeash(p);
		p.sendMessage("§9§lCosmétiques §8» §fVous avez désactivé votre §3ballon§f.");
	}
}
