package test1;

import Utilities.CommonOps;
import WorkFlows.ApiWF.CreateUserApi;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest extends CommonOps {
    @Test
    public void postTest(){
        CreateUserApi.post("dolev","dolevs@gmail.com","dolevsi","12345");
        Assert.assertEquals(CreateUserApi.responseCode(),200);

    }
}
