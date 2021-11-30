package PageObject.WebPO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {

    @FindBy(xpath = "//input[@name='login']") private WebElement profileUserName;

    public WebElement getProfileUserName() {
        return profileUserName;
    }

}
