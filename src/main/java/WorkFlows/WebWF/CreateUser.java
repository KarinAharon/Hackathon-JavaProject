package WorkFlows.WebWF;

import Extentions.UI_Actions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

public class CreateUser extends CommonOps {

    @Step("Start create user WorkFlows")
    public static void createNewUser(String name, String email, String user, String password) {

        moveToUsersServerAdmin();
        newUser();
        insertNewUserDetails(name, email, user, password);
        createUser();
        searchNewUser(user);
    }

    @Step("Verify new users")
    public static void searchNewUser(String userName) {
        initSoft();
        UI_Actions.sendKey(createUserPage.getSearch(), userName);
        soft.assertEquals(createUserPage.getSearchResult().getText(), userName);
    }


    @Step("Mouse over server and click users")
    public static void moveToUsersServerAdmin() {
        actions = new Actions(driver);
        UI_Actions.mouseOverAndPeek(actions, leftBarPage.getServerAdmin(), leftBarPage.getServerAdminUsers());
    }


    @Step("Click on newUser button")
    public static void newUser() {
        UI_Actions.click(createUserPage.getNewUserBtn());
    }

    @Step("Insert details of new user")
    public static void insertNewUserDetails(String name, String email, String user, String password) {
        UI_Actions.sendKey(createUserPage.getName(), name);
        UI_Actions.sendKey(createUserPage.getEmail(), email);
        UI_Actions.sendKey(createUserPage.getUserName(), user);
        UI_Actions.sendKey(createUserPage.getPassword(), password);
    }

    @Step("Click on createUser button")
    public static void createUser() {
        UI_Actions.click(createUserPage.getCreateUserBtn());
    }

}
