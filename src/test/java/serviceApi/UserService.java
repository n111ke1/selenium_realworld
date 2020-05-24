package serviceApi;

import apiTests.BaseApiTest;
import io.restassured.RestAssured;
import models.User;
import models.UserData;
import models.UserResponce;
import org.testng.annotations.Test;

public class UserService extends BaseApiTest {

    @Test
    public User login() {
        User defUser = UserData.defaultUser();
        UserResponce userResponce = new UserResponce();
        userResponce.setUser(defUser);
        User userAuth =  RestAssured
                .given()
                    .body(userResponce)
                .when()
                    .post("/users/login")
                .then()
                    .statusCode(200)
                    .extract().body()
                    .as(UserResponce.class)
                    .getUser();
      return userAuth;
    }




}
