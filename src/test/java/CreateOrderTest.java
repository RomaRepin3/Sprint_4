import org.junit.Test;
import pageobjects.*;

public class CreateOrderTest extends BaseTest {
    @Test
    public void createOrderByLowerButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickUpperOrderButton();

        CustomerDataPage customerDataPage = new CustomerDataPage(driver);
        customerDataPage.fillCustomerForm("Иван", "Иванов", "ул. Матросова 50", "Бульвар Рокоссовского", "88005553535");

        RentFormPage rentFormPage = new RentFormPage(driver);
        rentFormPage.fillRentFormPage("9", "двое суток");

        ConfirmFormPage confirmFormPage = new ConfirmFormPage(driver);
        confirmFormPage.waitForLoadConfirmFormPage();
        confirmFormPage.clickYesButton();

        SuccessPage successPage = new SuccessPage(driver);
        successPage.checkSuccessPage();
    }

    @Test
    public void createOrderByUpperButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickLowerOrderButton();

        CustomerDataPage customerDataPage = new CustomerDataPage(driver);
        customerDataPage.fillCustomerForm("Иван", "Иванов", "ул. Матросова 50", "Бульвар Рокоссовского", "88005553535");

        RentFormPage rentFormPage = new RentFormPage(driver);
        rentFormPage.fillRentFormPage("9", "двое суток");

        ConfirmFormPage confirmFormPage = new ConfirmFormPage(driver);
        confirmFormPage.waitForLoadConfirmFormPage();
        confirmFormPage.clickYesButton();

        SuccessPage successPage = new SuccessPage(driver);
        successPage.checkSuccessPage();
    }
}