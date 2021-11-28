package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftBarPage {

    @FindBy(xpath = "//a[@aria-label='Configuration']") private WebElement settingsLogo;
    @FindBy(xpath = "//a[@aria-label='admin']") private WebElement avatarLogo;
    @FindBy(xpath = "//a[@href='/logout']") private WebElement logOut;
    @FindBy(xpath = "//a[@href='/org/users']") private WebElement settingsLogoUsers;
    @FindBy(xpath = "//a[@href='/org/teams']") private WebElement teams;
    @FindBy(xpath = "//a[@aria-label='Server Admin']") private WebElement serverAdmin;
    @FindBy(xpath = "//li[2]/a[@href='/admin/users']") private WebElement serverAdminUsers;

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
