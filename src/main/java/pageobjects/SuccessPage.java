package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessPage {
    private final WebDriver driver;

    // надпись "Заказ оформлен"
    private final By placedOrderLabel = By.xpath("//div[text()='Заказ оформлен']");

    // сообщение с информацией о заказе
    private final By orderInfoText = By.className("Order_Text__2broi");

    // кнопка "Посмотреть статус"
    private final By watchStatusButton = By.xpath("//button[text()='Посмотреть статус']");

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkSuccessPage() {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(placedOrderLabel)
        );
        new WebDriverWait(
                driver,
                Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(orderInfoText)
        );
        new WebDriverWait(
                driver,
                Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(watchStatusButton)
        );
    }
}