package galvest.pages.base_pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import galvest.pages.Header;
import galvest.pages.component.ProductFilter;
import galvest.pages.elements.CatalogElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class BaseCatalogPage<T extends BaseCatalogPage<T>> extends BasePage {


    private final SelenideElement filterBtn = $x("//span[text()='Показать фильтр']");

    private final SelenideElement negativeText = $x("//p[text()='По вашему запросу товаров не найдено, попробуйте смягчить условия поиска.']");

    private final CatalogElement catElements = new CatalogElement();

    private final Header header = new Header();

    private String savedTitleText;

    public String getSavedTitleText() {
        return savedTitleText;
    }

    public Header getHeader() {
        return new Header();
    }

    public CatalogElement getCatalogElement(int index) {
        return new CatalogElement(index);
    }

    public boolean areElementsUnique() {
        return catElements.getTextElements().stream()
                .distinct()
                .count() == catElements.getTextElements().size();
    }

    public BaseCatalogPage assertTitlePage() {
        return this;
    }

    @Step("Првоерка уникальности элементов")
    public T  checkElementsUniqueness() {
        if (!areElementsUnique()) {
            throw new AssertionError("Элементы в каталоге не уникальны!");
        }
        return (T) this;
    }

    @Step("Открытие фильтра")
    public ProductFilter openFilter() {
        filterBtn.should(interactable).click();
        return new ProductFilter();
    }

    @Step("Добавление элемента в корзину и получение его названия")
    public T addGoodElement(int index) {
        getCatalogElement(index).addElement();
        savedTitleText = getCatalogElement(index).getTextTitleElement();
        return (T) this;
    }

    @Step("Проверка результатов фильтрации")
    public T checkingResult(int expectedResult) {
        switch (expectedResult) {
            case 0 -> {
                catElements.getElements().should(CollectionCondition.empty);
                negativeText.should(visible);
            }
            case 1 -> {
                catElements.getElements()
                        .shouldHave(sizeGreaterThan(0))
                        .first().shouldBe(interactable);
                negativeText.shouldNot(exist);
            }
        }
        System.out.println("Элементов найдено: " + catElements.getElements().size());
        System.out.println("Текст 'не найдено' присутствует на странице " + negativeText.isDisplayed());
        return (T) this;
    }
}
