package WorkFlows.DesktopWF;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class CalcAdd extends CommonOps {
    @Step
    public static int numbersToAdd(int num1, String operator, int num2){
        numberToWebElement(num1);
        operators(operator);
        numberToWebElement(num2);
        return getResult();

    }



}
