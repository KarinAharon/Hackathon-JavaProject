package test1;

import Utilities.AutoListeners;
import Utilities.DDT;
import WorkFlows.CreateUser;
import WorkFlows.DeleteUser;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Utilities.CommonOps;

@Listeners(AutoListeners.class)
public class SeleniumTest extends CommonOps {
    @Test(dataProvider = "data-provider", dataProviderClass = DDT.class)
    public void test01_createNewUser(String name, String email, String user, String password) {
        CreateUser.createNewUser(name, email, user, password);
        soft.assertAll();
    }

    @Test()
    public void test02_deleteUser() {
        DeleteUser.deleteUser("karina");
    }

}
