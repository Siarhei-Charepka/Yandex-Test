package page;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class DataTablesPage extends PageBase {

    private final By HEADER = By.cssSelector(".example h3");
    private final By LAST_NAME_HEADER_LOCATOR = By.xpath(".//span[contains(text() , 'Last Name')][1]");
    private final By LAST_NAMES_LOCATOR = By.cssSelector("#table1 tbody tr");

    public WebElement getHeaderDataTablesPage(){
        return driver.findElement(HEADER);
    }

    public void clickLastNameHeader(){
        driver.findElement(LAST_NAME_HEADER_LOCATOR).click();
    }

    public List<String> getLastNamesValue() {
       return driver.findElements(LAST_NAMES_LOCATOR).stream().map(WebElement::getText)
                .sorted().collect(Collectors.toList());
    }
}
