package WorkFlows.ElectronWF;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class DeleteTaskByName extends CommonOps {

    @Step("WorkFlow: Delete task by name")
    public static boolean deleteTaskByName(String taskName){
        deleteTask(taskName);
        return verifyDeleteTask(taskName);

    }

    @Step("Search for task")
    private static void deleteTask(String taskName) {

        for (int i = 0; i < toDoMainPage.getTaskText().size(); i++) {
            if (toDoMainPage.getTaskText().get(i).getText().equals(taskName))
                toDoMainPage.getDeleteTask().get(i).click();
        }

    }

    @Step("Verify task deleted")
    private static boolean verifyDeleteTask(String taskName) {

        for (WebElement name : toDoMainPage.getTaskText()) {
            if(name.getText().equals(taskName))
                return false;
        }
        return true;
    }
}
