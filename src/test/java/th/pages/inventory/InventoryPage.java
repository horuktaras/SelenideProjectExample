package th.pages.inventory;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import commons.StringFormatUtil;
import helper.pages.IPage;
import helper.pages.Url;
import th.cases.inventory.testdata.ProductItem;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Url("/inventory.html")
public class InventoryPage implements IPage<InventoryPage> {

    private int appliedProducts = 0;
    private final SelenideElement shoppingCartBadge = $(".shopping_cart_badge");
    private final ElementsCollection productImages = $$(".inventory_item img.inventory_item_img"),
            productName = $$(".inventory_item .inventory_item_name"),
            productDescription = $$(".inventory_item .inventory_item_desc"),
            productPrice = $$(".inventory_item .inventory_item_price"),
            productApplyBtn = $$(".btn_inventory");


    public InventoryPage checkProductExistsOnBasePage(int index, ProductItem productItem) {
        return checkProductName(index, productItem.getName())
                .checkProductDescription(index, productItem.getDescription())
                .checkProductPrice(index, productItem.getPrice())
                .checkProductImage(index, productItem.getImages());
    }

    public InventoryPage applyProduct(int index) {
        productApplyBtn.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(index)
                .click();
        appliedProducts++;
        shoppingCartBadge.shouldHave(Condition.text(String.valueOf(appliedProducts)));
        return this;
    }

    private InventoryPage checkProductImage(int index, String expSource) {
        productImages.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(index)
                .shouldHave(Condition.attribute("src", StringFormatUtil.concatenation(
                        Configuration.baseUrl,
                        expSource
                )));
        return this;
    }

    private InventoryPage checkProductPrice(int index, Double expPrice) {
        productPrice.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(index)
                .shouldHave(Condition.text(expPrice.toString()));
        return this;
    }

    private InventoryPage checkProductName(int index, String expName) {
        productName.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(index)
                .shouldHave(Condition.text(expName));
        return this;
    }

    private InventoryPage checkProductDescription(int index, String expName) {
        productDescription.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(index)
                .shouldHave(Condition.exactText(expName));
        return this;
    }
}
