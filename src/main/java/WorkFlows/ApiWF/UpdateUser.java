package WorkFlows.ApiWF;

import Extentions.API_Actions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;

public class UpdateUser extends CommonOps {

    @Step
    public static int findUserByID(String id){
        initUserApiUrl();
        initReq();
        initResReq(id);
        printUserInfo();

        return res.getStatusCode();
    }

    @Step
    public static int updateUserByID(String id, String name,String email,String login,String password){
        initUserApiUrl();
        initReq();
        printUserInfo(id, name, email, login, password);

        return res.getStatusCode();
    }


    private static void printUserInfo() {
        System.out.println("Email: " + jp.get("email"));
        System.out.println("login: " + jp.get("login"));
    }

    private static void initResReq(String id) {
        res = req.get("users/" + id);
        jp = res.jsonPath();
    }

    private static void printUserInfo(String id, String name,String email,String login,String password) {
        params = new JSONObject();

        API_Actions.putAction("email", email, params);
        API_Actions.putAction("login", login, params);

        putAction(id);
    }

    public static void putAction(String id){
        req.body(params.toJSONString());
        res = req.put("users/" + id);
    }


}
