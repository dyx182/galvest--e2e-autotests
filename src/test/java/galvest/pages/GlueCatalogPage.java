package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BaseCatalogPage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class GlueCatalogPage extends BaseCatalogPage {

    private final SelenideElement titlePageText = $x("//span[text()='Клеи']");

    Header header = new Header();

    private String savedTitleText;

    public String getSavedTitleText() {
        return savedTitleText;
    }

    public Header getHeader() {
        return header;
    }

    @Step("Проверка заголовка страницы")
    public GlueCatalogPage assertTitlePage() {
        titlePageText.should(visible).shouldHave(text("Клеи"), Duration.ofSeconds(5));
        return this;
    }
    @Step("Добавление элемента в корзину и получение его названия")
    public GlueCatalogPage addGoodElement(int index) {
        getCatalogElement(index).addElement();
        savedTitleText = getCatalogElement(index).getTextTitleElement();
        return this;
    }
}
