import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.TranslatePage;
import utils.TestListener;

@Listeners(TestListener.class)
public class TranslatePageTest extends TestBase {

    private static final String EXPECTED_LANGUAGE = "german";
    private static final String TRANSLATION_WORD = "test";
    private static final String EXPECTED_TRANSLATION_RESULT = "тест";
    private static final String RELATED_WORD = "verify";
    private static final String RELATED_TRANSLATION_RESULT = "проверить";

    private TranslatePage translatePage;

    @BeforeMethod
    public void navigateToTranslatePage() {
        translatePage = homePage.searchTranslatePage();
    }

    @Test
    public void translatePageIsDisplayedTest() {
        translatePage.isTranslatePageDisplayed();
    }

    @Test
    public void chooseLanguageButtonTest() {
        translatePage.clickLanguageButton();
        translatePage.clickChooseLanguageButton(EXPECTED_LANGUAGE);
        String actualLanguage = translatePage.getInfoAboutLanguage();
        Assert.assertEquals(actualLanguage, EXPECTED_LANGUAGE.toUpperCase());
    }

    @Test
    public void translationContainerTest() {
        translatePage.inputTranslatableWord(TRANSLATION_WORD);
        String actualTranslationResult = translatePage.getTranslationResult();
        Assert.assertEquals(actualTranslationResult, EXPECTED_TRANSLATION_RESULT);
    }

    @Test
    public void relatedWordsTest() {
        translatePage.inputTranslatableWord(TRANSLATION_WORD);
        translatePage.clickRelatedWord(RELATED_WORD);
        String actualTranslationResult = translatePage.getTranslationResult();
        Assert.assertEquals(actualTranslationResult, RELATED_TRANSLATION_RESULT);
    }

    @Test
    public void onScreenKeyboardTest() {
        translatePage.clickKeyboardButton();
        translatePage.pushChars(TRANSLATION_WORD);
        String actualTranslationResult = translatePage.getTranslationResult();
        Assert.assertEquals(actualTranslationResult, EXPECTED_TRANSLATION_RESULT);
    }

    @Test
    public void recentRequestTest() {
        translatePage.inputTranslatableWord(TRANSLATION_WORD);
        translatePage.clickClearButton();
        String actualRecentRequestResult = translatePage.getRecentRequestResult();
        Assert.assertEquals(actualRecentRequestResult, TRANSLATION_WORD);
    }
}
