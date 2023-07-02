package fr.edminecoreteam.cosmetics.edorm;

import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.cosmetics.Main;

public class SQLTasks extends BukkitRunnable 
{
	public int timer;
	private Main api;
	public MySQL database;
	
	public SQLTasks(Main api, MySQL database) {
		this.database = database;
		this.api = api;
		this.timer = 10;
	}

	@Override
	public void run() {
		if (timer == 0)
		{
			if (database.isOnline()) 
			{
				api.setSQLState(SQLState.CONECTED);
				this.timer = 10;
			}
			if (!database.isOnline())
			{
				api.setSQLState(SQLState.DISCONECTED);
				api.MySQLConnect();
				cancel();
			}
		}
		--timer;
	}
}
