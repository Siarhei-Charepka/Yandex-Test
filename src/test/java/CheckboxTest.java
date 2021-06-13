import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CheckboxPage;

import static page.CheckboxPage.Checkbox.FIRST;
import static page.CheckboxPage.Checkbox.SECOND;

public class CheckboxTest extends TestBase {

    private  CheckboxPage checkboxPage;

    @BeforeMethod
    public void openCheckboxPage(){
        checkboxPage = homePage.moveToCheckboxPage();
    }

    @Test
    public void checkLocationCheckboxPageTest(){
        Assert.assertTrue(checkboxPage.getHeaderCheckboxPage().isDisplayed());
    }

    @Test
    public void checkboxDefaultConditionTest() {
        Assert.assertFalse(checkboxPage.getFirstCheckbox().isSelected());
        Assert.assertTrue(checkboxPage.getSecondCheckbox().isSelected());
    }

    @Test
    public void selectedCheckboxTest() {
        checkboxPage.selectCheckbox(FIRST);
        checkboxPage.selectCheckbox(SECOND);
        Assert.assertTrue(checkboxPage.getFirstCheckbox().isSelected());
        Assert.assertTrue(checkboxPage.getSecondCheckbox().isSelected());
    }
}