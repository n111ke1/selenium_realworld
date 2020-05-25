package pages;

import models.Article;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class NewArticlePage extends BasePage {

    public NewArticlePage(WebDriver driver) {
        super(driver);
    }

    private By titleField = By.cssSelector(".form-group:nth-child(1)>input");
    private By whatAboutField = By.cssSelector(".form-group:nth-child(2)>input");
    private By articleBodyField = By.cssSelector(".form-group:nth-child(3)>textarea");
    private By tagsField = By.cssSelector(".form-group:nth-child(4)>input");
    private By publishArticleBtn = By.cssSelector("[type='button']");



    public NewArticlePage inputArticleTitle(String title) {
        inputText(titleField, title);
        return this;
    }

    public NewArticlePage inputWhatArticleAbout(String whatAbout) {
        inputText(whatAboutField, whatAbout);
        return this;
    }

    public NewArticlePage inputArticle(String article) {
        inputText(articleBodyField, article);
        return this;
    }

    public NewArticlePage inputTags(String tags) {
        inputText(tagsField, tags);
        return this;
    }

    public ArticleDetailsPage clickPublishArticleBtn() {
        driver.findElement(publishArticleBtn).click();
        return new ArticleDetailsPage(driver);
    }

    public Article createNewArticle(){
        Article article = new Article();
        article.setTitle("TestArticleTitle");
        article.setDescription("about article");
        article.setBody("Text text text");
        article.setTagList(Arrays.asList("tests", "hohho"));
        return article;
    }

    public ArticleDetailsPage createNewDefaultPost(){
        inputArticleTitle("TestArticleTitle");
        inputWhatArticleAbout("about article");
        inputArticle("Text text text");
        inputTags("@tags");
        return clickPublishArticleBtn();

    }


}
