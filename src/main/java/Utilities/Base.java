package Utilities;

import PageObject.DesktopPO.CalcPage;
import PageObject.ElectronPO.ToDoMainPage;
import PageObject.WebPO.CreateUserPage;
import PageObject.WebPO.DeleteUserPage;
import PageObject.WebPO.LeftBarPage;
import PageObject.WebPO.LoginPage;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;

public class Base {

    //selenium
    protected static WebDriver driver;
    protected static String urlGrafanaWeb;
    protected static Actions actions;
    protected static SoftAssert soft;

    //po
    protected static LoginPage loginPage;
    protected static LeftBarPage leftBarPage;
    protected static CreateUserPage createUserPage;
    protected static DeleteUserPage deleteUserPage;



    //appium


    //RestAPI
    public static RequestSpecification req;
    public static Response res;
    protected  static String getUrlGrafanaServer;
    protected static JsonPath jp;
    protected static JSONObject params;
    protected static String baseURL;
    protected static String baseAdminURL;

    //Desktop
    protected static WindowsDriver driverDesktop;
    protected static DesiredCapabilities capabilities;
    protected static CalcPage calcPage;
    protected static String calcApp ;

    //Electron
    protected static ChromeOptions opt;
    protected static ToDoMainPage toDoMainPage;



}
