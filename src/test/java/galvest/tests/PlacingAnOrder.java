package galvest.tests;

import galvest.TestBase;
import galvest.TestData;
import galvest.pages.GlueCatalogPage;
import galvest.pages.MainPage;
import galvest.pages.BasketPage;
import galvest.pages.OrderPage;
import org.junit.jupiter.api.Test;



import static galvest.TestData.*;

public class PlacingAnOrder extends TestBase {
    @Test
    public void placingOrderTest() {
        //Открытие каталога и добавление товара
        GlueCatalogPage gluePage = MainPage.open(TestData.BASE_URL)
                .getHeader()
                .clickBtnCatalog()
                .clickBtnProduct();

        gluePage.assertTitlePage()
                .addGoodElement(TestData.INDEX);

        //Проверка корзины
        gluePage.getHeader()
                .checkCounter()
                .linkToBasket();

        //Оформление заказа
        BasketPage basketPage = new BasketPage();
        basketPage.assertProductTitle()
                .addQuantity()
                .addCountGood()
                .checkAmount(TestData.AMOUNT)
                .placingOrder();

        //Заполнение данных
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

