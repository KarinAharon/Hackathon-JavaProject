package WorkFlows.WebWF;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.sikuli.script.FindFailed;

public class CreateDashboard extends CommonOps {


    @Step
    public static boolean createDashboard() throws FindFailed {
        boolean temp = createDashboardByImg();
        homePage();
        return temp;
    }

    @Step
    public static boolean createDashboardByImg() throws FindFailed{
        screen.hover(impPath + "plus.png");
        screen.click(impPath + "dashboard.png");
        screen.click(impPath + "addDash.png");
        if(screen.exists(impPath + "verify_IMG.png").toString().isEmpty()){
            return false;
        }
        return true;
    }

    @Step
    public static void homePage() throws FindFailed {
        screen.click(impPath + "homePage.png");
        screen.click(impPath + "finalSave.png");
    }
}
