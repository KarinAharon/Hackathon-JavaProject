package TestCases;

import Utilities.AutoListeners;
import Utilities.DDT;
import WorkFlows.WebWF.CreateUser;
import WorkFlows.WebWF.DeleteUser;
import org.sikuli.script.FindFailed;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Utilities.CommonOps;

import static WorkFlows.WebWF.CreatTeam.createNewUser;
import static WorkFlows.WebWF.CreateDashboard.createDashboard;
import static WorkFlows.WebWF.VerifyNewUserLogIn.verifyNewUserLogIn;

public class SeleniumTest extends CommonOps {

    @Test(dataProvider = "data-provider", description="Create new users by DDL",dataProviderClass = DDT.class)
    public void test01_createNewUser(String name, String email, String user, String password){
        CreateUser.createNewUser(name, email, user, password);
        soft.assertAll();
    }

    @Test(description="Delete user by name")
    public void test02_deleteUser() {
        DeleteUser.deleteUser("henb");
    }

    @Test(description="Verify correct user name and pass from DB")
    public void test3(){
        verifyNewUserLogIn();
        soft.assertAll();
    }

    @Test(description="Create dashboard by sikuli")
    public void test4() throws FindFailed {
        Assert.assertTrue(createDashboard());
    }

    @Test(description="Create new Team")
    public void test5(){
        Assert.assertTrue(createNewUser("MyTeam", "MyTeam@gmail.com"));
    }
}
/*    @Test
    @DisplayName("This is my test")//web
    @Tag("It is my tag")
    void test1(TestInfo testInfo) {
        assertEquals("This is my test", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("It is my tag"));
    }*/