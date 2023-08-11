package th.cases.inventory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import th.BaseTest;
import th.cases.inventory.testdata.ProductDataProvider;
import th.cases.inventory.testdata.ProductItem;
import th.pages.inventory.InventoryPage;
import th.pages.login.LoginPage;

public class InventoryTest extends BaseTest {

    private InventoryPage inventoryPage;

    @BeforeMethod
    public void initPage() {
        inventoryPage = LoginPage.init()
                .login(user.getName(), user.getPassword());
    }

    @Test(dataProvider = "Products", dataProviderClass = ProductDataProvider.class)
    public void checkProductAppeared(int index, ProductItem productItem) {
        inventoryPage.checkProductExistsOnBasePage(index, productItem);
    }

    @Test
    public void checkProductsAddedToCart() {
        inventoryPage
                .applyProduct(2)
                .applyProduct(3);
    }
}