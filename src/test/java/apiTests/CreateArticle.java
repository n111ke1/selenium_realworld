package apiTests;

import io.restassured.RestAssured;
import models.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateArticle extends BaseApiTest {


    @BeforeMethod
    public AuthenticationToken authenticationToken(){
        User defUser = UserData.defaultUser();
        UserResponce userResponce = new UserResponce();
        userResponce.setUser(defUser);
        AuthenticationToken authenticationToken =  RestAssured
                .given()
                .body(userResponce)
                .when()
                .post("/users/login")
                .then()
                .statusCode(200)
                .extract().body()
                .as(AuthenticationToken.class);
        return authenticationToken;
    }

//    @Test
//    public void createArticleTest() {
//        File json = new File("src/test/resources/articleData.json");
//        File login = new File("src/test/resources/userData.json");
//        AuthenticationToken authenticationToken =
//        RestAssured.given()
//                        .body(login)
//                        .expect()
//                        .statusCode(200)
//                        .when()
//                        .post("/users/login")
//                        .then()
//                        .log().all()
//                        .extract()
//                        .body().as(AuthenticationToken.class);
//               RestAssured.given()
//                       .param("token", authenticationToken)
//                .body(json)
//                .when()
//                .post("/articles")
//                .then()
//                .statusCode(200)
//                .assertThat().body("article.title", equalToIgnoringCase("title"))
//                .log();
//    }

    @Test
    public void createArticle(){
        ArticleResponse articleResponse = new ArticleResponse();
        Article article = new Article();
        articleResponse.setArticle(article);
       Article article1 = RestAssured.given()
                       .param("token", authenticationToken())
                .body(article)
                .when()
                .post("/articles")
                .then()
                .statusCode(200)
               .extract().body()
               .as(ArticleResponse.class).getArticle();
        System.out.println(article1);
    }

    @Test
    public void deleteArticle(){


    }



}
