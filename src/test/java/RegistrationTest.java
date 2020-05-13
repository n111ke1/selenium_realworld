import models.User;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Random;

import static org.openqa.selenium.By.cssSelector;

public class RegistrationTest extends BaseTest {
    public User user;

    By userSettings = cssSelector(".navbar-nav .nav-item > a[href='#settings']");
    By errorEmail = cssSelector(".error-messages li:nth-child(1)");
    By errorPass = cssSelector(".error-messages li:nth-child(2)");
    By errorUser = cssSelector(".error-messages li:nth-child(3)");


    @Test
    public void registrationPageIsAvailable(){
        element(registrationForm).click();
        String h1RegistrationText = driver.findElement(cssSelector("h1.text-xs-center ")).getText();
        Assertions.assertThat(h1RegistrationText).isEqualTo("Sign Up");
    }

    @Test
    public void registration(){
        By userProfile = cssSelector(".navbar-nav .nav-item > a[href='#@"+user.getUserName()+"']");
        element(registrationForm).click();
        printText(element(usernameField),user.getUserName());
        printText(element(emailField),user.getEmail());
        printText(element(passwordField),user.getPassword());
        element(submitFormBtn).click();
        Assertions.assertThat(driver.findElement(userProfile).getText().equals(user.getUserName()));
    }

    @Test
    public void registrationFormValidation(){
        element(registrationForm).click();
        element(submitFormBtn).click();
        String errorTextEmail = element(errorEmail).getText();
        String errorTextPass = element(errorPass).getText();
        String errorTextUser = element(errorUser).getText();
    Assertions.assertThat(errorTextEmail).isEqualTo("email can't be blank");
    Assertions.assertThat(errorTextPass).isEqualTo("password can't be blank");
    Assertions.assertThat(errorTextUser).isEqualTo("username can't be blankis too short (minimum is 1 character)is too long (maximum is 20 characters)");

    }

    @Test
    public void userNameFieldValidation(){
        element(registrationForm).click();
        element(usernameField).clear();
        printText(element(emailField),user.getEmail());
        printText(element(passwordField),user.getPassword());
        element(submitFormBtn).click();
        String errorTextUser = element(errorUser).getText();
        Assertions.assertThat(errorTextUser).isEqualTo("username can't be blankis too short (minimum is 1 character)is too long (maximum is 20 characters)");

    }

    @Test
    public void emailFieldValidation(){
        element(registrationForm).click();
        printText(element(usernameField),user.getUserName());
        element(emailField).clear();
        printText(element(passwordField), user.getPassword());
        element(submitFormBtn).click();
        String errorTextEmail = element(errorUser).getText();
        Assertions.assertThat(errorTextEmail).isEqualTo("email can't be blank");

    }

    @Test
    public void passFieldValidation(){
       element(registrationForm).click();
        printText(element(usernameField),user.getUserName());
        printText(element(emailField),user.getEmail());
        element(passwordField).clear();
        String errorTextPass = element(errorUser).getText();
        Assertions.assertThat(errorTextPass).isEqualTo("password can't be blank");

    }

}
