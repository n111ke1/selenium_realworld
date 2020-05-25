package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private By articles = By.cssSelector(".article-preview");

    public int getArticlesSize() {
        return driver.findElements(articles).size();
    }

    By previewPostName = By.cssSelector(".preview-link h1");

    public String getPreviewArticleText(){
        return getTextFromElement(driver.findElement(previewPostName));
    }

    public ArticleDetailsPage clickOnArticleTitle(){
        driver.findElement(By.cssSelector(".article-preview .preview-link")).click();
        return new ArticleDetailsPage(driver);

    }

}
