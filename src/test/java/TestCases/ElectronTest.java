package TestCases;

import Utilities.CommonOps;
import org.testng.Assert;
import org.testng.annotations.Test;

import static WorkFlows.ElectronWF.CreateTask.createTask;
import static WorkFlows.ElectronWF.DeleteTask.deleteAllTask;
import static WorkFlows.ElectronWF.DeleteTaskByName.deleteTaskByName;


public class ElectronTest extends CommonOps {

    @Test
    public void test01_createNewTask(){
        Assert.assertTrue(createTask("Do Home Work", "red"));
        Assert.assertTrue(createTask("Do Home Work2", "blue"));
        Assert.assertTrue(createTask("Do Home Work3", "green"));
    }

    @Test
    public void test02_delAllTask(){
        Assert.assertTrue(deleteAllTask());
    }

    @Test
    public void test03_delTaskByName(){
        Assert.assertTrue(deleteTaskByName("Do Home Work2"));
    }
}
