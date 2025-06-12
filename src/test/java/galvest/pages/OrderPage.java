package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.models.IndividualDTO;
import galvest.pages.base_pages.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static galvest.utils.PageUtils.fillingOutInputFields;

public class OrderPage extends BasePage {

    private final SelenideElement userType = $x("//div[@class='jq-selectbox__select']");

    private final SelenideElement userTypeText = $x("//div[@class='jq-selectbox__select-text']");

    private final SelenideElement individualType = $x("//li[(@data-jqfs-class='phys')]");

    private final SelenideElement inputName = $x("//input[@placeholder='Введите ваше ФИО'][@required]");

    private final SelenideElement inputPhone = $x("//input[@placeholder='Введите ваш телефон']");

    private final SelenideElement inputEmail = $x("//input[@placeholder='Введите ваш e-mail']");

    private final SelenideElement inputComment = $x("//textarea[@name='comment']");

    private final SelenideElement cbPickUp = $x("//label[@for='order1']");

    private final SelenideElement cbPersonalData = $x("(//label[@for='form_callback_check'])[1]");

    private final SelenideElement orderConfirmationText = $x("(//div/h4)[1]");

    private final SelenideElement btnSendApplication = $x("(//button[contains(text(), 'отправить заявку')])[1]");

    @Step("Проверка и выбор опции ФЛ в дд 'Тип пользователя' {userType}")
    public OrderPage checkAndSetindividualType(String userType) {
        while (!userType.equals(userTypeText.getText())) {
            this.userType.click();
            individualType.should(interactable).click();
        }
        return this;
    }
    @Step("Заполнение поля 'ФИО' {userName}")
    public OrderPage setInputName(String userName) {
        fillingOutInputFields(userName, inputName);
        return this;
    }
    @Step("Заполнение пооя 'Телефон' {phoneNumber}")
    public OrderPage setinputPhone(String phoneNumber) {
        fillingOutInputFields(phoneNumber, inputPhone);
        return this;
    }
    @Step("Заполнения поля 'Email' {email}")
    public OrderPage setinputEmail(String email) {
        fillingOutInputFields(email, inputEmail);
        return this;
    }
    @Step("Проверка чек бокса 'Доставка'")
    public OrderPage setDeliveryOption() {
        if (!cbPickUp.isSelected()) {
            cbPickUp.click();
        }
        return this;
    }
    @Step("Добавление комментария в поле 'Комментарий к заказу' {comment}")
    public OrderPage setComment(String comment) {
        fillingOutInputFields(comment, inputComment);
        return this;
    }
    @Step("Подтверждение оформления заказа")
    public OrderPage confirmOrder() {
        System.out.println(orderConfirmationText.getText());
        return this;
    }
    @Step("Нажатие кнопки 'Отправить заявку'")
    public OrderPage sendApplication() {
        btnSendApplication.should(interactable).click();
        return this;
    }
}
