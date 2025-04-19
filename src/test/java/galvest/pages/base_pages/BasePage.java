package galvest.pages.base_pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage {

    private final SelenideElement sendMessage = $x("//jdiv[@class='hoverArea__cMvXG']");

    @Step("Диалоговое окно чата")
    public SelenideElement getSendMessage() {
        return sendMessage;
    }

    protected void fillingOutInputFields(String value, SelenideElement  input) {
                input.sendKeys(String.valueOf(value));
    }
}