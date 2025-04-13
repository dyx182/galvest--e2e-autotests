package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;
import galvest.pages.elements.CatalogElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static galvest.pages.GlueCatalogPage.savedTitleText;

public class BasketPage extends BasePage {

    //Кнопка оформить заказ
    private final SelenideElement BtnDesignOrder = $("#page_content>div>div.basket_buttons>a.button");

    private final SelenideElement addGood = $x("//span[@class='add']");

    private final SelenideElement amountText = $x("//td[@class='price-show-401-0']");

    private final SelenideElement productTitle = $x("//td/a[@class='product_link']");

    private Header header = new Header();

    public Header getHeader() {
        return header;
    }

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
        Assertions.assertEquals(amountText.getText(), amount + ",00 р.", "Неверная сумма корзины");
        return this;
    }

    public BasketPage assertProductTitle() {
        Assertions.assertEquals(productTitle.getText(), savedTitleText);
        return this;
    }

}
