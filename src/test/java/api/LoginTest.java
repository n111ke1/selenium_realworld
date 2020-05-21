package api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public class LoginTest extends BaseApiTest{

    @Test
    public void loginApiTest() {
        File json = new File("src/test/resources/userData.json");
        RestAssured
                .given()
                .body(json)
                .when()
                .post("/users/login")
                .then()
                .statusCode(200)
                .assertThat().body("user.email", equalToIgnoringCase("niktest@email.com"))
                .log();
    }

}
