package base;

import config.TestConfig;
import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

public class TestBase {

    private static final String BASE_URL = TestConfig.get("url");
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void openBrowser() {
        Driver.getDriver().get(BASE_URL);
        homePage = new HomePage();
        homePage.searchYandexHomePage();
    }

    @AfterMethod
    public void closeBrowser() {
        Driver.tearDown();
    }
}
