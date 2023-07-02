package fr.edminecoreteam.cosmetics.entity.titres;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.Bukkit;

import org.bukkit.entity.Player;

public class ListenerTitre
{
    
    public static void despawnTitre(Player p) {
        for (Entity stand : Bukkit.getServer().getWorld("hub").getEntitiesByClasses(new Class[] { ArmorStand.class })) {
            if (stand != null && stand.hasMetadata("title_" + p.getName())) {
                stand.remove();
            }
        }
    }
}
