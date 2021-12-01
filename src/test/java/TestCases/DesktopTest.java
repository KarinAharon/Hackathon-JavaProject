package TestCases;

import Utilities.AutoListeners;
import Utilities.CommonOps;
import WorkFlows.DesktopWF.CalcAdd;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class DesktopTest extends CommonOps {
    @Test
    public void test1calc(){
        Assert.assertEquals(CalcAdd.numbersToAdd(3,"*",2), 6);
    }
}
