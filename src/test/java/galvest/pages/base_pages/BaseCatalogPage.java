package galvest.pages.base_pages;

import galvest.pages.elements.CatalogElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCatalogPage extends BasePage {


    public BaseCatalogPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CatalogElement getCatalogElement(int index) {
        return new CatalogElement(driver, index);
    }
}
