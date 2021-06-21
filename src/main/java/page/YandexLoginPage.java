package page;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YandexLoginPage extends PageBase {

    @FindBy(css = "[id='passp-field-login']")
    private WebElement userNameField;

    @FindBy(css = "[class *='has-social-block'] [type='submit']")
    private WebElement enterUserNameButton;

    @FindBy(css = "[name ='passwd']")
    private WebElement passwordField;

    @FindBy(css = ".passp-route-forward [type='submit']")
    private WebElement enterPasswordButton;

    @FindBy(css = ".Textinput-Hint")
    private WebElement errorMessageText;

    @FindBy(css = ".Textinput-Hint_state_error")
    private WebElement errorLoginMessageText;

    @FindBy(css = ".passp-exp-register-button a")
    private WebElement registerButton;

    @FindBy(css = ".PreviousStepButton")
    private WebElement backPaneButton;

    @FindBy(css = ".passp-add-account-page_has-social-block")
    private WebElement loginFormContainer;

    @FindBy(css = ".Field-link a")
    private WebElement forgotLoginLinkText;

    @FindBy(css = ".passp-route-forward")
    private WebElement phoneNumberForm;

    @FindBy(css = ".Field-link a")
    private WebElement forgotPasswordLinkText;

    @FindBy(css = ".passp-auth-screen")
    private WebElement phoneNumberFormContainer;

    @FindBy(css = ".AuthSocialBlock-providers button")
    private List<WebElement> socialNetworksIcons;

    @FindBy(css = ".AuthSocialBlock-provider_code_qr")
    private WebElement qrCodeIcon;

    @FindBy(css = ".MagicField-qr")
    private WebElement qRCodeContainer;

    public YandexLoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void inputUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void clickEnterUserNameButton() {
        enterUserNameButton.click();
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public UserAccountPage clickEnterPasswordButton() {
        enterPasswordButton.click();
        return new UserAccountPage();
    }

    public String getErrorPasswordMessageText() {
        return errorMessageText.getText();
    }

    public String getErrorLoginMessageText() {
        return errorLoginMessageText.getText();
    }

    public RegisterPage clickRegisterButton() {
        registerButton.click();
        return new RegisterPage();
    }

    public YandexLoginPage backPainButtonClick() {
        backPaneButton.click();
        return new YandexLoginPage();
    }

    public boolean loginFormContainerIsDisplayed() {
        return loginFormContainer.isDisplayed();
    }

    public YandexLoginPage clickForgotLoginText() {
        forgotLoginLinkText.click();
        return new YandexLoginPage();
    }

    public boolean phoneNumberFormIsDisplayed() {
        return phoneNumberForm.isDisplayed();
    }

    public YandexLoginPage clickForgotPasswordText() {
        forgotPasswordLinkText.click();
        return new YandexLoginPage();
    }

    public boolean socialIconsIsDisplayed() {
        return socialNetworksIcons.stream().allMatch(WebElement::isDisplayed);
    }

    public YandexLoginPage clickQrCodeIcon(){
        qrCodeIcon.click();
        return new YandexLoginPage();
    }

    public boolean qRContainerIsDisplayed(){
        return qRCodeContainer.isDisplayed();
    }
}
