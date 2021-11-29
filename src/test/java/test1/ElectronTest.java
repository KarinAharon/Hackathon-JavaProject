package test1;

import Utilities.CommonOps;
import org.testng.annotations.Test;

import static WorkFlows.ElectronWF.CreateTask.createTask;
import static WorkFlows.ElectronWF.DeleteTask.deleteAllTask;

public class ElectronTest extends CommonOps {

    @Test
    public void test01_createNewTask(){
        createTask("Do Home Work", "red");
        createTask("Do Home Work", "red");
        createTask("Do Home Work", "red");
        createTask("Do Home Work", "red");
        deleteAllTask();
    }
}
