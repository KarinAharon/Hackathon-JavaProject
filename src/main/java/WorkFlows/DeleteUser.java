package WorkFlows;

import Extentions.UI_Actions;
import PageObject.DeleteUserPage;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.testng.Assert;

public class DeleteUser extends CommonOps {

    @Step("full create user")
    public static void deleteUser(String userName) {
        moveToUsersConfiguration();
        selUserByUserName(userName);
        UI_Actions.click(deleteUserPage.getApproveDeleteBtn());
        searchByUser(userName);
    }

    @Step("verify user delete")
    public static void searchByUser(String userName) {
        UI_Actions.sendKey(deleteUserPage.getSearch(), userName);
        Assert.assertFalse(deleteUserPage.getListOfAllUsers().size() > 0);
    }
}
