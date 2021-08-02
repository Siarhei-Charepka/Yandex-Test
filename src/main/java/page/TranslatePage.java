package page;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.IntStream;

public class TranslatePage extends PageBase {


    @FindBy(css = "#mainContainer")
    private WebElement translatePage;

    @FindBy(css = "#srcLangButton")
    private WebElement chooseLanguageButton;

    @FindBy(css = "#srcLangListboxContent .listbox-option")
    private List<WebElement> languages;

    @FindBy(css = "#fakeArea")
    private WebElement translatableContainer;

    @FindBy(css = ".translation-container")
    private WebElement translationResultContainer;

    @FindBy(css = ".synonyms-value")
    private List<WebElement> relatedWords;

    @FindBy(css = "#keyboardButton")
    private WebElement keyboardButton;

    @FindBy(css = "#keyboard .keyboard-key")
    private List<WebElement> keyboardChars;

    @FindBy(css = ".history_records-item-text")
    private WebElement historyRecordWord;

    @FindBy(css = "#clearButton")
    private WebElement clearButton;

    public TranslatePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isTranslatePageDisplayed() {
        return translatePage.isDisplayed();
    }

    public void clickLanguageButton() {
        chooseLanguageButton.click();
    }

    public void clickChooseLanguageButton(String languageName) {
         languages.stream().filter(element -> element.getText().equalsIgnoreCase(languageName)).findFirst().get().click();

    }

    public String getInfoAboutLanguage(){
        return chooseLanguageButton.getText();
    }

    public void inputTranslatableWord(String word){
        translatableContainer.sendKeys(word);
        waiter.waitForElementIsNotEmpty(translationResultContainer);
    }

    public String getTranslationResult(){
        waiter.waitForElementIsNotEmpty(translationResultContainer);
        return translationResultContainer.getText();
    }

    public void clickRelatedWord(String word){
        String oldValue = translationResultContainer.getText();
        relatedWords.stream().filter(key -> key.getText().equals(word))
                .findFirst().get().click();
        waiter.waitForDataToBeUpdated(translatableContainer, oldValue);
    }

    public void clickKeyboardButton(){
        keyboardButton.click();
    }

    public void pushChar(char ch) {
        keyboardChars.stream().filter(key -> key.getText().equals(String.valueOf(ch)))
                .findFirst().get().click();
    }

    public void pushChars(String str) {
        IntStream.range(0, str.length()).forEach(i -> pushChar(str.toLowerCase().charAt(i)));
        waiter.waitForElementIsNotEmpty(translationResultContainer);
    }

    public void clickClearButton(){
        clearButton.click();
    }

    public String getRecentRequestResult() {
        return historyRecordWord.getText();
    }
}