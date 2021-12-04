package TestCases;

import Utilities.CommonOps;
import org.testng.Assert;
import org.testng.annotations.Test;

import static WorkFlows.ElectronWF.CreateTask.createTask;
import static WorkFlows.ElectronWF.DeleteTask.deleteAllTask;
import static WorkFlows.ElectronWF.DeleteTaskByName.deleteTaskByName;


public class ElectronTest extends CommonOps {

    @Test(description = "create new task")
    public void test01_createNewTask(){
        Assert.assertTrue(createTask("Do Home Work", "red"));
        Assert.assertTrue(createTask("Make food", "blue"));
        Assert.assertTrue(createTask("Wash dishes", "green"));
    }

    @Test(description = "delete task by name")
    public void test03_delTaskByName(){
        Assert.assertTrue(deleteTaskByName("Make food"));
    }

    @Test(description = "delete all tasks")
    public void test02_delAllTask(){
        Assert.assertTrue(deleteAllTask());
    }


}
