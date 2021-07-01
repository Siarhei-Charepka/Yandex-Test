import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners(TestListener.class)
public class HomePageTest extends TestBase {

    private static final String EXPECTED_TEXT = "test";
    private static final char KEYBOARD_KEY = 'v';
    private static final String KEYBOARD_TEXT = "Hello";

    @Test
    public void homePageContainerIsDisplayedTest() {
        Assert.assertTrue(homePage.homePageContainerIsDisplayed());
    }

    @Test
    public void logoIsDisplayedTest() {
        Assert.assertTrue(homePage.logoIsDisplayed());
    }

    @Test
    public void searchFieldIsDisplayedTest() {
        Assert.assertTrue(homePage.searchFieldIsDisplayed());
    }

    @Test
    public void logInLinkIsDisplayedTest() {
        Assert.assertTrue(homePage.logInLinkIsDisplayed());
    }

    @Test
    public void tabLinksOverSearchFieldIsDisplayedTest() {
        Assert.assertTrue(homePage.tabLinksOverSearchFieldIsDisplayed());
    }

    @Test
    public void getSuggestionsFromTheSearchFieldTest() {
        homePage.inputKeyToSearchField(EXPECTED_TEXT);
        Assert.assertTrue(homePage.suggestionsFromSearchFieldIsDisplayed(EXPECTED_TEXT));
    }

    @Test
    public void keyboardIsDisplayedTest() {
        homePage.keyboardButtonClick();
        Assert.assertTrue(homePage.keyboardIsDisplayed());
    }

    @Test
    public void keyboardPushKeyTest() {
        homePage.keyboardButtonClick();
        homePage.pushKey(KEYBOARD_KEY);
        Assert.assertTrue(homePage.checkSearchFieldValueByChar(KEYBOARD_KEY));
        Assert.assertEquals(String.valueOf(KEYBOARD_KEY), homePage.getCharSearchFieldValue());
    }

    @Test
    public void keyboardPushKeysTest() {
        homePage.keyboardButtonClick();
        homePage.pushKeys(KEYBOARD_TEXT);
        homePage.suggestionsClearButtonClick();
        Assert.assertTrue(homePage.checkClearSearchField());
    }
}
