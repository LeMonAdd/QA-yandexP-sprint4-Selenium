package qaScooterPraktikumServices.pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import qaScooterPraktikumServices.base.BasePage;
import static org.hamcrest.CoreMatchers.containsString;

public class Ordering extends BasePage {

    private final By buttonTopToOrder = By.xpath("//button[@class='Button_Button__ra12g']"); // Кнопка заказать вверху страницы на главной
    private final By buttonDownToOrder = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[contains(text(), 'Заказать')]"); // Кнопка заказать внизу страницы на главной
    private final By inputName = By.xpath("//div[@class='Order_Form__17u6u']/div/input"); // Инпут имя
    private final By inputSurName = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']"); // Инпут фамилия
    private final By inputAdress = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']"); // Инпут адрес
    private final By inputPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // Инпут телефон
    private final By inputMetro= By.xpath("//input[@placeholder='* Станция метро']"); // Инпут метро
    private final By btnNext = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка далее в форме заказа
    private final By inputDate = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // Инпут даты
    private final By btnArrowRentalTime = By.xpath("//span[@class='Dropdown-arrow']"); // Стрелка в инпуте срок аренды
    private final By secondElementDropDownRentalTime = By.xpath("//div[@class='Dropdown-menu']//*[contains(text(), 'двое суток')]"); // второй элемент из выпадающего списка
    private final By checkboxColorScooterGrey = By.xpath("//div[@class='Order_Checkboxes__3lWSI']//label[@for='grey']"); // чекбокс второй в блоке цвет самоката
    private final By checkboxColorScooterBlack = By.xpath("//div[@class='Order_Checkboxes__3lWSI']//label[@for='black']"); // чекбокс второй в блоке цвет самоката
    private final By inputComment = By.xpath("//input[@placeholder='Комментарий для курьера']"); // инпут комментарий
    private final By btnToOrderInOrderCard = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // кнопка заказать в карточке заказа
    private final By btnYesInCardToOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Да')]"); // кнопка подтверждения заказа
    private final By orderDoneHeader = By.className("Order_ModalHeader__3FDaJ"); // заголовок в карточке заказ выполнен
    private final String expectedTextStatusOrder = "Заказ оформлен"; // проверочные данные
    private WebDriver driver;

    public Ordering(WebDriver driver) {
        super(driver);
    }

    public Ordering orderBittonSelection(String btnClick) {

        // если параметр btnClick top, то осуществляется клик на верхнюю кнопку заказать, иначе скрол до нижней кнопки и клик по ней
        if(btnClick.equals("top")) {

            clickOnElement(buttonTopToOrder);

        } else {

            scrollInOrder(buttonDownToOrder);

        }

        return this;
    }

    /**
     * @param name - ввод в поле имя
     * @param surName - ввод в поле фамилия
     * @param adress - ввод в поле адресс
     * @param phone - ввод в поле телефон
     */
    // Вводит данные в поле
    public Ordering enterDataInTheField(String name, String surName, String adress, String phone) {

        findAndWaitElementAndSendKeys(inputName, name);
        findAndWaitElementAndSendKeys(inputSurName, surName);
        findAndWaitElementAndSendKeys(inputAdress, adress);
        findElementInPage(inputMetro).sendKeys(Keys.ARROW_DOWN , Keys.ENTER);
        findAndWaitElementAndSendKeys(inputPhone, phone); // телефон деда мороза

        return this;

    }

    /**
     * Выбор цвета кнопки
     * @param color - цвет кнопки
     * @return
     */
    public Ordering selectColorBtn(String color) {

        // если параметр серый то выбирается серый чекбокс, если другой то чёрный
        if(color.equals("grey")) {

            clickOnElement(checkboxColorScooterGrey);

        } else {

            clickOnElement(checkboxColorScooterBlack);

        }

        return this;
    }

    /**
     * Получить текст в карточке заказа
     * @return
     */
    public Ordering getTextInCardOrderAndCheckActualText() {

        explicitWaitEl(orderDoneHeader);
        String actualText = getText(orderDoneHeader);

        MatcherAssert.assertThat(actualText, containsString(expectedTextStatusOrder));

        return this;
    }

    /**
     * Метод делает заказ самоката и проверяет, что заказ оформлен (параметры передаются из тестового класса)
     * @param date - ввод даты в поле
     * @param comment - ввод комментария в поле
     * @param color - выбирается цвет самоката, через чекбокс
     * @return
     */
    public Ordering makeToOrderCkickScooterAndCheckHeaderOrderDone( String date, String comment, String color) {

        clickOnElement(btnNext);
        findAndWaitElementAndSendKeys(inputDate, date);
        clickOnElement(btnArrowRentalTime);
        clickOnElement(secondElementDropDownRentalTime);
        selectColorBtn(color);
        findAndWaitElementAndSendKeys(inputComment, comment);
        clickOnElement(btnToOrderInOrderCard);
        clickOnElement(btnYesInCardToOrder);

        return this;

    }

}
