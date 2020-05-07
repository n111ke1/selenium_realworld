import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.cssSelector;

public class AuthorizationUserTest extends BaseTest{
    String userName = "niktest";
    String email = "niktest@email.com";
    String password = "qwerty12345";

    By registrationForm = cssSelector(".navbar-nav .nav-item > a[href='#register']");
    By loginForm = cssSelector(".navbar-nav .nav-item > a[href='#login']");
    By usernameField = cssSelector("input[type='text']");
    By emailField = cssSelector("input[type='email']");
    By passwordField = cssSelector("input[type='password']");
    By submitFormBtn = cssSelector("button[type='submit']");
    By userSettingsTab = cssSelector(".navbar-nav .nav-item > a[href='#settings']");
    By newPostTab = cssSelector(".navbar-nav .nav-item > a[href='#editor']");
    By homeTab = cssSelector(".navbar-nav .nav-item > a[href='#']");
    By errorLoginFields = cssSelector(".error-messages");

    By userProfileTab = cssSelector(".navbar-nav .nav-item > a[href='#@"+userName+"']");


    @Test
    public void loginFormPageIsAvailible(){
        driver.findElement(loginForm).click();
        String h1LoginText = driver.findElement(cssSelector("h1.text-xs-center ")).getText();
        Assertions.assertThat(h1LoginText).isEqualTo("Sign In");
    }

    @Test
    public void loginUser(){
        driver.findElement(loginForm).click();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitFormBtn).click();
        Assertions.assertThat(driver.findElement(userProfileTab).getText().contains("niktest"));

    }

    @Test
    public void loginFormValidation(){
        driver.findElement(loginForm).click();
        driver.findElement(submitFormBtn).click();
        String errorText = driver.findElement(errorLoginFields).getText();
        Assertions.assertThat(errorText).isEqualTo("email or password is invalid");
    }

    @Test
    public void loginEmailFieldValidation(){
        driver.findElement(loginForm).click();
        driver.findElement(emailField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitFormBtn).click();
        String errorText = driver.findElement(errorLoginFields).getText();
        Assertions.assertThat(errorText).isEqualTo("email or password is invalid");
    }

    @Test
    public void loginPassFieldValidation(){
        driver.findElement(loginForm).click();
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(submitFormBtn).click();
        String errorText = driver.findElement(errorLoginFields).getText();
        Assertions.assertThat(errorText).isEqualTo("email or password is invalid");
    }

    @Test
    public void navigationToNewPostTab(){
        loginUser();
        driver.findElement(newPostTab).click();
        Assertions.assertThat(driver.getCurrentUrl().contains("editor"));
    }

    @Test
    public void navigationToSettingsTab(){
        loginUser();
        driver.findElement(userSettingsTab).click();
        Assertions.assertThat(driver.getCurrentUrl().contains("settings"));
    }

    @Test
    public void navigationToUserProfile(){
        loginUser();
        driver.findElement(userProfileTab).click();
        Assertions.assertThat(driver.getCurrentUrl().contains(userName));
    }

    @Test
    public void navigationToHomePage(){
        loginUser();
        driver.findElement(userProfileTab).click();
        driver.findElement(homeTab).click();
        WebElement feedTab = driver.findElement(cssSelector(".feed-toggle .nav-item .active"));
        System.out.println(feedTab.getText());
        Assertions.assertThat(feedTab.getText()).isEqualTo("Your Feed");
    }
    
}
