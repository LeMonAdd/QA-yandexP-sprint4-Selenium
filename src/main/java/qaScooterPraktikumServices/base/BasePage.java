package qaScooterPraktikumServices.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Общие методы для наследников класса базовой страницы .............................................

    /**
     * Метод открывает страницу
     * @param url - открываемая страница
     * @return
     */
    public BasePage open(String url) {

        driver.get(url);

        return this;

    }

    /**
     * Метод ожидает пока элемент станет кликабельным
     * @param el - элемент
     * @return
     */
    public BasePage explicitWaitEl(By el) {

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(el));

        return this;

    }

    /**
     * Неявное ожидание в 3 секунды
     * @return
     */
    public BasePage implicitWait() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return this;

    }

    /**
     * Метод скролит до любого элемента на странице
     * @param el
     * @return
     */
    public BasePage scrollToElement(By el) {

        explicitWaitEl(el);
        WebElement element = driver.findElement(el);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;

    }

    /**
     * Метод ищет элемент и вводет текст из параметра
     * @param el - элемент куда нужно ввести текст
     * @param str - вводимы текст
     * @return
     */
    public BasePage findAndWaitElementAndSendKeys(By el, String str) {

        driver.findElement(el).sendKeys(str);
        return this;

    }

    /**
     * Метод кликает по любому элементу
     * @param el
     * @return
     */
    public BasePage clickOnElement(By el) {

        explicitWaitEl(el);
        driver.findElement(el).click();
        return this;

    }

    /**
     * Возвращает текст
     * @param el
     * @return
     */
    public String getText(By el) {

        WebElement getTextEl = driver.findElement(el);
        return  getTextEl.getText();

    }

    /**
     * Поиск элеимента на странице
     * @param el
     * @return
     */
    public WebElement findElementInPage(By el) {

        explicitWaitEl(el);
        return driver.findElement(el);

    }

    /**
     * Скролл до кнопки нижней заказать на главной странице
     * @param el
     */
    public void scrollInOrder(By el) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        driver.findElement(el).click();

    }

    /**
     * Получить текущий урл
     * @return
     */
    public String geturl() {

        return driver.getCurrentUrl();

    }

    /**
     * Получить текущее окно браузера
     * @return
     */
    public String getWindow(){

        return driver.getWindowHandle();

    }

    /**
     * Получить текущий драйвер
     * @return
     */
    public WebDriver getDriver(){

         return driver;

    }

}
