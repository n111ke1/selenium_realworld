import io.github.bonigarcia.wdm.WebDriverManager;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    public User user = new User("niktest@email.com","qwerty12345");
    String userName = "niktest";
//    String email = "niktest@email.com";
//    String password = "qwerty12345";

//    By registrationForm = cssSelector(".navbar-nav .nav-item > a[href='#register']");
//    By loginForm = cssSelector(".navbar-nav .nav-item > a[href='#login']");
//    By emailField = cssSelector("input[type='email']");
//    By passwordField = cssSelector("input[type='password']");
//    By submitFormBtn = cssSelector("button[type='submit']");
//    By usernameField = cssSelector("input[type='text']");
//    By userProfileTab = cssSelector(".navbar-nav .nav-item > a[href='#@"+userName+"']");
//    By userSettingsTab = cssSelector(".navbar-nav .nav-item > a[href='#settings']");
//    By newPostTab = cssSelector(".navbar-nav .nav-item > a[href='#editor']");
//    By homeTab = cssSelector(".navbar-nav .nav-item > a[href='#']");
//
//    By articleTitleField = By.cssSelector("[placeholder='Article Title']");
//    By articleAboutField = By.cssSelector("fieldset > fieldset:nth-child(2) > input");
//    By articleText = By.cssSelector("[placeholder='Write your article (in markdown)']");
//    By articleTags = By.cssSelector("[placeholder='Enter tags']");
//    By publishArticleBtn = By.cssSelector("[type='button']");


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

    public WebElement element(By by){
        return driver.findElement(by);
    }









}
