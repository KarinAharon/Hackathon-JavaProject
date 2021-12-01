package test1;

import Utilities.AutoListeners;
import Utilities.CommonOps;
import WorkFlows.DesktopWF.CalcAdd;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AutoListeners.class)
public class DesktopTest extends CommonOps {
    @Test
    public void test1calc(){
       int x= CalcAdd.numbersToAdd(3,"*",2);
        Assert.assertEquals(x, 4);
    }
}
