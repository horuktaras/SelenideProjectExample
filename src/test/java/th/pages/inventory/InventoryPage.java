package th.pages.inventory;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import commons.StringFormatUtil;
import helper.pages.IPage;
import helper.pages.Url;
import io.qameta.allure.Step;
import th.cases.inventory.testdata.ProductItem;
import th.utils.actions.SelenideUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Url("/inventory.html")
public class InventoryPage implements IPage<InventoryPage> {

    private final SelenideElement shoppingCartBadge = $(".shopping_cart_badge");
    private final ElementsCollection productImages = $$(".inventory_item img.inventory_item_img"),
            productName = $$(".inventory_item .inventory_item_name"),
            productDescription = $$(".inventory_item .inventory_item_desc"),
            productPrice = $$(".inventory_item .inventory_item_price"),
            productApplyBtn = $$(".btn_inventory");
    private int appliedProducts = 0;

    @Step("Check product {productItem.name} exists on a Inventory page by {index}")
    public InventoryPage checkProductExistsOnBasePage(int index, ProductItem productItem) {
        return checkProductName(index, productItem.getName())
                .checkProductDescription(index, productItem.getDescription())
                .checkProductPrice(index, productItem.getPrice())
                .checkProductImage(index, productItem.getImages());
    }

    @Step("Apply product by {index}")
    public InventoryPage applyProduct(int index) {
        SelenideUtils.click(productApplyBtn.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(index));
        appliedProducts++;
        SelenideUtils.shouldHave(shoppingCartBadge, Condition.text(String.valueOf(appliedProducts)));
        return this;
    }

    @Step("Check product image by {index}")
    private InventoryPage checkProductImage(int index, String expSource) {
        SelenideElement element =
                SelenideUtils.validateElementsCollectionIsNotEmptyAndGet(productImages, index);
        SelenideUtils.shouldHave(element,
                Condition.attribute("src", StringFormatUtil.concatenation(
                        Configuration.baseUrl,
                        expSource
                )));
        return this;
    }

    @Step("Check product price by {index}")
    private InventoryPage checkProductPrice(int index, Double expPrice) {
        SelenideElement element =
                SelenideUtils.validateElementsCollectionIsNotEmptyAndGet(productPrice, index);
        SelenideUtils.shouldHave(element, Condition.text(expPrice.toString()));
        return this;
    }

    @Step("Check product name by {index}")
    private InventoryPage checkProductName(int index, String expName) {
        SelenideElement element =
                SelenideUtils.validateElementsCollectionIsNotEmptyAndGet(productName, index);
        SelenideUtils.shouldHave(element, Condition.text(expName));
        return this;
    }

    @Step("Check product description by {index}")
    private InventoryPage checkProductDescription(int index, String expName) {
        SelenideElement element =
                SelenideUtils.validateElementsCollectionIsNotEmptyAndGet(productDescription, index);
        SelenideUtils.shouldHave(element, Condition.exactText(expName));
        return this;
    }
}