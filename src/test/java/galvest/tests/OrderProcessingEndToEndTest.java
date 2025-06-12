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
                .clickBtnProduct()
                .assertTitlePage()
                .checkElementsUniqueness();

        BasketPage basketPage = gluePage
                .addGoodElement(GLUE_PRODUCT.getIndex())
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .assertProductTitle(gluePage.getSavedTitleText())
                .clickButtonBasket()
                .addCountGood()
                .checkAmount(GLUE_PRODUCT.getAmount());

        basketPage.placingOrder()
                .setDeliveryOption()
                .checkAndSetindividualType(INDIVIDUAL_DATA.getUserType())
                .setInputName(INDIVIDUAL_DATA.getUserName())
                .setinputPhone(INDIVIDUAL_DATA.getPhoneNumber())
                .setinputEmail(INDIVIDUAL_DATA.getEmail())
                .setComment(INDIVIDUAL_DATA.getComment())
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
                .goToProductInCatalog(ANCHOR.getIndex())
                .assertTitlePage();

        anchorPage
                .openFilter()
                .selectBrand(BRAND_PCI.getValue())
                .selectCountry(COUNTRY_GERMANY.getValue())
                .selectBase(BASE_METHACRYLATE.getValue())
                .selectDiameter(DIAMETER_1MM.getValue())
                .selectTemperature(TEMP_UP_TO_5.getValue())
                .selectType(TYPE_POURABLE.getValue())
                .clickConfirmBtn()
                .checkingResult(EMPTY)
                .resetFilters()
                .selectBrand(BRAND_BASF.getValue())
                .selectCountry(COUNTRY_SWITZERLAND.getValue())
                .selectBase(BASE_VINYL_ETHER.getValue())
                .checkingResult(FILLED)
                .clickConfirmBtn();

        BasketPage basketPage = anchorPage
                .addGoodElement(ANCHOR_PRODUCT.getIndex())
                .getHeader()
                .checkCounter()
                .linkToBasket()
                .getModalBasketPage()
                .clickButtonBasket();

        basketPage
                .checkAmount(ANCHOR_PRODUCT.getAmount())
                .clickCO()
                .getCommercialOfferPage()
                .setInputCompany(COMMERCIAL_OFFER_DATA.getCompany())
                .setInputName(COMMERCIAL_OFFER_DATA.getUserName())
                .SetInputObjectName(COMMERCIAL_OFFER_DATA.getObject())
                .sendCommercialOffer()
                .DownloadCO();
    }
}

