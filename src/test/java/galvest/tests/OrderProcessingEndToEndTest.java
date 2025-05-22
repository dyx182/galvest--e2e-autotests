package galvest.tests;

import galvest.testdata.TestData;
import galvest.common.enums.Filter;
import galvest.pages.*;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static galvest.common.constants.TestConstants.BASE_URL;
import static galvest.testdata.TestData.COMPANY;
import static galvest.testdata.TestData.OBJECT;
import static galvest.common.enums.Product.ANCHOR;
import static galvest.common.enums.Product.GLUE;


public class OrderProcessingEndToEndTest extends TestBase {

    @Test
    @Story("Оформление заказа как ФЛ")
    public void placingOrderTest() {

        GlueCatalogPage gluePage = MainPage.open(BASE_URL)
                .getHeader()
                .clickBtnCatalog()
                .clickBtnProduct();

        gluePage.assertTitlePage()
                .checkElementsUniqueness();


        gluePage.addGoodElement(GLUE)
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .assertProductTitle(gluePage.getSavedTitleText())
                .clickButtonBasket();

        BasketPage basketPage = new BasketPage();
        basketPage.addCountGood()
                .checkAmount(GLUE)
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

        AnchorCatalogPage anchorPage = MainPage.open(BASE_URL)
                .clickButtonProduct(0)
                .assertTitlePage();

        anchorPage
                .openFilter()
                .selectBrand(Filter.BRAND_PCI.getValue())
                .selectCountry(Filter.COUNTRY_GERMANY.getValue())
                .selectBase(Filter.BASE_METHACRYLATE.getValue())
                .selectDiameter(Filter.DIAMETER_1MM.getValue())
                .selectTemperature(Filter.TEMP_UP_TO_5.getValue())
                .selectType(Filter.TYPE_POURABLE.getValue())
                .clickConfirmBtn()
                .checkingResult(0)
                .resetFilters()
                .selectBrand(Filter.BRAND_BASF.getValue())
                .selectCountry(Filter.COUNTRY_SWITZERLAND.getValue())
                .selectBase(Filter.BASE_VINYL_ETHER.getValue())
                .checkingResult(1)
                .clickConfirmBtn();

        anchorPage
                .addGoodElement(ANCHOR)
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .clickButtonBasket();

        BasketPage basketPage = new BasketPage();
        basketPage
                .checkAmount(ANCHOR)
                .clickCO()
                .getCommercialOfferPage()
                .setInputCompany(COMPANY)
                .setInputName(TestData.USERNAME)
                .SetInputObjectName(OBJECT)
                .sendCommercialOffer()
                .DownloadCO();
    }
}

