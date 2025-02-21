package galvest.tests;

import galvest.TestBase;
import galvest.pages.MainPage;
import galvest.pages.BasketPage;
import galvest.pages.OrderPage;
import org.junit.jupiter.api.Test;


import static galvest.TestData.*;

public class PlacingAnOrder extends TestBase {

    @Test
    public void PlacingOrderTest() {
        MainPage page = new MainPage(driver, wait);
        page
                .open()
                .checkSendMessage()
                .getHeader()
                .clickBtnCatalog()
                .clickBtnProduct()
                .assertTextOnPage()
                .addGoodToBasket()
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .clickButtonBasket();

        BasketPage basketPage = new BasketPage(driver, wait);

        basketPage
                .addQuantity()
                .checkAmount(AMOUNT)
                .placingOrder();

        OrderPage orderPage = new OrderPage(driver, wait);

        orderPage
                .checkAndSetindividualType(USER_TYPE)
                .setDeliveryOption()
                .setInputName(USERNAME)
                .setinputPhone(PHONE_NUMBER)
                .setinputEmail(EMAIL)
                .setComment(COMMENT)
                .sendApplication()
                .confirmOrder();
    }
}

