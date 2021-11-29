package WorkFlows.DesktopWF;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static Extentions.Desktop_Actions.clickCalc;

public class CalcAdd extends CommonOps {

    @Step("Perform an arithmetic operation")
    public static int numbersToAdd(int num1, String operator, int num2){
        numberToWebElement(num1);
        operators(operator);
        numberToWebElement(num2);
        return getResult();

    }

    @Step
    public static void numberToWebElement(int number) {
        switch (number) {
            case 0:
                clickCalc(calcPage.getZero());
                break;
            case 1:
                clickCalc(calcPage.getOne());
                break;
            case 2:
                clickCalc(calcPage.getTwo());
                break;
            case 3:
                clickCalc(calcPage.getThree());
                break;
            case 4:
                clickCalc(calcPage.getFour());
                break;
            case 5:
                clickCalc(calcPage.getFive());
                break;
            case 6:
                clickCalc(calcPage.getSix());
                break;
            case 7:
                clickCalc(calcPage.getSeven());
                break;
            case 8:
                clickCalc(calcPage.getEight());
                break;
            case 9:
                clickCalc(calcPage.getNine());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + number);
        }

    }


    @Step
    public static void operators(String operator) {
        switch (operator) {
            case "+":
                clickCalc(calcPage.getPlusButton());
                break;

            case "-":
                clickCalc(calcPage.getMinusButton());
                break;

            case "*":
                clickCalc(calcPage.getMultiplyButton());
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

    }

    @Step
    public static int getResult() {
        clickCalc(calcPage.getEqualButton());
        return Integer.parseInt(calcPage.getCalculatorResults().getText().replaceAll("[a-zA-Z' ']",""));

    }



}
