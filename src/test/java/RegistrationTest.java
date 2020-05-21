import models.User;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MainPage;
import pages.SignUpPage;

public class RegistrationTest extends BaseTest {
    User user;

    @Test
    public void registration() {
        new MainPage(driver)
                .clickSignUp();
        new SignUpPage(driver)
                .inputUserName(user.getUsername())
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickSignInBtn();
        Assertions.assertThat(new HomePage(driver).isUserLoggedIn(user.getUsername()));
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
