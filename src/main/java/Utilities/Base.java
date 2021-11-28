package Utilities;

import org.openqa.selenium.WebDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {

    //selenium
    protected WebDriver driver;
    protected String urlGrafanaWeb;


    //appium


    //RestAPI
    public static RequestSpecification req;
    public Response res;
    protected String getUrlGrafanaServer;


}
