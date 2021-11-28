package Extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UI_Actions {

    @Step
    public static void click(WebElement elem) {
        elem.click();
    }

    @Step
    public static void sendKey(WebElement elem, String value) {
        elem.clear();
        elem.sendKeys(value);
    }

    @Step
    public static void mouseOver(Actions action, WebElement elem) {
        action.moveToElement(elem).build().perform();

    }

    @Step
    public static void mouseOverAndPeek(Actions action, WebElement elem1, WebElement elem2) {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();


    }
}
