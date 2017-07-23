package data;

/**
 * Created by azeezolaniran on 23/07/2017.
 */

public class SalesItem {

    private String itemName;
    private String itemPrice;
    private String itemIconUrl;

    public SalesItem(String nm, String price, String iconUrl) {
        this.itemName = nm;
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

    public static SalesItem[] getSalesItems() {
        return new SalesItem[]{
                new SalesItem("Chocolate Chip Cookies", "2$", "dummyUrl"),
                new SalesItem("Sugar Cookies", "2$", "dummyUrl"),
                new SalesItem("M&M Cookies", "2$", "dummyUrl"),
                new SalesItem("Oatmeal Raisin Cookies", "2$", "dummyUrl"),
                new SalesItem("Snicker Doodle Cookies", "2$", "dummyUrl"),
                new SalesItem("White Chocolate Cookies", "2$", "dummyUrl")
        };
    }
}
