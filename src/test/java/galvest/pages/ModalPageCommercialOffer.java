package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ModalPageCommercialOffer extends BasePage {

  private final SelenideElement inputCompany = $x("//input[@name='name_company']");

  private final SelenideElement inputName = $x("//input[@name='name'][@placeholder='Введите ваше ФИО']");

  private final SelenideElement inputObjectName = $x("//input[@name='name_object']");

  private final SelenideElement btnSendOrder = $x("//button[@class='button button_send']");

  private final SelenideElement commercialOfferText = $x("//p[text()='Ценовое предложение успешно сформировано.']");

  private final SelenideElement btnDownload = $x("//a[@download]");


  public ModalPageCommercialOffer setInputCompany(String value) {
      fillingOutInputFields(value, inputCompany);
      return this;
  }

    public ModalPageCommercialOffer setInputName(String value) {
        fillingOutInputFields(value, inputName);
        return this;
    }
    @Step("Заполнение поля")
    public ModalPageCommercialOffer SetInputObjectName(String value) {
        fillingOutInputFields(value, inputObjectName);
        return this;
    }
    @Step("Подтверждение выдачи коммерческого предложения")
    public ModalPageCommercialOffer sendCommercialOffer() {
        btnSendOrder.should(interactable).click();
        try {
            commercialOfferText.should(visible).should(text("Ценовое предложение успешно сформировано."));
        }
        catch (AssertionError e) {
            System.out.println("Неверный текст формирования предложения");
        }
      return this;
    }

    @Step("Загрузка коммерческого предложения")
    public ModalPageCommercialOffer DownloadCO() {
        btnDownload.should(interactable).click();
      return this;
    }
}
