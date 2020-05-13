import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NewPostTest extends BaseTest {

    By editPostBtn = By.cssSelector(".btn-outline-secondary");
    By deletePostBtn = By.cssSelector("button.btn-outline-danger");
    By createdPostName = By.cssSelector(".article-page .banner h1");


    @Test
    public void createNewPostTest(){
        loginUser();
        element(newPostTab).click();
    printText(element(articleTitleField),"TestArticleTitle");
    printText(element(articleAboutField), "about article");
    printText(element(articleText), "Text text text");
    printText(element(articleTags), "@tags");
    element(publishArticleBtn).click();
    element(createdPostName).getText();
        Assertions.assertThat(createdPostName).isEqualTo("TestArticleTitle");
    }

    @Test
    public void editExistsPost(){
        createNewDefaultPost();
        element(userProfileTab).click();
        WebElement el = driver.findElements(By.cssSelector(".article-preview .preview-link")).get(0);
        el.click();
        element(editPostBtn).click();
        printText(element(articleTitleField),"SomeNewTitle");
        printText(element(articleAboutField), "about article");
        printText(element(articleText), "changed text text text");
        element(publishArticleBtn).click();
        Assertions.assertThat(element(createdPostName).getText()).isEqualTo("SomeNewTitle");

    }

    @Test
    public void deletePost(){
        By previewPostName = By.cssSelector(".preview-link h1");
        createNewDefaultPost();
        element(deletePostBtn).click();
        element(userProfileTab).click();
        Assertions.assertThat(element(previewPostName)).isNull();

    }



}
