package test1;

import Utilities.CommonOps;
import org.testng.Assert;
import org.testng.annotations.Test;

import static WorkFlows.AppiumWF.PaymentVerify.getRepaymentResult;

public class AppiumTest extends CommonOps {

    @Test
    public void test01() {
        Assert.assertEquals(getRepaymentResult("100000", "10", "15"), 1660.43);
    }
}
