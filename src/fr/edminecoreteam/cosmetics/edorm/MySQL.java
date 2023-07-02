package fr.edminecoreteam.cosmetics.edorm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.plugin.Plugin;

import fr.edminecoreteam.cosmetics.Main;

public class MySQL 
{
	private MySQL instance;
	private Main api;
	private String urlBase;
	private String host;
	private String database;
	private String userName;
	private String password;
	private static Connection connection;
	
	public MySQL(Main api, String urlBase, String host, String database, String userName, String password) {
		this.api = api;
		this.urlBase = urlBase;
		this.host = host;
		this.database = database;
		this.userName = userName;
		this.password = password;
	}
	
	public static Connection getConnection() { return MySQL.connection; }
	
	public void connexion() {
        if (!this.isOnline()) {
            try {
            	instance = this;
            	
                MySQL.connection = DriverManager.getConnection(String.valueOf(this.urlBase) + this.host + "/" + this.database, this.userName, this.password);
                
                SQLTasks start = new SQLTasks(api, instance);
                start.runTaskTimer((Plugin)this.api, 0L, 20L);
                
                message("connectMSG");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void deconnexion() {
        if (this.isOnline()) {
            try {
                MySQL.connection.close();
                
                message("disconnectMSG");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public boolean isOnline() {
		try 
		{
			if (MySQL.connection == null || MySQL.connection.isClosed()) 
			{
				return false;
			}
			else if (MySQL.connection != null || !MySQL.connection.isClosed())
			{
				return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void creatingTableCosmetics() {
        try 
        {
        	PreparedStatement stm = MySQL.connection.prepareStatement("CREATE TABLE IF NOT EXISTS ed_cosmetics (`player_uuid` varchar(255) NOT NULL, `player_monture` int(11), `player_emote` int(11), `player_familier` int(11), `player_ballon` int(11), `player_titre` int(11), PRIMARY KEY (`player_uuid`), UNIQUE(`player_uuid`), INDEX(`player_uuid`)) CHARACTER SET utf8");
            stm.execute();
            stm.close();
            System.out.println("ED-NETWORK API");
			System.out.println("DATABASE: ed_cosmetics loaded.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	private void message(String condition) {
		if (condition == "connectMSG")
		{
			System.out.println("+--------------------+");
			System.out.println("ED-NETWORK API");
			System.out.println("ORM: Enable");
			System.out.println("ORM-DATABASE: Connected");
			System.out.println("+--------------------+");
		}
		if (condition == "disconnectMSG")
		{
			System.out.println("+--------------------+");
			System.out.println("ED-NETWORK API");
			System.out.println("ORM: Disable");
			System.out.println("ORM-DATABASE: Disconnected");
			System.out.println("+--------------------+");
		}
	}
	
	
}
