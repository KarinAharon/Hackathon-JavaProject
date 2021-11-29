package WorkFlows.ElectronWF;

import Extentions.Electron_Actions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Locale;

public class CreateTask extends CommonOps {


    @Step
    public static void createTask(String taskName, String color){
        colorPicker(color);
        createTaskByName(taskName);
        insertTask();


    }

    private static void createTaskByName(String taskName) {
        toDoMainPage.getTaskField().sendKeys(taskName);
    }

    private static void colorPicker(String color) {
        toDoMainPage.getOpenColorsList().click();
        toDoMainPage.getColorsList().get(Electron_Actions.colorToNum(color.toLowerCase(Locale.ROOT))).click();
        //System.out.println(Electron_Actions.colorToNum(color));

    }

    private static void insertTask(){
        toDoMainPage.getTaskField().click();
        actions.sendKeys(Keys.ENTER).build().perform();

    }
}
