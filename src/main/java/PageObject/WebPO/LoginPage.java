package PageObject.WebPO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//input[@name='user']") private WebElement userName;
    @FindBy(xpath = "//input[@id='current-password']") private WebElement password;
    @FindBy(className = "css-1xivtx2-button") private WebElement logIn;
    @FindBy(xpath = "//button[@class='css-1tbo7ox-button']") private WebElement skip;


    public WebElement getSkip() {
        return skip;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogIn() {
        return logIn;
    }
}
