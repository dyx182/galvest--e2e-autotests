package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static com.codeborne.selenide.Selenide.$x;

public class ModalBasketPage extends BasePage {

    private final SelenideElement sumGoodsText = $x("//div/div/div/span");

    private final SelenideElement btnGoToBasket = $x("//a[@class='button']");


    public ModalBasketPage() {
        super();
    }

    public ModalBasketPage clickButtonBasket() {
        wait.until(ExpectedConditions.visibilityOf(btnGoToBasket));
        btnGoToBasket.click();
        return this;
    }

}
