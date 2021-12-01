package Extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class Desktop_Actions  {

    @Step
    public static void clickCalc(WebElement elem) {
        elem.click();
    }


}
