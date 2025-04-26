package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;

public class ModalPageCommercialOffer extends BasePage {

  private final SelenideElement inputCompany = $x("//input[@name='name_company']");

  private final SelenideElement inputName = $x("//input[@name='name'][@placeholder='Введите ваше ФИО']");

  private final SelenideElement inputObjectName = $x("//input[@name='name_object']");

  private final SelenideElement btnSendOrder = $x("//button[@class='button button_send']");

  public ModalPageCommercialOffer setInputCompany(String value) {
      fillingOutInputFields(value, inputCompany);
      return this;
  }

    public ModalPageCommercialOffer setInputName(String value) {
        fillingOutInputFields(value, inputName);
        return this;
    }

    public ModalPageCommercialOffer SetInputObjectName(String value) {
        fillingOutInputFields(value, inputObjectName);
        return this;
    }

    public ModalPageCommercialOffer sendCommercialOffer() {
        btnSendOrder.should(interactable).click();
      return this;
    }
}
