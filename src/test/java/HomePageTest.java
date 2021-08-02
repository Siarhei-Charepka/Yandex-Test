import base.TestBase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners(TestListener.class)
public class HomePageTest extends TestBase {

    private static final String TEST = "test";
    private static final char KEY = 'v';
    private static final String KEYBOARD_TEXT = "Hello";

    @Test
    public void isMainContentDisplayedTest() {
        Assert.assertTrue(homePage.verifyHomePageContent());
        Assert.assertTrue(homePage.iSTabLinksOverSearchFieldDisplayed());
    }

    @Test
    public void searchFieldSuggestionsTest() {
        homePage.inputKeyToSearchField(TEST);
        Assert.assertTrue(homePage.verifySuggestionsContain(TEST));
    }

    @Test
    public void keyboardVisibilityTest() {
        homePage.clickKeyboardButton();
        Assert.assertTrue(homePage.isKeyboardDisplayed());
    }

    @Test
    public void keyboardPushKeyTest() {
        homePage.clickKeyboardButton();
        homePage.pushKey(KEY);
        Assert.assertEquals(String.valueOf(KEY), homePage.getCharSearchFieldValue());
    }

    @Description("the test checks the operation of the \"clear\" button in the search bar")
    @Test
    public void clearButtonTest() {
        homePage.clickKeyboardButton();
        homePage.pushKeys(KEYBOARD_TEXT);
        homePage.clickSuggestionsClearButton();
        Assert.assertTrue(homePage.getCharSearchFieldValue().isEmpty());
    }
}
