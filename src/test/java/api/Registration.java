package api;

import io.restassured.RestAssured;
import models.ApiUser;
import models.User;
import models.UserData;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Registration extends BaseApiTest{


    @Test
    public void registrationUserTest() {
        User user = UserData.randomUser();
        ApiUser apiUser = new ApiUser();
        apiUser.setUser(user);

        User newUser = RestAssured
                .given()
                .body(apiUser)
                .when()
                .post("/users")
                .then()
                .statusCode(200)
                .extract().body()
                .as(ApiUser.class)
                .getUser();

        assertThat(newUser.getEmail()).isEqualToIgnoringCase(user.getEmail());
        assertThat(newUser.getUsername()).isEqualToIgnoringCase(user.getUsername());
    }



}
