package Extentions;

import io.qameta.allure.Step;
import org.json.simple.JSONObject;



public class API_Actions {

    @Step
    public static void putAction(String key, String value, JSONObject params){
        params.put(key,value);
    }



}
