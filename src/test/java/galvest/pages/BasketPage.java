package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.common.enums.Product;
import galvest.pages.base_pages.BasePage;
import galvest.pages.component.ModalPageCommercialOffer;
import io.qameta.allure.Step;
import lombok.Getter;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;



public class BasketPage extends BasePage {
    @Getter
    ModalPageCommercialOffer CommercialOfferPage;

    private final SelenideElement BtnDesignOrder = $("#page_content>div>div.basket_buttons>a.button");

    private final SelenideElement amountText = $x("//td[contains (@class, 'price-show')]");

    private final SelenideElement addCount = $x("//span[@class='add']");

    private final SelenideElement btnCommercialOffer= $x("//a[contains (@class, 'button2 call_popup')]");

    public BasketPage() {
        CommercialOfferPage = new ModalPageCommercialOffer();
    }

    @Step("Нажатие кнопки 'Оформить заказ'")
    public OrderPage placingOrder() {
        BtnDesignOrder.should(interactable).click();
        return new OrderPage();
    }
    @Step("Проверка стоимости {amount}")
    public BasketPage checkAmount(String amount) {
        String fullText = amount + ",00 р.";
        try {
            amountText.should(visible).shouldHave(text(fullText));
        }
        catch (AssertionError e) {
            String actualText = amountText.getText();
            String err = String.format("Сумма не соответсвует ожидаемой \n" +
                    "%s != %s", fullText, actualText);
            System.out.println(err);
        }
        return this;
    }

    @Step("Добавление кол-ва товара")
    public BasketPage addCountGood() {
        addCount.should(interactable).click();
        return this;
    }

    @Step("Нажатие кнопки 'Сформировать коммерческое предложение'")
    public BasketPage clickCO() {
        btnCommercialOffer.should(interactable).click();
        return this;
    }
}
