import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Random;

import static org.openqa.selenium.By.cssSelector;

public class RegistrationTest extends BaseTest {

    By registrationForm = cssSelector(".navbar-nav .nav-item > a[href='#register']");
    By usernameField = cssSelector("input[type='text']");
    By emailField = cssSelector("input[type='email']");
    By passwordField = cssSelector("input[type='password']");
    By submitFormBtn = cssSelector("button[type='submit']");
    By userSettings = cssSelector(".navbar-nav .nav-item > a[href='#settings']");
    By errorEmail = cssSelector(".error-messages li:nth-child(1)");
    By errorPass = cssSelector(".error-messages li:nth-child(2)");
    By errorUser = cssSelector(".error-messages li:nth-child(3)");

    String userName = "userTest" + new Random().nextInt(10000);
    String email = userName + "@mail.com";
    String password = "qwerty12345";



    @Test
    public void registrationPageIsAvailable(){
        driver.findElement(registrationForm).click();
        String h1RegistrationText = driver.findElement(cssSelector("h1.text-xs-center ")).getText();
        Assertions.assertThat(h1RegistrationText).isEqualTo("Sign Up");
    }

    @Test
    public void registration(){
        By userProfile = cssSelector(".navbar-nav .nav-item > a[href='#@"+userName+"']");

        driver.findElement(registrationForm).click();
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(userName);
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitFormBtn).click();
        Assertions.assertThat(driver.findElement(userProfile).getText().equals(userName));
    }

    @Test
    public void registrationFormValidation(){
        driver.findElement(registrationForm).click();
        driver.findElement(submitFormBtn).click();
        String errorTextEmail = driver.findElement(errorEmail).getText();
        String errorTextPass = driver.findElement(errorPass).getText();
        String errorTextUser = driver.findElement(errorUser).getText();
    Assertions.assertThat(errorTextEmail).isEqualTo("email can't be blank");
    Assertions.assertThat(errorTextPass).isEqualTo("password can't be blank");
    Assertions.assertThat(errorTextUser).isEqualTo("username can't be blankis too short (minimum is 1 character)is too long (maximum is 20 characters)");

    }

    @Test
    public void userNameFieldValidation(){
        driver.findElement(registrationForm).click();
        driver.findElement(usernameField).clear();
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitFormBtn).click();
        String errorTextUser = driver.findElement(errorUser).getText();
        Assertions.assertThat(errorTextUser).isEqualTo("username can't be blankis too short (minimum is 1 character)is too long (maximum is 20 characters)");

    }

    @Test
    public void emailFieldValidation(){
        driver.findElement(registrationForm).click();
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(userName);
        driver.findElement(emailField).clear();
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitFormBtn).click();
        String errorTextEmail = driver.findElement(errorUser).getText();
        Assertions.assertThat(errorTextEmail).isEqualTo("email can't be blank");

    }

    @Test
    public void passFieldValidation(){
        driver.findElement(registrationForm).click();
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(userName);
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(submitFormBtn).click();
        String errorTextPass = driver.findElement(errorUser).getText();
        Assertions.assertThat(errorTextPass).isEqualTo("password can't be blank");

    }

}
