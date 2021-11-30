package WorkFlows.AppiumWF;

import Extentions.Appium_Actions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class PaymentVerify extends CommonOps {

    @Step("get full repayment result")
    public static double getRepaymentResult(String gbp, String years, String rate){
        insertDetails(gbp, years, rate);
        calculate();
        return Appium_Actions.stringToDoubleResult(paymentResult());
    }


    @Step("insert details")
    public static void insertDetails(String gbp, String years, String rate) {
        Appium_Actions.sendKey(mainPage.getGpbFiled(), gbp);
        Appium_Actions.sendKey(mainPage.getYears(), years);
        Appium_Actions.sendKey(mainPage.getRate(), rate);
    }

    @Step("click on calculate button")
    public static void calculate(){
        Appium_Actions.click(mainPage.getCalculateBTN());
    }

    @Step("get payment result")
    public static String paymentResult(){
        return mainPage.getPaymentResult().getText();
    }


}
