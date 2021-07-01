package page;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class SearchResultPage extends PageBase {

    @FindBy(css = ".OrganicTitle-LinkText b")
    private List<WebElement> suggestions;

    @FindBy(css = ".search2__button .websearch-button")
    private WebElement searchButton;

    @FindBy(css = ".service_name_images a")
    private WebElement imagesLink;

    @FindBy(css = "a[href*='/images/']")
    private WebElement suggestionsOfImages;

    @FindBy(css = ".service_name_video a")
    private WebElement videoLink;

    @FindBy(css = "a[href*='/video/']")
    private WebElement suggestionsOfVideo;

    @FindBy(css = ".service_name_music a")
    private WebElement musicLink;

    @FindBy(css = ".payment-plus__header-close")
    private WebElement closeAdsButton;

    @FindBy(css = ".typo-track")
    private WebElement suggestionsOfMusic;

    @FindBy(css = "button.input__settings")
    private WebElement inputSettingButton;

    @FindBy(css = "div.advanced-search-loader")
    private WebElement advancedSearchLoaderForm;


    public SearchResultPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean suggestionsIsDisplayed(String key) {
        return suggestions.stream().allMatch(suggestion -> suggestion.getText().toLowerCase()
                .contains(key)) && suggestions.size() == 10;
    }

    public void clickImagesLink() {
        imagesLink.click();
    }

    public boolean imagesContainerIsDisplayed() {
        return suggestionsOfImages.isDisplayed();
    }

    public void clickVideoLink() {
        videoLink.click();
    }

    public boolean videoContainerIsDisplayed() {
        return videoLink.isDisplayed();
    }

    public void clickMusicLink() {
        musicLink.click();
        Set<String> windowHandles = driver.getWindowHandles();
        driver.switchTo().window((String) windowHandles.toArray()[1]);
        closeAdsButton.click();
    }

    public boolean musicContainerIsDisplayed() {
        return suggestionsOfMusic.isDisplayed();
    }

    public void clickInputSettingButton() {
        inputSettingButton.click();
        waiter.waitForElementVisibility(advancedSearchLoaderForm);
    }

    public boolean advancedSearchLoaderFormIsDisplayed() {
        return advancedSearchLoaderForm.isDisplayed();
    }


}
