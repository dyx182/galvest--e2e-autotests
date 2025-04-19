package galvest.tests;

import galvest.TestBase;
import galvest.TestData;
import galvest.pages.GlueCatalogPage;
import galvest.pages.MainPage;
import galvest.pages.BasketPage;
import galvest.pages.OrderPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;



public class PlacingAnOrder extends TestBase {

    @Test
    @Story("Оформление заказа как ФЛ")
    public void placingOrderTest() {

        GlueCatalogPage gluePage = MainPage.open(TestData.BASE_URL)
                .getHeader()
                .clickBtnCatalog()
                .clickBtnProduct();

        gluePage.assertTitlePage()
                .checkingTheTUiquenessOfElements();


        gluePage.addGoodElement(TestData.INDEX)
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .assertProductTitle()
                .clickButtonBasket();

        BasketPage basketPage = new BasketPage();
        basketPage.addCountGood()
                .checkAmount(TestData.AMOUNT)
                .placingOrder();

        OrderPage orderPage = new OrderPage();
        orderPage.checkAndSetindividualType(TestData.USER_TYPE)
                .setDeliveryOption()
                .setInputName(TestData.USERNAME)
                .setinputPhone(TestData.PHONE_NUMBER)
                .setinputEmail(TestData.EMAIL)
                .setComment(TestData.COMMENT)
                .sendApplication()
                .confirmOrder();
    }
}

