package Utilities;

import Extentions.UI_Actions;
import PageObject.DesktopPO.CalcPage;
import PageObject.WebPO.CreateUserPage;
import PageObject.WebPO.DeleteUserPage;
import PageObject.WebPO.LeftBarPage;
import PageObject.WebPO.LoginPage;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import org.junit.Rule;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import java.util.concurrent.TimeUnit;

import static Extentions.Desktop_Actions.clickCalc;


public class CommonOps extends Base {

    @BeforeClass(description = "open driver")
    public void startSession() throws IOException {
        switch (ExternalFiles.getData("Platform")){
            case "Desktop":
                initDesktop();
                break;
            case "Web":
                initWeb();
                break;
            case "API":
                initApi();
                break;
            case "Appium":
                break;
            case "Electron":
                break;
        }


    }

    // @Rule public TestName name = new TestName();

    //"init API"
    public void initApi() {
        initAdminApiUrl();
        initReq();
        initParams();
    }

   //("init web")
    private void initWeb() {
        //name.getMethodName();
        createWebSiteDriver();
        enterURL();
        createPageObject();
        insertLoginDetails();
        imWait();
        logIn();
    }

    //page management
    public void createPageObject() {
        switch (ExternalFiles.getData("Platform")){
            case "Desktop":
                calcPage = PageFactory.initElements(driverDesktop, CalcPage.class);
                break;

            case "Web":
                loginPage = PageFactory.initElements(driver, LoginPage.class);
                leftBarPage = PageFactory.initElements(driver, LeftBarPage.class);
                createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
                deleteUserPage = PageFactory.initElements(driver, DeleteUserPage.class);
                break;

            case "API":

                break;
            case "Appium":
                break;
            case "Electron":
                break;
        }


    }


    //Create chrome driver
    public void createWebSiteDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //enter chrome website
    public static void enterURL() {
        driver.get(ExternalFiles.getData("Url"));
    }

    //init action
    public static void initAction() {
        actions = new Actions(driver);
    }

    //init soft
    public static void initSoft() {
        soft = new SoftAssert();
    }

    //implicitly wait
    public static void imWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @AfterMethod
    public static void navigateToHomePage() {
        if(ExternalFiles.getData("Platform").equals("Web"))
            driver.get(ExternalFiles.getData("UrlMain"));
    }


    @AfterClass
    public void closeSession() {
        if(ExternalFiles.getData("Platform").equals("Desktop"))
            driverDesktop.quit();
        else if(ExternalFiles.getData("Platform").equals("Web"))
            driver.quit();


    }


    //API

    //Init request
    private void initReq() {
        req = RestAssured.given();
        req.header("Content-Type", "application/json");

    }

    //Init Api url
    public void initAdminApiUrl() {
        baseAdminURL = ExternalFiles.getData("UrlAdminAPI");
        RestAssured.baseURI = baseAdminURL;

    }

    //inti jason params
    public void initParams() {
        params = new JSONObject();


    }

    //Desktop

    //init desktop application
    public void initDesktop() throws IOException {
        initSignature();
        initCapabilities();
        createPageObject();


    }

    //init capabilities
    public void initCapabilities() throws IOException {

        capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", calcApp);
        driverDesktop = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);

    }

    //init signature
    public void initSignature() {
        calcApp = ExternalFiles.getData("Signature");
        System.out.println(calcApp);
    }


    //login web
    @Step("click on logIn button")
    public static void logIn() {
        UI_Actions.click(loginPage.getLogIn());
        UI_Actions.click(loginPage.getSkip());
    }

    @Step("login: insert user name and password")
    public static void insertLoginDetails() {
        UI_Actions.sendKey(loginPage.getUserName(), ExternalFiles.getData("UserName"));
        UI_Actions.sendKey(loginPage.getPassword(), ExternalFiles.getData("Password"));

    }
}