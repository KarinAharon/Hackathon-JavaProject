package WorkFlows.ApiWF;

import Extentions.API_Actions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class CreateUserApi extends CommonOps {

    @Step("Post - Create new user")
    public static void post(String name,String email,String login,String password) {

        API_Actions.putAction("name", name,params);
        API_Actions.putAction("email", email,params);
        API_Actions.putAction("login", login,params);
        API_Actions.putAction("password", password,params);
        postAction();

    }
    @Step
    public static void postAction(){
        req.body(params.toJSONString());
        res = req.post(baseAdminURL);
    }

    @Step
    public static int responseCode(){
        return res.getStatusCode();
    }
}