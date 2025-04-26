package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BaseCatalogPage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GlueCatalogPage extends BaseCatalogPage<GlueCatalogPage> {

    private final SelenideElement titlePageText = $x("//span[text()='Клеи']");

    @Step("Проверка заголовка страницы")
    @Override
    public GlueCatalogPage assertTitlePage() {
        titlePageText.should(visible).shouldHave(text("Клеи"), Duration.ofSeconds(5));
        return this;
    }

}
