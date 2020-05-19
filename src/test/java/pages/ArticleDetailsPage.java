package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waits;

public class ArticleDetailsPage extends BasePage {

    public ArticleDetailsPage(WebDriver driver) {
        super(driver);
    }

    By createdPostName = By.cssSelector(".article-page .banner h1");
    By deletePostBtn = By.cssSelector("button.btn-outline-danger");
    By editPostBtn = By.cssSelector(".btn-outline-secondary");



    public String getArticleTitleText(){
        return getTextFromElement(driver.findElement(createdPostName));
    }

    public HomePage clickDeleteArticle(){
        waits.elementToBeClickable(deletePostBtn);
        driver.findElement(deletePostBtn).click();
        return new HomePage(driver);
    }

    public NewArticlePage clickEditPost(){
        driver.findElement(editPostBtn).click();
        return new NewArticlePage(driver);
    }



}
