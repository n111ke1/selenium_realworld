package uiTests;

import models.Article;
import models.User;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import serviceApi.ArticleService;
import serviceApi.UserService;

public class NewPostTest extends BaseTest {

   private User user;
    private UserService userService = new UserService();
    private Article article;

    @BeforeMethod
    public void beforeTest(){
        user = userService.login();
    ArticleService articleService = new ArticleService(user.getToken());
    article =  articleService.createArticle(new NewArticlePage(driver).createNewArticle());
        new MainPage(driver)
                .clickSignIn()
                .login(user.getEmail(), user.getPassword());

        Assertions.assertThat(new ArticleDetailsPage(driver).getArticleTitleText()).isEqualTo("TestArticleTitle");

    }

//    @Test
//    public void createNewPostTest(){
//        new HomePage(driver)
//                .clickNewPost()
//                .createNewDefaultPost();
//        Assertions.assertThat(new ArticleDetailsPage(driver).getArticleTitleText()).isEqualTo("TestArticleTitle");
//        new ArticleDetailsPage(driver).clickDeleteArticle();
//
//    }

    @Test
    public void editExistsPost(){
//        new HomePage(driver);
//                .clickNewPost()
//                .createNewDefaultPost()
        new  HomePage(driver)
                .clickProfile()
                .clickOnArticleTitle();
        new ArticleDetailsPage(driver)
                .clickEditPost()
                .inputArticleTitle("SomeNewTitle")
                .inputWhatArticleAbout( "about article")
                .inputArticle("changed text text text")
                .inputTags("@newTag")
                .clickPublishArticleBtn();
        Assertions.assertThat(new ArticleDetailsPage(driver).getArticleTitleText()).isEqualTo("SomeNewTitle");
        new ArticleDetailsPage(driver).clickDeleteArticle();
    }

    @Test
    public void deletePost(){
        beforeTest();
        new HomePage(driver)
                .clickNewPost()
                .createNewDefaultPost()
                .clickDeleteArticle();
        new HomePage(driver)
                .clickProfile();
        Assertions.assertThat(new ProfilePage(driver).getArticlesSize()).isNull();

    }



}
