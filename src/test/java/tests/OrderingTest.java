package tests;

import base.BaseTest;
import org.junit.Test;
import static qaScooterPraktikumServices.base.Constants.Urls.MAIN_PAGE_URL;

public class OrderingTest extends BaseTest {
    @Test
    public void makeToOrderCkickScooterAndCheckHeaderOrderDonPositiveOneTest()  {

        ordering.open(MAIN_PAGE_URL);
        ordering.orderBittonSelection("top").enterDataInTheField("Роман", "Иванов", "ул.Челюскинцев, 144, Саратов, Саратовская обл.", "890065465437")
                .makeToOrderCkickScooterAndCheckHeaderOrderDone("28.12.2022", "comment", "grey")
                .getTextInCardOrderAndCheckActualText();

    }

    @Test
    public void makeToOrderCkickScooterAndCheckHeaderOrderDonPositiveSecondTest()  {

        ordering.open(MAIN_PAGE_URL);
        ordering.orderBittonSelection("down").enterDataInTheField("Егор", "Петров", "улица Победы над ленью", "890065465444")
                .makeToOrderCkickScooterAndCheckHeaderOrderDone("28.12.2023"," comment2", "black")
                .getTextInCardOrderAndCheckActualText();

    }

}
