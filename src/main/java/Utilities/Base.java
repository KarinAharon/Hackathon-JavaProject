package Utilities;

import PageObject.CreateUserPage;
import PageObject.DeleteUserPage;
import PageObject.LeftBarPage;
import PageObject.LoginPage;
import org.openqa.selenium.WebDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.interactions.Actions;
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


}
