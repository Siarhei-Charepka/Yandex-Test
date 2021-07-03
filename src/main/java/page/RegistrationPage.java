package page;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends PageBase {

    @FindBy(css = "#firstname")
    private WebElement firstNameField;

    @FindBy(css = "#lastname")
    private WebElement lastNameField;

    @FindBy(css = "#login")
    private WebElement loginField;

    @FindBy(css = ".registration__form")
    private WebElement registrationForm;

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    @FindBy(css = "[data-t ='field:input-password']")
    private WebElement inputPasswordField;

    @FindBy(css = "[data-t ='field:input-password_confirm']")
    private WebElement inputPasswordConfirmField;

    @FindBy(css = ".field__password .reg-field__popup")
    private WebElement validPasswordMessage;

    @FindBy(css = "[type='submit']")
    private WebElement registrationButton;

    public RegistrationPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isRegistrationFormDisplayed() {
        return registrationForm.isDisplayed();
    }

    public void inputFirstName(String name) {
        firstNameField.sendKeys(name);
    }

    public void inputLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        inputPasswordField.sendKeys(password);
    }

    public void inputConfirmationPassword(String confirmationPassword) {
        inputPasswordConfirmField.sendKeys(confirmationPassword);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getPasswordMessage() {
        return validPasswordMessage.getText();
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }
}
