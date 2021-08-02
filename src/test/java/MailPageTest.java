import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.MailPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class MailPageTest extends TestBase {

    private MailPage mailPage;

    private static final String EXAMPLE_CONTACT = "example";

    @BeforeMethod
    public void navigateToMailPage() {
        mailPage = homePage.navigateToMailPage();
    }

    @Test
    public void checkComposeButtonTest() {
        mailPage.clickComposeButton();
        Assert.assertTrue(mailPage.letterFormContainerIsDisplayed());
    }

    @Test
    public void checkMailPackagesTest() {
        Assert.assertTrue(mailPage.mailPackagesIsDisplayed());
    }

    @Test
    public void checkSettingButtonTest() {
        mailPage.clickSettingButton();
        Assert.assertTrue(mailPage.settingContainerIsDisplayed());
    }
    
    @Test
    public void getSuggestionsFromSearchFieldTest() {
        mailPage.clickInputSearchField();
        Assert.assertTrue(mailPage.suggestionsContainerIsDisplayed());
    }

    @Test
    public void checkSearchContactFieldTest() {
        mailPage.enterContactIntoSearchField(EXAMPLE_CONTACT);
        mailPage.clickSearchButton();
        Assert.assertTrue(mailPage.notFoundBlockIsDisplayed());
    }
}
