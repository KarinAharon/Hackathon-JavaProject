package test1;

import Utilities.CommonOps;
import org.testng.annotations.Test;

import static WorkFlows.ElectronWF.CreateTask.createTask;

public class ElectronTest extends CommonOps {

    @Test
    public void test01_createNewTask(){
       createTask("Do Home Work", "red");
    }
}
