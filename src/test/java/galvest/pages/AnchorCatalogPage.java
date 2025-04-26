package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BaseCatalogPage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AnchorCatalogPage extends BaseCatalogPage<AnchorCatalogPage> {

    private final SelenideElement titlePageText = $x("//span[text()='Анкерные составы']");

    @Step("Проверка заголовка страницы")
    @Override
    public AnchorCatalogPage assertTitlePage() {
        titlePageText.should(visible).shouldHave(text("Анкерные составы"), Duration.ofSeconds(10));
        return this;
    }

}
