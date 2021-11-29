package test1;

import WorkFlows.DesktopWF.CalcAdd;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopTest {
    @Test
    public void test1calc(){
       int x= CalcAdd.numbersToAdd(2,"*",2);
        Assert.assertEquals(x, 4);
    }
}
