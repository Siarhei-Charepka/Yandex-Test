package base;

import driver.Driver;
import org.openqa.selenium.WebDriver;

public class PageBase {

    protected WebDriver driver;

    public PageBase() {
        this.driver = Driver.getDriver();
    }
}
