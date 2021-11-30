package WorkFlows.WebWF;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.sikuli.script.FindFailed;

public class CreateDashboard extends CommonOps {

    @Step
    public static void createDashboard() throws FindFailed {
        screen.click(impPath + "plus.png");
        screen.click(impPath + "dashboard.png");
        screen.click(impPath + "addDash.png");
        System.out.println(screen.exists(impPath + "verify.png"));

    }
}
