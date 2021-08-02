package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaiterUtils {
    private WebDriver driver;

    public WaiterUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementVisibility(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForDataToBeUpdated(WebElement element, String oldValue) {
        new WebDriverWait(driver, 10).until(driver -> !element.getText().equals(oldValue));
    }

    public void waitForElementIsNotEmpty(WebElement element) {
        new WebDriverWait(driver, 10).until(driver -> !element.getText().isEmpty());
    }
}
