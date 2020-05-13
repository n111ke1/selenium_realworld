import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.cssSelector;

public class AuthorizationUserTest extends BaseTest{


    By usernameField = cssSelector("input[type='text']");


    By errorLoginFields = cssSelector(".error-messages");



    @Test
    public void loginFormPageIsAvailible(){
        element(loginForm).click();
        String h1LoginText = element(cssSelector("h1.text-xs-center")).getText();
        Assertions.assertThat(h1LoginText).isEqualTo("Sign In");
    }

    @Test
    public void loginUserTest(){
        element(loginForm).click();
        printText(element(emailField),user.getEmail());
        printText(element(passwordField),user.getPassword());
        element(submitFormBtn).click();
        Assertions.assertThat(element(userProfileTab).getText().contains("niktest"));

    }

    @Test
    public void loginFormValidation(){
        element(loginForm).click();
        element(submitFormBtn).click();
        String errorText = element(errorLoginFields).getText();
        Assertions.assertThat(errorText).isEqualTo("email or password is invalid");
    }

    @Test
    public void loginEmailFieldValidation(){
        element(loginForm).click();
        element(emailField).clear();
        element(passwordField).sendKeys(user.getPassword());
        element(submitFormBtn).click();
        String errorText = element(errorLoginFields).getText();
        Assertions.assertThat(errorText).isEqualTo("email or password is invalid");
    }

    @Test
    public void loginPassFieldValidation(){
        element(loginForm).click();
        element(emailField).clear();
        element(emailField).sendKeys(user.getEmail());
        element(passwordField).clear();
        element(submitFormBtn).click();
        String errorText = element(errorLoginFields).getText();
        Assertions.assertThat(errorText).isEqualTo("email or password is invalid");
    }

    @Test
    public void navigationToNewPostTab(){
        loginUser();
        element(newPostTab).click();
        Assertions.assertThat(driver.getCurrentUrl().contains("editor"));
    }

    @Test
    public void navigationToSettingsTab(){
        loginUser();
        element(userSettingsTab).click();
        Assertions.assertThat(driver.getCurrentUrl().contains("settings"));
    }

    @Test
    public void navigationToUserProfile(){
        loginUser();
        element(userProfileTab).click();
        Assertions.assertThat(driver.getCurrentUrl().contains(userName));
    }

    @Test
    public void navigationToHomePage(){
        loginUser();
        element(userProfileTab).click();
        element(homeTab).click();
        WebElement feedTab = element(cssSelector(".feed-toggle .nav-item .active"));
        System.out.println(feedTab.getText());
        Assertions.assertThat(feedTab.getText()).isEqualTo("Your Feed");
    }
    
}
