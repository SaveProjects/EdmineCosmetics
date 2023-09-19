package fr.edminecoreteam.cosmetics.commands;

import fr.edminecoreteam.cosmetics.data.CosmeticsData;
import fr.edminecoreteam.cosmetics.entity.ballon.ListenerBallon;
import fr.edminecoreteam.cosmetics.entity.ballon.ListenerBallonLeash;
import fr.edminecoreteam.cosmetics.entity.familier.ListenerFamilier;
import fr.edminecoreteam.cosmetics.entity.titres.ListenerTitre;
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
			if(args.length == 1){
				if(args[0].equals("remove")){

					CosmeticsData cListener = new CosmeticsData(p);
					ListenerBallon.despawnBallon(p);
					ListenerBallonLeash.despawnLeash(p);
					ListenerFamilier.despawnCompagnons(p);
					ListenerTitre.despawnTitre(p);
					cListener.updateMonture(0);
					//p.sendMessage("§9§lCosmétiques §8» §fLa totalité de vos cosmétiques ont été désactivés.");

				}
			}
		}
		
		return false;
	}
	
}
