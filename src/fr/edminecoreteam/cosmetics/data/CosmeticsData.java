package fr.edminecoreteam.cosmetics.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import fr.edminecoreteam.cosmetics.Main;
import fr.edminecoreteam.cosmetics.edorm.MySQL;
import fr.edminecoreteam.cosmetics.store.PurchaseData;

public class CosmeticsData 
{
	private Player p;
	private static Main main = Main.getInstance();
	
	public CosmeticsData(Player p)
	{
		this.p = p;
	}
	
	public void createSettingCosmetics() 
    {
        if (!hasSettingCosmetics()) 
        {
        	try 
            {
                PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("INSERT INTO ed_cosmetics (player_uuid, player_monture, player_emote, player_familier, player_ballon, player_titre) VALUES (?, ?, ?, ?, ?, ?)");
                preparedStatement.setString(1, p.getUniqueId().toString()); /*player_uuid*/
                preparedStatement.setInt(2, 0);
                preparedStatement.setInt(3, 0);
                preparedStatement.setInt(4, 0);
                preparedStatement.setInt(5, 0);
                preparedStatement.setInt(6, 0);
                preparedStatement.execute();
                preparedStatement.close();
            }
            catch (SQLException e) 
            {
                e.toString();
            }
        }
    }
	
	public boolean hasSettingCosmetics()
    {
        try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT player_monture FROM ed_cosmetics WHERE player_uuid = ?");
            preparedStatement.setString(1, p.getUniqueId().toString());
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        }
        catch (SQLException e) 
        {
            e.toString();
            return false;
        }
    }
	
	
	public List<Integer> getCosmeticsUnlock(String type)
	{
		List<Integer> list = new ArrayList<Integer>();
		PurchaseData buyData = new PurchaseData(p.getName());
		for (String articles : main.getConfig().getConfigurationSection("cosmetics.type." + type).getKeys(false))
        {
			int articleID = main.getConfig().getInt("cosmetics.type." + type + "." + articles + ".referenceid");
        	if (buyData.hasArticle(articleID))
        	{
        		list.add(articleID);
        	}
        }
		return list;
	}
	
	public int getCosmeticsCount(String type)
	{
		int i = 0;
		for (@SuppressWarnings("unused") String articles : main.getConfig().getConfigurationSection("cosmetics.type." + type).getKeys(false))
        {
        	i++;
        }
		return i;
	}
	
	
	public int getActiveMonture() 
    {
        try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT player_monture FROM ed_cosmetics WHERE player_uuid = ?");
            preparedStatement.setString(1, p.getUniqueId().toString());
            int result = 0;
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) 
            {
            	result = rs.getInt("player_monture");
            }
            preparedStatement.close();
            return result;
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            return 0;
        }
    }
	public void updateMonture(int monture)
	{
		try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("UPDATE ed_cosmetics SET player_monture = ? WHERE player_uuid = ?");
            preparedStatement.setInt(1, monture);
            preparedStatement.setString(2, p.getUniqueId().toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) 
        {
            e.toString();
        }
	}
	
	public int getActiveEmote() 
    {
        try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT player_emote FROM ed_cosmetics WHERE player_uuid = ?");
            preparedStatement.setString(1, p.getUniqueId().toString());
            int result = 0;
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) 
            {
            	result = rs.getInt("player_emote");
            }
            preparedStatement.close();
            return result;
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            return 0;
        }
    }
	public void updateEmote(int emote)
	{
		try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("UPDATE ed_cosmetics SET player_emote = ? WHERE player_uuid = ?");
            preparedStatement.setInt(1, emote);
            preparedStatement.setString(2, p.getUniqueId().toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) 
        {
            e.toString();
        }
	}
	
	public int getActiveFamilier() 
    {
        try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT player_familier FROM ed_cosmetics WHERE player_uuid = ?");
            preparedStatement.setString(1, p.getUniqueId().toString());
            int result = 0;
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) 
            {
            	result = rs.getInt("player_familier");
            }
            preparedStatement.close();
            return result;
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            return 0;
        }
    }
	public void updateFamilier(int familier)
	{
		try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("UPDATE ed_cosmetics SET player_familier = ? WHERE player_uuid = ?");
            preparedStatement.setInt(1, familier);
            preparedStatement.setString(2, p.getUniqueId().toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) 
        {
            e.toString();
        }
	}
	
	public int getActiveBallon() 
    {
        try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT player_ballon FROM ed_cosmetics WHERE player_uuid = ?");
            preparedStatement.setString(1, p.getUniqueId().toString());
            int result = 0;
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) 
            {
            	result = rs.getInt("player_ballon");
            }
            preparedStatement.close();
            return result;
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            return 0;
        }
    }
	public void updateBallon(int ballon)
	{
		try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("UPDATE ed_cosmetics SET player_ballon = ? WHERE player_uuid = ?");
            preparedStatement.setInt(1, ballon);
            preparedStatement.setString(2, p.getUniqueId().toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) 
        {
            e.toString();
        }
	}
	
	public int getActiveTitre() 
    {
        try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT player_titre FROM ed_cosmetics WHERE player_uuid = ?");
            preparedStatement.setString(1, p.getUniqueId().toString());
            int result = 0;
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) 
            {
            	result = rs.getInt("player_titre");
            }
            preparedStatement.close();
            return result;
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            return 0;
        }
    }
	public void updateTitre(int titre)
	{
		try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("UPDATE ed_cosmetics SET player_titre = ? WHERE player_uuid = ?");
            preparedStatement.setInt(1, titre);
            preparedStatement.setString(2, p.getUniqueId().toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) 
        {
            e.toString();
        }
	}
}
