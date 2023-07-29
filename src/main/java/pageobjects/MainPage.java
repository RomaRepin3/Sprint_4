package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    // верхняя кнопка "Заказать"
    private final By upperOrderButton = By.cssSelector(".Header_Nav__AGCXC > .Button_Button__ra12g");

    // изображение самокаката
    private final By scooterImage = By.cssSelector(".Home_Scooter__3YdJy img");

    // нижняя кнопка "Заказать"
    private final By lowerOrderButton = By.cssSelector(".Home_FinishButton__1_cWm > .Button_Button__ra12g");

    public MainPage(WebDriver driver) {
        this.driver = driver;
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
        new WebDriverWait(
                driver,
                Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(scooterImage)
        );
    }

    public void clickFaqQuestion(String faqQuestionText) {
        final By faqQuestion = faqQuestion(faqQuestionText);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(faqQuestion)
        );
        driver.findElement(faqQuestion).click();
    }

    public void checkFaqAnswer(String faqAnswerText) {
        final By faqAnswer = faqAnswer(faqAnswerText);
        new WebDriverWait(
                driver,
                Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(faqAnswer)
        );
    }

    public void clickQuestionAndCheckAnswer(String question, String answer) {
        clickFaqQuestion(question);
        checkFaqAnswer(answer);
    }

    public void clickLowerOrderButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(lowerOrderButton)
        );
        driver.findElement(lowerOrderButton).click();
    }
}