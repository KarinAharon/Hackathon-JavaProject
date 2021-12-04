package TestCases;

import Utilities.CommonOps;
import WorkFlows.DesktopWF.CalculatePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DesktopTest extends CommonOps {

    @Test(description = "multiply two numbers")
    public void test1calc(){
        Assert.assertEquals(CalculatePage.twoNumbersToCalculate(3,"*",2), 6);
    }
}
