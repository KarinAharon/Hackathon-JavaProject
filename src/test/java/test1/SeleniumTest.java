package test1;

import Utilities.DDT;
import org.testng.annotations.Test;
import Utilities.CommonOps;

public class SeleniumTest extends CommonOps {
    @Test(dataProvider = "data-provider", dataProviderClass = DDT.class)
    public void test01_createNewUser(String name, String email, String user, String password){
        System.out.println(name);
        System.out.println(email);
        System.out.println(user);
        System.out.println(password);
        moveToUsersServerAdmin();
        newUser();
        insertNewUserDetails(name, email, user, password);
        createUser();
    }

}
