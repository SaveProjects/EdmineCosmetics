package fr.edminecoreteam.cosmetics.store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import fr.edminecoreteam.cosmetics.edorm.MySQL;
import fr.edminecoreteam.cosmetics.utils.CosmeticsListListener;
import org.bukkit.Bukkit;

public class PurchaseData 
{
	private String pS;
    
    public PurchaseData(String pS) 
    {
        this.pS = pS;
    }
    
    public void addArticle(int id, String deadLine) 
    {
        	try 
        	{
            	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);  
                Date resultdate = new Date();
                String date = sdf.format(resultdate);
                PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("INSERT INTO ed_shop_purchase (player_name, article_id, purchase_date, deadline_date) VALUES (?, ?, ?, ?)");
                preparedStatement.setString(1, pS); /*player_name*/
                preparedStatement.setInt(2, id); /*article_id*/
                preparedStatement.setString(3, date); /*purchase_date*/
                preparedStatement.setString(4, deadLine); /*deadline_date*/
                preparedStatement.execute();
                preparedStatement.close();
	        }
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
    }
    
    public String getArticle(int id) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT player_name FROM ed_shop_purchase WHERE article_id = ? AND player_name = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, pS);
            ResultSet rs = preparedStatement.executeQuery();
            String s = "";
            while (rs.next()) {
                s = rs.getString("player_name");
            }
            preparedStatement.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public boolean hasArticle(int id) 
    {
        try 
        {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT article_id FROM ed_shop_purchase WHERE article_id = ? AND player_name = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, pS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
        return false;
    }

   /* public List<Integer> getAllArticle(){
        List <Integer> buyList = new ArrayList<Integer>();

        try {
                PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT ed_shop_purchase.article_id FROM ed_shop_purchase,ed_shop_articles WHERE player_name = ? AND ed_shop_purchase.article_id = ed_shop_articles.article_id AND article_type = 'cosmetics'");

            ps.setString(1, pS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                buyList.add(rs.getInt("article_id"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        Bukkit.broadcastMessage("load fini");
        return buyList;
    }*/

    public List<Integer> getAllArticle(){
        List <Integer> buyList = new ArrayList<Integer>();

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT article_id FROM ed_shop_purchase WHERE player_name = ?");

            ps.setString(1, pS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                buyList.add(rs.getInt("article_id"));

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        CosmeticsListListener.purchaseListOfPlayer.put(pS, buyList);
        return buyList;
    }
}
