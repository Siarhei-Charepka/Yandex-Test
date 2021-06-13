import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DataTablesPage;

import java.util.Collections;
import java.util.List;

public class DataTableTest extends TestBase {

    private DataTablesPage dataTablesPage;

    @BeforeMethod
    public void openDataTableTest() {
        dataTablesPage = homePage.moveToDataTablesPage();
    }

    @Test
    public void checkLocationDataTablesPageTest() {
        Assert.assertTrue(dataTablesPage.getHeaderDataTablesPage().isDisplayed());
    }

    @Test
    public void sortNamesTest() {
        List<String> lastNames = dataTablesPage.getLastNamesValue();
        Collections.sort(lastNames);
        dataTablesPage.clickLastNameHeader();
        List<String> sortedLastNames = dataTablesPage.getLastNamesValue();
        Assert.assertEquals(lastNames, sortedLastNames);
    }
}
