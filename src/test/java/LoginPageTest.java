import base.TestBase;
import config.TestConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.LoginPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class LoginPageTest extends TestBase {

    private static final String USER_NAME = TestConfig.get("login");
    private static final String PASSWORD = TestConfig.get("password");
    private static final String EXPECTED_ERROR_ENTER_PASSWORD_MESSAGE_TEXT = "Enter password";
    private static final String EXPECTED_ERROR_INCORRECT_PASSWORD_MESSAGE_TEXT = "Incorrect password";
    private static final String EXPECTED_ERROR_LOGIN_MESSAGE_TEXT = "Enter a login";
    private static final String EXPECTED_ERROR_INCORRECT_LOGIN_MESSAGE_TEXT = "Account doesn't exist";

    private LoginPage loginPage;

    @BeforeMethod
    public void navigateToLoginPage() {
        loginPage = homePage.searchLoginPage();
    }

    @Test
    public void loginTest() {
        loginPage.inputUserName(USER_NAME);
        loginPage.clickUserNameButton();
        loginPage.inputPassword(PASSWORD);
        loginPage.clickPasswordButton();
        Assert.assertTrue(loginPage.isMailPageDisplayed());

    }

    @Test
    public void errorPasswordMessageTextTest() {
        loginPage.inputUserName(USER_NAME);
        loginPage.clickUserNameButton();
        loginPage.clickPasswordButton();
        String actualErrorPasswordMessageText = loginPage.getErrorMessageText();
        Assert.assertEquals(actualErrorPasswordMessageText, EXPECTED_ERROR_ENTER_PASSWORD_MESSAGE_TEXT);
    }

    @Test
    public void incorrectPasswordTest() {
        loginPage.inputUserName(USER_NAME);
        loginPage.clickUserNameButton();
        loginPage.inputPassword(RandomStringUtils.randomAlphabetic(8));
        loginPage.clickPasswordButton();
        String actualErrorPasswordMessageText = loginPage.getErrorMessageText();
        Assert.assertEquals(actualErrorPasswordMessageText, EXPECTED_ERROR_INCORRECT_PASSWORD_MESSAGE_TEXT);
    }

    @Test
    public void errorLoginMessageTextTest() {
        loginPage.clickUserNameButton();
        String actualErrorLoginMessageText = loginPage.getErrorMessageText();
        Assert.assertEquals(actualErrorLoginMessageText, EXPECTED_ERROR_LOGIN_MESSAGE_TEXT);
    }

    @Test
    public void incorrectLoginTest() {
        loginPage.inputUserName((RandomStringUtils.randomAlphabetic(8)));
        loginPage.clickUserNameButton();
        String actualErrorIncorrectLoginMessageText = loginPage.getErrorMessageText();
        Assert.assertEquals(actualErrorIncorrectLoginMessageText, EXPECTED_ERROR_INCORRECT_LOGIN_MESSAGE_TEXT);
    }

}