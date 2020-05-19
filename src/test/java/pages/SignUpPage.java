package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.cssSelector;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    By loginForm = cssSelector(".navbar-nav .nav-item > a[href='#login']");
    By inputEmailField = cssSelector("input[type='email']");
    By inputPasswordField = cssSelector("input[type='password']");
    By registrationForm = cssSelector(".navbar-nav .nav-item > a[href='#register']");
    By usernameField = cssSelector("input[type='text']");
    By submitFormBtn = cssSelector("button[type='submit']");

    By errorEmail = cssSelector(".error-messages li:nth-child(1)");
    By errorPass = cssSelector(".error-messages li:nth-child(2)");
    By errorUser = cssSelector(".error-messages li:nth-child(3)");

    public SignUpPage inputEmail(String email) {
        WebElement emailField = driver.findElement(inputEmailField);
        inputText(emailField, email);
        return this;
    }

    public SignUpPage inputPassword(String password) {
        WebElement passwordField = driver.findElement(inputPasswordField);
        inputText(passwordField, password);
        return this;
    }

    public SignUpPage inputUserName(String username) {
        WebElement passwordField = driver.findElement(usernameField);
        inputText(passwordField, username);
        return this;
    }

    public HomePage clickSignInBtn(){
        driver.findElement(submitFormBtn).click();
        return new HomePage(driver);
    }

    public String getErrorUserNameText(){
        return getTextFromElement(driver.findElement(errorUser));
    }

    public String getErrorEmailText(){
        return getTextFromElement(driver.findElement(errorEmail));
    }

    public String getErrorPassText(){
        return getTextFromElement(driver.findElement(errorPass));
    }




}
