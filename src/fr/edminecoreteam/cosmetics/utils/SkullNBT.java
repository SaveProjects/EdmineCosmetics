package fr.edminecoreteam.cosmetics.utils;

import java.lang.reflect.Field;
import org.bukkit.inventory.meta.ItemMeta;
import com.mojang.authlib.properties.Property;
import org.apache.commons.codec.binary.Base64;
import com.mojang.authlib.GameProfile;
import java.util.UUID;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.Listener;

public class SkullNBT implements Listener
{
	public static ItemStack getSkull(String url) {
	    ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	    	if (url.isEmpty())
	    		return head; 
	    SkullMeta headMeta = (SkullMeta)head.getItemMeta();
	    GameProfile profile = new GameProfile(UUID.randomUUID(), null);
	    byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", new Object[] { url }).getBytes());
	    profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
	    Field profileField = null;
	    	try {
	    		profileField = headMeta.getClass().getDeclaredField("profile");
	    		profileField.setAccessible(true);
	    		profileField.set(headMeta, profile);
	    	} catch (NoSuchFieldException|IllegalArgumentException|IllegalAccessException error) {
	    		error.printStackTrace();
	    	} 
	    head.setItemMeta((ItemMeta)headMeta);
	    return head;
	  }
}
