package th.pages.login;

import th.utils.actions.Open;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helper.pages.IPage;
import helper.pages.PageFactory;
import helper.pages.Url;
import io.qameta.allure.Step;
import th.pages.inventory.InventoryPage;
import th.utils.actions.SelenideUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Url("/")
public class LoginPage implements IPage<LoginPage> {

    private final SelenideElement
            usernameInput = $("#user-name"),
            passwordInput = $("#password"),
            loginButton = $("#login-button"),
            errorFld = $x("//h3[@data-test='error']");

    @Step("Open Login page")
    public static LoginPage init() {
        return Open.browserOn().the(LoginPage.class);
    }

    @Step("Perform login with user: {username} and password: {password}")
    public InventoryPage login(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    @Step("Fill username with {username} value")
    public LoginPage enterUsername(String username) {
        SelenideUtils.val(usernameInput, username);
        return this;
    }

    @Step("Fill password with {password} value")
    public LoginPage enterPassword(String password) {
        SelenideUtils.val(passwordInput, password);
        return this;
    }

    @Step("Click Login button")
    public InventoryPage clickLoginButton() {
        SelenideUtils.click(loginButton);
        return PageFactory.init(InventoryPage.class);
    }

    @Step("Click Login button and check error appears")
    public LoginPage clickLoginButtonAndCheckErrorMessage(String expTxt) {
        SelenideUtils.click(loginButton);
        return verifyError(expTxt);
    }

    @Step("Check error message '{expTxt}' appears")
    private LoginPage verifyError(String expTxt) {
        SelenideUtils.shouldHave(errorFld, Condition.exactText(expTxt));
        return this;
    }
}
