package PageObject.WebPO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {

    @FindBy(xpath = "//*[@class='css-1mhnkuh']") private WebElement newUserBtn;
    @FindBy(xpath = "//input[@name='login']") private WebElement userName;
    @FindBy(xpath = "//input[@name='password']") private WebElement password;
    @FindBy(xpath = "//input[@name='name']") private WebElement name;
    @FindBy(xpath = "//input[@name='email']") private WebElement email;
    @FindBy(xpath = "//button[@type='submit']") private WebElement createUserBtn;
    @FindBy(xpath = "//input[@placeholder='Search user by login, email, or name.']") private WebElement search;
    @FindBy(xpath = "//tbody/tr/td[2]/a") private WebElement searchResult;

    public WebElement getSearchResult() {
        return searchResult;
    }

    public WebElement getNewUserBtn() {
        return newUserBtn;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getCreateUserBtn() {
        return createUserBtn;
    }

    public WebElement getSearch() {
        return search;
    }
}
