package WorkFlows.ElectronWF;

import Utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DeleteTask extends CommonOps {

    @Step("Delete all task")
    public static void deleteAllTask(){
        int numOfTask = toDoMainPage.getDeleteTask().size();
        for (int i = (numOfTask-1); i >= 0; i--) {
            toDoMainPage.getDeleteTask().get(i).click();
        }
    }
}
