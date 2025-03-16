package galvest.pages;

import galvest.pages.base_pages.BasePage;
import galvest.pages.elements.CatalogElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static galvest.pages.GlueCatalogPage.savedTitleText;

public class BasketPage extends BasePage {

    //Кнопка оформить заказ
    @FindBy(css = "#page_content>div>div.basket_buttons>a.button")
    private WebElement BtnDesignOrder;

    @FindBy(xpath = "//span[@class='add']")
    private WebElement addGood;

    @FindBy(xpath = "//td[@class='price-show-401-0']")
    private WebElement amountText;

    @FindBy(xpath = "//td/a[@class='product_link']")
    private WebElement productTitle;

    private Header header = new Header(driver, wait);

    public Header getHeader() {
        return header;
    }

    public BasketPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
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
