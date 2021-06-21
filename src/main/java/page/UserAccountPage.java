package page;

import base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage extends PageBase {

    @FindBy(css = ".personal")
    private WebElement avatarContainer;

    public UserAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        return avatarContainer.isDisplayed();
    }
}
