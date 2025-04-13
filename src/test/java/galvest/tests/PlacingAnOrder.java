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
        MainPage page = new MainPage();
        page
                .open(BASE_URL)
                //.checkSendMessage()
                .getHeader()
                .clickBtnCatalog()
                .clickBtnProduct()
                .assertTitlePage()
                .assertsUniqueElements()
                .addGoodElement(INDEX)
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .clickButtonBasket();

        BasketPage basketPage = new BasketPage();

        basketPage
                .assertProductTitle()
                .addQuantity()
                .checkAmount(AMOUNT)
                .placingOrder();

        OrderPage orderPage = new OrderPage();

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

