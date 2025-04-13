package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static galvest.pages.GlueCatalogPage.savedTitleText;

@Getter
public class BasketPage extends BasePage {

    //Кнопка оформить заказ
    private final SelenideElement BtnDesignOrder = $("#page_content>div>div.basket_buttons>a.button");

    private final SelenideElement addGood = $x("//span[@class='add']");

    private final SelenideElement amountText = $x("//td[@class='price-show-401-0']");

    private final SelenideElement productTitle = $x("//td/a[@class='product_link']");

    private final Header header = new Header();


    public BasketPage() {
        super();
    }

    public BasketPage addQuantity() {
        addGood.click();
        return this;
    }

    public BasketPage placingOrder() {
        BtnDesignOrder.click();
        return this;
    }

    public BasketPage checkAmount(String amount) {
        String fullText = amount + ",00 р.";
        amountText.shouldHave(text(fullText));
        return this;
    }

    public BasketPage assertProductTitle() {
        Assertions.assertEquals(productTitle.getText(), savedTitleText);
        return this;
    }

}
