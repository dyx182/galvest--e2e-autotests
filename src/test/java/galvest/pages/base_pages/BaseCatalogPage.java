package galvest.pages.base_pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import galvest.pages.GlueCatalogPage;
import galvest.pages.Header;
import galvest.pages.elements.CatalogElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class BaseCatalogPage<T extends BaseCatalogPage<T>> extends BasePage {



    private final SelenideElement filterBtn = $x("//span[text()='Показать фильтр']");

    private final SelenideElement btnConfirmFltr = $x("//input[@value='Применить']");

    private final SelenideElement btnReset = $x("//a[@href='#']");


    private final SelenideElement negativeText = $x("//p[text()='По вашему запросу товаров не найдено, попробуйте смягчить условия поиска.']");

    private final CatalogElement catElements = new CatalogElement();

    private final Header header = new Header();

    private String savedTitleText;

    public String getSavedTitleText() {
        return savedTitleText;
    }

    public Header getHeader() {
        return new Header();
    }

    public CatalogElement getCatalogElement(int index) {
        return new CatalogElement(index);
    }

    public boolean areElementsUnique() {
        return catElements.getTextElements().stream()
                .distinct()
                .count() == catElements.getTextElements().size();
    }

    public BaseCatalogPage assertTitlePage() {
        return this;
    }

    @Step("Првоерка уникальности элементов")
    public T  checkElementsUniqueness() {
        if (!areElementsUnique()) {
            throw new AssertionError("Элементы в каталоге не уникальны!");
        }
        return (T) this;
    }

    @Step("Открытие фильтра")
    public T openFilter() {
        filterBtn.click();
        return (T) this;
    }


    @Step("Выбор фильтра 'Производитель': {index}")
    public T brandSelection(int index) {
        $x("//div[@class='SumoSelect sumo_brand']").click();
        for (int i = 1; i < 5; i++) {
            $x("(//p[@title=' Производитель']/following-sibling::div//i)["+ i +"]")
                    .click();
        }
        btnReset.click();

        $x("(//p[@title=' Производитель']/following-sibling::div//i)["+ index +"]")
                    .click();
        return (T) this;
    }

    @Step("Выбор страны производителя: {countries}")
    public T selectCountries(String... countries) {
        return (T) this;
    }

    @Step("Выбор фильтра 'Основа'")
    public T baseSelection (String baseName) {
        return (T) this;
    }

    @Step("Выбор фильтра 'Температура'")
    public T temperatureSelection (String temperatureName) {
        return (T) this;
    }

    @Step("Нажатие кнопки 'Применить в фильтре'")
    public T clickConfirmBtn() {
        btnConfirmFltr.click();
        return (T) this;
    }

    @Step("Проверка результатов фильтрации")
    public T checkingResult(int expectedResult) {
        switch (expectedResult) {
            case 0 -> {
                catElements.getElements().should(CollectionCondition.empty);
                negativeText.should(visible);
            }
            case 1 -> {
                catElements.getElements()
                        .shouldHave(sizeGreaterThan(0))
                        .first().shouldBe(interactable);
                negativeText.shouldNot(exist);
            }
        }
        System.out.println("Элементов найдено: " + catElements.getElements().size());
        System.out.println("Текст 'не найдено' виден? " + negativeText.isDisplayed());
        return (T) this;
    }

    @Step("Добавление элемента в корзину и получение его названия")
    public T addGoodElement(int index) {
        getCatalogElement(index).addElement();
        savedTitleText = getCatalogElement(index).getTextTitleElement();
        return (T) this;
    }
}
