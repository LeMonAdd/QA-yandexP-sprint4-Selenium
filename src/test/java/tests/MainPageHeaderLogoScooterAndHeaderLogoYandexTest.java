package tests;

import base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import qaScooterPraktikumServices.pages.MainPageHeaderLogoScooterAndHeaderLogoYandex;
import io.github.bonigarcia.wdm.WebDriverManager;

import static qaScooterPraktikumServices.base.Constants.Urls.MAIN_PAGE_URL;

public class MainPageHeaderLogoScooterAndHeaderLogoYandexTest extends BaseTest {


    @Test
    public void checkIfClickLogoScooterOpenMainPageScooterPositiveTest()  {

        mainPageHeaderLogoScooterAndHeaderLogoYandex.open(MAIN_PAGE_URL);
        mainPageHeaderLogoScooterAndHeaderLogoYandex.checkIfClickLogoScooterOpenMainPageScooterPositive();

    }

    @Test
    public void checkIfClickLogoYandexInNewWindowOpenMainPageYandexPositiveTest()  {

        mainPageHeaderLogoScooterAndHeaderLogoYandex.open(MAIN_PAGE_URL);
        mainPageHeaderLogoScooterAndHeaderLogoYandex.checkIfClickLogoYandexInNewWindowOpenMainPageYandexPositive();

    }



}
