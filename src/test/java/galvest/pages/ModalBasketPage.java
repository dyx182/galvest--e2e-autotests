package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;


public class ModalBasketPage {

    private final SelenideElement btnGoToBasket = $x("//a[@class='button']");

    private final SelenideElement productTitle = $x("(//span[text()='Эпоксидный клей Adesilex PG4'])[1]");

    @Step("Проверка товара")
    public ModalBasketPage assertProductTitle(String expectedTitle) {
        productTitle.shouldHave(exactText((expectedTitle)), Duration.ofSeconds(5));
        return this;
    }
    @Step("Нажатие кнопки 'Перейти в корзину'")
    public ModalBasketPage clickButtonBasket() {
        btnGoToBasket.click();
        return this;
    }
}
