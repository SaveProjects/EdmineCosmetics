package fr.edminecoreteam.cosmetics.gui;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.cosmetics.Main;
import fr.edminecoreteam.cosmetics.data.CosmeticsData;
import fr.edminecoreteam.cosmetics.entity.titres.CustomTitreType;
import fr.edminecoreteam.cosmetics.store.StoreData;
import fr.edminecoreteam.cosmetics.store.StoreInfo;
import fr.edminecoreteam.cosmetics.utils.SkullNBT;

public class TitreGui implements Listener
{
	
	private static Main api = Main.getInstance();
	private static ItemStack getSkull(String url) { return SkullNBT.getSkull(url); }
	static HashMap<Player, Integer> pageCount = new HashMap<Player, Integer>();
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        ItemStack it = e.getCurrentItem();
        PageGestion pGestion = new PageGestion(p);
        if (e.getView().getTopInventory().getTitle().contains("§8Cosmétiques (Titres)")) 
        {
        	if (it.getType() == Material.AIR || it.getType() == null)  { return; }
        	int MaxPage = pGestion.getCosmeticsPageNumber("titres");
        	e.setCancelled(true);
        	if (it.getType() == Material.ARROW)
            {
        		if(it.getItemMeta().getDisplayName() == "§8§l⬇ §7Retour §8§l⬇")
            	{
            		p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            		MainGui.gui(p);
            	}
            }
        	if (it.getType() == Material.SKULL_ITEM)
            {
        		if(it.getItemMeta().getDisplayName() == "§8➡ §7Page Suivante")
            	{
            		p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            		pageCount.put(p, pageCount.get(p) + 1);
            		gui(p, pageCount.get(p), MaxPage);
            	}
            	if(it.getItemMeta().getDisplayName() == "§8⬅ §7Page Précédente")
            	{
            		p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            		pageCount.put(p, pageCount.get(p) - 1);
            		gui(p, pageCount.get(p), MaxPage);
            	}
            }
        	if (it.getType() == Material.BARRIER)
            {
        		if(it.getItemMeta().getDisplayName() == "§cDésactiver votre titre")
            	{
            		p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            		CosmeticsData data = new CosmeticsData(p);
            		data.updateTitre(0);
            		CustomTitreType tListener = new CustomTitreType(p);
    				tListener.despawn();
    				gui(p, pageCount.get(p), MaxPage);
            	}
            }
        	CosmeticsData data = new CosmeticsData(p);
        	String name = "§7Titre: " + it.getItemMeta().getDisplayName();
        	StoreData info = new StoreData(name);
        	if (it.getType() == Material.NAME_TAG)
            {
        		if (info.getArticleIDByName() != 0)
                {
                	int articleID = info.getArticleIDByName();
                	if (data.getActiveTitre() == articleID)
                	{
                		CustomTitreType tListener = new CustomTitreType(p);
                		data.updateTitre(0);
        				tListener.despawn();
                		p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
        				gui(p, pageCount.get(p), MaxPage);
                	}
                	else
                	{
                		if (data.getActiveTitre() != 0)
                		{
                			data.updateTitre(articleID);
                    		for (String articles : api.getConfig().getConfigurationSection("cosmetics.type.titres").getKeys(false))
                            {
                    			if (api.getConfig().getInt("cosmetics.type.titres." + articles + ".referenceid") == articleID)
                    			{
                    				CustomTitreType tListener = new CustomTitreType(p);
                    				tListener.despawn();
                    				tListener.spawn();
                    				p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
                    				gui(p, pageCount.get(p), MaxPage);
                    				p.sendMessage("§9§lCosmétiques §8» §fVous avez activé votre §etitre §fsur " + it.getItemMeta().getDisplayName() + "§f.");
                    			}
                            }
                		}
                		else
                		{
                			data.updateTitre(articleID);
                    		for (String articles : api.getConfig().getConfigurationSection("cosmetics.type.titres").getKeys(false))
                            {
                    			if (api.getConfig().getInt("cosmetics.type.titres." + articles + ".referenceid") == articleID)
                    			{
                    				CustomTitreType tListener = new CustomTitreType(p);
                    				tListener.spawn();
                    				p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
                    				gui(p, pageCount.get(p), MaxPage);
                    				p.sendMessage("§9§lCosmétiques §8» §fVous avez activé votre §etitre §fsur " + it.getItemMeta().getDisplayName() + "§f.");
                    			}
                            }
                		}
                	}
                }
                else
                {
                	return;
                }
            }
        }
    }
	
	public static void gui(Player p, int Page, int MaxPage) {
		
		Inventory inv = Bukkit.createInventory(null, 54, "§8Cosmétiques (Titres) " + Page + "/" + MaxPage);
		PageGestion pGestion = new PageGestion(p);
		CosmeticsData data = new CosmeticsData(p);
		p.openInventory(inv);
        pageCount.put(p, Page);
        int cosmeticsPerPage = 10;
        
        ItemStack back = new ItemStack(Material.ARROW, 1);
        ItemMeta backM = back.getItemMeta();
        backM.setDisplayName("§8§l⬇ §7Retour §8§l⬇");
        back.setItemMeta(backM);
        inv.setItem(49, back);
		
        if (Page != MaxPage)
        {
        	if (Page == 1)
        	{
        		ItemStack suivant = getSkull("http://textures.minecraft.net/texture/956a3618459e43b287b22b7e235ec699594546c6fcd6dc84bfca4cf30ab9311");
                ItemMeta suivantM = suivant.getItemMeta();
                suivantM.setDisplayName("§8➡ §7Page Suivante");
                suivant.setItemMeta(suivantM);
                inv.setItem(50, suivant);
        	}
        	if (Page != 1)
        	{
        		ItemStack suivant = getSkull("http://textures.minecraft.net/texture/956a3618459e43b287b22b7e235ec699594546c6fcd6dc84bfca4cf30ab9311");
                ItemMeta suivantM = suivant.getItemMeta();
                suivantM.setDisplayName("§8➡ §7Page Suivante");
                suivant.setItemMeta(suivantM);
                inv.setItem(50, suivant);
                
                ItemStack precedent = getSkull("http://textures.minecraft.net/texture/cdc9e4dcfa4221a1fadc1b5b2b11d8beeb57879af1c42362142bae1edd5");
                SkullMeta precedentM = (SkullMeta)precedent.getItemMeta();
                precedentM.setDisplayName("§8⬅ §7Page Précédente");
                precedent.setItemMeta((ItemMeta)precedentM);
                inv.setItem(48, precedent);
        	}
        }
        else if (Page == MaxPage)
        {
        	if (MaxPage == 1)
        	{
        		//Rien
        	}
        	else if (MaxPage > 1)
        	{
        		ItemStack precedent = getSkull("http://textures.minecraft.net/texture/cdc9e4dcfa4221a1fadc1b5b2b11d8beeb57879af1c42362142bae1edd5");
                SkullMeta precedentM = (SkullMeta)precedent.getItemMeta();
                precedentM.setDisplayName("§8⬅ §7Page Précédente");
                precedent.setItemMeta((ItemMeta)precedentM);
                inv.setItem(48, precedent);
        	}
        }
        
        
		new BukkitRunnable() {
            int t = 0;   
	        public void run() {
	        	
	        	if (!p.getOpenInventory().getTitle().contains("§8Cosmétiques (Titres)")) { cancel(); }
		            	ItemStack deco = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4);
		                ItemMeta decoM = deco.getItemMeta();
		                decoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		                decoM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		                decoM.setDisplayName("§r");
		                deco.setItemMeta(decoM);
		                inv.setItem(0, deco); inv.setItem(8, deco); inv.setItem(9, deco); inv.setItem(17, deco);
		                inv.setItem(45, deco); inv.setItem(53, deco); inv.setItem(36, deco); inv.setItem(44, deco);
                ++t;
                if (t == 10) {
                    run();
                }
            }
        }.runTaskTimer((Plugin)api, 0L, 10L);
            
        	/*ItemStack addfriend = getSkull("http://textures.minecraft.net/texture/f3bfe4131a6f612c75b45d80839bcb37edd7e8717e695a3e64ce9d033beafe6");
            SkullMeta addfriendM = (SkullMeta) addfriend.getItemMeta();
            addfriendM.setDisplayName("§d§lAjouter un ami");
            ArrayList<String> loreaddfriend = new ArrayList<String>();
            loreaddfriend.add("");
            loreaddfriend.add(" §aDescription:");
            loreaddfriend.add(" §f▶ §7Ajouter de manière simple");
            loreaddfriend.add(" §f  §7un joueur de votre choix.");
            loreaddfriend.add("");
            loreaddfriend.add("§8➡ §fCliquez pour y accéder.");
            addfriendM.setLore(loreaddfriend);
            addfriend.setItemMeta(addfriendM);
            inv.setItem(4, addfriend);*/
        
        ItemStack removecosmetic = new ItemStack(Material.BARRIER, 1);
        ItemMeta removecosmeticM = removecosmetic.getItemMeta();
        removecosmeticM.setDisplayName("§cDésactiver votre titre");
        ArrayList<String> loreremovecosmetic = new ArrayList<String>();
        loreremovecosmetic.add("");
        loreremovecosmetic.add(" §aDescription:");
        loreremovecosmetic.add(" §f▶ §7Cliquez pour désactiver");
        loreremovecosmetic.add(" §f  §7votre cosmétique en cours...");
        loreremovecosmetic.add("");
        loreremovecosmetic.add("§8➡ §fCliquez pour y accéder.");
        removecosmeticM.setLore(loreremovecosmetic);
        removecosmetic.setItemMeta(removecosmeticM);
        inv.setItem(4, removecosmetic);
            
            
            int slot = 20;
        	int cosmeticsCount = 0;
            for (Integer friends : pGestion.getCosmeticsForPage(Page, "titres")) {
            	++cosmeticsCount;
            	StoreInfo info = new StoreInfo(friends);
            	ItemStack cosmetic = new ItemStack(Material.NAME_TAG, 1);
                ItemMeta cosmeticM = cosmetic.getItemMeta();
                cosmeticM.setDisplayName(info.getArticleName().replace("&7Titre:_", "").replace("&", "§").replace("_", " "));
                ArrayList<String> lorecosmetic = new ArrayList<String>();
                if (data.getActiveTitre() == friends)
                {
                	lorecosmetic.add("");
                	lorecosmetic.add(" §aDescription:");
                	lorecosmetic.add(" §f▶ §7Avec ce titre,");
                	lorecosmetic.add(" §f  §7parcourez sans limite");
                	lorecosmetic.add(" §f  §7le lobby du serveur !");
                	lorecosmetic.add("");
                	lorecosmetic.add(" §dInformation:");
                	if (info.getArticleRarity() == 1)
    	            {
                		lorecosmetic.add(" §f▶ §7Rareté: §6✯§8✯✯✯✯");
    	            }
    	            else if (info.getArticleRarity() == 2)
    	            {
    	            	lorecosmetic.add(" §f▶ §7Rareté: §6✯✯§8✯✯✯");
    	            }
    	            else if (info.getArticleRarity() == 3)
    	            {
    	            	lorecosmetic.add(" §f▶ §7Rareté: §6✯✯✯§8✯✯");
    	            }
    	            else if (info.getArticleRarity() == 4)
    	            {
    	            	lorecosmetic.add(" §f▶ §7Rareté: §6✯✯✯✯§8✯");
    	            }
    	            else if (info.getArticleRarity() == 5)
    	            {
    	            	lorecosmetic.add(" §f▶ §7Rareté: §6✯✯✯✯✯");
    	            }
                	lorecosmetic.add("");
                	lorecosmetic.add(" §f▶ §aTitre activée.");
                    lorecosmetic.add("");
                    lorecosmetic.add("§8➡ §fCliquez pour désactiver.");
                }
                else
                {
                	lorecosmetic.add("");
                	lorecosmetic.add(" §aDescription:");
                	lorecosmetic.add(" §f▶ §7Utilisez ce titre");
                	lorecosmetic.add(" §f  §7parcourir le lobby !");
                	lorecosmetic.add("");
                	lorecosmetic.add(" §dInformation:");
                	if (info.getArticleRarity() == 1)
    	            {
                		lorecosmetic.add(" §f▶ §7Rareté: §6✯§8✯✯✯✯");
    	            }
    	            else if (info.getArticleRarity() == 2)
    	            {
    	            	lorecosmetic.add(" §f▶ §7Rareté: §6✯✯§8✯✯✯");
    	            }
    	            else if (info.getArticleRarity() == 3)
    	            {
    	            	lorecosmetic.add(" §f▶ §7Rareté: §6✯✯✯§8✯✯");
    	            }
    	            else if (info.getArticleRarity() == 4)
    	            {
    	            	lorecosmetic.add(" §f▶ §7Rareté: §6✯✯✯✯§8✯");
    	            }
    	            else if (info.getArticleRarity() == 5)
    	            {
    	            	lorecosmetic.add(" §f▶ §7Rareté: §6✯✯✯✯✯");
    	            }
                	lorecosmetic.add("");
                    lorecosmetic.add("§8➡ §fCliquez pour activer.");
                }
                
                cosmeticM.setLore(lorecosmetic);
                cosmetic.setItemMeta(cosmeticM);
                
                
                if (cosmeticsCount == cosmeticsPerPage)
                {
                	inv.setItem(slot, cosmetic);
                }
                else if (cosmeticsCount != cosmeticsPerPage)
                {
                	inv.setItem(slot, cosmetic);
                }
                if (slot == 24) {
                	slot += 4;
                }
                if (slot != 25 || slot != 33  && slot < 33) {
                	slot += 1;
                }
                if (slot == 34) {
                	return;
                }
            }
        	
	}
}
