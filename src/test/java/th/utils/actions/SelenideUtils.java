package th.utils.actions;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import commons.StringFormatUtil;
import org.apache.commons.lang3.math.NumberUtils;

import static io.qameta.allure.Allure.step;

public class SelenideUtils extends Selenide {

    public static void click(SelenideElement element) {
        step(StringFormatUtil.concatenation("Click on ", element.getSearchCriteria()), () ->
                element.scrollIntoView(false).click());
    }

    public static SelenideElement val(SelenideElement element, String value) {
        return step(String.format("Set '%s' to %s", value, element.getSearchCriteria()), () ->
                element.scrollIntoView(false).val(value));
    }

    public static SelenideElement shouldHave(SelenideElement element, Condition condition) {
        return step(String.format("Check '%s' element has '%s' condition",
                        element.getSearchCriteria(),
                        condition.getName()),
                () -> element.shouldHave(condition));
    }

    public static SelenideElement validateElementsCollectionIsNotEmptyAndGet(ElementsCollection elements, int index){
        return step("Check ElementsCollection is not empty",
                () -> elements.shouldHave(CollectionCondition.sizeGreaterThan(NumberUtils.INTEGER_ZERO)).get(index));
    }

    //Class must be extended due to requirements
}