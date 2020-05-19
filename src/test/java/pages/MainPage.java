package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.cssSelector;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    By registrationForm = cssSelector(".navbar-nav .nav-item > a[href='#register']");
    By loginForm = cssSelector(".navbar-nav .nav-item > a[href='#login']");
    By homeTab = cssSelector(".navbar-nav .nav-item > a[href='#']");

    public MainPage checkTittle(String tittle) {
        assertThat(tittle).isEqualTo(driver.getTitle());
        return this;
    }

    public SignInPage clickSignIn() {
        driver.findElement(loginForm).click();
        return new SignInPage(driver);
    }

    public SignUpPage clickSignUp() {
        driver.findElement(registrationForm).click();
        return new SignUpPage(driver);
    }

    public MainPage clickHome() {
        driver.findElement(homeTab).click();
        return new MainPage(driver);
    }
}
