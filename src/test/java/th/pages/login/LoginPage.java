package th.pages.login;

import actions.Open;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helper.pages.IPage;
import helper.pages.PageFactory;
import helper.pages.Url;
import th.pages.inventory.InventoryPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Url("/")
public class LoginPage implements IPage<LoginPage> {

    private final SelenideElement
            usernameInput = $("#user-name"),
            passwordInput = $("#password"),
            loginButton = $("#login-button"),
            errorFld = $x("//h3[@data-test='error']");

    public static LoginPage init() {
        return Open.browserOn().the(LoginPage.class);
    }

    public InventoryPage login(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    public LoginPage enterUsername(String username) {
        usernameInput.val(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.val(password);
        return this;
    }

    public InventoryPage clickLoginButton() {
        loginButton.click();
        return PageFactory.init(InventoryPage.class);
    }

    public LoginPage clickLoginButtonAndCheckErrorMessage(String expTxt) {
        loginButton.click();
        return verifyError(expTxt);
    }

    private LoginPage verifyError(String expTxt) {
        errorFld.shouldHave(Condition.exactText(expTxt));
        return this;
    }
}
