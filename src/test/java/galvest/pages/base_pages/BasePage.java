package galvest.pages.base_pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage {


    private final SelenideElement sendMessage = $x("//jdiv[@class='hoverArea__cMvXG']");

    public SelenideElement getSendMessage() {
        return sendMessage;
    }

    protected void fillingOutInputFields(String value, SelenideElement  input) {
                input.sendKeys(String.valueOf(value));
    }
}