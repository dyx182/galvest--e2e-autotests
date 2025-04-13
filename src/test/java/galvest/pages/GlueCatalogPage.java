package galvest.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BaseCatalogPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$x;


public class GlueCatalogPage extends BaseCatalogPage {

    Header header = new Header();

    //TODO Заменить локатор
    private final SelenideElement titlePageText = $x("//div[2]/ul/li[3]/span");

    //текст элемнета
    public static String savedTitleText;


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
