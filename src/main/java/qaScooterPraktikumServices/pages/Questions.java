package qaScooterPraktikumServices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qaScooterPraktikumServices.base.BasePage;
import static org.junit.Assert.*;

public class Questions extends BasePage {
    private final By questionsImportantBlock = By.className("Home_FourPart__1uthg"); // Родительский блок "Вопросы о важном"
    private WebDriver driver;

    public Questions(WebDriver driver) {
        super(driver);
    }

    // Метод скролит до блокка "Вопросы о важном" на главной странице веб приложения
    public Questions scrollToBlockquestionsImportant() {

        scrollToElement(questionsImportantBlock);
        return this;

    }

    /**
     *
     * @param el - элемент для клика из списка
     * @param actualText - полученный текст из абзаца раскрытого списка
     * @param expectedText - текст для проверки
     * @return
     */

    // Метод раскрывает аккордион, получает текст абзаца и сверяет его с ожидаемым текстом
    public Questions clickElementItemsQuestionsImportantAndCheckTextInList(By el, By actualText, String expectedText) {

        clickOnElement(el);
        explicitWaitEl(actualText);
        String text = getText(actualText);
        assertEquals(expectedText, text);
        return this;

    }
}
