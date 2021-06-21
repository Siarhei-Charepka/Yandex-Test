package base;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import utils.WaiterUtils;

public class PageBase {

    protected WebDriver driver;
    protected WaiterUtils waiter;

    public PageBase() {
        this.driver = Driver.getDriver();
        this.waiter = new WaiterUtils(driver);
    }
}
