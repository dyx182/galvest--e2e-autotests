package galvest.pages.base_pages;

import galvest.pages.elements.CatalogElement;


public class BaseCatalogPage extends BasePage {

    CatalogElement catElements = new CatalogElement();


    public CatalogElement getCatalogElement(int index) {
        return new CatalogElement(index);
    }

    public boolean checkingTheTUiquenessOfElements() {
         boolean checkUnique = catElements.getTextElements().stream()
                .distinct()
                .count() == catElements.getTextElements().size();
         return checkUnique;
    }
}
