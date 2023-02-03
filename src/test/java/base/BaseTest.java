package base;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import qaScooterPraktikumServices.base.BasePage;
import qaScooterPraktikumServices.pages.MainPageHeaderLogoScooterAndHeaderLogoYandex;
import qaScooterPraktikumServices.pages.Ordering;
import qaScooterPraktikumServices.pages.Questions;

public class BaseTest {
    //private WebDriver chrome; расскоментить если хочешь использовать хром
    private WebDriver firefox = new FirefoxDriver();

    BasePage basePage = new BasePage(firefox);
    protected Ordering ordering = new Ordering(firefox);
    protected Questions questions = new Questions(firefox);
    protected MainPageHeaderLogoScooterAndHeaderLogoYandex mainPageHeaderLogoScooterAndHeaderLogoYandex = new MainPageHeaderLogoScooterAndHeaderLogoYandex(firefox);

    @After
    public void teardown() {
        //chrome.quit(); расскоментить если хочешь использовать хром
        firefox.quit();
    }

}
