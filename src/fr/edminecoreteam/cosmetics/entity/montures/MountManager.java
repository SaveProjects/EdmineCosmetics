package fr.edminecoreteam.cosmetics.entity.montures;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.cosmetics.Main;
import fr.edminecoreteam.cosmetics.data.CosmeticsData;
import fr.edminecoreteam.cosmetics.entity.MountListener;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableBlaze;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableChicken;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableCow;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableCreeper;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableEnderDragon;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableEnderman;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableGolem;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableHorse;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableMooshroom;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableOcelot;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideablePig;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideablePigman;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableRabbit;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableSheep;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableSilverFish;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableSkeleton;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableSpider;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableVillager;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableWitch;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableWither;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableWolf;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableZombie;

import org.bukkit.block.Block;
import net.minecraft.server.v1_8_R3.World;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.minecraft.server.v1_8_R3.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;

import net.minecraft.server.v1_8_R3.EntityAgeable;

import org.bukkit.entity.Blaze;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Ocelot;

import net.minecraft.server.v1_8_R3.EntityHuman;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;

import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.NBTTagCompound;

import org.bukkit.event.Listener;

public class MountManager implements Listener
{
    public static double maxHealth;
    public static float mountSpeed;
    private static Main api = Main.getInstance();
    
    static {
        MountManager.maxHealth = 0.1;
        MountManager.mountSpeed = 0.2f;
    }
    
    public static boolean shouldDie(EntityLiving mount, Player rider) {
        if (mount.passenger == null || !(mount.passenger instanceof EntityHuman)) {
            mount.die();
            return true;
        }
        return false;
    }
    
    public static void make(EntityLiving nmsEntity, Player player, String s) {
        if (!canSummonMount(player.getLocation())) {
            player.sendMessage("§9§lCosmétiques §8» §fImpossible de faire apparaître cette §6monture§f ici...");
            CosmeticsData data = new CosmeticsData(player);
            data.updateMonture(0);
            return;
        }
        
        LivingEntity mount = (LivingEntity)nmsEntity.getBukkitEntity();
        if (mount instanceof EntityAgeable) {
            ((EntityAgeable)mount).setAge(0);
        }
        if (mount instanceof Horse)
        {
        	Horse horse = (Horse) mount;
        	horse.setTamed(true);
            horse.setOwner(player);
            horse.setCustomNameVisible(false);
            horse.setCustomName("§f");
        }
        if (mount instanceof Ocelot)
        {
        	Ocelot ocelot = (Ocelot) mount;
        	ocelot.setTamed(true);
        	ocelot.setOwner(player);
        	ocelot.setCustomNameVisible(false);
        	ocelot.setCustomName("§f");
        }
        if (mount instanceof Wolf)
        {
        	Wolf wolf = (Wolf) mount;
        	wolf.setTamed(true);
        	wolf.setOwner(player);
        	wolf.setCustomNameVisible(false);
        	wolf.setCustomName("§f");
        }
        if (mount instanceof Blaze)
        {
        	Blaze blaze = (Blaze) mount;
        	MountListener mListener = new MountListener(blaze);
        	mListener.noBlazeAir();
        	
        }
        Location loc = player.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        nmsEntity.setPosition(loc.getX(), loc.getY(), loc.getZ());
        nmsWorld.addEntity((Entity)nmsEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
        Location locs = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 1.5, player.getLocation().getZ(), player.getEyeLocation().getYaw(), player.getEyeLocation().getPitch());
        player.teleport(locs);
        mount.setMetadata("mount_" + player.getName(), new FixedMetadataValue(api, "mount_" + player.getName()));
        mount.setPassenger((org.bukkit.entity.Entity)player);
        mount.setHealth(MountManager.maxHealth);
        mount.setCustomNameVisible(false);
        net.minecraft.server.v1_8_R3.Entity znms1 = ((CraftEntity) mount).getHandle();
        NBTTagCompound ztag1 = new NBTTagCompound();
        znms1.c(ztag1);
        ztag1.setBoolean("Silent", true);
        ztag1.setBoolean("CustomNameVisible", false);
        znms1.f(ztag1);
        new BukkitRunnable() {
            int t = 0;   
			public void run() {

	        	if (mount.getPassenger() == null)
	        	{
	        		if (!Bukkit.getOnlinePlayers().contains(player))
	        		{
	        			cancel();
	        		}
	        		
	        		CosmeticsData data = new CosmeticsData(player);
	        		int getMonture = data.getActiveMonture();
	        		if (getMonture != 0)
	        		{
	        			for (String articles : api.getConfig().getConfigurationSection("cosmetics.type.montures").getKeys(false))
	                    {
	            			if (api.getConfig().getInt("cosmetics.type.montures." + articles + ".referenceid") == getMonture)
	            			{
	            				if (Bukkit.getOnlinePlayers().contains(player))
	            				{
	            					MountListener mListener = new MountListener(player);
		                        	mListener.equip(api.getConfig().getString("cosmetics.type.montures." + articles + ".managemount"));
		                        	cancel();
	            				}
	            				else
	            				{
	            					cancel();
	            				}
	            			}
	                    }
	        		}
	        		cancel();
	        	}
	        	
                ++t;
                if (t == 10) {
                    t = 0;
                }
            }
        }.runTaskTimer((Plugin)api, 0L, 10L);
    }
    
