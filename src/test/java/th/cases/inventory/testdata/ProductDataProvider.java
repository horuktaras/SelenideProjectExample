package th.cases.inventory.testdata;

import commons.testdata.AbstractDataProvider;
import org.testng.annotations.DataProvider;

public class ProductDataProvider extends AbstractDataProvider {

    @DataProvider(name = "Products")
    public Object[][] getProductData() {
        ProductItem[] productItems = defaultProducts();
        Object[][] data = new Object[productItems.length][2];

        for (int i = 0; i < productItems.length; i++) {
            data[i][0] = i;  // Index
            data[i][1] = productItems[i];  // ProductItem
        }

        return data;
    }

//todo move to json
    private ProductItem[] defaultProducts() {
        return new ProductItem[]{
                new ProductItem(
                        "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg",
                        "Sauce Labs Backpack",
                        "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                        29.99
                ),
                new ProductItem("/static/media/bike-light-1200x1500.37c843b0.jpg",
                        "Sauce Labs Bike Light",
                        "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                        9.99
                ),
                new ProductItem("/static/media/bolt-shirt-1200x1500.c2599ac5.jpg",
                        "Sauce Labs Bolt T-Shirt",
                        "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                        15.99
                ),
                new ProductItem("/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg",
                        "Sauce Labs Fleece Jacket",
                        "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                        49.99
                ),
                new ProductItem("/static/media/red-onesie-1200x1500.2ec615b2.jpg",
                        "Sauce Labs Onesie",
                        "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                        7.99
                ),
                new ProductItem("/static/media/red-tatt-1200x1500.30dadef4.jpg",
                        "Test.allTheThings() T-Shirt (Red)",
                        "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
                        15.99
                )
        };
    }
}