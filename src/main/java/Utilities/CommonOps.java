package Utilities;

import Extentions.UI_Actions;
import PageObject.CreateUserPage;
import PageObject.DeleteUserPage;
import PageObject.LeftBarPage;
import PageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class CommonOps extends Base{

    @BeforeClass(description = "open driver")
    public void startSession() {


        createWebSiteDriver();
        enterURL();
        createPageObject();
        insertLoginDetails();
        imWait();
        logIn();

    }

    @Step("Create LoginPage object")
    public void createPageObject() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        leftBarPage = PageFactory.initElements(driver, LeftBarPage.class);
        createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
        deleteUserPage = PageFactory.initElements(driver, DeleteUserPage.class);
    }

    @Step("Create chrome driver")
    public void createWebSiteDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Step("enter chrome website")
    public static void enterURL() {
        driver.get(ExternalFiles.getData("Url"));
    }

    @Step("init action")
    public static void initAction(){
        actions = new Actions(driver);
    }

    @Step("init soft")
    public static void initSoft(){
        soft = new SoftAssert();
    }



    //Login Page
    @Step("login: insert user name and password")
    public static void insertLoginDetails(){
        UI_Actions.sendKey(loginPage.getUserName(),ExternalFiles.getData("UserName"));
        UI_Actions.sendKey(loginPage.getPassword(),ExternalFiles.getData("Password") );

    }

    @Step("click on logIn button")
    public static void logIn(){
        UI_Actions.click(loginPage.getLogIn());
        UI_Actions.click(loginPage.getSkip());
    }

    @Step("implicitly wait")
    public static void imWait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    //Left Bar Page

    @Step("move from server admin to users")
    public static void moveToUsersServerAdmin(){
        actions = new Actions(driver);
        UI_Actions.mouseOverAndPeek(actions,leftBarPage.getServerAdmin(), leftBarPage.getServerAdminUsers());
    }

    //Create User Page

    @Step("click on newUser button")
    public static void newUser(){
        UI_Actions.click(createUserPage.getNewUserBtn());
    }

    @Step("insert details of new user")
    public static void insertNewUserDetails(String name, String email, String user, String password){
        UI_Actions.sendKey(createUserPage.getName(),name);
        UI_Actions.sendKey(createUserPage.getEmail(),email);
        UI_Actions.sendKey(createUserPage.getUserName(),user);
        UI_Actions.sendKey(createUserPage.getPassword(),password);
    }

    @Step("click on createUser button")
    public static void createUser(){
        UI_Actions.click(createUserPage.getCreateUserBtn());
    }

    //Delete User Page

    @Step("move from Configuration to users")
    public static void moveToUsersConfiguration(){
        actions = new Actions(driver);
        UI_Actions.mouseOverAndPeek(actions,leftBarPage.getSettingsLogo(), leftBarPage.getSettingsLogoUsers());
    }

    @Step("delete user by usernamr")
    public static void selUserByUserName(String userName){
        for (WebElement user :
                deleteUserPage.getListOfAllUsers()) {
            if(user.findElement(By.xpath("./td[2]")).getText().equals(userName))
                UI_Actions.click(user.findElement(By.xpath("./td[7]")));
        }
    }

    @AfterMethod
    public static void navigateToHomePage(){
        driver.get(ExternalFiles.getData("UrlMain"));
    }


    @AfterClass
    public void closeSession(){
        driver.quit();
    }


}
