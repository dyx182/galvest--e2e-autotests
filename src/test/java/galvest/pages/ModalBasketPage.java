package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;



import static com.codeborne.selenide.Selenide.$x;

public class ModalBasketPage extends BasePage {

    private final SelenideElement sumGoodsText = $x("//div/div/div/span");

    private final SelenideElement btnGoToBasket = $x("//a[@class='button']");


    public ModalBasketPage() {
        super();
    }

    public ModalBasketPage clickButtonBasket() {
        btnGoToBasket.click();
        return this;
    }
}
