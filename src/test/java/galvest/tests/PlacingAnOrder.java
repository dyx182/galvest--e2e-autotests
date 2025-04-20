package galvest.tests;

import galvest.TestBase;
import galvest.TestData;
import galvest.pages.*;
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
                .checkElementsUniqueness();


        gluePage.addGoodElement(TestData.ProductIndex.EPOXY_GLUE.getIndex())
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .assertProductTitle(gluePage.getSavedTitleText())
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

    @Test
    @Story("Оформление коммерческого предложения")
    public void commercialOffer() {

        AnchorCatalogPage anchorPage = MainPage.open(TestData.BASE_URL)
                .clickButtonProduct(TestData.ProductIndex.ANCHOR_PAGE.getIndex())
                .assertTitlePage();

        anchorPage
                .openFilter()
                .brandSelection(1)
                .selectCountries("Швейцария") //TODO переработать селекты, как первый
                .baseSelection("Винилэфир")
                .temperatureSelection("до +5℃")
                .clickConfirmBtn()
                .checkingResult(1);

        anchorPage
                .addGoodElement(1)
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .clickButtonBasket();

    }


}

