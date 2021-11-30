package Extentions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Appium_Actions {

    @Step("string to double converter")
    public static Double stringToDoubleResult(String result) {
        return Double.parseDouble(result.replaceAll("[£]", ""));
    }

    @Step("click")
    public static void click(WebElement elem) {
        elem.click();
    }

    @Step("sendKey")
    public static void sendKey(WebElement elem, String value) {
        elem.clear();
        elem.sendKeys(value);
    }



}
