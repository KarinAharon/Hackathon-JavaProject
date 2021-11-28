package WorkFlows;

import Extentions.UI_Actions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class CreateUser extends CommonOps {

    @Step("full create user")
    public static void createNewUser(String name, String email, String user, String password) {
        moveToUsersServerAdmin();
        newUser();
        insertNewUserDetails(name, email, user, password);
        createUser();
        searchNewUser(user);
    }

    @Step("verify new users")
    public static void searchNewUser(String userName) {
        initSoft();
        UI_Actions.sendKey(createUserPage.getSearch(), userName);
        soft.assertEquals(createUserPage.getSearchResult().getText(), userName);
    }


}
