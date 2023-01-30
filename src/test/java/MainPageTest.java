import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import qaScooterPraktikumServices.MainPage;
import qaScooterPraktikumServices.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class MainPageTest {
    private WebDriver chrome;
    private WebDriver firefox;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        chrome = new ChromeDriver();
        firefox = new FirefoxDriver(); // драйвер установлен локально

    }

    @Test
    public void clickAndCheckTextItemsListQuestionsImportantPositiveTest()  {

        MainPage mainPage = new MainPage(firefox);
        Constants constants = new Constants();

        mainPage.open(constants.MAIN_PAGE_URL)
                .implicitWait()
                .scrollToBlockquestionsImportant()
                .clickElementItemsquestionsImportant();

    }

    @Test
    public void makeToOrderKickScooterPositiveOneTest()  {

        MainPage mainPage = new MainPage(firefox);
        Constants constants = new Constants();

        mainPage.open(constants.MAIN_PAGE_URL)
                .makeToOrderCkickScooter("top", "Роман", "Иванов", "ул.Челюскинцев, 144, Саратов, Саратовская обл.", "890065465437",
                        "28.12.2022", "comment", "grey");

    }

    @Test
    public void makeToOrderKickScooterPositiveSecondTest()  {

        MainPage mainPage = new MainPage(firefox);
        Constants constants = new Constants();

        mainPage.open(constants.MAIN_PAGE_URL).makeToOrderCkickScooter("down","Егор", "Петров", "улица Победы над ленью", "890065465444",
                "28.12.2023"," comment2", "black");

    }

    @Test
    public void checkIfClickLogoScooterOpenMainPageScooterPositiveTest()  {

        MainPage mainPage = new MainPage(firefox);
        Constants constants = new Constants();

        mainPage.open(constants.MAIN_PAGE_URL).checkIfClickLogoScooterOpenMainPageScooterPositive();

    }

    @Test
    public void checkIfClickLogoYandexInNewWindowOpenMainPageYandexPositiveTest()  {

        MainPage mainPage = new MainPage(firefox);
        Constants constants = new Constants();

        mainPage.open(constants.MAIN_PAGE_URL).checkIfClickLogoYandexInNewWindowOpenMainPageYandexPositive();

    }


    @After
    public void teardown() {
        chrome.quit();
        firefox.quit();
    }
}
