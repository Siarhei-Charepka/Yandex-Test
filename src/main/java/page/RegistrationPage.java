package page;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends PageBase {

    @FindBy(css = ".registration__form")
    private WebElement registrationForm;

    @FindBy(css = "#login")
    private WebElement loginField;

    @FindBy(css = ".form__login-message")
    private WebElement errorLoginMessage;

    @FindBy(css = "[data-t ='field:input-firstname']")
    private WebElement inputFirstNameField;

    @FindBy(css = "[data-t ='field:input-lastname']")
    private WebElement inputLastNameField;

    @FindBy(css = "[data-t ='field:input-login']")
    private WebElement inputLoginField;

    @FindBy(css = "[data-t ='field:input-password']")
    private WebElement inputPasswordField;

    @FindBy(css = "[data-t ='field:input-password_confirm']")
    private WebElement inputPasswordConfirmField;

    @FindBy(css = ".error-message")
    private WebElement errorPasswordMessage;

    @FindBy(css = ".field__password .reg-field__popup")
    private WebElement validPasswordMessage;

    @FindBy(css = "div.form__submit > span > button")
    private WebElement registrationButton;

    public RegistrationPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean registrationFormIsDisplayed() {
        return registrationForm.isDisplayed();
    }

    public void inputIncorrectLogin(String login) {
        loginField.sendKeys(login);
    }

    public String getLoginErrorMessage() {
        return errorLoginMessage.getText();
    }

    public void inputFirstName(String name) {
        inputFirstNameField.sendKeys(name);
    }

    public void inputLastName(String lastName) {
        inputLastNameField.sendKeys(lastName);
    }

    public void inputLogin(String login) {
        inputLoginField.sendKeys(login);
    }

    public void inputShortPassword(String password) {
        inputPasswordField.sendKeys(password);
    }

    public void inputConfirmationPassword(String confirmationPassword) {
        inputPasswordConfirmField.sendKeys(confirmationPassword);
    }

    public String getErrorPasswordMessage() {
        return errorPasswordMessage.getText();
    }

    public String getPasswordMessage() {
        return validPasswordMessage.getText();
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }
}
