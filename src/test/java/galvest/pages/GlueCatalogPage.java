package galvest.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlueCatalogPage extends BasePage{

    @FindBy(xpath = "//div[2]/ul/li[3]/span")
    private WebElement titlePageText;

    @FindBy(xpath = "//a[@data-id='401'][@class='button buy to_basket']")
    private WebElement btnAddToBasketElement;

    @FindBy(xpath = "//li[14]/div/div[1]")
    private WebElement priceOfElement;

    Header header = new Header(driver, wait);

    public Header getHeader() {
        return header;
    }

    public GlueCatalogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public GlueCatalogPage assertTextOnPage() {
        wait.until(ExpectedConditions.visibilityOf(titlePageText));
        Assertions.assertEquals(titlePageText.getText(), "Клеи", "Произошел неверный переход");
        return this;
    }

    public GlueCatalogPage addGoodToBasket() {
        Actions actions = new Actions(driver);
        actions
                .moveToElement(btnAddToBasketElement)
                .click()
                .perform();
        return this;
    }

}
