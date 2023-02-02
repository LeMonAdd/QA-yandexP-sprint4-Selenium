package qaScooterPraktikumServices.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaScooterPraktikumServices.base.BasePage;
import static org.junit.Assert.*;
import java.time.Duration;
import java.util.Set;

public class MainPageHeaderLogoScooterAndHeaderLogoYandex extends BasePage {

   private final By headerLogoScooter = By.className("Header_LogoScooter__3lsAR"); //
   private final By headerLogoYandex = By.className("Header_LogoYandex__3TSOI"); //
   private final String expectedUrlScooter = "https://qa-scooter.praktikum-services.ru/"; //
   private final String expectedUrlYandex = "https://dzen.ru/?yredirect=true"; //
    private WebDriver driver;

    public MainPageHeaderLogoScooterAndHeaderLogoYandex(WebDriver driver) {
        super(driver);
    }


    // Дополнительное задание ..................................................................


    // Задание № 1 Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».

    public MainPageHeaderLogoScooterAndHeaderLogoYandex checkIfClickLogoScooterOpenMainPageScooterPositive() {

        clickOnElement(headerLogoScooter);
        String currentUrl = geturl();
        assertEquals(expectedUrlScooter, currentUrl);

        return this;

    }

    // Задание № 2 Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.

    public MainPageHeaderLogoScooterAndHeaderLogoYandex checkIfClickLogoYandexInNewWindowOpenMainPageYandexPositive() {

        String window1 = getWindow();

        clickOnElement(headerLogoYandex);

        Set<String> currentWindows = getDriver().getWindowHandles();

        String window2 = null;

        for (String windowHandle : currentWindows) {
            if(!windowHandle.equals(window1)) {
                window2 = windowHandle;
                break;
            }
        }

        getDriver().switchTo().window(window2);

        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));


        String currentUrl = geturl();
        assertEquals(expectedUrlYandex, currentUrl);

        return this;

    }

}
