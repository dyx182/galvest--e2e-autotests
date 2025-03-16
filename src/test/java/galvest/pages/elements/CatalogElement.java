package galvest.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogElement {

    @FindBy(xpath = "//a[@class='button buy to_basket']")
    private List<WebElement> btnAddToBasket;

    @FindBy(xpath = "//li/div[starts-with(@class,'product')]")
    private List<WebElement> element;

    @FindBy(xpath = "//li//span[@class='product_name']")
    private List<WebElement> titleElement;

    private WebDriver driver;
    private int index;
    private List<String> textElements;

    public CatalogElement(WebDriver driver, int index) {
        this.driver = driver;
        this.index = index;
        PageFactory.initElements(driver, this);
    }

    public CatalogElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addElement() {
        btnAddToBasket.get(index).click();
    }

    public List<WebElement> getTitleElement() {
        return titleElement;
    }
    //текст элементов
    public List<String> getTextElements() {
       return textElements = getTitleElement().stream()
                .map(WebElement::getText)
                .toList();
    }
    //текст элемента
    public String getTextTitleElement() {
        return titleElement.get(index).getText();
    }
}
