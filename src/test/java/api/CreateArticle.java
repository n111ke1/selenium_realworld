package api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CreateArticle extends BaseApiTest {

    @Test
    public void createArticleTest() {
        File json = new File("src/test/resources/articleData.json");
        File login = new File("src/test/resources/userData.json");
        AuthenticationToken authenticationToken =
        RestAssured.given()
                        .body(login)
                        .expect()
                        .statusCode(200)
                        .when()
                        .post("/users/login")
                        .then()
                        .log().all()
                        .extract()
                        .body().as(AuthenticationToken.class);
               RestAssured.given()
                       .param("token", authenticationToken)
                .body(json)
                .when()
                .post("/articles")
                .then()
                .statusCode(200)
                .assertThat().body("article.title", equalToIgnoringCase("title"))
                .log();
    }



}
