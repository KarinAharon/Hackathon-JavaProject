package WorkFlows.AppiumWF;

import Extentions.Appium_Actions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class monthlyPayment extends CommonOps {


    @Step("Business flow: get full repayment result")
    public static double getRepaymentResult(String gbp, String years, String rate){
        insertDetails(gbp, years, rate);
        calculate();
        return Appium_Actions.stringToDoubleResult(paymentResult());
    }
    @Step("Business flow: get full interest result")
    public static double getInterestResult(String gbp, String years, String rate){
        insertDetails(gbp, years, rate);
        calculate();
        return Appium_Actions.stringToDoubleResult(interestResult());
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


    @Step("get interest result")
    public static String interestResult(){
        return mainPage.getInterestResult().getText();
    }
}