    public static boolean canSummonMount(Location loc) {
        org.bukkit.World world = loc.getWorld();
        Block block = loc.getBlock();
        for (int x = loc.getBlockX() - 1; x <= loc.getBlockX() + 0.1; ++x) {
            for (int y = loc.getBlockY(); y <= loc.getBlockY() + 0.1; ++y) {
                for (int z = loc.getBlockZ() - 1; z <= loc.getBlockZ() + 0.1; ++z) {
                    block = world.getBlockAt(x, y, z);
                    if (block.getType().isSolid()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    @EventHandler
    public void jump(PlayerMoveEvent e) {
        final Location from = e.getFrom();
        final Location to = e.getTo();
        final Player p = e.getPlayer();
        if (from.getBlockY() < to.getBlockY() && !p.isFlying() && p.isInsideVehicle()) {
            final org.bukkit.entity.Entity en = e.getPlayer().getVehicle();
            en.setVelocity(en.getLocation().getDirection().setY(0.15));
        }
    }
    
    public static void rideWolf(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableWolf(nmsWorld), p, "1");
    }
    
    public static void rideOcelot(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableOcelot(nmsWorld), p, "2");
    }
    
    public static void rideSheep(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableSheep(nmsWorld), p, "3");
    }
    
    public static void ridePig(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideablePig(nmsWorld), p, "4");
    }
    
    public static void rideCow(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableCow(nmsWorld), p, "5");
    }
    
    public static void rideChicken(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableChicken(nmsWorld), p, "6");
    }
    
    public static void rideMooshroom(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableMooshroom(nmsWorld), p, "7");
    }
    
    public static void rideVillager(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableVillager(nmsWorld), p, "8");
    }
    
    public static void rideZombie(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableZombie(nmsWorld), p, "9");
    }
    
    public static void rideSkeleton(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableSkeleton(nmsWorld), p, "10");
    }
    
    public static void rideSpider(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableSpider(nmsWorld), p, "11");
    }
    
    public static void ridePigman(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideablePigman(nmsWorld), p, "12");
    }
    
    public static void rideEnderman(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableEnderman(nmsWorld), p, "13");
    }
    
    public static void rideBlaze(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableBlaze(nmsWorld), p, "14");
    }
    
    public static void rideGolem(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableGolem(nmsWorld), p, "15");
    }
    
    public static void rideWitch(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableWitch(nmsWorld), p, "16");
    }
    
    public static void rideRabbit(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableRabbit(nmsWorld), p, "17");
    }
    
    public static void rideHorse(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableHorse(nmsWorld), p, "18");
    }
    
    public static void rideCreeper(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableCreeper(nmsWorld), p, "19");
    }
    
    public static void rideSilverFish(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableSilverFish(nmsWorld), p, "20");
    }
    
    public static void rideWither(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableWither(nmsWorld), p, "21");
    }
    
    public static void rideEnderDragon(Player p) {
        Location loc = p.getLocation();
        World nmsWorld = (World)((CraftWorld)loc.getWorld()).getHandle();
        make((EntityLiving)new RideableEnderDragon(nmsWorld), p, "22");
    }
}
