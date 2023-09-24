package fr.edminecoreteam.cosmetics;

import fr.edminecoreteam.cosmetics.utils.CosmeticsListListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.edminecoreteam.cosmetics.commands.MainCommand;
import fr.edminecoreteam.cosmetics.edorm.MySQL;
import fr.edminecoreteam.cosmetics.edorm.SQLState;
import fr.edminecoreteam.cosmetics.entity.MountListener;
import fr.edminecoreteam.cosmetics.entity.montures.CustomEntityType;
import fr.edminecoreteam.cosmetics.gui.BallonGui;
import fr.edminecoreteam.cosmetics.gui.FamilierGui;
import fr.edminecoreteam.cosmetics.gui.MainGui;
import fr.edminecoreteam.cosmetics.gui.MontureGui;
import fr.edminecoreteam.cosmetics.gui.TitreGui;
import fr.edminecoreteam.cosmetics.item.ItemsListener;
import fr.edminecoreteam.cosmetics.item.JoinListener;
import fr.edminecoreteam.cosmetics.listeners.PlayerJoinListener;
import fr.edminecoreteam.cosmetics.listeners.PlayerQuitListener;

import java.util.ArrayList;
import java.util.List;


public class Main extends JavaPlugin
{
	private static Main instance;
	
	public MySQL database;


	private SQLState sqlState;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		MySQLConnect();
		
		loadListeners();
		loadCommands();

		loadCosmeticsList();

		loadMounts();
		
		System.out.println("EdmineCosmetics: Plugin Enable");
	}

	private void loadCosmeticsList() {
		CosmeticsListListener.getCosmeticsList();
	}

	@Override
	public void onDisable() {
		MySQLDisconnect();
		System.out.println("EdmineCosmetics: Plugin Disable");
	}
	
	
	private void loadListeners() {
		instance = this;
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents((Listener)new PlayerJoinListener(), (Plugin)this);
		pm.registerEvents((Listener)new PlayerQuitListener(), (Plugin)this);
		pm.registerEvents((Listener)new JoinListener(), (Plugin)this);
		pm.registerEvents((Listener)new ItemsListener(), (Plugin)this);
		
		pm.registerEvents((Listener)new MountListener(), (Plugin)this);
		
		pm.registerEvents((Listener)new MainGui(), (Plugin)this);
		pm.registerEvents((Listener)new MontureGui(), (Plugin)this);
		pm.registerEvents((Listener)new FamilierGui(), (Plugin)this);
		pm.registerEvents((Listener)new BallonGui(), (Plugin)this);
		pm.registerEvents((Listener)new TitreGui(), (Plugin)this);
	}
	
	private void loadCommands() {
		instance = this;
		
		this.getCommand("edcosmetics").setExecutor((CommandExecutor)new MainCommand());
	}
	
	private void loadMounts() {
		CustomEntityType.registerAllEntities();
	}
	
	/*
	 * Méthode de connexion au serveur SQL.
	 * 
	 * "jdbc:mysql://", "45.140.165.235", "22728-database", "22728-database", "S5bV5su4p9"
	 */
	public void MySQLConnect() 
	{
	    instance = this;
	    
	    (this.database = new MySQL(instance, "jdbc:mysql://", "45.140.165.235", "22728-database", "22728-database", "S5bV5su4p9")).connexion();
	    
	    database.creatingTableCosmetics();
	}
	
	/*
	 * Méthode de déconnexion au serveur SQL.
	 */
	public void MySQLDisconnect()
	{
		database.deconnexion();
	}
	
	/*
	 * Méthode de statut de l'instance MySQL
	 * State List: DISCONECTED 0, CONECTED 1.
	 */
	public void setSQLState(SQLState sqlState) 
	{
		this.sqlState = sqlState;
	}
	public boolean isSQLState(SQLState sqlState) 
	{
		return this.sqlState == sqlState;
	}
	
	public static Main getInstance() {  return Main.instance; }
	public static Plugin getPlugin() { return null; }
}
