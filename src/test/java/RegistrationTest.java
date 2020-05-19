import models.User;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MainPage;
import pages.SignUpPage;

import java.util.Random;

import static org.openqa.selenium.By.cssSelector;

public class RegistrationTest extends BaseTest {
    User user;

    @Test
    public void registration() {
        new MainPage(driver)
                .clickSignUp();
        new SignUpPage(driver)
                .inputUserName(user.getUserName())
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickSignInBtn();
        Assertions.assertThat(new HomePage(driver).isUserLoggedIn(user.getUserName()));
    }

    @Test
    public void registrationFormValidation(){
        new MainPage(driver)
                .clickSignUp();
        new SignUpPage(driver)
                .clickSignInBtn();
        Assertions.assertThat(new SignUpPage(driver).getErrorEmailText()).isEqualTo("email can't be blank");
        Assertions.assertThat(new SignUpPage(driver).getErrorPassText()).isEqualTo("password can't be blank");
        Assertions.assertThat(new SignUpPage(driver).getErrorUserNameText()).isEqualTo("username can't be blankis too short (minimum is 1 character)is too long (maximum is 20 characters)");

    }


}
