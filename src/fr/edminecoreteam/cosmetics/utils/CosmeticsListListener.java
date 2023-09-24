package fr.edminecoreteam.cosmetics.utils;

import fr.edminecoreteam.cosmetics.Main;
import fr.edminecoreteam.cosmetics.store.StoreInfo;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

public class CosmeticsListListener {
    private static Main main = Main.getInstance();
    public static HashMap<Integer, String> montureList = new HashMap<>();
    public static HashMap<Integer, Integer> montureRarete = new HashMap<>();

    public static HashMap<Integer, String> familierList = new HashMap<>();
    public static HashMap<Integer, Integer> familierRarete = new HashMap<>();

    public static HashMap<Integer, String> titreList = new HashMap<>();
    public static HashMap<Integer, Integer> titreRarete = new HashMap<>();


    public static HashMap<Integer, String> ballonList = new HashMap<>();
    public static HashMap<Integer, Integer> ballonRarete = new HashMap<>();
    public static HashMap<Integer, String> cosmeticSkull = new HashMap<>();

    public static HashMap<String, List<Integer>> purchaseListOfPlayer = new HashMap<>();

    public static void getCosmeticsList() {
        for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.montures").getKeys(false)) {
            Integer cosmeticID = main.getConfig().getInt("cosmetics.type.montures." + articles + ".referenceid");
            StoreInfo info = new StoreInfo(cosmeticID);

            montureRarete.put(cosmeticID, info.getArticleRarity());
            montureList.put(cosmeticID, info.getArticleName());
            cosmeticSkull.put(cosmeticID, info.getArticleSkull());

        }

        for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.compagnons").getKeys(false)) {
            Integer cosmeticID = main.getConfig().getInt("cosmetics.type.compagnons." + articles + ".referenceid");
            StoreInfo info = new StoreInfo(cosmeticID);

            familierRarete.put(cosmeticID, info.getArticleRarity());
            familierList.put(cosmeticID, info.getArticleName());
            cosmeticSkull.put(cosmeticID, info.getArticleSkull());
        }

        for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.ballons").getKeys(false)) {
            Integer cosmeticID = main.getConfig().getInt("cosmetics.type.ballons." + articles + ".referenceid");
            StoreInfo info = new StoreInfo(cosmeticID);

            ballonRarete.put(cosmeticID, info.getArticleRarity());
            ballonList.put(cosmeticID, info.getArticleName());
            cosmeticSkull.put(cosmeticID, info.getArticleSkull());
        }

        for (String articles : main.getConfig().getConfigurationSection("cosmetics.type.titres").getKeys(false)){
            Integer cosmeticID = main.getConfig().getInt("cosmetics.type.titres." + articles + ".referenceid");
            StoreInfo info = new StoreInfo(cosmeticID);

            titreRarete.put(cosmeticID, info.getArticleRarity());
            titreList.put(cosmeticID, info.getArticleName());
        }
    }

}
