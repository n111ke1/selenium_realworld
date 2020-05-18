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
    By emailField = cssSelector("input[type='email']");
    By passwordField = cssSelector("input[type='password']");
    By registrationForm = cssSelector(".navbar-nav .nav-item > a[href='#register']");

    public void inputEmail(String email) {
        WebElement emailField = signUpForm().findElement(By.cssSelector("input[type='email']"));
        inputText(emailField, email);
    }

    public void inputPassword(String password) {
        WebElement passwordField = signUpForm().findElement(By.cssSelector("input[type='password']"));
        inputText(passwordField, password);
    }

    public WebElement signUpForm(){

       return driver.findElement(registrationForm);

    }


}
