package fr.edminecoreteam.cosmetics.entity.familier;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.Bukkit;
import fr.edminecoreteam.cosmetics.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ListenerFamilier implements Listener
{
    
    public static void despawnCompagnons(Player p) {
        for (Entity stand : Bukkit.getServer().getWorld("hub").getEntitiesByClasses(new Class[] { ArmorStand.class })) {
            if (stand != null && stand.getCustomName().equalsIgnoreCase(p.getName())) {
                stand.remove();
                runAction(p, "false");
            }
        }
    }
    
    private static String getCardinalDirection(Player player) {
        double rotation = (player.getLocation().getYaw() - 180.0f) % 360.0f;
        if (rotation < 0.0) {
            rotation += 360.0;
        }
        if (0.0 <= rotation && rotation < 22.5) {
            return "N";
        }
        if (22.5 <= rotation && rotation < 67.5) {
            return "NE";
        }
        if (67.5 <= rotation && rotation < 112.5) {
            return "E";
        }
        if (112.5 <= rotation && rotation < 157.5) {
            return "SE";
        }
        if (157.5 <= rotation && rotation < 202.5) {
            return "S";
        }
        if (202.5 <= rotation && rotation < 247.5) {
            return "SW";
        }
        if (247.5 <= rotation && rotation < 292.5) {
            return "W";
        }
        if (292.5 <= rotation && rotation < 337.5) {
            return "NW";
        }
        if (337.5 <= rotation && rotation < 360.0) {
            return "N";
        }
        return null;
    }
    
    private static void updateLocCompagnons(Player p) {
        for (Entity stand : Bukkit.getServer().getWorld("hub").getEntitiesByClasses(new Class[] { ArmorStand.class })) {
            if (stand != null && stand.getCustomName().equalsIgnoreCase(p.getName())) {
                Vector playerLookDirection = p.getEyeLocation().getDirection().normalize().multiply(1).add(new Vector(0, 0, 0));
                if (getCardinalDirection(p) == "N") {
                    Location playerLocation = p.getLocation();
                    double x1 = playerLocation.getX() - 0.5;
                    double y1 = playerLocation.getY();
                    double z1 = playerLocation.getZ() - 0.5;
                    double x2 = x1 + playerLookDirection.getX() * -1.0;
                    double y2 = y1 + 1.6;
                    double z2 = z1 + playerLookDirection.getZ() * -1.0;
                    float yaw = playerLocation.getYaw();
                    float pitch = playerLocation.getPitch();
                    Location armorStandLocation = new Location(Bukkit.getServer().getWorld("hub"), x2, y2, z2, yaw, pitch);
                    stand.teleport(armorStandLocation);
                }
                if (getCardinalDirection(p) == "NE") {
                    Location playerLocation = p.getLocation();
                    double x1 = playerLocation.getX() - 0.5;
                    double y1 = playerLocation.getY();
                    double z1 = playerLocation.getZ() - 0.5;
                    double x2 = x1 + playerLookDirection.getX() * -1.0;
                    double y2 = y1 + 1.6;
                    double z2 = z1 + playerLookDirection.getZ() * -1.0;
                    float yaw = playerLocation.getYaw();
                    float pitch = playerLocation.getPitch();
                    Location armorStandLocation = new Location(Bukkit.getServer().getWorld("hub"), x2, y2, z2, yaw, pitch);
                    stand.teleport(armorStandLocation);
                }
                if (getCardinalDirection(p) == "E") {
                    Location playerLocation = p.getLocation();
                    double x1 = playerLocation.getX() + 0.5;
                    double y1 = playerLocation.getY();
                    double z1 = playerLocation.getZ() - 0.5;
                    double x2 = x1 + playerLookDirection.getX() * -1.0;
                    double y2 = y1 + 1.6;
                    double z2 = z1 + playerLookDirection.getZ() * -1.0;
                    float yaw = playerLocation.getYaw();
                    float pitch = playerLocation.getPitch();
                    Location armorStandLocation = new Location(Bukkit.getServer().getWorld("hub"), x2, y2, z2, yaw, pitch);
                    stand.teleport(armorStandLocation);
                }
                if (getCardinalDirection(p) == "SE") {
                    Location playerLocation = p.getLocation();
                    double x1 = playerLocation.getX() + 0.5;
                    double y1 = playerLocation.getY();
                    double z1 = playerLocation.getZ() - 0.5;
                    double x2 = x1 + playerLookDirection.getX() * -1.0;
                    double y2 = y1 + 1.6;
                    double z2 = z1 + playerLookDirection.getZ() * -1.0;
                    float yaw = playerLocation.getYaw();
                    float pitch = playerLocation.getPitch();
                    Location armorStandLocation = new Location(Bukkit.getServer().getWorld("hub"), x2, y2, z2, yaw, pitch);
                    stand.teleport(armorStandLocation);
                }
                if (getCardinalDirection(p) == "S") {
                    Location playerLocation = p.getLocation();
                    double x1 = playerLocation.getX() + 0.5;
                    double y1 = playerLocation.getY();
                    double z1 = playerLocation.getZ() + 0.5;
                    double x2 = x1 + playerLookDirection.getX() * -1.0;
                    double y2 = y1 + 1.6;
                    double z2 = z1 + playerLookDirection.getZ() * -1.0;
                    float yaw = playerLocation.getYaw();
                    float pitch = playerLocation.getPitch();
                    Location armorStandLocation = new Location(Bukkit.getServer().getWorld("hub"), x2, y2, z2, yaw, pitch);
                    stand.teleport(armorStandLocation);
                }
                if (getCardinalDirection(p) == "SW") {
                    Location playerLocation = p.getLocation();
                    double x1 = playerLocation.getX() + 0.5;
                    double y1 = playerLocation.getY();
                    double z1 = playerLocation.getZ() + 0.5;
                    double x2 = x1 + playerLookDirection.getX() * -1.0;
                    double y2 = y1 + 1.6;
                    double z2 = z1 + playerLookDirection.getZ() * -1.0;
                    float yaw = playerLocation.getYaw();
                    float pitch = playerLocation.getPitch();
                    Location armorStandLocation = new Location(Bukkit.getServer().getWorld("hub"), x2, y2, z2, yaw, pitch);
                    stand.teleport(armorStandLocation);
                }
                if (getCardinalDirection(p) == "W") {
                    Location playerLocation = p.getLocation();
                    double x1 = playerLocation.getX() - 0.5;
                    double y1 = playerLocation.getY();
                    double z1 = playerLocation.getZ() + 0.5;
                    double x2 = x1 + playerLookDirection.getX() * -1.0;
                    double y2 = y1 + 1.6;
                    double z2 = z1 + playerLookDirection.getZ() * -1.0;
                    float yaw = playerLocation.getYaw();
                    float pitch = playerLocation.getPitch();
                    Location armorStandLocation = new Location(Bukkit.getServer().getWorld("hub"), x2, y2, z2, yaw, pitch);
                    stand.teleport(armorStandLocation);
                }
                if (getCardinalDirection(p) != "NW") {
                    continue;
                }
                Location playerLocation = p.getLocation();
                double x1 = playerLocation.getX() - 0.5;
                double y1 = playerLocation.getY();
                double z1 = playerLocation.getZ() + 0.5;
                double x2 = x1 + playerLookDirection.getX() * -1.0;
                double y2 = y1 + 1.6;
                double z2 = z1 + playerLookDirection.getZ() * -1.0;
                float yaw = playerLocation.getYaw();
                float pitch = playerLocation.getPitch();
                Location armorStandLocation = new Location(Bukkit.getServer().getWorld("hub"), x2, y2, z2, yaw, pitch);
                stand.teleport(armorStandLocation);
            }
        }
    }
    
    public static void runAction(Player player, String s) {
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++t;
                if (t == 1) {
                    if (s == "true") {
                        run();
                    }
                    else if (s == "false") {
                        cancel();
                    }
                }
                for (Entity stand : Bukkit.getServer().getWorld("hub").getEntitiesByClasses(new Class[] { ArmorStand.class })) {
                    if (stand != null && stand.getCustomName().equalsIgnoreCase(player.getName())) {
                        updateLocCompagnons(player);
                    }
                }
                if (!player.isOnline()) {
                    cancel();
                }
            }
        }.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
    }
    
}
