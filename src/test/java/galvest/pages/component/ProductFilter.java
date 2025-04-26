package galvest.pages.component;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BaseCatalogPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ProductFilter extends BaseCatalogPage<ProductFilter> {

    private final SelenideElement filter = $x("//div[@class='filter']");

    private final SelenideElement btnConfirmFltr = filter.$x(".//input[@value='Применить']");

    private final SelenideElement btnResetFltr = filter.$x(".//a[contains(@class, 'filter_reset')]");


    @Step("Выбор производителя: {brandName}")
    public ProductFilter selectBrand(String brandName) {
        SelectOption(".//div[contains(@class, 'sumo_brand')]", brandName);
        return this;
    }

    @Step("Выбор диаметра заполнителя: {diameter}")
    public ProductFilter selectDiameter(String diameter) {
        SelectOption(".//div[contains(@class, 'sumo_8')]", diameter);
        return this;
    }

    @Step("Выбор основы: {baseName}")
    public ProductFilter selectBase(String baseName) {
        SelectOption(".//div[contains(@class, 'sumo_4')]", baseName);
        return this;
    }

    @Step("Выбор страны: {countryName}")
    public ProductFilter selectCountry(String countryName) {
        SelectOption(".//div[contains(@class, 'sumo_3')]", countryName);
        return this;
    }

    @Step("Выбор температуры применения: {temperature}")
    public ProductFilter selectTemperature(String temperature) {
        SelectOption(".//div[contains(@class, 'sumo_10')]", temperature);
        return this;
    }

    @Step("Выбор типа: {typeName}")
    public ProductFilter selectType(String typeName) {
        SelectOption(".//div[contains(@class, 'sumo_6')]", typeName);
        return this;
    }

    @Step("Нажатие кнопки 'Применить в фильтре'")
    public ProductFilter clickConfirmBtn() {
        btnConfirmFltr.should(interactable).click();
        return this;
    }

    @Step("Сброс фильтров")
    public ProductFilter resetFilters() {
        btnResetFltr.shouldBe(interactable).click();
        return this;
    }

    private void SelectOption(String filterXpath, String optionName) {
        SelenideElement filterElement = $x(filterXpath);
        filterElement.should(interactable).click();
        filterElement.$x(".//label[text()='" + optionName + "']/preceding-sibling::span/i")
                .shouldBe(interactable)
                .click();
    }
}
