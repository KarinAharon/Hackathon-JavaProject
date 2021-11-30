package PageObject.WebPO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftBarPage {

    @FindBy(xpath = "//a[@aria-label='Configuration']") private WebElement settingsLogo;
    @FindBy(xpath = "//span[@class='css-vy1tg3']/img") private WebElement avatarLogo;
    @FindBy(xpath = "//a[@href='/logout']") private WebElement logOut;
    @FindBy(xpath = "//a[@href='/org/users']") private WebElement settingsLogoUsers;
    @FindBy(xpath = "//a[@href='/org/teams']") private WebElement teams;
    @FindBy(xpath = "//a[@aria-label='Server Admin']") private WebElement serverAdmin;
    @FindBy(xpath = "//li[2]/a[@href='/admin/users']") private WebElement serverAdminUsers;
    @FindBy(xpath = "//div/ul[@role='menu']/li[1]/a[@href='/profile']") private WebElement connectedUserProfile;

    public WebElement getConnectedUserProfile() {
        return connectedUserProfile;
    }

    public WebElement getSettingsLogo() {
        return settingsLogo;
    }

    public WebElement getAvatarLogo() {
        return avatarLogo;
    }

    public WebElement getLogOut() {
        return logOut;
    }

    public WebElement getSettingsLogoUsers() {
        return settingsLogoUsers;
    }

    public WebElement getTeams() {
        return teams;
    }

    public WebElement getServerAdmin() {
        return serverAdmin;
    }

    public WebElement getServerAdminUsers() {
        return serverAdminUsers;
    }
}
