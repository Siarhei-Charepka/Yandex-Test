package base;

import config.TestConfig;
import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

public class TestBase {


    private static final String BASE_URL = TestConfig.get("url");
    protected WebDriver driver;
    protected HomePage homePage;

    public TestBase() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @BeforeMethod
    public void openBrowser() {
        Driver.getDriver().get(BASE_URL);
        homePage = new HomePage();
        homePage.navigateToYandexHomePage();
    }

    @AfterMethod
    public void closeBrowser() {
        Driver.tearDown();
    }
}
