package galvest.pages.elements;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;
import static com.codeborne.selenide.Selenide.$$x;


public class CatalogElement {

    private final ElementsCollection btnAddToBasket = $$x("//a[@class='button buy to_basket']");

    //private final ElementsCollection element = $$x("//li/div[starts-with(@class,'product')]");

    private final ElementsCollection titleElement = $$x("//li//span[@class='product_name']");

    private int index;

    public CatalogElement(int index) {
        this.index = index;
    }

    public CatalogElement() {
    }

    public void addElement() {
        btnAddToBasket.get(index).click();
    }

    public List<String> getTextElements() {
       return  titleElement.texts();
    }

    public String getTextTitleElement() {
        return titleElement.get(index).getText();
    }
}
