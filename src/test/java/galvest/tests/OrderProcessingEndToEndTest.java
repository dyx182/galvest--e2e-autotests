package galvest.tests;

import galvest.testdata.TestData;
import galvest.common.enums.Filter;
import galvest.pages.*;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static galvest.common.constants.TestConstants.BASE_URL;
import static galvest.common.enums.CatalogSections.ANCHOR;
import static galvest.common.enums.Filter.*;
import static galvest.common.enums.Product.*;
import static galvest.testdata.TestData.COMPANY;
import static galvest.testdata.TestData.OBJECT;


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


        gluePage.addGoodElement(GLUE_PRODUCT)
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .assertProductTitle(gluePage.getSavedTitleText())
                .clickButtonBasket();

        BasketPage basketPage = new BasketPage();
        basketPage.addCountGood()
                .checkAmount(GLUE_PRODUCT)
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
                .goToProductInCatalog(ANCHOR)
                .assertTitlePage();

        anchorPage
                .openFilter()
                .selectBrand(BRAND_PCI)
                .selectCountry(COUNTRY_GERMANY)
                .selectBase(BASE_METHACRYLATE)
                .selectDiameter(DIAMETER_1MM)
                .selectTemperature(TEMP_UP_TO_5)
                .selectType(TYPE_POURABLE)
                .clickConfirmBtn()
                .checkingResult(0)
                .resetFilters()
                .selectBrand(BRAND_BASF)
                .selectCountry(COUNTRY_SWITZERLAND)
                .selectBase(BASE_VINYL_ETHER)
                .checkingResult(1)
                .clickConfirmBtn();

        anchorPage
                .addGoodElement(ANCHOR_PRODUCT)
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .clickButtonBasket();

        BasketPage basketPage = new BasketPage();
        basketPage
                .checkAmount(ANCHOR_PRODUCT)
                .clickCO()
                .getCommercialOfferPage()
                .setInputCompany(COMPANY)
                .setInputName(TestData.USERNAME)
                .SetInputObjectName(OBJECT)
                .sendCommercialOffer()
                .DownloadCO();
    }
}

