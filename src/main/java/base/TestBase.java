package base;

import config.TestConfig;
import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.YandexLoginPage;

public class TestBase {

    private static final String BASE_URL = TestConfig.get("url");

    protected YandexLoginPage yandexLoginPage;

    @BeforeMethod
    public void openBrowser() {
        Driver.getDriver().get(BASE_URL);
        yandexLoginPage = new YandexLoginPage();
    }

    @AfterMethod
    public void closeBrowser() {
        Driver.tearDown();
    }
}
