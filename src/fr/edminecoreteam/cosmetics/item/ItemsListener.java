package fr.edminecoreteam.cosmetics.item;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.edminecoreteam.cosmetics.gui.MainGui;
import fr.edminecoreteam.cosmetics.playersettings.SettingInfo;
import fr.edminecoreteam.cosmetics.utils.SkullNBT;


public class ItemsListener implements Listener
{
	private Player p;
	private static ItemStack getSkull(String url) { return SkullNBT.getSkull(url); }
	
	public ItemsListener(Player p) 
	{
		this.p = p;
	}
	
	public ItemsListener() {
		// TODO Auto-generated constructor stub
	}
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        ItemStack it = e.getCurrentItem();
        if (it == null) {  return; }
        	if (it.getType() == Material.SKULL_ITEM)
        	{
        		if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§9§lCosmétiques §7• Clique"))
        		{
        			e.setCancelled(true);
        			p.playSound(p.getLocation(), Sound.HORSE_ARMOR, 1.0f, 1.0f);
        			MainGui.gui(p);
        		}
        		if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§9§lCosmetics §7• Click"))
        		{
        			e.setCancelled(true);
        			p.playSound(p.getLocation(), Sound.HORSE_ARMOR, 1.0f, 1.0f);
        			MainGui.gui(p);
        		}
        		if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§9§lCosméticos §7• Clic"))
        		{
        			e.setCancelled(true);
        			p.playSound(p.getLocation(), Sound.HORSE_ARMOR, 1.0f, 1.0f);
        			MainGui.gui(p);
        		}
        		if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§9§lKosmetika §7• Sklick"))
        		{
        			e.setCancelled(true);
        			p.playSound(p.getLocation(), Sound.HORSE_ARMOR, 1.0f, 1.0f);
        			MainGui.gui(p);
        		}
        	}
    }
	
	@EventHandler
    public void onInteract(PlayerInteractEvent e) {
		
        Player p = e.getPlayer();
        Action a = e.getAction();
        ItemStack it = e.getItem();
        if (it == null) { return; }
        
        if (it.getType() == Material.SKULL_ITEM 
        		&& it.getItemMeta().getDisplayName().equalsIgnoreCase("§9§lCosmétiques §7• Clique")
        			&& (a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK || a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)) 
        {
        	e.setCancelled(true);
        	p.playSound(p.getLocation(), Sound.HORSE_ARMOR, 1.0f, 1.0f);
        	MainGui.gui(p);
        }
        if (it.getType() == Material.SKULL_ITEM 
        		&& it.getItemMeta().getDisplayName().equalsIgnoreCase("§9§lCosmetics §7• Click")
        			&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK)) 
        {
        	e.setCancelled(true);
        	p.playSound(p.getLocation(), Sound.HORSE_ARMOR, 1.0f, 1.0f);
        	MainGui.gui(p);
        }
        if (it.getType() == Material.SKULL_ITEM 
        		&& it.getItemMeta().getDisplayName().equalsIgnoreCase("§9§lCosméticos §7• Clic")
        			&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK)) 
        {
        	e.setCancelled(true);
        	p.playSound(p.getLocation(), Sound.HORSE_ARMOR, 1.0f, 1.0f);
        	MainGui.gui(p);
        }
        if (it.getType() == Material.SKULL_ITEM 
        		&& it.getItemMeta().getDisplayName().equalsIgnoreCase("§9§lKosmetika §7• Sklick") 
        			&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK)) 
        {
        	e.setCancelled(true);
        	p.playSound(p.getLocation(), Sound.HORSE_ARMOR, 1.0f, 1.0f);
        	MainGui.gui(p);
        }  
    }
	
	public void joinItem() 
	{
		SettingInfo settingInfo = new SettingInfo(p);
		
		if (settingInfo.getLang() == 0)
		{
			ItemStack cosmetic = getSkull("http://textures.minecraft.net/texture/337b96a45a8f0c6fd7dfab2a85e1a384daca4b806eb892a87e27f52a9f91c084");
	        SkullMeta cosmeticM = (SkullMeta)cosmetic.getItemMeta();
	        cosmeticM.setDisplayName("§9§lCosmétiques §7• Clique");
	        cosmetic.setItemMeta((ItemMeta)cosmeticM);
	        p.getInventory().setItem(8, cosmetic);
		}
		if (settingInfo.getLang() == 1)
		{
			ItemStack cosmetic = getSkull("http://textures.minecraft.net/texture/337b96a45a8f0c6fd7dfab2a85e1a384daca4b806eb892a87e27f52a9f91c084");
	        SkullMeta cosmeticM = (SkullMeta)cosmetic.getItemMeta();
	        cosmeticM.setDisplayName("§9§lCosmetics §7• Click");
	        cosmetic.setItemMeta((ItemMeta)cosmeticM);
	        p.getInventory().setItem(8, cosmetic);
		}
		if (settingInfo.getLang() == 2)
		{
			ItemStack cosmetic = getSkull("http://textures.minecraft.net/texture/337b96a45a8f0c6fd7dfab2a85e1a384daca4b806eb892a87e27f52a9f91c084");
	        SkullMeta cosmeticM = (SkullMeta)cosmetic.getItemMeta();
	        cosmeticM.setDisplayName("§9§lCosméticos §7• Clic");
	        cosmetic.setItemMeta((ItemMeta)cosmeticM);
	        p.getInventory().setItem(8, cosmetic);
		}
		if (settingInfo.getLang() == 3)
		{
			ItemStack cosmetic = getSkull("http://textures.minecraft.net/texture/337b96a45a8f0c6fd7dfab2a85e1a384daca4b806eb892a87e27f52a9f91c084");
	        SkullMeta cosmeticM = (SkullMeta)cosmetic.getItemMeta();
	        cosmeticM.setDisplayName("§9§lKosmetika §7• Sklick");
	        cosmetic.setItemMeta((ItemMeta)cosmeticM);
	        p.getInventory().setItem(8, cosmetic);
		}
	}
}
