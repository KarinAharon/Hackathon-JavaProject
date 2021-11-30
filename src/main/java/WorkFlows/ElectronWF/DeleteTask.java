package WorkFlows.ElectronWF;

import Utilities.CommonOps;
import io.qameta.allure.Step;

public class DeleteTask extends CommonOps {

    @Step("WorkFlow: Delete all task")
    public static boolean deleteAllTask(){
        delAllTask();
        return VerifyDel();
    }

    @Step("Verify all task Delete")
    private static boolean VerifyDel() {
        return (toDoMainPage.getTaskText().size() == 0);
    }

    @Step("Delete task by task")
    public static void delAllTask(){
        int numOfTask = toDoMainPage.getDeleteTask().size();
        for (int i = (numOfTask-1); i >= 0; i--) {
            toDoMainPage.getDeleteTask().get(i).click();
        }
    }
}
