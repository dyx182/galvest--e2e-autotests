package galvest.pages;

import galvest.pages.base_pages.BaseCatalogPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GlueCatalogPage extends BaseCatalogPage {

    Header header = new Header(driver, wait);

    @FindBy(xpath = "//div[2]/ul/li[3]/span")
    private WebElement titlePageText;
    //текст элемнета
    public static String savedTitleText;

    public GlueCatalogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public Header getHeader() {
        return header;
    }

    public GlueCatalogPage assertTitlePage() {
        wait.until(ExpectedConditions.visibilityOf(titlePageText));
        Assertions.assertEquals(titlePageText.getText(), "Клеи", "Произошел неверный переход");
        return this;
    }
    //Добавление элемента в корзину и получение его названия
    public GlueCatalogPage addGoodElement(int index) {
        getCatalogElement(index).addElement();
        savedTitleText = getCatalogElement(index).getTextTitleElement();
        return this;
    }

    //Проверка кол-ва элементов
    public GlueCatalogPage assertsUniqueElements() {
        Assertions.assertTrue(checkingTheTUiquenessOfElements());
        return this;
    }

}
