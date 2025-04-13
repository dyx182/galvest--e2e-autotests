package galvest.pages.elements;


import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

@Getter
@Setter
public class CatalogElement {

    private final ElementsCollection btnAddToBasket = $$x("//a[@class='button buy to_basket']");

    private final ElementsCollection element = $$x("//li/div[starts-with(@class,'product')]");

    private final ElementsCollection titleElement = $$x("//li//span[@class='product_name']");


    private int index;
    private List<String> textElements;

    public CatalogElement(int index) {
        this.index = index;
    }

    public CatalogElement() {
    }

    public void addElement() {
        btnAddToBasket.get(index).click();
    }


    //текст элементов
    public List<String> getTextElements() {
       return textElements = getTitleElement().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    //текст элемента
    public String getTextTitleElement() {
        return titleElement.get(index).getText();
    }
}
