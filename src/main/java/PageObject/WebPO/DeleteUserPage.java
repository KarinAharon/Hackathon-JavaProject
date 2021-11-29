package PageObject.WebPO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeleteUserPage {

    @FindBy(xpath = "//tbody/tr") private List<WebElement> listOfAllUsers;
    @FindBy(xpath = "//button[@aria-label='Confirm Modal Danger Button']") private WebElement approveDeleteBtn;

    public WebElement getSearch() {
        return search;
    }

    @FindBy(xpath = "//input[@placeholder='Search user by login, email or name']") private WebElement search;

    public WebElement getApproveDeleteBtn() {
        return approveDeleteBtn;
    }

    public List<WebElement> getListOfAllUsers() {
        return listOfAllUsers;
    }


}
