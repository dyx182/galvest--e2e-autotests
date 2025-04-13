package galvest.pages.base_pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class BasePage {

    private final SelenideElement sendMessage = $x("//jdiv[@class='hoverArea__cMvXG']");

    protected void fillingOutInputFields(String value, WebElement input) {
        try {
            for (char c : value.toCharArray()) {
                input.sendKeys(String.valueOf(c));
                Thread.sleep(30);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}