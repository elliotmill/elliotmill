package data;

import java.util.HashMap;

/**
 * Created by azeezolaniran on 23/07/2017.
 */

public class Store {

    public static SalesItem[] getSalesItems() {
        return new SalesItem[]{
                new SalesItem("Chocolate Chip Cookies", "2$", "dummyUrl", "Chocolate Chip say Filled with Chocolate chips and a price tag of 2$"),
                new SalesItem("Sugar Cookies", "2$", "dummyUrl", "Coated in sugar and a price tag of 2$"),
                new SalesItem("M&M Cookies", "2$", "dummyUrl", "Filled with M&M's and a price tag of 2$"),
                new SalesItem("Oatmeal Raisin Cookies", "2$", "dummyUrl", "Classic oatmeal raisin cookie and price of 2$"),
                new SalesItem("Snicker Doodle Cookies", "2$", "dummyUrl", "orginal recipe made from scratch with a price of 2$"),
                new SalesItem("White Chocolate Cookies", "2$", "dummyUrl", "Filled with white chocolate chips with a price tag of 2$")
        };
    }
}
