package page;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HomePage extends PageBase {

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

    @FindBy(css = "a[href*='registration']")
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

    public void searchYandexHomePage() {
        homePageLink.click();
    }

    public LoginPage searchLoginPage() {
        loginLink.click();
        enterButton.click();
        return new LoginPage();
    }

    public RegistrationPage searchRegistrationPage() {
        logInLink.click();
        registrationButton.click();
        return new RegistrationPage();
    }

    public TranslatePage searchTranslatePage() {
        translatePageLink.click();
        return new TranslatePage();
    }

    public MailPage searchMailPage(String login, String password) {
        mailButton.click();
        enterButton.click();
        loginField.sendKeys(login);
        signInButton.click();
        passwordField.sendKeys(password);
        signInButton.click();
        return new MailPage();
    }

    public SearchResultPage searchSearchResultPage(String testWord) {
        searchField.sendKeys(testWord);
        searchButton.click();
        return new SearchResultPage();
    }


    public boolean verifyHomePageContent(){
        return Stream.of(logo, searchField, logInLink, searchField).allMatch(WebElement::isDisplayed);
    }

    public boolean iSTabLinksOverSearchFieldDisplayed() {
        return tabLinksOverSearchField.stream().allMatch(WebElement::isDisplayed)
                && tabLinksOverSearchField.size() == 7;
    }

    public void inputKeyToSearchField(String key) {
        searchField.sendKeys(key);
    }

    public boolean verifySuggestionsContain(String keyWord) {
        return suggestions.stream().allMatch(suggestion -> suggestion.getText().contains(keyWord));
    }

    public void clickKeyboardButton() {
        keyboardButton.click();
    }

    public boolean isKeyboardDisplayed() {
        return keyboardContainer.isDisplayed();
    }

    public void pushKey(char ch) {
        virtualKeyboardKeys.stream().filter(key -> key.getText().equals(String.valueOf(ch)))
                .findFirst().get().click();
    }

    public String getCharSearchFieldValue() {
        return searchField.getAttribute("value");
    }

    public void pushKeys(String str) {
        IntStream.range(0, str.length()).forEach(i -> pushKey(str.toLowerCase().charAt(i)));
    }

    public void clickSuggestionsClearButton() {
        clearSearchFieldButton.click();
    }
}
