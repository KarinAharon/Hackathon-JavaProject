package PageObject.AppiumPO;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MainPage {

    @AndroidFindBy(xpath = "//*[@id='etAmount']")
    private WebElement gpbFiled;

    @AndroidFindBy(xpath = "//*[@id='etTerm']")
    private WebElement years;

    @AndroidFindBy(xpath = "//*[@id='etRate']")
    private WebElement rate;

    @AndroidFindBy(xpath = "//*[@id='add_schedule_text']")
    private WebElement calculateBTN;

    @AndroidFindBy(xpath = "//*[@id='tvRepayment']")
    private WebElement paymentResult;

    @AndroidFindBy(xpath = "//*[@id='tvInterestOnly']")
    private WebElement interestResult;

    public WebElement getGpbFiled() {
        return gpbFiled;
    }

    public WebElement getYears() {
        return years;
    }

    public WebElement getRate() {
        return rate;
    }

    public WebElement getCalculateBTN() {
        return calculateBTN;
    }

    public WebElement getPaymentResult() {
        return paymentResult;
    }

    public WebElement getInterestResult() {
        return interestResult;
    }
}
