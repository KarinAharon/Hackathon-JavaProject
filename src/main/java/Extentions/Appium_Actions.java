package Extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class Appium_Actions {


    @Step("string to double converter")
    public static Double stringToDoubleResult(String result){
      return Double.parseDouble(result.replaceAll("[£]", ""));
    }

    @Step("click")
    public static void click(WebElement elem){
        elem.click();
    }

    @Step("sendKey")
    public static void sendKey(WebElement elem, String value){
        elem.sendKeys(value);
    }


}
