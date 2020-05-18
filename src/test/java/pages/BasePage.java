package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waits;

public class BasePage {


    protected WebDriver driver;
    protected Waits waits;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);;
    }

    protected void inputText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void inputText(By locator, String text) {
        WebElement element = waits.visibilityOfElementLocated(locator);
        element.clear();
        element.sendKeys(text);
    }
    public String getTextFromElement(WebElement element){
        return element.getText();
    }


}
