package fr.edminecoreteam.cosmetics.commands;

import org.bukkit.entity.Player;

public class CommandMessage 
{
	public static void MainHelp(Player p)
	{
		p.sendMessage("");
		p.sendMessage(" §7» §9§lCentre d'aide §9(EDCosmetics):");
		p.sendMessage("");
        p.sendMessage(" §7● §d/§fedcosmetics §8§l» §7Ouvrir le menu principal de l'API.");
	}
}
