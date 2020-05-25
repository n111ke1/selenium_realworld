package serviceApi;

import apiTests.BaseApiTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import models.User;
import models.UserData;
import models.UserResponce;

public class UserService extends BaseApiTest {


    public User login() {
        User defUser = UserData.defaultUser();
        UserResponce userResponce = new UserResponce();
        userResponce.setUser(defUser);
            RestAssured.baseURI = "https://conduit.productionready.io";
            RestAssured.basePath = "/api";
            RestAssured.requestSpecification =
                    new RequestSpecBuilder()
                            .setAccept(ContentType.JSON)
                            .setContentType(ContentType.JSON)
                            .log(LogDetail.ALL)
                            .build();

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
        userAuth.setPassword(defUser.getPassword());

      return userAuth;
    }




}
