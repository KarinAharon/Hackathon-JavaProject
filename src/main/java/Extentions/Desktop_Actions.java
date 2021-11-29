package Extentions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Desktop_Actions  {

    @Step
    public static void clickCalc(WebElement elem) {
        elem.click();
    }


}
