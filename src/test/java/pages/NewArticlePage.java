package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewArticlePage extends BasePage {

    public NewArticlePage(WebDriver driver) {
        super(driver);
    }

    private By titleField = By.cssSelector(".form-group:nth-child(1)>input");
    private By whatAboutField = By.cssSelector(".form-group:nth-child(2)>input");
    private By articleBodyField = By.cssSelector(".form-group:nth-child(3)>textarea");
    private By tagsField = By.cssSelector(".form-group:nth-child(4)>input");
    private By publishArticleBtn = By.cssSelector("[type='button']");

    public void inputArticleTitle(String title) {
        inputText(titleField, title);
    }

    public void inputWhatArticleAbout(String whatAbout) {
        inputText(whatAboutField, whatAbout);
    }

    public void inputArticle(String article) {
        inputText(articleBodyField, article);
    }

    public void inputTags(String tags) {
        inputText(tagsField, tags);
    }

    public ArticleDetailsPage clickPublishArticleBtn() {
        driver.findElement(publishArticleBtn).click();
        return new ArticleDetailsPage(driver);
    }

//    public void createNewDefaultPost(){
//
//        element(newPostTab).click();
//        printText(element(articleTitleField),"TestArticleTitle");
//        printText(element(articleAboutField), "about article");
//        printText(element(articleText), "Text text text");
//        printText(element(articleTags), "@tags");
//        element(publishArticleBtn).click();
//    }


}
