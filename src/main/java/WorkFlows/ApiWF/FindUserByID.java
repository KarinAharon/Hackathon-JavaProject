package WorkFlows.ApiWF;

import Utilities.CommonOps;
import io.qameta.allure.Step;

public class FindUserByID extends CommonOps {

    @Step
    public static int findUserByID(String id){
        initUserApiUrl();
        initReq();
        initResReq(id);
        printUserInfo();

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


}
