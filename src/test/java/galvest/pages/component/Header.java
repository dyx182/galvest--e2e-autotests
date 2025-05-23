package galvest.pages.component;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.GlueCatalogPage;
import io.qameta.allure.Step;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Header {
    @Getter
    ModalBasketPage modalBasketPage;

    private final SelenideElement btnCatalog = $("a.catalog");

    private final SelenideElement btnCatalogCatEight = $("li a.cat8");

    private final SelenideElement counterBasket = $x("//span[@class='basket_link']/span");

    private final SelenideElement iconBasket = $x("//span[@class='basket_link']");

    public Header() {
        modalBasketPage = new ModalBasketPage();
    }

    @Step("Нажатие кнопки Каталог товаров")
    public Header clickBtnCatalog(){
        btnCatalog.should(interactable).click();
        return this;
    }
    @Step("Нажатие кнопки 'Клеи' в выпадающем списке")
    public GlueCatalogPage clickBtnProduct() {
        btnCatalogCatEight.should(interactable).click();
        return new GlueCatalogPage();
    }

    @Step("Нажатие кнопки корзины")
    public Header checkCounter() {
        counterBasket.shouldBe(visible).shouldHave(text("1"), Duration.ofSeconds(10));
        return this;
    }
    @Step("Нажатие кнопки 'Корзина'")
    public Header linkToBasket() {
        iconBasket.should(visible).click();
        return this;
    }
}
