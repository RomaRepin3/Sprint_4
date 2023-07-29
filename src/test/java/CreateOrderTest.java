import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.*;


@RunWith(Parameterized.class)
public class CreateOrderTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;

    private final String date;
    private final String rentPeriod;

    public CreateOrderTest(
            String name,
            String surname,
            String address,
            String metroStation,
            String phone,
            String date,
            String rentPeriod
    ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.rentPeriod = rentPeriod;
    }

    @Parameterized.Parameters
    public static String[][] getTestData() {
        return new String[][] {
                {"Иван", "Иванов", "ул. Соколова 50", "Преображенская площадь", "88005553535", "9", "двое суток"},
                {"Пётр", "Петров", "ул. Димитрова 12", "Бульвар Рокоссовского", "88001234567", "21", "трое суток"}
        };
    }

    @Test
    public void createOrderByLowerButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickUpperOrderButton();

        CustomerDataPage customerDataPage = new CustomerDataPage(driver);
        customerDataPage.fillCustomerForm(name, surname, address, metroStation, phone);

        RentFormPage rentFormPage = new RentFormPage(driver);
        rentFormPage.fillRentFormPage(date, rentPeriod);

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