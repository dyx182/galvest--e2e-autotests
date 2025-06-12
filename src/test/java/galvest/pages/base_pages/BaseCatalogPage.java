package galvest.pages.base_pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import galvest.common.enums.FilteringCheck;
import galvest.common.enums.Product;
import galvest.pages.component.Header;
import galvest.pages.component.ProductFilter;
import galvest.pages.elements.CatalogElement;
import io.qameta.allure.Step;
import lombok.Getter;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class BaseCatalogPage<T extends BaseCatalogPage<T>> extends BasePage {

    @Getter
    private final Header header;
    @Getter
    private String savedTitleText;

    private final SelenideElement filterBtn = $x("//span[text()='Показать фильтр']");

    private final SelenideElement negativeText = $x("//p[text()='По вашему запросу товаров не найдено, попробуйте смягчить условия поиска.']");

    private final CatalogElement catElements = new CatalogElement();

    public BaseCatalogPage() {
        header = new Header();
    }

    public CatalogElement getCatalogElement(int index) {
        return new CatalogElement(index);
    }

    public boolean areElementsUnique() {
        return catElements.getTextElements().stream()
                .distinct()
                .count() == catElements.getTextElements().size();
    }

    public T assertTitlePage() {
        return (T) this;
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

    @Step("Добавление элемента в корзину и получение его названия {index}")
    public T addGoodElement(Integer index) {
        getCatalogElement(index).addElement();
        savedTitleText = getCatalogElement(index).getTextTitleElement();
        return (T) this;
    }

    @Step("Проверка результатов фильтрации {variable}")
    public T checkingResult(FilteringCheck variable) {
        switch (variable) {
            case EMPTY -> {
                catElements.getElements().should(CollectionCondition.empty);
                negativeText.should(visible);
            }
            case FILLED -> {
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
