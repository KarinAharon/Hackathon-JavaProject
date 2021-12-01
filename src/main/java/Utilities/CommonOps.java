package Utilities;

import Extentions.UI_Actions;
import PageObject.AppiumPO.MainPage;
import PageObject.DesktopPO.CalcPage;
import PageObject.ElectronPO.ToDoMainPage;
import PageObject.WebPO.*;
import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;


import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static Utilities.JDBC.*;


public class CommonOps extends Base {

    @BeforeClass(description = "open driver")
    @Parameters({"Platform", "Browser"})
    public void startSession(String platform, String browser) throws IOException {
        switch (platform) {
            case "Desktop":
                initDesktop(platform);
                break;
            case "Web":
                initWeb(platform,browser);
                break;
            case "API":
                initApi();
                break;
            case "Appium":
                initAppium(platform);
                break;
            case "Electron":
                initElectron(platform);
                break;
        }


    }

    // @Rule public TestName name = new TestName();

    //init API
    public void initApi() {
        initReq();
        initParams();
    }

    //init web

    private void initWeb(String platform, String browser) {
        //name.getMethodName();
        createWebSiteDriver(browser);
        enterURL();
        createPageObject(platform);
        insertLoginDetails();
        imWait();
        logIn();
        initUrlDB();
        initScreenSikuli();
    }

    public void initScreenSikuli() {
        screen = new Screen();
        impPath = "C:\\Automation\\new\\Hackathon-JavaProject\\sikuli_IMG\\";
    }

    //page management
    public void createPageObject(String platform) {
        switch (platform) {
            case "Desktop":
                calcPage = PageFactory.initElements(driverDesktop, CalcPage.class);
                break;

            case "Web":
                loginPage = PageFactory.initElements(driver, LoginPage.class);
                leftBarPage = PageFactory.initElements(driver, LeftBarPage.class);
                createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
                deleteUserPage = PageFactory.initElements(driver, DeleteUserPage.class);
                profilePage = PageFactory.initElements(driver, ProfilePage.class);
                newTeamPage = PageFactory.initElements(driver, NewTeamPage.class);
                break;

            case "API":

                break;
            case "Appium":
                mainPage = new MainPage(driverAndroid);
                //mainPage = PageFactory.initElements(driverAndroid, MainPage.class);
                break;
            case "Electron":
                toDoMainPage = PageFactory.initElements(driver, ToDoMainPage.class);
        }


    }


    //Create chrome driver

    public void createWebSiteDriver(String browser) {
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

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

    @BeforeMethod
    public void BeforeMethod(Method method){
        try {
            MonteScreenRecorder.startRecord(method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public static void navigateToHomePage(String platform) {
        if (platform.equals("Web")) {
            driver.get(ExternalFiles.getData("UrlMain"));
            closeDBCon();
        }
    }


    @AfterClass
    public void closeSession() {
        if (ExternalFiles.getData("Platform").equals("Desktop"))
            driverDesktop.quit();
        else if (ExternalFiles.getData("Platform").equals("Appium"))
            driverAndroid.quit();
        else if (ExternalFiles.getData("Platform").equals("Web") || ExternalFiles.getData("Platform").equals("Electron"))
            driver.quit();


    }


    //API

    //Init request
    protected static void initReq() {
        req = RestAssured.given().auth().preemptive().basic("admin", "admin");
        req.header("Content-Type", "application/json");
    }

    //Init admin Api url
    public static void initAdminApiUrl() {
        baseAdminURL = ExternalFiles.getData("UrlAdminAPI");
        RestAssured.baseURI = baseAdminURL;

    }

    //Init user Api url
    public static void initUserApiUrl() {
        baseUserURL = ExternalFiles.getData("UrlAPI");
        RestAssured.baseURI = baseUserURL;
    }

    //inti jason params
    public void initParams() {
        params = new JSONObject();


    }

    //Desktop

    //init desktop application
    public void initDesktop(String platform) throws IOException {
        initSignature();
        initCapabilities();
        createPageObject(platform);


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
    public void initElectron(String platform) {
        initElectronCapability();
        initAction();
        createPageObject(platform);

    }

    public void initElectronCapability() {
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
    private void initAppium(String platform) throws MalformedURLException {
        initAppiumCapability();
        initAppiumDriver();
        createPageObject(platform);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

    private void initAppiumDriver() throws MalformedURLException {
        driverAndroid = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        driverAndroid.setLogLevel(Level.INFO);
    }

    private void initAppiumCapability() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("reportDirectory", ExternalFiles.getData("ReportDirectory"));
        capabilities.setCapability("reportFormat", ExternalFiles.getData("ReportFormat"));
        capabilities.setCapability("testName", ExternalFiles.getData("TestName"));
        capabilities.setCapability(MobileCapabilityType.UDID, "2269b6b83a0d7ece");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.shivgadhia.android.ukMortgageCalc");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");

    }

    //DB
    public void initUrlDB() {
        dbUrl = ExternalFiles.getData("UrlDB");
        usernameDB = ExternalFiles.getData("UserNameDB");
        passwordDB = ExternalFiles.getData("PasswordDB");
        initSQLConnection();
        getCredentials();
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

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public static byte[] saveScreenshot () {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}