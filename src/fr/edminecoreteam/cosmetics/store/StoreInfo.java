package fr.edminecoreteam.cosmetics.store;

import java.util.HashMap;
import java.util.Map;

public class StoreInfo 
{
	private Map<Integer, StoreInfo> storeInfo;
	@SuppressWarnings("unused")
	private String article_type;
	@SuppressWarnings("unused")
	private String article_name;
	@SuppressWarnings("unused")
	private String type_of_pay;
	@SuppressWarnings("unused")
	private Float article_price;
	@SuppressWarnings("unused")
	private int article_rarity;
	@SuppressWarnings("unused")
	private String article_item;
	@SuppressWarnings("unused")
	private int article_id;
	@SuppressWarnings("unused")
	private String article_status;
	
	private StoreData storeData;
	
	public StoreInfo(String article_type, String article_name, String type_of_pay, Float article_price, int article_rarity, String article_item) {
		this.article_type = article_type;
        this.article_name = article_name;
        this.type_of_pay= type_of_pay;
        this.article_price = article_price;
        this.article_rarity = article_rarity;
        this.article_item = article_item;
        this.storeInfo = new HashMap<Integer, StoreInfo>();
        this.storeData = new StoreData(article_type, article_name, type_of_pay, article_price, article_rarity, article_item);
        this.storeInfo.put(null, this);
    }
	
	public StoreInfo(int article_id) {
        this.article_id = article_id;
        this.storeInfo = new HashMap<Integer, StoreInfo>();
        this.storeData = new StoreData(article_id);
        this.storeInfo.put(article_id, this);
    }
	
	public StoreInfo(String article_name) {
        this.article_name = article_name;
    }
	
	public int returnID() 
    {
        return storeData.returnID();
    }
	
	public void createArticle() { storeData.createArticle(); }
	public void removeArticle() { storeData.removeArticle(); }
	
	public String getArticleName() { return storeData.getArticleName(); }
	public String getArticleType() { return storeData.getArticleType(); }
	public String getArticleSubType() { return storeData.getArticleSubType(); }
	public String getTypeOfPay() { return storeData.getTypeOfPay(); }
	public Float getArticlePrice() { return storeData.getArticlePrice(); }
	public String getIsInReduction() { return storeData.getIsInReduction(); }
	public int getReductionPercentage() { return storeData.getReductionPercentage(); }
	public int getArticleRarity() { return storeData.getArticleRarity(); }
	public String getArticleItem() { return storeData.getArticleItem(); }
	public int getArticleItemSlot() { return storeData.getArticleItemSlot(); }
	public String getArticleSkull() { return storeData.getArticleSkull(); }
	public String getArticleStatus() { return storeData.getArticleStatus(); }
	public int getArticleIDByName() { return storeData.getArticleIDByName(); }
	public int getArticlePage() { return storeData.getArticlePage(); }

	
	public void updateArticleName(String data) { storeData.updateArticleName(data); }
	public void updateArticleSubType(String data) { storeData.updateArticleSubType(data); }
	public void updateTypeOfPay(String data) { storeData.updateTypeOfPay(data); }
	public void updatePrice(Float data) { storeData.updatePrice(data); }
	public void updateIsInReduction(String data) { storeData.updateIsInReduction(data); }
	public void updateReductionPercentage(int data) { storeData.updateReductionPercentage(data); }
	public void updateRarity(int data) { storeData.updateRarity(data); }
	public void updateItem(String data) { storeData.updateItem(data); }
	public void updateItemSlot(int data) { storeData.updateItemSlot(data); }
	public void updateSkull(String data) { storeData.updateSkull(data); }
	public void updateStatus(String data) { storeData.updateStatus(data); }
	public void updateArticlePage(int data) { storeData.updateArticlePage(data); }
}
