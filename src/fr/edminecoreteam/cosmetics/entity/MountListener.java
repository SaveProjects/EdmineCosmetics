package fr.edminecoreteam.cosmetics.entity;

import org.bukkit.World;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.cosmetics.Main;
import fr.edminecoreteam.cosmetics.data.CosmeticsData;
import fr.edminecoreteam.cosmetics.entity.montures.MountManager;

public class MountListener implements Listener
{
	private Player p;
	private Blaze b;
	private static Main main = Main.getInstance();
	
	public MountListener() {
		// TODO Auto-generated constructor stub
	}
	
	public MountListener(Blaze b) {
		this.b = b;
	}
	
	public MountListener(Player p) {
		this.p = p;
	}
	
	@EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof Creeper) {
            event.setCancelled(true);
        }
        if (event.getEntity() instanceof Wither)
        {
        	event.setCancelled(true);
        }
        if (event.getEntity() instanceof EnderDragon)
        {
        	event.setCancelled(true);
        }
    }
	
	@EventHandler
    public void onEntityTarget(EntityTargetEvent event) {
        if (event.getEntity() instanceof Creeper && event.getTarget() instanceof Player) {
            event.setCancelled(true);
        }
        if (event.getEntity() instanceof Enderman && event.getTarget() instanceof Player) {
            event.setCancelled(true);
        }
        if (event.getEntity() instanceof Wither && event.getTarget() instanceof Player) {
            event.setCancelled(true);
        }
        if (event.getEntity() instanceof EnderDragon && event.getTarget() instanceof Player) {
            event.setCancelled(true);
        }
        if (event.getEntity() instanceof Witch && event.getTarget() instanceof Player) {
            event.setCancelled(true);
        }
    }
	
	@EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        Entity vehicle = player.getVehicle();
        if (vehicle != null) {
        	event.setCancelled(true);
            vehicle.setVelocity(vehicle.getVelocity().add(vehicle.getLocation().getDirection().multiply(0.5)));
        }
    }
	
	@EventHandler
	public void itemSpawnEvent(ItemSpawnEvent event) {
			Item item = event.getEntity();
            if (item.getItemStack().getType() == org.bukkit.Material.EGG) {
                World world = item.getWorld();
                if (world.getName().equalsIgnoreCase("hub")) {
                    item.remove();
                }
            }
	}
	
	@EventHandler
    public void onEntityTeleport(EntityTeleportEvent event) {
        if (event.getEntity() instanceof Enderman) {
            event.setCancelled(true);
        }
    }
	
	public void noBlazeAir()
	{
		new BukkitRunnable() {
            @Override
            public void run() {
                if (b != null)
                {
                	if (isAboveGround())
                	{
                		b.teleport(b.getLocation().subtract(0, b.getLocation().getY() - getGroundLevel(), 0));
                	}
                }
                else
                {
                	cancel();
                }
            }
        }.runTaskTimer((Plugin)main, 20L, 20L);
	}
	
	private boolean isAboveGround() {
        return b.getLocation().getY() > getGroundLevel() + 1;
    }

    private int getGroundLevel() {
        return b.getWorld().getHighestBlockYAt(b.getLocation().getBlockX(), b.getLocation().getBlockZ());
    }
	
	public void equip(String mount) 
	{
		if (mount.equalsIgnoreCase("wolf"))
		{
			MountManager.rideWolf(p);
		}
		if (mount.equalsIgnoreCase("ocelot"))
		{
			MountManager.rideOcelot(p);
		}
		if (mount.equalsIgnoreCase("sheep"))
		{
			MountManager.rideSheep(p);
		}
		if (mount.equalsIgnoreCase("pig"))
		{
			MountManager.ridePig(p);
		}
		if (mount.equalsIgnoreCase("cow"))
		{
			MountManager.rideCow(p);
		}
		if (mount.equalsIgnoreCase("chicken"))
		{
			MountManager.rideChicken(p);
		}
		if (mount.equalsIgnoreCase("mooshroom"))
		{
			MountManager.rideMooshroom(p);
		}
		if (mount.equalsIgnoreCase("villager"))
		{
			MountManager.rideVillager(p);
		}
		if (mount.equalsIgnoreCase("zombie"))
		{
			MountManager.rideZombie(p);
		}
		if (mount.equalsIgnoreCase("skeleton"))
		{
			MountManager.rideSkeleton(p);
		}
		if (mount.equalsIgnoreCase("spider"))
		{
			MountManager.rideSpider(p);
		}
		if (mount.equalsIgnoreCase("pigman"))
		{
			MountManager.ridePigman(p);
		}
		if (mount.equalsIgnoreCase("enderman"))
		{
			MountManager.rideEnderman(p);
		}
		if (mount.equalsIgnoreCase("blaze"))
		{
			MountManager.rideBlaze(p);
		}
		if (mount.equalsIgnoreCase("golem"))
		{
			MountManager.rideGolem(p);
		}
		if (mount.equalsIgnoreCase("witch"))
		{
			MountManager.rideWitch(p);
		}
		if (mount.equalsIgnoreCase("rabbit"))
		{
			MountManager.rideRabbit(p);
		}
		if (mount.equalsIgnoreCase("horse"))
		{
			MountManager.rideHorse(p);
		}
		if (mount.equalsIgnoreCase("creeper"))
		{
			MountManager.rideCreeper(p);
		}
		if (mount.equalsIgnoreCase("silverfish"))
		{
			MountManager.rideSilverFish(p);
		}
		if (mount.equalsIgnoreCase("wither"))
		{
			MountManager.rideWither(p);
		}
		if (mount.equalsIgnoreCase("enderdragon"))
		{
			MountManager.rideEnderDragon(p);
		}
	}
	
	public void desequip()
	{
		CosmeticsData data = new CosmeticsData(p);
		data.updateMonture(0);
		p.sendMessage("§9§lCosmétiques §8» §fVous avez désactivé votre §6monture§f.");
		shouldDie(p);
	}
	
	public void despawn()
	{
		shouldDie(p);
	}
	
	private void shouldDie(Player rider) {
        rider.setSneaking(true);
        BukkitRunnable task = new BukkitRunnable() {
            public void run() {
                rider.setSneaking(false);
            }
        };
        task.runTaskLater((Plugin)Main.getInstance(), 10L);
    }
}
