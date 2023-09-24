package fr.edminecoreteam.cosmetics.gui;

import java.util.ArrayList;
import java.util.List;

import fr.edminecoreteam.cosmetics.utils.CosmeticsListListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.edminecoreteam.cosmetics.Main;
import fr.edminecoreteam.cosmetics.data.CosmeticsData;
import fr.edminecoreteam.cosmetics.store.PurchaseData;
import fr.edminecoreteam.cosmetics.store.StoreInfo;
import fr.edminecoreteam.cosmetics.utils.SkullNBT;

public class MainGui implements Listener
{
	private static Main main = Main.getInstance();
	private static ItemStack getSkull(String url) { return SkullNBT.getSkull(url); }
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        ItemStack it = e.getCurrentItem();
        if (it == null) {  return; }
        
        if (e.getView().getTopInventory().getTitle().equalsIgnoreCase("§8Cosmétiques")) 
        {
        	e.setCancelled(true);
        	PageGestion pGestion = new PageGestion(p);
            PurchaseData buyData = new PurchaseData(p.getName());
            List<Integer> monturebuy = new ArrayList<Integer>();
            List<Integer> familierbuy = new ArrayList<Integer>();
            List<Integer> ballonbuy = new ArrayList<Integer>();
            List<Integer> titrebuy = new ArrayList<Integer>();

            List<Integer> buyList = buyData.getAllArticle();


            for (Integer article : CosmeticsListListener.montureList.keySet()){
                if (buyList.contains(article)){
                    monturebuy.add(article);
                }
            }

            for(Integer article : CosmeticsListListener.titreList.keySet()) {
                if (buyList.contains(article)) {
                    titrebuy.add(article);
                }
            }

            for(Integer article : CosmeticsListListener.ballonList.keySet()) {
                if (buyList.contains(article)) {
                    ballonbuy.add(article);
                }
            }

            for(Integer article : CosmeticsListListener.familierList.keySet()) {
                if (buyList.contains(article)) {
                    familierbuy.add(article);
                }
            }

           /* for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.montures").getKeys(false)){
                if(buyList.contains(main.getConfig().getInt("cosmetics.type.montures." + articles + ".referenceid"))){
                    monturebuy.add(main.getConfig().getInt("cosmetics.type.montures." + articles + ".referenceid"));
                }
            }

            for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.compagnons").getKeys(false))
            {
                if (buyList.contains(main.getConfig().getInt("cosmetics.type.compagnons." + articles + ".referenceid")))
                {
                    familierbuy.add(main.getConfig().getInt("cosmetics.type.compagnons." + articles + ".referenceid"));
                }
            }

            for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.ballons").getKeys(false))
            {
                if (buyList.contains(main.getConfig().getInt("cosmetics.type.ballons." + articles + ".referenceid")))
                {
                    ballonbuy.add(main.getConfig().getInt("cosmetics.type.ballons." + articles + ".referenceid"));
                }
            }

            for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.titres").getKeys(false))
            {
                if (buyList.contains(main.getConfig().getInt("cosmetics.type.titres." + articles + ".referenceid")))
                {
                    titrebuy.add(main.getConfig().getInt("cosmetics.type.titres." + articles + ".referenceid"));
                }
            }*/
            /*for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.montures").getKeys(false))
            {
            	if (buyData.hasArticle(main.getConfig().getInt("cosmetics.type.montures." + articles + ".referenceid")))
            	{
            		monturebuy.add(main.getConfig().getInt("cosmetics.type.montures." + articles + ".referenceid"));
            	}
            }
            for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.compagnons").getKeys(false))
            {
            	if (buyData.hasArticle(main.getConfig().getInt("cosmetics.type.compagnons." + articles + ".referenceid")))
            	{
            		familierbuy.add(main.getConfig().getInt("cosmetics.type.compagnons." + articles + ".referenceid"));
            	}
            }
            for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.ballons").getKeys(false))
            {
            	if (buyData.hasArticle(main.getConfig().getInt("cosmetics.type.ballons." + articles + ".referenceid")))
            	{
            		ballonbuy.add(main.getConfig().getInt("cosmetics.type.ballons." + articles + ".referenceid"));
            	}
            }
            for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.titres").getKeys(false))
            {
            	if (buyData.hasArticle(main.getConfig().getInt("cosmetics.type.titres." + articles + ".referenceid")))
            	{
            		titrebuy.add(main.getConfig().getInt("cosmetics.type.titres." + articles + ".referenceid"));
            	}
            }
            */
            if (it.getType() == Material.SADDLE || it.getType() == Material.SKULL_ITEM || it.getType() == Material.NAME_TAG)
            {
            	if(it.getItemMeta().getDisplayName() == "§6§lMontures")
            	{
            		if (monturebuy.size() != 0)
                    {
            			p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            			MontureGui.gui(p, 1, pGestion.getCosmeticsPageNumber("montures", buyList));
                    }
            		else
            		{
            			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
            		}
            	}
            	if(it.getItemMeta().getDisplayName() == "§d§lCompagnons")
            	{
            		if (familierbuy.size() != 0)
                    {
            			p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            			FamilierGui.gui(p, 1, pGestion.getCosmeticsPageNumber("compagnons", buyList));
                    }
            		else
            		{
            			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
            		}
            	}
            	if(it.getItemMeta().getDisplayName() == "§b§lBallons")
            	{
            		if (ballonbuy.size() != 0)
                    {
            			p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            			BallonGui.gui(p, 1, pGestion.getCosmeticsPageNumber("ballons", buyList));
                    }
            		else
            		{
            			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
            		}
            	}
            	if(it.getItemMeta().getDisplayName() == "§e§lTitres")
            	{
            		if (titrebuy.size() != 0)
                    {
            			p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            			TitreGui.gui(p, 1, pGestion.getCosmeticsPageNumber("titres", buyList));
                    }
            		else
            		{
            			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
            		}
            	}
            }
        }
    }
	
	public static void gui(Player p)
	{
		Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "§8Cosmétiques");
		ItemStack deco = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
        ItemMeta decoM = deco.getItemMeta();
        decoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        decoM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        decoM.setDisplayName("§r");
        deco.setItemMeta(decoM);
        inv.setItem(0, deco); inv.setItem(8, deco); inv.setItem(9, deco); inv.setItem(44, deco);
        inv.setItem(45, deco); inv.setItem(53, deco); inv.setItem(36, deco); inv.setItem(17, deco);
        CosmeticsData data = new CosmeticsData(p);
        PurchaseData buyData = new PurchaseData(p.getName());
        
        List<Integer> monturebuy = new ArrayList<Integer>();
        List<Integer> familierbuy = new ArrayList<Integer>();
        List<Integer> ballonbuy = new ArrayList<Integer>();
        List<Integer> titrebuy = new ArrayList<Integer>();

        List<Integer> buyList = buyData.getAllArticle();


        for (Integer article : CosmeticsListListener.montureList.keySet()){
            if (buyList.contains(article)){
                monturebuy.add(article);
            }
        }

        for(Integer article : CosmeticsListListener.titreList.keySet()) {
            if (buyList.contains(article)) {
                titrebuy.add(article);
            }
        }

        for(Integer article : CosmeticsListListener.ballonList.keySet()) {
            if (buyList.contains(article)) {
                ballonbuy.add(article);
            }
        }

        for(Integer article : CosmeticsListListener.familierList.keySet()) {
            if (buyList.contains(article)) {
                familierbuy.add(article);
            }
        }
        
        if (monturebuy.size() != 0)
        {
        	if (data.getActiveMonture() != 0)
        	{
				StoreInfo buyInfo = new StoreInfo(data.getActiveMonture());
        		
        		ItemStack montures = getSkull("http://textures.minecraft.net/texture/" + buyInfo.getArticleSkull());
                ItemMeta monturesM = montures.getItemMeta();
                monturesM.setDisplayName("§6§lMontures");
                ArrayList<String> loremontures = new ArrayList<String>();
                loremontures.add("");
                loremontures.add(" §aDescription:");
                loremontures.add(" §f▶ §7À dos de votre magnifique");
                loremontures.add(" §f  §7monture, prenez place et");
                loremontures.add(" §f  §7visitez le lobby entier !");
                loremontures.add("");
                loremontures.add(" §dInformations:");
                loremontures.add(" §f▶ §7Monture actif: §e" + buyInfo.getArticleName().replace("&7Monture:_", "").replace("&", "§"));
                loremontures.add(" §f▶ §7Monture possédés: §a" + monturebuy.size() + "§a/" + CosmeticsListListener.montureList.size());
                loremontures.add("");
                loremontures.add("§8➡ §fCliquez pour y accéder.");
                monturesM.setLore(loremontures);
                montures.setItemMeta(monturesM);
                inv.setItem(20, montures);
        	}
        	else
        	{
        		ItemStack montures = new ItemStack(Material.SADDLE, 1);
                ItemMeta monturesM = montures.getItemMeta();
                monturesM.setDisplayName("§6§lMontures");
                ArrayList<String> loremontures = new ArrayList<String>();
                loremontures.add("");
                loremontures.add(" §aDescription:");
                loremontures.add(" §f▶ §7À dos de votre magnifique");
                loremontures.add(" §f  §7monture, prenez place et");
                loremontures.add(" §f  §7visitez le lobby entier !");
                loremontures.add("");
                loremontures.add(" §dInformations:");
                loremontures.add(" §f▶ §7Monture actif: §caucune");
                loremontures.add(" §f▶ §7Monture possédés: §a" + monturebuy.size() + "§a/" + CosmeticsListListener.montureList.size());
                loremontures.add("");
                loremontures.add("§8➡ §fCliquez pour y accéder.");
                monturesM.setLore(loremontures);
                montures.setItemMeta(monturesM);
                inv.setItem(20, montures);
        	}
        }
        else
        {
        	ItemStack montures = new ItemStack(Material.SADDLE, 1);
            ItemMeta monturesM = montures.getItemMeta();
            monturesM.setDisplayName("§6§lMontures");
            ArrayList<String> loremontures = new ArrayList<String>();
            loremontures.add("");
            loremontures.add(" §aDescription:");
            loremontures.add(" §f▶ §7À dos de votre magnifique");
            loremontures.add(" §f  §7monture, prenez place et");
            loremontures.add(" §f  §7visitez le lobby entier !");
            loremontures.add("");
            loremontures.add("§8➡ §cAucune montures débloqué...");
            monturesM.setLore(loremontures);
            montures.setItemMeta(monturesM);
            inv.setItem(20, montures);
        } 
        
        
        if (familierbuy.size() != 0)
        {
        	if (data.getActiveFamilier() != 0)
        	{
				StoreInfo buyInfo = new StoreInfo(data.getActiveFamilier());
        		
        		ItemStack montures = getSkull("http://textures.minecraft.net/texture/" + buyInfo.getArticleSkull());
                ItemMeta monturesM = montures.getItemMeta();
                monturesM.setDisplayName("§d§lCompagnons");
                ArrayList<String> loremontures = new ArrayList<String>();
                loremontures.add("");
                loremontures.add(" §aDescription:");
                loremontures.add(" §f▶ §7Faites apparaître un");
                loremontures.add(" §f  §7petit compagnon qui vous");
                loremontures.add(" §f  §7acompagnera dans le lobby !");
                loremontures.add("");
                loremontures.add(" §dInformations:");
                loremontures.add(" §f▶ §7Compagnon actif: §e" + buyInfo.getArticleName().replace("&7Compagnon:_", "").replace("&", "§").replace("_", " "));
                loremontures.add(" §f▶ §7Compagnon possédés: §a" + familierbuy.size() + "§a/" + CosmeticsListListener.familierList.size());
                loremontures.add("");
                loremontures.add("§8➡ §fCliquez pour y accéder.");
                monturesM.setLore(loremontures);
                montures.setItemMeta(monturesM);
                inv.setItem(29, montures);
        	}
        	else
        	{
        		ItemStack montures = getSkull("http://textures.minecraft.net/texture/98041e3d8c0f9c8b94ca311937007b93d5ff4662f78995294c987ce0c4e2022f");
                ItemMeta monturesM = montures.getItemMeta();
                monturesM.setDisplayName("§d§lCompagnons");
                ArrayList<String> loremontures = new ArrayList<String>();
                loremontures.add("");
                loremontures.add(" §aDescription:");
                loremontures.add(" §f▶ §7Faites apparaître un");
                loremontures.add(" §f  §7petit compagnon qui vous");
                loremontures.add(" §f  §7acompagnera dans le lobby !");
                loremontures.add("");
                loremontures.add(" §dInformations:");
                loremontures.add(" §f▶ §7Compagnon actif: §caucun");
                loremontures.add(" §f▶ §7Compagnon possédés: §a" + familierbuy.size() + "§a/" + CosmeticsListListener.familierList.size());
                loremontures.add("");
                loremontures.add("§8➡ §fCliquez pour y accéder.");
                monturesM.setLore(loremontures);
                montures.setItemMeta(monturesM);
                inv.setItem(29, montures);
        	}
        }
        else
        {
        	ItemStack montures = getSkull("http://textures.minecraft.net/texture/98041e3d8c0f9c8b94ca311937007b93d5ff4662f78995294c987ce0c4e2022f");
            ItemMeta monturesM = montures.getItemMeta();
            monturesM.setDisplayName("§d§lCompagnons");
            ArrayList<String> loremontures = new ArrayList<String>();
            loremontures.add("");
            loremontures.add(" §aDescription:");
            loremontures.add(" §f▶ §7Faites apparaître un");
            loremontures.add(" §f  §7petit compagnon qui vous");
            loremontures.add(" §f  §7acompagnera dans le lobby !");
            loremontures.add("");
            loremontures.add("§8➡ §cAucun compagnons débloqué...");
            monturesM.setLore(loremontures);
            montures.setItemMeta(monturesM);
            inv.setItem(29, montures);
        } 
        
        
        if (ballonbuy.size() != 0)
        {
        	if (data.getActiveBallon() != 0)
        	{
				StoreInfo buyInfo = new StoreInfo(data.getActiveBallon());
        		
        		ItemStack montures = getSkull("http://textures.minecraft.net/texture/" + buyInfo.getArticleSkull());
                ItemMeta monturesM = montures.getItemMeta();
                monturesM.setDisplayName("§b§lBallons");
                ArrayList<String> loremontures = new ArrayList<String>();
                loremontures.add("");
                loremontures.add(" §aDescription:");
                loremontures.add(" §f▶ §7Faites apparaître un");
                loremontures.add(" §f  §7petit ballon qui vous");
                loremontures.add(" §f  §7acompagnera dans le lobby !");
                loremontures.add("");
                loremontures.add(" §dInformations:");
                loremontures.add(" §f▶ §7Ballon actif: §e" + buyInfo.getArticleName().replace("&7Ballon:_", "").replace("&", "§").replace("_", " "));
                loremontures.add(" §f▶ §7Ballon possédés: §a" + ballonbuy.size() + "§a/" + CosmeticsListListener.ballonList.size());
                loremontures.add("");
                loremontures.add("§8➡ §fCliquez pour y accéder.");
                monturesM.setLore(loremontures);
                montures.setItemMeta(monturesM);
                inv.setItem(22, montures);
        	}
        	else
        	{
        		ItemStack montures = getSkull("http://textures.minecraft.net/texture/b03338e1e9ae77cb28a195790fcbc0601c6588830ca429af19205c3e0642bed7");
                ItemMeta monturesM = montures.getItemMeta();
                monturesM.setDisplayName("§b§lBallons");
                ArrayList<String> loremontures = new ArrayList<String>();
                loremontures.add("");
                loremontures.add(" §aDescription:");
                loremontures.add(" §f▶ §7Faites apparaître un");
                loremontures.add(" §f  §7petit ballon qui vous");
                loremontures.add(" §f  §7acompagnera dans le lobby !");
                loremontures.add("");
                loremontures.add(" §dInformations:");
                loremontures.add(" §f▶ §7Ballon actif: §caucun");
                loremontures.add(" §f▶ §7Ballon possédés: §a" + ballonbuy.size() + "§a/" + CosmeticsListListener.ballonList.size());
                loremontures.add("");
                loremontures.add("§8➡ §fCliquez pour y accéder.");
                monturesM.setLore(loremontures);
                montures.setItemMeta(monturesM);
                inv.setItem(22, montures);
        	}
        }
        else
        {
        	ItemStack montures = getSkull("http://textures.minecraft.net/texture/b03338e1e9ae77cb28a195790fcbc0601c6588830ca429af19205c3e0642bed7");
            ItemMeta monturesM = montures.getItemMeta();
            monturesM.setDisplayName("§b§lBallons");
            ArrayList<String> loremontures = new ArrayList<String>();
            loremontures.add("");
            loremontures.add(" §aDescription:");
            loremontures.add(" §f▶ §7Faites apparaître un");
            loremontures.add(" §f  §7petit ballon qui vous");
            loremontures.add(" §f  §7acompagnera dans le lobby !");
            loremontures.add("");
            loremontures.add("§8➡ §cAucun ballons débloqué...");
            monturesM.setLore(loremontures);
            montures.setItemMeta(monturesM);
            inv.setItem(22, montures);
        } 
        
        
        if (titrebuy.size() != 0)
        {
        	if (data.getActiveTitre() != 0)
        	{
				StoreInfo buyInfo = new StoreInfo(data.getActiveTitre());
        		
        		ItemStack montures = new ItemStack(Material.NAME_TAG, 1);
                ItemMeta monturesM = montures.getItemMeta();
                monturesM.setDisplayName("§e§lTitres");
                ArrayList<String> loremontures = new ArrayList<String>();
                loremontures.add("");
                loremontures.add(" §aDescription:");
                loremontures.add(" §f▶ §7Faites apparaître un");
                loremontures.add(" §f  §7titre sur votre tête qui vous");
                loremontures.add(" §f  §7acompagnera dans le lobby !");
                loremontures.add("");
                loremontures.add(" §dInformations:");
                loremontures.add(" §f▶ §7Titre actif: §e" + buyInfo.getArticleName().replace("&7Titre:_", "").replace("&", "§").replace("_", " "));
                loremontures.add(" §f▶ §7Titre possédés: §a" + titrebuy.size() + "§a/" + CosmeticsListListener.titreList.size());
                loremontures.add("");
                loremontures.add("§8➡ §fCliquez pour y accéder.");
                monturesM.setLore(loremontures);
                montures.setItemMeta(monturesM);
                inv.setItem(30, montures);
        	}
        	else
        	{
        		ItemStack montures = new ItemStack(Material.NAME_TAG, 1);
                ItemMeta monturesM = montures.getItemMeta();
                monturesM.setDisplayName("§e§lTitres");
                ArrayList<String> loremontures = new ArrayList<String>();
                loremontures.add("");
                loremontures.add(" §aDescription:");
                loremontures.add(" §f▶ §7Faites apparaître un");
                loremontures.add(" §f  §7titre sur votre tête qui vous");
                loremontures.add(" §f  §7acompagnera dans le lobby !");
                loremontures.add("");
                loremontures.add(" §dInformations:");
                loremontures.add(" §f▶ §7Titre actif: §caucun");
                loremontures.add(" §f▶ §7Titre possédés: §a" + titrebuy.size() + "§a/" + CosmeticsListListener.titreList.size());
                loremontures.add("");
                loremontures.add("§8➡ §fCliquez pour y accéder.");
                monturesM.setLore(loremontures);
                montures.setItemMeta(monturesM);
                inv.setItem(30, montures);
        	}
        }
        else
        {
        	ItemStack montures = new ItemStack(Material.NAME_TAG, 1);
            ItemMeta monturesM = montures.getItemMeta();
            monturesM.setDisplayName("§e§lTitres");
            ArrayList<String> loremontures = new ArrayList<String>();
            loremontures.add("");
            loremontures.add(" §aDescription:");
            loremontures.add(" §f▶ §7Faites apparaître un");
            loremontures.add(" §f  §7titre sur votre tête qui vous");
            loremontures.add(" §f  §7acompagnera dans le lobby !");
            loremontures.add("");
            loremontures.add("§8➡ §cAucun titres débloqué...");
            monturesM.setLore(loremontures);
            montures.setItemMeta(monturesM);
            inv.setItem(30, montures);
        } 
        p.openInventory(inv);
	}
}
