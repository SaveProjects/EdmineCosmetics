package fr.edminecoreteam.cosmetics.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			if (args.length == 0)
			{
				CommandMessage.MainHelp(p);
			}
		}
		
		return false;
	}
	
}
