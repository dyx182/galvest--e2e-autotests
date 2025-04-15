package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$x;

public class OrderPage extends BasePage {

    private final SelenideElement userType = $x("//div[@class='jq-selectbox__select']");

    private final SelenideElement userTypeText = $x("//div[@class='jq-selectbox__select-text']");

    private final SelenideElement individualType = $x("//li[(@data-jqfs-class='phys')]");

    private final SelenideElement inputName = $x("//form/div[1]//div[1]/input");
    //TODO Поменять локатор
    private final SelenideElement inputPhone = $x("//div[1]/div[2]/div[2]/input");
    //TODO Поменять локатор
    private final SelenideElement inputEmail = $x("//div[1]/div[2]/div[3]/input");

    private final SelenideElement inputComment = $x("//textarea[@name='comment']");

    private final SelenideElement cbPickUp = $x("//label[@for='order1']");
    //TODO Поменять локатор
    private final SelenideElement cbPersonalData = $x("//div//div[3]//label");
    //TODO Поменять локатор
    private final SelenideElement orderConfirmationText = $x("//div[2]/div/div/h4");

    private final SelenideElement btnSendApplication = $x("(//button[contains(text(), 'отправить заявку')])[1]");


    public OrderPage() {
    }
    @Step("Проверка и выбор опции ФЛ в дд 'Тип пользователя'")
    public OrderPage checkAndSetindividualType(String userType) {
        while (!userType.equals(userTypeText.getText())) {
            this.userType.click();
            individualType.click();
        }
        return this;
    }
    @Step("Заполнение поля 'ФИО'")
    public OrderPage setInputName(String value) {
        fillingOutInputFields(value, inputName);
        return this;
    }
    @Step("Заполнение пооя 'Телефон'")
    public OrderPage setinputPhone(String value) {
        fillingOutInputFields(value, inputPhone);
        return this;
    }
    @Step("Заполнения поля 'Email'")
    public OrderPage setinputEmail(String value) {
        fillingOutInputFields(value, inputEmail);
        return this;
    }
    @Step("Проверка чек бокса 'Доставка'")
    public OrderPage setDeliveryOption() {
        if (!cbPickUp.isSelected()) {
            cbPickUp.click();
        }
        return this;
    }
    @Step("Добавление комментария в поле 'Комментарий к заказу'")
    public OrderPage setComment(String value) {
        fillingOutInputFields(value, inputComment);
        return this;
    }
    @Step("Подтверждение оформления заказа")
    public OrderPage confirmOrder() {
        System.out.println(orderConfirmationText.getText());
        return this;
    }
    @Step("Нажатие кнопки 'Отправить заявку'")
    public OrderPage sendApplication() {
        btnSendApplication.click();
        return this;
    }
}
