package TestCases;

import Utilities.CommonOps;
import org.testng.Assert;
import org.testng.annotations.Test;

import static WorkFlows.ElectronWF.CreateTask.createTask;
import static WorkFlows.ElectronWF.DeleteTask.deleteAllTask;
import static WorkFlows.ElectronWF.DeleteTaskByName.deleteTaskByName;


public class ElectronTest extends CommonOps {

    @Test(description = "create tasks")
    public void test01_createNewTask(){
        Assert.assertTrue(createTask("Do Home Work", "red"));
        Assert.assertTrue(createTask("Wash the dishes", "blue"));
        Assert.assertTrue(createTask("Make food", "green"));
    }
    @Test(description = "delete task by name")
    public void test02_delTaskByName(){
        Assert.assertTrue(deleteTaskByName("Wash the dishes"));
    }

    @Test(description = "delete all tasks")
    public void test03_delAllTask(){
        Assert.assertTrue(deleteAllTask());
    }


}
