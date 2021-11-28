package Utilities;

import Extentions.UI_Actions;
import PageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
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

    @Step("Create page object")
    public void createPageObject() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
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


    @Step
    public static void insertLoginDetails(){
        UI_Actions.sendKey(loginPage.getUserName(),ExternalFiles.getData("UserName"));
        UI_Actions.sendKey(loginPage.getPassword(),ExternalFiles.getData("Password") );

    }

    @Step
    public static void logIn(){
        UI_Actions.click(loginPage.getLogIn());
        UI_Actions.click(loginPage.getSkip());
    }

    @Step
    public static void imWait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
