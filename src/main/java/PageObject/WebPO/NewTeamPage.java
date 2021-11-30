package PageObject.WebPO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewTeamPage {

    @FindBy(xpath = "//span[@class='css-1mhnkuh']") private WebElement newTeamBtn;
    @FindBy(xpath = "//input[@id='team-name']") private WebElement teamName;
    @FindBy(xpath = "//input[@name='email']") private WebElement teamEmail;
    @FindBy(xpath = "//button[@type='submit']") private WebElement createBtn;
    @FindBy(xpath = "//tbody/tr/td[2]/a") private List<WebElement> listOfTeamsNames;

    public List<WebElement> getListOfTeamsNames() {
        return listOfTeamsNames;
    }
//    @FindBy(xpath = "//input[@placeholder='Search members']") private WebElement searchAddMemberToTeam;
//    @FindBy(xpath = "//span[@class='css-1mhnkuh']") private WebElement addMemberToTeamBtn;
//    @FindBy(xpath = "//div[@class='user-picker']") private WebElement addUserPicker;
//    @FindBy(xpath = "//button[@type='submit']") private WebElement addMemberAfterChooseName;

    public WebElement getNewTeamBtn() {
        return newTeamBtn;
    }

    public WebElement getTeamName() {
        return teamName;
    }

    public WebElement getTeamEmail() {
        return teamEmail;
    }

    public WebElement getCreateBtn() {
        return createBtn;
    }
}
