package galvest.utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.interactable;
import static java.lang.Thread.sleep;

public class PageUtils {

    public static void fillingOutInputFields(String value, SelenideElement input) {
        input.should(interactable).sendKeys(String.valueOf(value));
    }

    public static void waiting(long ms) {
        try {
            sleep(ms);
        }
        catch (InterruptedException e) {
            System.out.println("thread interruption" + e.getMessage());
        }
    }
}
