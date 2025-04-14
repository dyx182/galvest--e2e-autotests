package galvest.pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private SelenideElement btnCatOne = $("a.cat1 span");

    private Header header = new Header();

    public MainPage() {
        super();
    }

    public Header getHeader() {
        return header;
    }

    public MainPage open(String url) {
        Selenide.open(url);
        return new MainPage();
    }

//    // Нажатие анкерные составы на главной
//    public MainPage clickButtonProductOne() {
//        btnCatOne.click();
//        return this;
//    }

    public MainPage checkSendMessage() {
        getSendMessage().isDisplayed();
        return this;
    }
}