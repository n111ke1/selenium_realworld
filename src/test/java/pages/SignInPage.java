package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.cssSelector;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    By errorLoginFields = cssSelector(".error-messages");


    public HomePage login(String email, String password) {
        inputEmail(email);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputPassword(password);
        return clickSingInButton();
    }

    public void inputEmail(String email) {
        WebElement emailField = singForm().findElement(By.cssSelector("input[type='email']"));
        inputText(emailField, email);
    }

    public void inputPassword(String password) {
        WebElement passwordField = singForm().findElement(By.cssSelector("input[type='password']"));
        inputText(passwordField, password);
    }

    public String getPageTitle() {
        return driver.findElement(By.cssSelector(".auth-page h1")).getText();
    }

    public HomePage clickSingInButton() {
        WebElement signInButton = singForm().findElement(By.cssSelector("button[type='submit']"));
        signInButton.click();
        return new HomePage(driver);
    }

    protected WebElement singForm() {
        return driver.findElement(By.cssSelector(".auth-page form"));
    }


}
