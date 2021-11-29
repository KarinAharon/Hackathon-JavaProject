package PageObject.DesktopPO;

import Utilities.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalcPage {

    @FindBy(xpath = "//*[@AutomationId='clearButton']")
    private WebElement clearBtn;

    @FindBy (xpath = "//*[@AutomationId='num0Button']")
    private WebElement zero;

    @FindBy (xpath = "//*[@AutomationId='num1Button']")
    private WebElement one;

    @FindBy (xpath = "//*[@AutomationId='num2Button']")
    private WebElement two;

    @FindBy (xpath = "//*[@AutomationId='num3Button']")
    private WebElement three;

    @FindBy (xpath = "//*[@AutomationId='num4Button']")
    private WebElement four;

    @FindBy (xpath = "//*[@AutomationId='num5Button']")
    private WebElement five;

    @FindBy (xpath = "//*[@AutomationId='num6Button']")
    private WebElement six;

    @FindBy (xpath = "//*[@AutomationId='num7Button']")
    private WebElement seven;

    @FindBy (xpath = "//*[@AutomationId='num8Button']")
    private WebElement eight;

    @FindBy (xpath = "//*[@AutomationId='num9Button']")
    private WebElement nine;

    @FindBy (xpath = "//*[@AutomationId='plusButton']")
    private WebElement plusButton;

    @FindBy (xpath = "//*[@AutomationId='minusButton']")
    private WebElement minusButton;

    @FindBy (xpath = "//*[@AutomationId='multiplyButton']")
    private WebElement multiplyButton;

    @FindBy (xpath = "//*[@AutomationId='equalButton']")
    private WebElement equalButton;

    @FindBy (xpath = "//*[@AutomationId='CalculatorResults']")
    private WebElement CalculatorResults;

    public WebElement getClearBth() {
        return clearBtn;
    }

    public WebElement getZero() {
        return zero;
    }

    public WebElement getOne() {
        return one;
    }

    public WebElement getTwo() {
        return two;
    }

    public WebElement getThree() {
        return three;
    }

    public WebElement getFour() {
        return four;
    }

    public WebElement getFive() {
        return five;
    }

    public WebElement getSix() {
        return six;
    }

    public WebElement getSeven() {
        return seven;
    }

    public WebElement getEight() {
        return eight;
    }

    public WebElement getNine() {
        return nine;
    }

    public WebElement getPlusButton() {
        return plusButton;
    }

    public WebElement getMinusButton() {
        return minusButton;
    }

    public WebElement getMultiplyButton() {
        return multiplyButton;
    }

    public WebElement getEqualButton() {
        return equalButton;
    }

    public WebElement getCalculatorResults() {
        return CalculatorResults;
    }
}
