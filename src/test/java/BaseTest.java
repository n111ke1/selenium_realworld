import io.github.bonigarcia.wdm.WebDriverManager;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.cssSelector;

public class BaseTest {

    WebDriver driver;
    public User user = new User("niktest@email.com","qwerty12345");
    String userName = "niktest";
//    String email = "niktest@email.com";
//    String password = "qwerty12345";

    By registrationForm = cssSelector(".navbar-nav .nav-item > a[href='#register']");
    By loginForm = cssSelector(".navbar-nav .nav-item > a[href='#login']");
    By emailField = cssSelector("input[type='email']");
    By passwordField = cssSelector("input[type='password']");
    By submitFormBtn = cssSelector("button[type='submit']");
    By usernameField = cssSelector("input[type='text']");
    By userProfileTab = cssSelector(".navbar-nav .nav-item > a[href='#@"+userName+"']");
    By userSettingsTab = cssSelector(".navbar-nav .nav-item > a[href='#settings']");
    By newPostTab = cssSelector(".navbar-nav .nav-item > a[href='#editor']");
    By homeTab = cssSelector(".navbar-nav .nav-item > a[href='#']");

    By articleTitleField = By.cssSelector("[placeholder='Article Title']");
    By articleAboutField = By.cssSelector("fieldset > fieldset:nth-child(2) > input");
    By articleText = By.cssSelector("[placeholder='Write your article (in markdown)']");
    By articleTags = By.cssSelector("[placeholder='Enter tags']");
    By publishArticleBtn = By.cssSelector("[type='button']");


    @BeforeClass
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.get("https://react-redux.realworld.io/");
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public WebElement element(By by){
        return driver.findElement(by);
    }

    public void printText(WebElement el, String text){
        el.clear();
        el.sendKeys(text);
    }

    public String getTextFromElement(WebElement element){
        return element.getText();
    }

    public void loginUser() {
        element(loginForm).click();
        element(emailField).sendKeys(user.getEmail());
        element(passwordField).sendKeys(user.getPassword());
        element(submitFormBtn).click();

    }
    public void createNewDefaultPost(){
        loginUser();
        element(newPostTab).click();
        printText(element(articleTitleField),"TestArticleTitle");
        printText(element(articleAboutField), "about article");
        printText(element(articleText), "Text text text");
        printText(element(articleTags), "@tags");
        element(publishArticleBtn).click();
    }



}
