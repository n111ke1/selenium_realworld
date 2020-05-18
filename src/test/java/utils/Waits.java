package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private static final long DEFAULT_WAIT_TIME = 4;

    public WebDriver driver;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement visibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement visibilityOfElementLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement visibilityOfElementLocated(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement elementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement elementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean invisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean stalenessOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        return wait.until(ExpectedConditions.stalenessOf(element));
    }

    public boolean textToBePresentInElement(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean textToBePresentInElement(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public boolean attributeContains(By locator, String attribute, String text) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        return wait.until(ExpectedConditions.attributeContains(locator, attribute, text));
    }


}
