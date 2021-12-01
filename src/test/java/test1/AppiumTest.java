package test1;

import Utilities.AutoListeners;
import Utilities.CommonOps;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static WorkFlows.AppiumWF.monthlyPayment.getInterestResult;
import static WorkFlows.AppiumWF.monthlyPayment.getRepaymentResult;

@Listeners(AutoListeners.class)
public class AppiumTest extends CommonOps {

    @Test(description = "Verify repayment result")
    public void test01() {
        Assert.assertEquals(getRepaymentResult("100000", "10", "15"), 1660.43);
    }

    @Test(description = "Verify interest result")
    public void test02() {
        Assert.assertEquals(getInterestResult("100000", "10", "15"), 1250.00);
    }

}
