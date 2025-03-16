package galvest.pages.base_pages;

import galvest.pages.elements.CatalogElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseCatalogPage extends BasePage {

    CatalogElement catElements = new CatalogElement(driver);

    public BaseCatalogPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CatalogElement getCatalogElement(int index) {
        return new CatalogElement(driver, index);
    }

    public boolean checkingTheTUiquenessOfElements() {
         boolean checkUnique = catElements.getTextElements().stream()
                .distinct()
                .count() == catElements.getTextElements().size();
         return checkUnique;
    }
}
