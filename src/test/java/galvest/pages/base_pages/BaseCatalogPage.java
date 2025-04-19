package galvest.pages.base_pages;

import galvest.pages.elements.CatalogElement;
import io.qameta.allure.Step;

public class BaseCatalogPage extends BasePage {

    CatalogElement catElements = new CatalogElement();

    public CatalogElement getCatalogElement(int index) {
        return new CatalogElement(index);
    }

    public boolean areElementsUnique() {
        return catElements.getTextElements().stream()
                .distinct()
                .count() == catElements.getTextElements().size();
    }

    @Step("Првоерка уникальности элементов")
    public BaseCatalogPage checkElementsUniqueness() {
        if (!areElementsUnique()) {
            throw new AssertionError("Элементы в каталоге не уникальны!");
        }
        return this;
    }
}
