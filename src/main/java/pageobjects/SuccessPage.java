package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage extends BasePage {
    // надпись "Заказ оформлен"
    private final By placedOrderLabel = By.xpath("//div[text()='Заказ оформлен']");

    // сообщение с информацией о заказе
    private final By orderInfoText = By.className("Order_Text__2broi");

    // кнопка "Посмотреть статус"
    private final By watchStatusButton = By.xpath("//button[text()='Посмотреть статус']");

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public void checkSuccessPage() {
        waitPresenceOfElementLocated(placedOrderLabel);
        waitPresenceOfElementLocated(orderInfoText);
        waitPresenceOfElementLocated(watchStatusButton);
    }
}