package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmFormPage extends BasePage {
    // надпись "Хотите оформить заказ?"
    private final By wantPlaceOrderLabel = By.xpath("//div[text()='Хотите оформить заказ?']");

    // кнопка "Да"
    private final By yesButton = By.xpath("//button[text()='Да']");

    public ConfirmFormPage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoadConfirmFormPage() {
        waitPresenceOfElementLocated(wantPlaceOrderLabel);
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
}