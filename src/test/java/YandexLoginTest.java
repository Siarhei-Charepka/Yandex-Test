import base.TestBase;
import config.TestConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.UserAccountPage;

public class YandexLoginTest extends TestBase {

    private static final String USER_NAME = TestConfig.get("login");
    private static final String PASSWORD = TestConfig.get("password");
    private static final String EXPECTED_ERROR_PASSWORD_MESSAGE_TEXT = "Incorrect password";
    private static final String EXPECTED_ERROR_LOGIN_MESSAGE_TEXT = "Account doesn't exist";

    private UserAccountPage userAccountPage;

    @Test
    public void loginTest() {
        yandexLoginPage.inputUserName(USER_NAME);
        yandexLoginPage.clickEnterUserNameButton();
        yandexLoginPage.inputPassword(PASSWORD);
        userAccountPage = yandexLoginPage.clickEnterPasswordButton();
        Assert.assertTrue(userAccountPage.isDisplayed());
    }

    @Test
    public void incorrectPasswordTest() {
        yandexLoginPage.inputUserName(USER_NAME);
        yandexLoginPage.clickEnterUserNameButton();
        yandexLoginPage.inputPassword(RandomStringUtils.randomAlphabetic(8));
        userAccountPage = yandexLoginPage.clickEnterPasswordButton();
        String actualErrorPasswordMessageText = yandexLoginPage.getErrorPasswordMessageText();
        Assert.assertEquals(actualErrorPasswordMessageText, EXPECTED_ERROR_PASSWORD_MESSAGE_TEXT);

    }

    @Test
    public void incorrectLoginTest() {
        yandexLoginPage.inputUserName((RandomStringUtils.randomAlphabetic(8)));
        yandexLoginPage.clickEnterUserNameButton();
        String actualErrorLoginMessageText = yandexLoginPage.getErrorLoginMessageText();
        Assert.assertEquals(actualErrorLoginMessageText, EXPECTED_ERROR_LOGIN_MESSAGE_TEXT);

    }

    @Test
    public void registerButtonTest() {
        Assert.assertTrue(yandexLoginPage.clickRegisterButton().isDisplayed());
    }

    @Test
    public void backPaneTest() {
        yandexLoginPage.inputUserName(USER_NAME);
        yandexLoginPage.clickEnterUserNameButton();
        Assert.assertTrue(yandexLoginPage.backPainButtonClick().loginFormContainerIsDisplayed());
    }

    @Test
    public void forgotLoginLinkTest() {
        Assert.assertTrue(yandexLoginPage.clickForgotLoginText().phoneNumberFormIsDisplayed());
    }

    @Test
    public void forgotPasswordLinkTest() {
        yandexLoginPage.inputUserName(USER_NAME);
        Assert.assertTrue(yandexLoginPage.clickForgotPasswordText().loginFormContainerIsDisplayed());
    }

    @Test
    public void getSocialIconsTest() {
        Assert.assertTrue(yandexLoginPage.socialIconsIsDisplayed());
    }

    @Test
    public void qRCodeIconTest() {
        Assert.assertTrue(yandexLoginPage.clickQrCodeIcon().qRContainerIsDisplayed());
    }
}