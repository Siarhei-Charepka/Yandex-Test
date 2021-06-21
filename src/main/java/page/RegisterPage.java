package page;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends PageBase {

    @FindBy(css = ".registration__wrapper")
    private WebElement registerContainer;

    public RegisterPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed(){
        return registerContainer.isDisplayed();
    }

}
