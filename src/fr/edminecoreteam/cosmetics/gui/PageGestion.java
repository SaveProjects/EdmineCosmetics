package fr.edminecoreteam.cosmetics.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import fr.edminecoreteam.cosmetics.Main;
import fr.edminecoreteam.cosmetics.data.CosmeticsData;
import fr.edminecoreteam.cosmetics.store.PurchaseData;



public class PageGestion 
{
	private Player p;
	private static Main main = Main.getInstance();
	
    public PageGestion(Player p) 
    {
        this.p = p;
    }
	
    public List<Integer> getCosmeticsUnlock(String type) {
		CosmeticsData data = new CosmeticsData(p);
		return data.getCosmeticsUnlock(type);
	}
	
	public int getCosmeticsPageNumber(String type) {
		int Page = 1;
		int CosmeticsOnPage = 0;
		
		PurchaseData buyData = new PurchaseData(p.getName());
		for (String articles : main.getConfig().getConfigurationSection("cosmetics.type." + type).getKeys(false))
        {
			int articleID = main.getConfig().getInt("cosmetics.type." + type + "." + articles + ".referenceid");
        	if (buyData.hasArticle(articleID))
        	{
        		if (CosmeticsOnPage == 10)
                {
                	CosmeticsOnPage = 0;
                	++Page;
                }
        		else
        		{
        			++CosmeticsOnPage;
        		}
        	}
        }
	    return Page;
	}
	
	public List<Integer> getCosmeticsForPage(int Page, String type) {
		int cosmeticsPerPage = 10;
		int cosmeticsOnPage = 0;
		int sqlPage = 1;
		List<Integer> cosmeticsList = new ArrayList<Integer>();
		List<Integer> cosmeticsPageList = new ArrayList<Integer>();
		
		PurchaseData buyData = new PurchaseData(p.getName());
		for (String articles : main.getConfig().getConfigurationSection("cosmetics.type." + type).getKeys(false))
        {
			int articleID = main.getConfig().getInt("cosmetics.type." + type + "." + articles + ".referenceid");
        	if (buyData.hasArticle(articleID))
        	{
        		if (sqlPage != Page)
                {
                	if (cosmeticsPerPage != cosmeticsOnPage)
                    {
                		cosmeticsList.add(articleID);
                    	++cosmeticsOnPage;
                    }
                    if(cosmeticsPerPage == cosmeticsOnPage)
                    {
                    	cosmeticsOnPage = 0;
                    	++sqlPage;
                    }
                }
                else if (sqlPage == Page)
                {
                	if (cosmeticsPerPage != cosmeticsOnPage)
                    {
                		cosmeticsPageList.add(articleID);
                    	++cosmeticsOnPage;
                    }
                    if(cosmeticsPerPage == cosmeticsOnPage)
                    {
                    	cosmeticsOnPage = 0;
                    }
                }
        	}
        }
		return cosmeticsPageList;
	}
}
