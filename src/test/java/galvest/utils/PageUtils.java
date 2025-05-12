package galvest.utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.interactable;

public class PageUtils {

    public static void fillingOutInputFields(String value, SelenideElement input) {
        input.should(interactable).sendKeys(String.valueOf(value));
    }
}
