package galvest.pages;

import galvest.pages.base_pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalBasketPage extends BasePage {

    @FindBy(xpath = "//div/div/div/span")
    private WebElement sumGoodsText;

    @FindBy(xpath = "//a[@class='button']")
    private WebElement btnGoToBasket;

    public ModalBasketPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public ModalBasketPage clickButtonBasket() {
        wait.until(ExpectedConditions.visibilityOf(btnGoToBasket));
        btnGoToBasket.click();
        return this;
    }

}
