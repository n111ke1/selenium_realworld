package apiTests;

import io.restassured.RestAssured;
import models.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import serviceApi.UserService;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateArticle extends BaseApiTest {


    @BeforeMethod
    public User authenticationToken(){
        User user;
        UserService userService = new UserService();
        user = userService.registration();
        return user;
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
        article.setTitle("dwad");
        article.setDescription("dwad");
        article.setBody("dawdawd");
        article.setTagList(Arrays.asList("test", "dawddad"));
        articleResponse.setArticle(article);
        Article article1 = RestAssured
               .given()
                    . header("Authorization", "Token " + authenticationToken().getToken())
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
