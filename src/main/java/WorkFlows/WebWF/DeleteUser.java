package WorkFlows.WebWF;

import Extentions.UI_Actions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DeleteUser extends CommonOps {

    @Step("Start delete user WorkFlows")
    public static void deleteUser(String userName) {
        moveToUsersConfiguration();
        selUserByUserName(userName);
        UI_Actions.click(deleteUserPage.getApproveDeleteBtn());
        searchByUser(userName);
    }

    @Step("Delete user - Verify user delete")
    public static void searchByUser(String userName) {
        UI_Actions.sendKey(deleteUserPage.getSearch(), userName);
        Assert.assertFalse(deleteUserPage.getListOfAllUsers().size() > 0);
    }
    @Step("Delete user - Move from Configuration to users")
    public static void moveToUsersConfiguration() {
        actions = new Actions(driver);
        UI_Actions.mouseOverAndPeek(actions, leftBarPage.getSettingsLogo(), leftBarPage.getSettingsLogoUsers());
    }

    @Step("Delete user - Delete user by username")
    public static void selUserByUserName(String userName) {
        for (WebElement user :
                deleteUserPage.getListOfAllUsers()) {
            if (user.findElement(By.xpath("./td[2]")).getText().equals(userName))
                UI_Actions.click(user.findElement(By.xpath("./td[7]")));
        }
    }

}
