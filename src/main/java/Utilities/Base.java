package Utilities;

import PageObject.AppiumPO.MainPage;
import PageObject.DesktopPO.CalcPage;
import PageObject.ElectronPO.ToDoMainPage;
import PageObject.WebPO.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class Base {

    // selenium
    protected static WebDriver driver;
    protected static String urlGrafanaWeb;
    protected static Actions actions;
    protected static SoftAssert soft;

    //Sikuli
    protected static Screen screen;
    protected static String impPath;

    //po
    protected static LoginPage loginPage;
    protected static LeftBarPage leftBarPage;
    protected static CreateUserPage createUserPage;
    protected static DeleteUserPage deleteUserPage;
    protected static ProfilePage profilePage;
    protected static MainPage mainPage;
    protected static NewTeamPage newTeamPage;



    //appium
    protected AndroidDriver<AndroidElement> driverAndroid;
    protected static String reportDirectory;
    protected static String reportFormat;
    protected static String testName;


    //RestAPI
    public static RequestSpecification req;
    public static Response res;
    protected  static String getUrlGrafanaServer;
    protected static JsonPath jp;
    protected static JSONObject params;
    protected static String baseURL;
    protected static String baseAdminURL;
    protected static String baseUserURL;

    //Desktop
    protected static WindowsDriver driverDesktop;
    protected static DesiredCapabilities capabilities;
    protected static CalcPage calcPage;
    protected static String calcApp ;

    //Electron
    protected static ChromeOptions opt;
    protected static ToDoMainPage toDoMainPage;


    //Database
    protected static String dbUrl;
    protected static ResultSet rs;
    protected static Connection con;
    protected static Statement stmt;
    protected static String usernameDB;
    protected static String passwordDB;
    protected static List<String> credentialsUser;
    protected static List<String> credentialsPass;




}
