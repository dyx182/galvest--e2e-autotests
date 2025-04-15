package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;
import io.qameta.allure.Step;


import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static galvest.pages.GlueCatalogPage.savedTitleText;


public class BasketPage extends BasePage {

    //Кнопка оформить заказ
    private final SelenideElement BtnDesignOrder = $("#page_content>div>div.basket_buttons>a.button");

    private final SelenideElement amountText = $x("//td[@class='price-show-401-0']");

    private final SelenideElement addCount = $x("//span[@class='add']");


    @Step("Нажатие кнопки 'Оформить заказ'")
    public BasketPage placingOrder() {
        BtnDesignOrder.click();
        return this;
    }
    @Step("Проверка стоимости")
    public BasketPage checkAmount(String amount) {
        String fullText = amount + ",00 р.";
        amountText.shouldHave(text(fullText));
        return this;
    }

    @Step("Добавление кол-ва товара")
    public BasketPage addCountGood() {
        addCount.click();
        return this;
    }
}
