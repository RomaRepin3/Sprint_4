package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CustomerDataPage {

    private final WebDriver driver;

    // поле "Имя"
    private final By nameField = By.cssSelector(".Order_Form__17u6u > .Input_InputContainer__3NykH:nth-child(1) input");

    // поле "Фамилия"
    private final By surnameField = By.cssSelector(".Order_Form__17u6u > .Input_InputContainer__3NykH:nth-child(2) input");

    // поле "Адрес"
    private final By addressField = By.cssSelector(".Order_Form__17u6u > .Input_InputContainer__3NykH:nth-child(3) input");

    // поле "Станция метро"
    private final By metroStationField = By.cssSelector(".select-search__value");

    // поле "Телефон"
    private final By phoneField = By.cssSelector(".Order_Form__17u6u > .Input_InputContainer__3NykH:nth-child(5) input");

    // кнопка "Далее"
    private final By continueButton = By.cssSelector(".Order_Content__bmtHS .Button_Button__ra12g");

    public CustomerDataPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для формирования селектора выбора станции метро в выпадающем списке
    private By metroStationDropdownListPoint(String metroStationName) {
        return By.xpath(
                String.format(".//div[@class='Order_Text__2broi' and text()='%s']", metroStationName)
        );
    }

    public void fillNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void fillAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void selectMetroStation(String metroStationName) {
        driver.findElement(metroStationField).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(metroStationDropdownListPoint(metroStationName)));
        driver.findElement(metroStationDropdownListPoint(metroStationName)).click();
    }

    public void fillPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickContinueButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(continueButton));
        driver.findElement(continueButton).click();
    }

    public void fillCustomerForm(String name, String surname, String address, String metroStation, String phone) {
        fillNameField(name);
        fillSurnameField(surname);
        fillAddressField(address);
        selectMetroStation(metroStation);
        fillPhoneField(phone);
        clickContinueButton();
    }
}