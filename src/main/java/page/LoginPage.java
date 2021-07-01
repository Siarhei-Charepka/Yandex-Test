package page;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {

    @FindBy(css = ".passp-auth-content")
    private WebElement loginFormContainer;

    @FindBy(css = "[id='passp-field-login']")
    private WebElement userNameField;

    @FindBy(css = "[class *='has-social-block'] [type='submit']")
    private WebElement enterUserNameButton;

    @FindBy(css = "[name ='passwd']")
    private WebElement passwordField;

    @FindBy(css = ".passp-route-forward [type='submit']")
    private WebElement enterPasswordButton;

    @FindBy(css = ".mail-Page-Body")
    private WebElement mailPageBody;

    @FindBy(css = ".Textinput-Hint")
    private WebElement errorMessage;

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean loginFormContainerIsDisplayed() {
        return loginFormContainer.isDisplayed();
    }

    public void inputUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void clickUserNameButton() {
        enterUserNameButton.click();
    }

    public void clickUserNameButtonWithWaiter() {
        enterUserNameButton.click();
        waiter.waitForElementVisibility(errorMessage);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickPasswordButton() {
        enterPasswordButton.click();
    }

    public void clickPasswordButtonWithWaiter() {
        enterPasswordButton.click();
        waiter.waitForElementVisibility(errorMessage);
    }
    public boolean mailPageBodyIsDisplayed(){
        return mailPageBody.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
