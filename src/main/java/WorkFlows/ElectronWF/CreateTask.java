package WorkFlows.ElectronWF;

import Extentions.Electron_Actions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class CreateTask extends CommonOps {


    @Step("WorkFlows: Start create task")
    public static boolean createTask(String taskName, String color){
        colorPicker(color);
        createTaskByName(taskName);
        insertTask();
        return VerifyCreate(taskName);
    }

    @Step("Verify task created")
    private static boolean VerifyCreate(String taskName) {
        toDoMainPage.getTaskText();

        for (WebElement name : toDoMainPage.getTaskText()) {
            if(name.getText().equals(taskName))
                return true;
        }
        return false;
    }

    @Step("Create task - Insert task info")
    private static void createTaskByName(String taskName) {
        toDoMainPage.getTaskField().sendKeys(taskName);
    }

    @Step("Create task - Choose task color")
    private static void colorPicker(String color) {
        toDoMainPage.getOpenColorsList().click();
        toDoMainPage.getColorsList().get(Electron_Actions.colorToNum(color.toLowerCase(Locale.ROOT))).click();
    }

    @Step("Create task - Send Enter key to insert the task")
    private static void insertTask(){
        toDoMainPage.getTaskField().click();
        actions.sendKeys(Keys.ENTER).build().perform();
    }
}
