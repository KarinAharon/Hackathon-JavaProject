package Utilities;

import PageObject.CreateUserPage;
import PageObject.LeftBarPage;
import PageObject.LoginPage;
import org.openqa.selenium.WebDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.interactions.Actions;

public class Base {

    //selenium
    protected static WebDriver driver;
    protected static String urlGrafanaWeb;
    protected static Actions actions;
    //po
    protected static LoginPage loginPage;
    protected static LeftBarPage leftBarPage;
    protected static CreateUserPage createUserPage;


    //appium


    //RestAPI
    public static RequestSpecification req;
    public static Response res;
    protected  static String getUrlGrafanaServer;


}
