package PageObject.ElectronPO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ToDoMainPage {

    @FindBy(xpath = "//span[@class='dateFormatted_3GjaR']") private WebElement date;
    @FindBy(xpath = "//input[@placeholder='Create a task']") private WebElement taskField;
    @FindBy(xpath = "//*[name()='svg'][@class='destroy_19w1q']") private WebElement deleteTask;
    @FindBy(xpath = "//div[@class='taskWrapper_2u8dN']") private List<WebElement> tasksList;
    @FindBy(xpath = "//div[@class='topWrapper_2caNE']/*[name()='svg']") private WebElement openColorsList;
    @FindBy(xpath = "//div[@class='wrapper_3Kpfj vertical_di1oV tagList_2NRe0']/span") private List<WebElement> colorsList;

    public WebElement getTaskField() {
        return taskField;
    }

    public WebElement getDate() {
        return date;
    }

    public WebElement getDeleteTask() {
        return deleteTask;
    }

    public List<WebElement> getTasksList() {
        return tasksList;
    }

    public WebElement getOpenColorsList() {
        return openColorsList;
    }

    public List<WebElement> getColorsList() {
        return colorsList;
    }
}
