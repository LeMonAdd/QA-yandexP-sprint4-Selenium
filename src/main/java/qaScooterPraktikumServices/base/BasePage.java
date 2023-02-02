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


    // Метод открывает страницу
    public BasePage open(String url) {

        driver.get(url);

        return this;

    }

    // Метод ожидает пока элемент станет кликабельным
    public BasePage explicitWaitEl(By el) {

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(el));

        return this;

    }

    // неявное ожидание в 3 секунды
    public BasePage implicitWait() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return this;

    }

    // Метод скролит до любого элемента на странице
    public BasePage scrollToElement(By el) {

        explicitWaitEl(el);
        WebElement element = driver.findElement(el);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;

    }

    // Метод ждёт пока элемнт станет кликабельным, ищет его и вводет текст из параметра
    public BasePage findAndWaitElementAndSendKeys(By el, String str) {

        //explicitWaitEl(el);
        driver.findElement(el).sendKeys(str);
        return this;

    }

    // Метод кликает по любому элементу
    public BasePage clickOnElement(By el) {

        explicitWaitEl(el);
        driver.findElement(el).click();
        return this;

    }

    public String getText(By el) {

        WebElement getTextEl = driver.findElement(el);
        return  getTextEl.getText();

    }

    public WebElement findElementInPage(By el) {

        explicitWaitEl(el);
        return driver.findElement(el);

    }

    public void scrollInOrder(By el) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        driver.findElement(el).click();

    }

    public String geturl() {

        return driver.getCurrentUrl();

    }

    public String getWindow(){

        return driver.getWindowHandle();

    }

    public WebDriver getDriver(){

         return driver;

    }

}
