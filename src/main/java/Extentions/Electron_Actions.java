package Extentions;

import PageObject.ElectronPO.ToDoMainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Electron_Actions {


    @Step
    public static void mouseOverAndClick(Actions action, WebElement elem) {
        action.moveToElement(elem).click().build().perform();

    }


    @Step
    public static int colorToNum(String color){
        switch (color){
            case "white":
                return 0;
            case "red":
                return 1;
            case "orange":
                return 2;
            case "yellow":
                return 3;
            case "green":
                return 4;
            case "blue":
                return 5;
            case "purple":
                return 6;
            case "gray":
                return 7;
            default: return 0;
        }
    }

}
