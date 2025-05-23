package galvest.pages.component;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.BasketPage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ModalBasketPage {

    private final SelenideElement btnGoToBasket = $x("//a[@class='button']");

    private final SelenideElement productTitle = $x("(//span[text()='Эпоксидный клей Adesilex PG4'])[1]");

    @Step("Проверка товара")
    public ModalBasketPage assertProductTitle(String expectedTitle) {
        productTitle.should(visible).shouldHave(exactText((expectedTitle)), Duration.ofSeconds(5));
        return this;
    }
    @Step("Нажатие кнопки 'Перейти в корзину'")
    public BasketPage clickButtonBasket() {
        btnGoToBasket.should(interactable).click();
        return new BasketPage();
    }
}
