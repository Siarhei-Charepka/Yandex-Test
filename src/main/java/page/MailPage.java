package page;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MailPage extends PageBase {

    @FindBy(css = ".mail-ComposeButton-Text")
    private WebElement composeButton;

    @FindBy(css = ".composeReact__inner")
    private WebElement letterFormContainer;

    @FindBy(css = ".ns-view-folders .ns-view-folder")
    private List<WebElement> packages;

    @FindBy(css = ".mail-SettingsButton")
    private WebElement settingButton;

    @FindBy(css = ".Popup2")
    private WebElement settingContainer;

    @FindBy(css = ".search-input__form-input > input")
    private WebElement searchInputField;

    @FindBy(css = ".search__popup")
    private WebElement suggestionsContainer;

    @FindBy(css = ".search-input__form-button")
    private WebElement searchButton;

    @FindBy(css = ".b-search-not-found__block")
    private WebElement notFoundBlock;

    public MailPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void clickComposeButton() {
        composeButton.click();
    }

    public boolean iSLetterFormContainerDisplayed() {
        return letterFormContainer.isDisplayed();
    }

    public boolean isMailPackagesDisplayed() {
        return packages.stream().allMatch(WebElement::isDisplayed) && packages.size() == 5;
    }

    public void clickSettingButton() {
        settingButton.click();
    }

    public boolean iSSettingContainerDisplayed() {
        waiter.waitForElementVisibility(settingContainer);
        return settingContainer.isDisplayed();
    }

    public void clickInputSearchField() {
        searchInputField.click();
    }

    public boolean isSuggestionsContainerDisplayed() {
        waiter.waitForElementVisibility(suggestionsContainer);
        return suggestionsContainer.isDisplayed();
    }

    public void enterContactIntoSearchField(String contact) {
        searchInputField.sendKeys(contact);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean notFoundBlockIsDisplayed() {
        return notFoundBlock.isDisplayed();
    }
}


