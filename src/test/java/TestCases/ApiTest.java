package TestCases;

import Utilities.CommonOps;
import WorkFlows.ApiWF.CreateUserApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import static WorkFlows.ApiWF.FindUserByID.findUserByID;
import static WorkFlows.ApiWF.UpdateUser.updateUserByID;


public class ApiTest extends CommonOps {
    @Test(description = "Post: Create new user")
    public void Test1_CreateUser(){
        CreateUserApi.post("Ilan","Ilan@gmail.com","Ilan","12345");
        Assert.assertEquals(CreateUserApi.responseCode(),200);

    }
    @Test(description = "Get: find user by id")
    public void Test02_GetUserByID(){
        Assert.assertEquals(findUserByID("1"), 200);
    }

    @Test(description = "Put: update details of any user by id")
    public void Test03_UpdateUserByID(){
        Assert.assertEquals(updateUserByID("14", "Ilgan","Il33an@gmail.com","Ilgan","12r345"), 200);
    }


}
