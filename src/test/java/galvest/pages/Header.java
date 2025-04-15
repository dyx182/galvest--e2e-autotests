package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Header {

    private final SelenideElement btnCatalog = $("a.catalog");
    private final SelenideElement btnCatalogCatEight = $("li a.cat8");
    //TODO Заменить локатор
    private final SelenideElement counterBasket = $x("//div[5]/span/span");
    private final SelenideElement iconBasket = $x("//span[@class='basket_link']");

    ModalBasketPage modalBasketPage = new ModalBasketPage();

    public ModalBasketPage getModalBasketPage() {
        return modalBasketPage;
    }

    @Step("Нажатие кнопки Каталог товаров")
    public Header clickBtnCatalog(){
        btnCatalog.click();
        return this;
    }
    @Step("Нажатие кнопки 'Клеи' в выпадающем списке")
    public GlueCatalogPage clickBtnProduct() {
        btnCatalogCatEight.click();
        return new GlueCatalogPage();
    }

    @Step("Нажатие кнопки корзины")
    public Header checkCounter() {
        counterBasket.shouldBe(visible).shouldHave(text("1"), Duration.ofSeconds(10));
        return this;
    }
    @Step("Нажатие кнопки 'Корзина'")
    public Header linkToBasket() {
        iconBasket.click();
        return this;
    }
}
