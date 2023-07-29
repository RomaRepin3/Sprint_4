package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmFormPage {
    private final WebDriver driver;

    // надпись "Хотите оформить заказ?"
    private final By wantPlaceOrderLabel = By.xpath("//div[text()='Хотите оформить заказ?']");

    // кнопка "Да"
    private final By yesButton = By.xpath("//button[text()='Да']");

    public ConfirmFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadConfirmFormPage() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(wantPlaceOrderLabel)
        );
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
}