package galvest.pages.base_pages;

import galvest.pages.elements.CatalogElement;
import io.qameta.allure.Step;

public class BaseCatalogPage extends BasePage {

    CatalogElement catElements = new CatalogElement();

    public CatalogElement getCatalogElement(int index) {
        return new CatalogElement(index);
    }

    @Step("Првоерка количества элементов")
    public void checkingTheTUiquenessOfElements() {
        boolean checkUnique = catElements.getTextElements().stream()
                .distinct()
                .count() == catElements.getTextElements().size();
        if (!checkUnique) {
            System.out.println("Необходимо проверить каталог");
        }
    }
}
