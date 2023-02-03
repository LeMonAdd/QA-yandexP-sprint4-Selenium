package tests;

import base.BaseTest;
import org.junit.Test;
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
