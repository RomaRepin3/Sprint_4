package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentFormPage extends BasePage {
    // поле "Когда привезти самокат"
    private final By dateField = By.className("react-datepicker__input-container");

    // поле "Срок аренды"
    private final By rentPeriodField = By.className("Dropdown-root");

    // кнопка "Заказать" на форме аренды
    private final By orderButton = By.xpath("//div[@class='Order_Content__bmtHS']//button[text()='Заказать']");

    public RentFormPage(WebDriver driver) {
        super(driver);
    }

    // число в календаре
    private By datePoint (String date) {
        return By.xpath(String.format("//div[text()='%s']", date));
    }

    // элемент выпадающего списка "Срок аренды"
    private By rentPeriodDropdownListPoint(String rentPeriod) {
        return By.xpath(String.format("//div[text()='%s']", rentPeriod));
    }

    public void selectDate(String date) {
        driver.findElement(dateField).click();
        driver.findElement(datePoint(date)).click();
    }

    public void selectRentPeriod(String rentPeriod) {
        driver.findElement(rentPeriodField).click();
        driver.findElement(rentPeriodDropdownListPoint(rentPeriod)).click();

    }

    public void clickOrderButton() {
        scrollIntoViewElement(orderButton);
        driver.findElement(orderButton).click();
    }

    public void fillRentFormPage(String date, String rentPeriod) {
        selectDate(date);
        selectRentPeriod(rentPeriod);
        clickOrderButton();
    }
}