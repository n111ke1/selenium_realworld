package uiTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;



    @BeforeClass
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public MainPage setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.get("https://react-redux.realworld.io/");
        return new MainPage(driver).checkTittle("Conduit");
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }









}
