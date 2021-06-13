package page;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckboxPage extends PageBase {

    private static final By HEADER = By.cssSelector(".example h3");
    private static final By CHECKBOX_1 = By.xpath(".//form[@id ='checkboxes']/input[1]");
    private static final By CHECKBOX_2 = By.xpath(".//form[@id ='checkboxes']/input[2]");

    public WebElement getHeaderCheckboxPage(){
        return driver.findElement(HEADER);
    }

    public WebElement getFirstCheckbox() {
        return driver.findElement(CHECKBOX_1);
    }

    public WebElement getSecondCheckbox() {
        return driver.findElement(CHECKBOX_2);
    }

    public void selectCheckbox(Checkbox checkbox) {
        switch (checkbox) {
            case FIRST:
                select(getFirstCheckbox());
                break;
            case SECOND:
                select(getSecondCheckbox());
                break;
        }
    }

    private void select(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    public enum Checkbox {
        FIRST, SECOND;
    }
}
