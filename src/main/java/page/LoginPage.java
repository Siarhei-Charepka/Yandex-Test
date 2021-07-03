package page;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {

    @FindBy(css = ".mail-Page-Body")
    private WebElement mailPageBody;

    @FindBy(css = "[id='passp-field-login']")
    private WebElement userNameField;

    @FindBy(css = "[class *='has-social-block'] [type='submit']")
    private WebElement enterUserNameButton;

    @FindBy(css = "[name ='passwd']")
    private WebElement passwordField;

    @FindBy(css = ".passp-route-forward [type='submit']")
    private WebElement enterPasswordButton;

    @FindBy(css = ".Textinput-Hint")
    private WebElement errorMessage;

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void inputUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void clickUserNameButton() {
        enterUserNameButton.click();
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickPasswordButton() {
        enterPasswordButton.click();
    }

    public boolean isMailPageDisplayed() {
        return mailPageBody.isDisplayed();
    }

    public String getErrorMessageText() {
        waiter.waitForElementVisibility(errorMessage);
        return errorMessage.getText();
    }
}
