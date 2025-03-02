package galvest.pages;

import galvest.pages.base_pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BasePage {

    @FindBy(css = "a.catalog")
    private WebElement btnCatalog;

    @FindBy(css = "li a.cat8")
    private WebElement btnCatalogCatEight;

    @FindBy(xpath = "//div[5]/span/span" )
    private WebElement counterBasket;

    @FindBy(xpath = "//span[@class='basket_link']")
    private WebElement iconBasket;

    ModalBasketPage modalBasketPage = new ModalBasketPage(driver, wait);

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
        return new GlueCatalogPage(driver, wait);
    }

    public Header(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
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
