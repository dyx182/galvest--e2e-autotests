package galvest.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogElement {

    @FindBy(xpath = "//a[@class='button buy to_basket']")
    List<WebElement> btnAddToBasket;

    WebDriver driver;
    int index;

    public CatalogElement(WebDriver driver, int index) {
        this.driver = driver;
        this.index = index;
        PageFactory.initElements(driver, this);
    }

    public void addElement() {
        btnAddToBasket.get(index).click();
    }

}
