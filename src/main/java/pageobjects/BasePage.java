package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitPresenceOfElementLocated(By elementSelector) {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(elementSelector)
        );
    }

    protected void scrollIntoViewElement(By element) {
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(element
                )
        );
    }
}