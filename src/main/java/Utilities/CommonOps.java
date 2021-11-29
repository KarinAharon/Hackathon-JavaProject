package Utilities;

import Extentions.UI_Actions;
import PageObject.DesktopPO.CalcPage;
import PageObject.ElectronPO.ToDoMainPage;
import PageObject.WebPO.CreateUserPage;
import PageObject.WebPO.DeleteUserPage;
import PageObject.WebPO.LeftBarPage;
import PageObject.WebPO.LoginPage;
import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


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
                initAppium();
                break;
            case "Electron":
                initElectron();
                break;
        }


    }

    // @Rule public TestName name = new TestName();

    //init API
    public void initApi() {
        initAdminApiUrl();
        initReq();
        initParams();
    }

   //init web
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
                toDoMainPage = PageFactory.initElements(driver, ToDoMainPage.class);
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
        else if(ExternalFiles.getData("Platform").equals("Appium"))
            driverAndroid.quit();
        else if(ExternalFiles.getData("Platform").equals("Web") || ExternalFiles.getData("Platform").equals("Electron"))
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

    //Electron
    public void initElectron(){
        initElectronCapability();
        initAction();
        createPageObject();

    }

    public void initElectronCapability(){
        System.setProperty("webdriver.chrome.driver", "C:/Automation/electrondriver.exe");
        opt = new ChromeOptions();
        opt.setBinary("C:/todolist/Todolist.exe");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("chromeOptions", opt);
        capabilities.setBrowserName("chrome");
        opt.merge(capabilities);
        driver = new ChromeDriver(capabilities);
        imWait();
        Uninterruptibles.sleepUninterruptibly(8, TimeUnit.SECONDS);

    }
    
    //Appium
    private void initAppium() throws MalformedURLException {
        initAppiumCapability();
        initAppiumDriver();
        createPageObject();
    }

    private void initAppiumDriver() throws MalformedURLException {
        driverAndroid = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        driverAndroid.setLogLevel(Level.INFO);
    }

    private void initAppiumCapability() {
        capabilities.setCapability("reportDirectory", ExternalFiles.getData("ReportDirectory"));
        capabilities.setCapability("reportFormat", ExternalFiles.getData("ReportFormat"));
        capabilities.setCapability("testName", ExternalFiles.getData("TestName"));
        capabilities.setCapability(MobileCapabilityType.UDID, "207adae9");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "kr.sira.unit");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Intro");
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