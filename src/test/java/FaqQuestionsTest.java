import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.MainPage;


@RunWith(Parameterized.class)
public class FaqQuestionsTest extends BaseTest {

    private final String question;
    private final String answer;

    public FaqQuestionsTest(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static String[][] getTestData() {
        return new String[][] {
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkFaqAnswerAndQuestion() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickQuestionAndCheckAnswer(
                question,
                answer
        );
    }
}