package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Header extends BasePage {

    private final SelenideElement btnCatalog = $("a.catalog");

    private final SelenideElement btnCatalogCatEight = $("li a.cat8");
    //TODO ЗАменить локатор
    private final SelenideElement counterBasket = $x("//div[5]/span/span");

    private final SelenideElement iconBasket = $x("//span[@class='basket_link']");

    ModalBasketPage modalBasketPage = new ModalBasketPage();

    public ModalBasketPage getModalBasketPage() {
        return modalBasketPage;
    }

    // Нажатие кнопки Каталог товаров
    public Header clickBtnCatalog(){
        btnCatalog.click();
        return this;
    }
    // Нажатие клеи в дропдауне
    public GlueCatalogPage clickBtnProduct() {
        btnCatalogCatEight.click();
        return new GlueCatalogPage();
    }

    public Header() {
        super();
    }

    public Header checkCounter() {
        wait.until(ExpectedConditions.visibilityOf(counterBasket));
        Assertions.assertEquals(counterBasket.getText(), "1", "Товар не добавился в корзину");
        return this;
    }

    public Header linkToBasket() {
        iconBasket.click();
        return this;
    }
}
