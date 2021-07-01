package page;

import base.PageBase;
import config.TestConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import utils.TestListener;

import java.util.List;
import java.util.stream.IntStream;

@Listeners(TestListener.class)
public class HomePage extends PageBase {

    private static final String LOGIN = TestConfig.get("login");
    private static final String PASSWORD = TestConfig.get("password");
    private static final String EXAMPLE_WORD = "automation";

    @FindBy(css = "a[title*='yandex.com']")
    private WebElement homePageLink;

    @FindBy(css = ".b-layout")
    private WebElement homePageContainer;

    @FindBy(css = ".logo__image_bg")
    private WebElement logo;

    @FindBy(css = " .input__control")
    private WebElement searchField;

    @FindBy(css = ".user__login-link")
    private WebElement logInLink;

    @FindBy(css = ".tabs div.b-inline")
    private List<WebElement> tabLinksOverSearchField;

    @FindBy(css = ".mini-suggest__item")
    private List<WebElement> suggestions;

    @FindBy(css = ".keyboard-loader")
    private WebElement keyboardButton;

    @FindBy(css = ".keyboard")
    private WebElement keyboardContainer;

    @FindBy(css = ".keyboard__row__cell")
    private List<WebElement> virtualKeyboardKeys;

    @FindBy(css = ".input__clear")
    private WebElement clearSearchFieldButton;

    @FindBy(css = ".user__login-link")
    private WebElement loginLink;

    @FindBy(css = ".HeadBanner-Button-Enter")
    private WebElement enterButton;

    @FindBy(css = "a[href*='https://passport.yandex.com/registration/']")
    private WebElement registrationButton;

    @FindBy(css = "a[href*='//translate.yandex.com']")
    private WebElement translatePageLink;

    @FindBy(css = "#tab-mail")
    private WebElement mailButton;

    @FindBy(css = "#passp-field-login")
    private WebElement loginField;

    @FindBy(css = ".passp-sign-in-button > button")
    private WebElement signInButton;

    @FindBy(css = "#passp-field-passwd")
    private WebElement passwordField;

    @FindBy(css = ".button_size_search")
    private WebElement searchButton;

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void navigateToYandexHomePage() {
        homePageLink.click();
    }

    public LoginPage navigateToLoginPage() {
        loginLink.click();
        enterButton.click();
        return new LoginPage();
    }

    public RegistrationPage navigateToRegistrationPage() {
        logInLink.click();
        registrationButton.click();
        return new RegistrationPage();
    }

    public TranslatePage navigateToTranslatePage() {
        translatePageLink.click();
        return new TranslatePage();
    }

    public MailPage navigateToMailPage() {
        mailButton.click();
        enterButton.click();
        loginField.sendKeys(LOGIN);
        signInButton.click();
        passwordField.sendKeys(PASSWORD);
        signInButton.click();
        return new MailPage();
    }

    public SearchResultPage navigateToSearchResultPage() {
        searchField.sendKeys(EXAMPLE_WORD);
        searchButton.click();
        return new SearchResultPage();
    }

    public boolean homePageContainerIsDisplayed() {
        return homePageContainer.isDisplayed();
    }

    public boolean logoIsDisplayed() {
        return logo.isDisplayed();
    }

    public boolean searchFieldIsDisplayed() {
        return searchField.isDisplayed();
    }

    public boolean logInLinkIsDisplayed() {
        return logInLink.isDisplayed();
    }

    public boolean tabLinksOverSearchFieldIsDisplayed() {
        return tabLinksOverSearchField.stream().allMatch(WebElement::isDisplayed)
                && tabLinksOverSearchField.size() == 7;
    }

    public void inputKeyToSearchField(String key) {
        searchField.sendKeys(key);
    }

    public boolean suggestionsFromSearchFieldIsDisplayed(String key) {
        return suggestions.stream().anyMatch(suggestion -> suggestion.getText().contains(key));
    }

    public void keyboardButtonClick() {
        keyboardButton.click();
    }

    public boolean keyboardIsDisplayed() {
        return keyboardContainer.isDisplayed();
    }

    public void pushKey(char ch) {
        virtualKeyboardKeys.stream().filter(key -> key.getText().equals(String.valueOf(ch)))
                .findFirst().get().click();
    }

    public boolean checkSearchFieldValueByChar(char ch) {
        return searchField.getAttribute("value").equals(String.valueOf(ch));
    }

    public String getCharSearchFieldValue() {
        return searchField.getAttribute("value");
    }

    public void pushKeys(String str) {
        IntStream.range(0, str.length()).forEach(i -> pushKey(str.toLowerCase().charAt(i)));
    }

    public void suggestionsClearButtonClick() {
        clearSearchFieldButton.click();
    }

    public boolean checkClearSearchField() {
        return searchField.getAttribute("value").isEmpty();
    }
}
