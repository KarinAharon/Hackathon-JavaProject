package WorkFlows.WebWF;

import Extentions.UI_Actions;
import Utilities.CommonOps;
import org.openqa.selenium.interactions.Actions;

public class VerifyNewUserLogIn extends CommonOps {

    public static void verifyNewUserLogIn(){
        initSoft();
        logInNewUser();
    }

    public static void logOut(){
        actions = new Actions(driver);
        UI_Actions.mouseOverAndPeek(actions, leftBarPage.getAvatarLogo(), leftBarPage.getLogOut());
    }

    public static void logInNewUser(){
        int i =0;
        while(i < credentialsUser.size()){
            logOut();
            UI_Actions.sendKey(loginPage.getUserName(), credentialsUser.get(i));
            UI_Actions.sendKey(loginPage.getPassword(), credentialsPass.get(i));
            UI_Actions.click(loginPage.getLogIn());

            UI_Actions.mouseOverAndPeek(actions, leftBarPage.getAvatarLogo(), leftBarPage.getConnectedUserProfile());
            soft.assertEquals(profilePage.getProfileUserName().getAttribute("value"), credentialsUser.get(i++));
        }
    }
}
