package galvest.pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import galvest.common.enums.CatalogSections;
import galvest.pages.base_pages.BasePage;
import galvest.pages.component.Header;
import galvest.pages.elements.MainPageElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static galvest.utils.PageUtils.waiting;

public class MainPage extends BasePage {
    @Getter
    private Header header;
    private MainPageElement element;
    private SelenideElement btnCatOne = $("a.cat1 span");

    public MainPage() {
        header = new Header();
        element = new MainPageElement();
    }

    public MainPageElement getElement(int index) {
        return new MainPageElement(index);
    }

    public Header getHeader() {
        return header;
    }
    @Step("Открытие главной страницы")
    public static MainPage open(String url) {
        Selenide.open(url);
        return new MainPage();
    }

    @Step("Выбор раздела на главной странице")
    public AnchorCatalogPage goToProductInCatalog(CatalogSections section) {
        getElement(section.getIndex()).chooseElement();
        return new AnchorCatalogPage();
    }

    public MainPage checkSendMessage() {
        waiting(3000);
        getSendMessage().should(visible);
        return this;
    }
}