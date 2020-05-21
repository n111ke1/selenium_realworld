import models.User;
import models.UserData;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MainPage;
import pages.SignInPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorizationUserTest extends BaseTest{

    private User user = UserData.defaultUser();


    @Test
    public void loginUserTest(){
        new MainPage(driver)
                .clickSignIn();
        new SignInPage(driver)
                .login(user.getEmail(), user.getPassword());
        assertThat(new HomePage(driver).isUserLoggedIn(user.getUsername())).isTrue();
    }

    @Test(enabled = false)
    public void loginFormValidation(){
        new MainPage(driver)
                .clickSignIn();
        new SignInPage(driver).clickSingInButton();
        assertThat(new SignInPage(driver).getErrorText()).isEqualTo("email or password is invalid");
    }


}
