package galvest.pages.elements;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;


public class MainPageElement {

    private final ElementsCollection elementBtn = $$x("//div[@class='catalog_blocks']/a[@href]");

    private int index;

    public MainPageElement(int index) {
        this.index = index;
    }

    public MainPageElement() {
    }

    public void chooseElement() {
        elementBtn.get(index).click();
    }

}
