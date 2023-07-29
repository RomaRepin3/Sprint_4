package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    // верхняя кнопка "Заказать"
    private final By upperOrderButton = By.cssSelector(".Header_Nav__AGCXC > .Button_Button__ra12g");

    // изображение самокаката
    private final By scooterImage = By.cssSelector(".Home_Scooter__3YdJy img");

    // нижняя кнопка "Заказать"
    private final By lowerOrderButton = By.cssSelector(".Home_FinishButton__1_cWm > .Button_Button__ra12g");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
    }

    // надпись вопроса в блоке "Вопросы о важном"
    private By faqQuestion(String faqQuestionText) {
        final String faqQuestionTemplate = "//div[@class='accordion__button' and text()='%s']";
        return By.xpath(String.format(faqQuestionTemplate, faqQuestionText));
    }

    // надпись ответа в блоке "Вопросы о важном"
    private By faqAnswer(String faqAnswerText) {
        final String faqAnswerTemplate = "//div[@class='accordion__panel']//p[text()='%s']";
        return By.xpath(String.format(faqAnswerTemplate, faqAnswerText));
    }

    public void waitForLoadMainPage() {
        waitPresenceOfElementLocated(scooterImage);
    }

    public void clickFaqQuestion(String faqQuestionText) {
        final By faqQuestion = faqQuestion(faqQuestionText);
        scrollIntoViewElement(faqQuestion);
        driver.findElement(faqQuestion).click();
    }

    public void checkFaqAnswer(String faqAnswerText) {
        final By faqAnswer = faqAnswer(faqAnswerText);
        waitPresenceOfElementLocated(faqAnswer);
    }

    public void clickQuestionAndCheckAnswer(String question, String answer) {
        clickFaqQuestion(question);
        checkFaqAnswer(answer);
    }

    public void clickLowerOrderButton() {
        scrollIntoViewElement(lowerOrderButton);
        driver.findElement(lowerOrderButton).click();
    }
}