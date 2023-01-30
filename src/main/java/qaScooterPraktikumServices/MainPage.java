package qaScooterPraktikumServices;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.containsString;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainPage {
   private WebDriver driver;
   private final By questionsImportantBlock = By.className("Home_FourPart__1uthg"); // Родительский блок "Вопросы о важном"
   private final By buttonTopToOrder = By.xpath("//button[@class='Button_Button__ra12g']"); // Кнопка заказать вверху страницы на главной
    private final By buttonDownToOrder = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[contains(text(), 'Заказать')]"); // Кнопка заказать внизу страницы на главной
   private final By inputName = By.xpath("//div[@class='Order_Form__17u6u']/div/input"); // Инпут имя
   private final By inputSurName = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']"); // Инпут фамилия
   private final By inputAdress = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']"); // Инпут адрес
   private final By inputPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // Инпут телефон
   private final By inputMetro= By.xpath("//input[@placeholder='* Станция метро']"); // Инпут метро
   private final By btnNext = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка далее в форме заказа
   private final By inputDate = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // Инпут даты
   private final By btnArrowRentalTime = By.xpath("//span[@class='Dropdown-arrow']"); // Чтрелка в инпуте срок аренды
   private final By secondElementDropDownRentalTime = By.xpath("//div[@class='Dropdown-menu']//*[contains(text(), 'двое суток')]"); // второй элемент из выпадающего списка
   private final By checkboxColorScooterGrey = By.xpath("//div[@class='Order_Checkboxes__3lWSI']//label[@for='grey']"); // чекбокс второй в блоке цвет самоката
   private final By checkboxColorScooterBlack = By.xpath("//div[@class='Order_Checkboxes__3lWSI']//label[@for='black']"); // чекбокс второй в блоке цвет самоката
   private final By inputComment = By.xpath("//input[@placeholder='Комментарий для курьера']"); // инпут комментарий
   private final By btnToOrderInOrderCard = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // кнопка заказать в карточке заказа
   private final By btnYesInCardToOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Да')]"); // кнопка подтверждения заказа
   private final By orderDoneHeader = By.className("Order_ModalHeader__3FDaJ"); // заголовок в карточке заказ выполнен
   private final By headerLogoScooter = By.className("Header_LogoScooter__3lsAR"); // заголовок в карточке заказ выполнен
   private final By headerLogoYandex = By.className("Header_LogoYandex__3TSOI"); // заголовок в карточке заказ выполнен
   private final String expectedUrlScooter = "https://qa-scooter.praktikum-services.ru/"; // заголовок в карточке заказ выполнен
   private final String expectedUrlYandex = "https://dzen.ru/?yredirect=true"; // заголовок в карточке заказ выполнен
    private final String expectedTextStatusOrder = "Заказ оформлен"; // проверочные данные


    // Элементы аккордиона из блока на главной странице "Вопросы о важном" для клика и раскрытия списка
   private final By[] questionsImportantItems = {
            By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7"),
    };

   // Список путей для получения текста из абзацев в аккордеон "Вопросы о важном"
   private final By[] itemsGetTextBlockQuestionsImportant = {
           By.xpath("//div[@id='accordion__panel-0']/p"),
           By.xpath("//div[@id='accordion__panel-1']/p"),
           By.xpath("//div[@id='accordion__panel-2']/p"),
           By.xpath("//div[@id='accordion__panel-3']/p"),
           By.xpath("//div[@id='accordion__panel-4']/p"),
           By.xpath("//div[@id='accordion__panel-5']/p"),
           By.xpath("//div[@id='accordion__panel-6']/p"),
           By.xpath("//div[@id='accordion__panel-7']/p"),
   };

    // Проверочный текст для абзацев из аккордиона
   private final String[] expectedTextQuestionsImportant = {
           "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
           "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
           "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
           "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
           "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
           "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
           "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
           "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
   };

    public MainPage(WebDriver driver) {

        this.driver = driver;

    }

    // Метод открывает страницу
    public MainPage open(String MAIN_PAGE_URL) {

        driver.get(MAIN_PAGE_URL);

        return this;

    }


    // Метод ожидает пока элемент станет кликабельным
    public MainPage explicitWaitElem(By elem) {

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(elem));
        return this;

    }

    // Метод ждёт пока элемнт станет кликабельным, ищет его и вводет текст из параметра
    public MainPage findAndWaitElementAndSendKeys(By elem, String str) {
        explicitWaitElem(elem);
        driver.findElement(elem).sendKeys(str);
        return this;

    }

    // неявное ожидание в 3 секунды
    public MainPage implicitWait() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return this;

    }

    // Метод скролит до любого элемента на странице
    public MainPage scrollToElement(By elem) {

        WebElement element = driver.findElement(elem);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;

    }

    // Метод скролит до блокка "Вопросы о важном" на главной странице веб приложения
    public MainPage scrollToBlockquestionsImportant() {

        scrollToElement(questionsImportantBlock);
        return this;

    }

    // Метод кликает по любому элементу
    public MainPage clickOnElement(By elem) {

        explicitWaitElem(elem);
        driver.findElement(elem).click();
        return this;

    }


    // Метод раскрывает аккордион по этапно, получает текст абзаца и сверяет его с ожидаемым текстом
    public MainPage clickElementItemsquestionsImportant() {

        int i = 0;
        for (By item : questionsImportantItems) {
            clickOnElement(item);
            assertEquals(expectedTextQuestionsImportant[i], driver.findElement(itemsGetTextBlockQuestionsImportant[i]).getText());
            i++;
        }

        return this;

    }

    // Метод делает заказ самоката и проверяет, что заказ оформлен (параметры передаются из тестового класса)

    /**
     *
     * @param btnClick - определяет какую кнопку нажимать
     * @param name - ввод в поле имя
     * @param surName - ввод в поле фамилия
     * @param adress - ввод в поле адресс
     * @param phone - ввод в поле телефон
     * @param date - ввод даты в поле
     * @param comment - ввод комментария в поле
     * @param color - выбирается цвет самоката, через чекбокс
     * @return
     */
    public MainPage makeToOrderCkickScooter(String btnClick, String name, String surName, String adress, String phone, String date, String comment, String color) {

            // если параметр btnClick top, то осуществляется клик на верхнюю кнопку заказать, иначе скрол до нижней кнопки и клик по ней
            if(btnClick.equals("top")) {
                clickOnElement(buttonTopToOrder);
            } else {
                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("window.scrollBy(0,2000)");
                 driver.findElement(buttonDownToOrder).click();
            }

            findAndWaitElementAndSendKeys(inputName, name);
            findAndWaitElementAndSendKeys(inputSurName, surName);
            findAndWaitElementAndSendKeys(inputAdress, adress); // адрес для кореспонденции деду морозу в Саратове

            driver.findElement(inputMetro).sendKeys(Keys.ARROW_DOWN , Keys.ENTER);

            findAndWaitElementAndSendKeys(inputPhone, phone); // телефон деда мороза
            clickOnElement(btnNext);

            findAndWaitElementAndSendKeys(inputDate, date); // Поиск поля
            clickOnElement(btnArrowRentalTime);
            clickOnElement(secondElementDropDownRentalTime);


            // если параметр серый то выбирается серый чекбокс, если другой то чёрный
            if(color.equals("grey")) {
                clickOnElement(checkboxColorScooterGrey);
            } else {
                clickOnElement(checkboxColorScooterBlack);
            }

            findAndWaitElementAndSendKeys(inputComment, comment);

            clickOnElement(btnToOrderInOrderCard);
            clickOnElement(btnYesInCardToOrder);

            explicitWaitElem(orderDoneHeader);
            String actualText = driver.findElement(orderDoneHeader).getText();

            MatcherAssert.assertThat(actualText, containsString(expectedTextStatusOrder));

        return this;

    }



    // Дополнительное задание ..................................................................


    // Задание № 1 Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».

    public MainPage checkIfClickLogoScooterOpenMainPageScooterPositive() {

        clickOnElement(headerLogoScooter);
        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrlScooter, currentUrl);

        return this;

    }

    // Задание № 2 Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.

    // Урл записывается раньше, чем новое окно подгружается. Ожидания в селениуме просто ужас, в селениде в 100 раз лучше реализованно, не получается
    // Это сделать :) добавил миллион ожиданий, всё равно один результат
    public MainPage checkIfClickLogoYandexInNewWindowOpenMainPageYandexPositive() {

        String window1 = driver.getWindowHandle();

        clickOnElement(headerLogoYandex);

        Set<String> currentWindows = driver.getWindowHandles();

        String window2 = null;

        for (String windowHandle : currentWindows) {
            if(!windowHandle.equals(window1)) {
                window2 = windowHandle;
                break;
            }
        }

        driver.switchTo().window(window2);


        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));


        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrlYandex, currentUrl);

        return this;

    }

    // Остальные решил не делать доп задания и так по времени уже мягкий дедлайн пропустил. Они не очень сложные по идее

}
