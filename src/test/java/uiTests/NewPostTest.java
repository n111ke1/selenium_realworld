package uiTests;

import models.User;
import models.UserData;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ArticleDetailsPage;
import pages.HomePage;
import pages.MainPage;
import pages.ProfilePage;

public class NewPostTest extends BaseTest {

   private User user = UserData.defaultUser();

    @BeforeTest
    public void beforeTest(){
        new MainPage(driver)
                .clickSignIn()
                .login(user.getEmail(), user.getPassword());
    }

    @Test
    public void createNewPostTest(){
        beforeTest();
        new HomePage(driver)
                .clickNewPost()
                .createNewDefaultPost();
        Assertions.assertThat(new ArticleDetailsPage(driver).getArticleTitleText()).isEqualTo("TestArticleTitle");
        new ArticleDetailsPage(driver).clickDeleteArticle();

    }

    @Test
    public void editExistsPost(){
        beforeTest();
        new HomePage(driver)
                .clickNewPost()
                .createNewDefaultPost()
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
