import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.SearchResultPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class SearchResultPageTest extends TestBase {

    private static final String AUTOMATION = "automation";

    private SearchResultPage searchResultPage;

    @BeforeMethod
    public void navigateToSearchResultPage() {
      searchResultPage = homePage.searchSearchResultPage(AUTOMATION);
    }

    @Test
    public void checkSuggestionsTest(){
        searchResultPage.clickSearchButton();
        Assert.assertTrue(searchResultPage.suggestionsIsDisplayed(AUTOMATION));
    }

    @Test
    public void checkSuggestionsOfImagesTest() {
        searchResultPage.clickImagesLink();
        Assert.assertTrue(searchResultPage.imagesContainerIsDisplayed());
    }

    @Test
    public void checkSuggestionsOfVideoTest() {
        searchResultPage.clickVideoLink();
        Assert.assertTrue(searchResultPage.videoContainerIsDisplayed());
    }

    @Test
    public void checkSuggestionsOfMusicTest() {
        searchResultPage.clickMusicLink();
        Assert.assertTrue(searchResultPage.musicContainerIsDisplayed());
    }

    @Test
    public void inputSettingButtonTest() {
        searchResultPage.clickInputSettingButton();
        Assert.assertTrue(searchResultPage.advancedSearchLoaderFormIsDisplayed());
    }
}
