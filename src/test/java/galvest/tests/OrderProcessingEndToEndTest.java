package galvest.tests;


import galvest.pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static galvest.common.constants.TestConstants.BASE_URL;
import static galvest.common.enums.CatalogSections.ANCHOR;
import static galvest.common.enums.Filter.*;
import static galvest.common.enums.FilteringCheck.FILLED;
import static galvest.common.enums.FilteringCheck.EMPTY;
import static galvest.common.enums.Product.*;
import static galvest.testdata.TestData.*;


public class OrderProcessingEndToEndTest extends TestBase {

    @Test
    @Story("Оформление заказа как ФЛ")
    @Description("""
            Тест проверяет возможность оформления заказа на физическое лицо, возможность ввода
            данных физического лица и оформлением предварительной накладной.
            Так же проверяет работу чата на странице, каталога и корзины.
            """)
    public void placingOrderTest() {

        GlueCatalogPage gluePage = MainPage.open(BASE_URL)
                .getHeader()
                .clickBtnCatalog()
                .clickBtnProduct();

        gluePage.assertTitlePage()
                .checkElementsUniqueness();

        BasketPage basketPage = gluePage
                .addGoodElement(GLUE_PRODUCT)
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .assertProductTitle(gluePage.getSavedTitleText())
                .clickButtonBasket();

        basketPage.addCountGood()
                .checkAmount(GLUE_PRODUCT);

        OrderPage orderPage = basketPage.placingOrder();

        orderPage.setDeliveryOption()
                .checkAndSetindividualType(INDIVIDUAL_DATA)
                .setInputName(INDIVIDUAL_DATA)
                .setinputPhone(INDIVIDUAL_DATA)
                .setinputEmail(INDIVIDUAL_DATA)
                .setComment(INDIVIDUAL_DATA)
                .sendApplication()
                .confirmOrder();
    }

    @Test
    @Story("Оформление коммерческого предложения")
    @Description("""
            Тест проверяет возможность оформления коммерческого предложения, возможность ввода
            данных юридического лица и оформление спецификации с ценами.
            Так же проверяет поведение фильтра в каталоге и страницу коммерческого предложеия.
            """)
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
                .checkingResult(EMPTY)
                .resetFilters()
                .selectBrand(BRAND_BASF)
                .selectCountry(COUNTRY_SWITZERLAND)
                .selectBase(BASE_VINYL_ETHER)
                .checkingResult(FILLED)
                .clickConfirmBtn();

        BasketPage basketPage = anchorPage
                .addGoodElement(ANCHOR_PRODUCT)
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .clickButtonBasket();

        basketPage
                .checkAmount(ANCHOR_PRODUCT)
                .clickCO()
                .getCommercialOfferPage()
                .setInputCompany(COMMERCIAL_OFFER_DATA)
                .setInputName(COMMERCIAL_OFFER_DATA)
                .SetInputObjectName(COMMERCIAL_OFFER_DATA)
                .sendCommercialOffer()
                .DownloadCO();
    }
}

