package data;

/**
 * Created by azeezolaniran on 23/07/2017.
 */

public class SalesItem {

    private String itemName;
    private String itemPrice;
    private String itemIconUrl;
    private String itemDescription;


    public SalesItem(String nm, String price, String iconUrl, String iDesc) {
        this.itemName = nm;
        this.itemDescription = iDesc;
        this.itemPrice = price;
        this.itemIconUrl = iconUrl;
    }

    public String getItemName(){
        return this.itemName;
    }

    public String getItemPrice() {
        return this.itemPrice;
    }

    public String getItemIconUrl() {
        return this.itemIconUrl;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

}
