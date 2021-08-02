import base.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.RegistrationPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class RegistrationPageTest extends TestBase {

    private RegistrationPage registrationPage;

    private static final String EXPECTED_INCORRECT_LOGIN_MESSAGE_TEXT = "Invalid username";
    private static final String EXPECTED_ERROR_SHORT_PASSWORD_MESSAGE_TEXT = "Password too short";
    private static final String EXPECTED_ERROR_PASSWORDS_DONT_MATCH_MESSAGE_TEXT = "Passwords don't match";
    private static final String EXPECTED_VALID_PASSWORD_MESSAGE_TEXT = "Strong password";

    @BeforeMethod
    public void navigateToRegistrationPage() {
        registrationPage = homePage.searchRegistrationPage();
    }

    @Test
    public void registrationFormIsDisplayedTest() {
        Assert.assertTrue(registrationPage.isRegistrationFormDisplayed());
    }

    @Test
    public void checkIncorrectLoginMessageTest() {
        registrationPage.inputLogin(RandomStringUtils.randomAlphabetic(40));
        String actualErrorMessage = registrationPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, EXPECTED_INCORRECT_LOGIN_MESSAGE_TEXT);
    }

    @Test
    public void checkShortPasswordMessageTest() {
        registrationPage.inputPassword(RandomStringUtils.randomAlphabetic(1));
        registrationPage.inputConfirmationPassword(RandomStringUtils.randomAlphabetic(1));
        String actualShortErrorMessage = registrationPage.getErrorMessage();
        Assert.assertEquals(actualShortErrorMessage, EXPECTED_ERROR_SHORT_PASSWORD_MESSAGE_TEXT);
    }

    @Test
    public void checkValidPasswordMessageTest() {
        registrationPage.inputFirstName(RandomStringUtils.randomAlphabetic(10));
        registrationPage.inputLastName(RandomStringUtils.randomAlphabetic(10));
        registrationPage.inputLogin(RandomStringUtils.randomAlphabetic(10));
        registrationPage.inputPassword(RandomStringUtils.randomAlphabetic(10));
        String actualValidMessage = registrationPage.getPasswordMessage();
        Assert.assertTrue(actualValidMessage.contains(EXPECTED_VALID_PASSWORD_MESSAGE_TEXT));
    }

    @Test
    public void checkDontMatchesPasswordMessageTest() {
        registrationPage.inputFirstName(RandomStringUtils.randomAlphabetic(10));
        registrationPage.inputLogin(RandomStringUtils.randomAlphabetic(10));
        registrationPage.inputPassword(RandomStringUtils.randomAlphabetic(10));
        registrationPage.inputConfirmationPassword(RandomStringUtils.randomAlphabetic(10));
        registrationPage.clickRegistrationButton();
        String actualValidMessage = registrationPage.getErrorMessage();
        Assert.assertEquals(actualValidMessage, EXPECTED_ERROR_PASSWORDS_DONT_MATCH_MESSAGE_TEXT);
    }
}
