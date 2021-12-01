package WorkFlows.WebWF;

import Extentions.UI_Actions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CreatTeam extends CommonOps {

    @Step("WebFlow: create Team ")
    public static boolean createNewTeam(String name, String email) {

        moveToUsersSettingTeam();
        newTeam();
        insertNewTeamDetails(name, email);
        createTeam();
        moveToUsersSettingTeam();
        return verifyNewTeam(name);
    }

    private static void newTeam() {
        UI_Actions.click(newTeamPage.getNewTeamBtn());
    }

    private static boolean verifyNewTeam(String team) {
        for (WebElement name: newTeamPage.getListOfTeamsNames()) {
            if(name.getText().equals(team))
                return true;
        }
        return false;
    }

    private static void createTeam() {
        UI_Actions.click(newTeamPage.getCreateBtn());
    }

    private static void insertNewTeamDetails(String name, String email) {
        UI_Actions.sendKey(newTeamPage.getTeamName(), name);
        UI_Actions.sendKey(newTeamPage.getTeamEmail(), email);

    }

    private static void moveToUsersSettingTeam() {
        actions = new Actions(driver);
        UI_Actions.mouseOverAndPeek(actions, leftBarPage.getSettingsLogo(), leftBarPage.getTeams());
    }
}
