import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.RegistrationPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class RegistrationPageTest extends TestBase {

    private RegistrationPage registrationPage;

    private static final String INCORRECT_LOGIN = "bilbiboboooooooooooooooooooooooo";
    private static final String EXPECTED_INCORRECT_LOGIN_MESSAGE_TEXT = "Invalid username";
    private static final String FIRST_NAME = "didididid";
    private static final String LAST_NAME = "didididid";
    private static final String LOGIN = "ddddiiiiiiiiiiiiiii";
    private static final String SHORT_PASSWORD = "1";
    private static final String EXPECTED_ERROR_SHORT_PASSWORD_MESSAGE_TEXT = "Password too short";
    private static final String VALID_PASSWORD = "1234567sssss";
    private static final String INCORRECT_CONFIRM_PASSWORD = "1234567ss";
    private static final String EXPECTED_ERROR_PASSWORDS_DONT_MATCH_MESSAGE_TEXT = "Passwords don't match";
    private static final String EXPECTED_VALID_PASSWORD_MESSAGE_TEXT = "Strong password";

    @BeforeMethod
    public void navigateToRegistrationPage(){
        registrationPage = homePage.navigateToRegistrationPage();
    }

    @Test
    public void loginPageIsDisplayedTest() {
        Assert.assertTrue(registrationPage.registrationFormIsDisplayed());
    }

    @Test
    public void checkIncorrectLoginMessageTest() {
        registrationPage.inputIncorrectLogin(INCORRECT_LOGIN);
        String actualErrorMessage = registrationPage.getLoginErrorMessage();
        Assert.assertEquals(actualErrorMessage, EXPECTED_INCORRECT_LOGIN_MESSAGE_TEXT);
    }

    @Test
    public void checkShortPasswordMessageTest() {
        registrationPage.inputFirstName(FIRST_NAME);
        registrationPage.inputLastName(LAST_NAME);
        registrationPage.inputLogin(LOGIN);
        registrationPage.inputShortPassword(SHORT_PASSWORD);
        registrationPage.inputConfirmationPassword(SHORT_PASSWORD);
        String actualShortErrorMessage = registrationPage.getErrorPasswordMessage();
        Assert.assertEquals(actualShortErrorMessage, EXPECTED_ERROR_SHORT_PASSWORD_MESSAGE_TEXT);
    }

    @Test
    public void checkValidPasswordMessageTest() {
        registrationPage.inputFirstName(FIRST_NAME);
        registrationPage.inputLastName(LAST_NAME);
        registrationPage.inputLogin(LOGIN);
        registrationPage.inputShortPassword(VALID_PASSWORD);
        String actualValidMessage = registrationPage.getPasswordMessage();
        Assert.assertTrue(actualValidMessage.contains(EXPECTED_VALID_PASSWORD_MESSAGE_TEXT));
    }

    @Test
    public void checkDontMatchesPasswordMessageTest() {
        registrationPage.inputFirstName(FIRST_NAME);
        registrationPage.inputLastName(LAST_NAME);
        registrationPage.inputLogin(LOGIN);
        registrationPage.inputShortPassword(VALID_PASSWORD);
        registrationPage.inputConfirmationPassword(INCORRECT_CONFIRM_PASSWORD);
        registrationPage.clickRegistrationButton();
        String actualValidMessage = registrationPage.getErrorPasswordMessage();
        Assert.assertEquals(actualValidMessage, EXPECTED_ERROR_PASSWORDS_DONT_MATCH_MESSAGE_TEXT);
    }
}
