package TestCases;

import Utilities.AutoListeners;
import Utilities.CommonOps;
import WorkFlows.ApiWF.CreateUserApi;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static WorkFlows.ApiWF.FindUserByID.findUserByID;
import static WorkFlows.ApiWF.UpdateUser.updateUserByID;


public class ApiTest extends CommonOps {
    @Test
    public void Test1_CreateUser(){
        CreateUserApi.post("Ilan","Ilan@gmail.com","Ilan","12345");
        Assert.assertEquals(CreateUserApi.responseCode(),200);

    }
    @Test
    public void Test02_GetUserByID(){
        Assert.assertEquals(findUserByID("1"), 200);
    }

    @Test
    public void Test03_UpdateUserByID(){
        Assert.assertEquals(updateUserByID("14", "Ilgan","Il33an@gmail.com","Ilgan","12r345"), 200);
    }


}
