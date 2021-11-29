package test1;

import Utilities.AutoListeners;
import Utilities.DDT;
import WorkFlows.WebWF.CreateUser;
import WorkFlows.WebWF.DeleteUser;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Utilities.CommonOps;

@Listeners(AutoListeners.class)
public class SeleniumTest extends CommonOps {
    @Test(dataProvider = "data-provider", dataProviderClass = DDT.class)
    public void test01_createNewUser(String name, String email, String user, String password){
        CreateUser.createNewUser(name, email, user, password);
        soft.assertAll();
    }

    @Test()
    public void test02_deleteUser() {
        DeleteUser.deleteUser("karina");
    }

}
/*    @Test
    @DisplayName("This is my test")//web
    @Tag("It is my tag")
    void test1(TestInfo testInfo) {
        assertEquals("This is my test", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("It is my tag"));
    }*/