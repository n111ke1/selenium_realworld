package serviceApi;

import apiTests.BaseApiTest;
import io.restassured.RestAssured;
import models.Article;
import models.ArticleResponse;

public class ArticleService extends BaseApiTest {

    private String token;

    public ArticleService(String token) {
        this.token = token;
    }

    public Article createArticle(Article article) {
        return RestAssured
                .given()
                .header("Authorization", "Token " + token)
                .body(article)
                .when()
                .post("/articles")
                .then()
                .statusCode(200)
                .extract().body()
                .as(ArticleResponse.class)
                .getArticle();

    }

}
