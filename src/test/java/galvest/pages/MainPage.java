package galvest.pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;
import galvest.pages.component.Header;
import galvest.pages.elements.MainPageElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private SelenideElement btnCatOne = $("a.cat1 span");

    private Header header = new Header();

    private MainPageElement element = new MainPageElement();

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
    public AnchorCatalogPage clickButtonProduct(int index) {
        getElement(index).chooseElement();
        return new AnchorCatalogPage();
    }

    public MainPage checkSendMessage() {
        getSendMessage().should(visible);
        return this;
    }
}