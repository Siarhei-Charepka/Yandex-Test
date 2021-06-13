package page;

import base.PageBase;
import org.openqa.selenium.By;

public class HomePage extends PageBase {

    private static final By CHECKBOX_LINK = By.cssSelector("a[href='/checkboxes']");
    private static final By DATA_TABLE_LINK = By.cssSelector("a[href='/tables']");

    public CheckboxPage moveToCheckboxPage(){
        driver.findElement(CHECKBOX_LINK).click();
        return new CheckboxPage();
    }

    public DataTablesPage moveToDataTablesPage(){
        driver.findElement(DATA_TABLE_LINK).click();
        return new DataTablesPage();
    }

}
