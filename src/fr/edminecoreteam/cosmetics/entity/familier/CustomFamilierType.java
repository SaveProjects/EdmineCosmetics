package fr.edminecoreteam.cosmetics.entity.familier;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import fr.edminecoreteam.cosmetics.Main;
import fr.edminecoreteam.cosmetics.data.CosmeticsData;
import fr.edminecoreteam.cosmetics.entity.familier.animations.HellowAnimation;
import fr.edminecoreteam.cosmetics.entity.familier.animations.WalkAnimation;
import fr.edminecoreteam.cosmetics.utils.ItemStackSerializer;
import fr.edminecoreteam.cosmetics.utils.SkullNBT;

public class CustomFamilierType 
{
	private static Main api = Main.getInstance();
	private static ItemStack getSkull(String url) { return SkullNBT.getSkull(url); }
	private Player p;
	
	public CustomFamilierType(Player p) {
		this.p = p;
	}

	public void spawn() 
	{
		CosmeticsData data = new CosmeticsData(p);
		int getFamilier = data.getActiveFamilier();
		for (String articles : api.getConfig().getConfigurationSection("cosmetics.type.compagnons").getKeys(false))
        {
			if (api.getConfig().getInt("cosmetics.type.compagnons." + articles + ".referenceid") == getFamilier)
			{
				Location customloc = new Location(Bukkit.getWorld(p.getWorld().getName()), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
		        ArmorStand armorStand = (ArmorStand)Bukkit.getWorld(p.getWorld().getName()).spawnEntity(customloc, EntityType.ARMOR_STAND);
		        armorStand.setSmall(true);
		        
		        if (api.getConfig().getString("cosmetics.type.compagnons." + articles + ".invisible").equalsIgnoreCase("yes"))
		        {
		        	armorStand.setVisible(false);
		        }
		        else
		        {
		        	armorStand.setVisible(true);
		        }
		        
		        armorStand.setCanPickupItems(false);
		        armorStand.setArms(true);
		        armorStand.setCustomName(p.getName());
		        armorStand.setCustomNameVisible(false);
		        armorStand.setGravity(false);
		        armorStand.setBasePlate(false);
		        armorStand.setMarker(true);
		        armorStand.setHelmet(getSkull("http://textures.minecraft.net/texture/" + api.getConfig().getString("cosmetics.type.compagnons." + articles + ".headurl")));
		        if (!api.getConfig().getString("cosmetics.type.compagnons." + articles + ".iteminhand").equalsIgnoreCase("null"))
		        {
		        	ItemStack iteminhand = ItemStackSerializer.deserialize(api.getConfig().getString("cosmetics.type.compagnons." + articles + ".iteminhand"));
			        ItemMeta iteminhandM = (ItemMeta)iteminhand.getItemMeta();
			        if (api.getConfig().getString("cosmetics.type.compagnons." + articles + ".itemisenchant").equalsIgnoreCase("yes"))
			        {
			        	iteminhandM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			        }
			        iteminhand.setItemMeta((ItemMeta)iteminhandM);
			        armorStand.setItemInHand(iteminhand);
		        }
		        else
		        {
		        	armorStand.setItemInHand(null);
		        }
		        String anim = api.getConfig().getString("cosmetics.type.compagnons." + articles + ".animation");
		        
		        if (anim.equalsIgnoreCase("{anim1}")) { WalkAnimation.start(armorStand); }
		        if (anim.equalsIgnoreCase("{anim2}")) { HellowAnimation.start(armorStand); }
		        
		        /*
		         * 
		         * Chesplate: Cuir (RGB) / Autre Materiaux
		         * 
		         */
		        if (api.getConfig().getString("cosmetics.type.compagnons." + articles + ".chestplate.type").contains("leather"))
		        {
		        	ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			        LeatherArmorMeta itemM = (LeatherArmorMeta)item.getItemMeta();
			        itemM.setColor(Color.fromRGB(
			        		api.getConfig().getInt("cosmetics.type.compagnons." + articles + ".chestplate.color.r"), 
			        		api.getConfig().getInt("cosmetics.type.compagnons." + articles + ".chestplate.color.g"), 
			        		api.getConfig().getInt("cosmetics.type.compagnons." + articles + ".chestplate.color.b")));
			        if (api.getConfig().getString("cosmetics.type.compagnons." + articles + ".chestplate.isenchant").equalsIgnoreCase("yes"))
			        {
			        	itemM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			        }
			        item.setItemMeta((ItemMeta)itemM);
			        armorStand.setChestplate(item);
		        }
		        else if (!api.getConfig().getString("cosmetics.type.compagnons." + articles + ".chestplate.type").contains("leather") 
		        		&& !api.getConfig().getString("cosmetics.type.compagnons." + articles + ".chestplate.type").equalsIgnoreCase("null"))
		        {
		        	ItemStack item = ItemStackSerializer.deserialize(api.getConfig().getString("cosmetics.type.compagnons." + articles + ".chestplate.type"));
			        ItemMeta itemM = item.getItemMeta();
			        if (api.getConfig().getString("cosmetics.type.compagnons." + articles + ".chestplate.isenchant").equalsIgnoreCase("yes"))
			        {
			        	itemM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			        }
			        item.setItemMeta((ItemMeta)itemM);
			        armorStand.setChestplate(item);
		        }
		        
		        /*
		         * 
		         * Leggings: Cuir (RGB) / Autre Materiaux
		         * 
		         */
		        if (api.getConfig().getString("cosmetics.type.compagnons." + articles + ".leggings.type").contains("leather"))
		        {
		        	ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			        LeatherArmorMeta itemM = (LeatherArmorMeta)item.getItemMeta();
			        itemM.setColor(Color.fromRGB(
			        		api.getConfig().getInt("cosmetics.type.compagnons." + articles + ".leggings.color.r"), 
			        		api.getConfig().getInt("cosmetics.type.compagnons." + articles + ".leggings.color.g"), 
			        		api.getConfig().getInt("cosmetics.type.compagnons." + articles + ".leggings.color.b")));
			        if (api.getConfig().getString("cosmetics.type.compagnons." + articles + ".leggings.isenchant").equalsIgnoreCase("yes"))
			        {
			        	itemM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			        }
			        item.setItemMeta((ItemMeta)itemM);
			        armorStand.setLeggings(item);
		        }
		        else if (!api.getConfig().getString("cosmetics.type.compagnons." + articles + ".leggings.type").contains("leather") 
		        		&& !api.getConfig().getString("cosmetics.type.compagnons." + articles + ".leggings.type").equalsIgnoreCase("null"))
		        {
		        	ItemStack item = ItemStackSerializer.deserialize(api.getConfig().getString("cosmetics.type.compagnons." + articles + ".leggings.type"));
			        ItemMeta itemM = item.getItemMeta();
			        if (api.getConfig().getString("cosmetics.type.compagnons." + articles + ".leggings.isenchant").equalsIgnoreCase("yes"))
			        {
			        	itemM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			        }
			        item.setItemMeta((ItemMeta)itemM);
			        armorStand.setLeggings(item);
		        }
		        
		        /*
		         * 
		         * Boots: Cuir (RGB) / Autre Materiaux
		         * 
		         */
		        if (api.getConfig().getString("cosmetics.type.compagnons." + articles + ".boots.type").contains("leather"))
		        {
		        	ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
			        LeatherArmorMeta itemM = (LeatherArmorMeta)item.getItemMeta();
			        itemM.setColor(Color.fromRGB(
			        		api.getConfig().getInt("cosmetics.type.compagnons." + articles + ".boots.color.r"), 
			        		api.getConfig().getInt("cosmetics.type.compagnons." + articles + ".boots.color.g"), 
			        		api.getConfig().getInt("cosmetics.type.compagnons." + articles + ".boots.color.b")));
			        if (api.getConfig().getString("cosmetics.type.compagnons." + articles + ".boots.isenchant").equalsIgnoreCase("yes"))
			        {
			        	itemM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			        }
			        item.setItemMeta((ItemMeta)itemM);
			        armorStand.setBoots(item);
		        }
		        else if (!api.getConfig().getString("cosmetics.type.compagnons." + articles + ".boots.type").contains("leather") 
		        		&& !api.getConfig().getString("cosmetics.type.compagnons." + articles + ".boots.type").equalsIgnoreCase("null"))
		        {
		        	ItemStack item = ItemStackSerializer.deserialize(api.getConfig().getString("cosmetics.type.compagnons." + articles + ".boots.type"));
			        ItemMeta itemM = item.getItemMeta();
			        if (api.getConfig().getString("cosmetics.type.compagnons." + articles + ".boots.isenchant").equalsIgnoreCase("yes"))
			        {
			        	itemM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			        }
			        item.setItemMeta((ItemMeta)itemM);
			        armorStand.setBoots(item);
		        }
		        
		        ListenerFamilier.runAction(p, "true");
			}
        }
	}
	
	public void despawn()
	{
		ListenerFamilier.despawnCompagnons(p);
		p.sendMessage("§9§lCosmétiques §8» §fVous avez désactivé votre §dcompagnon§f.");
	}
}
