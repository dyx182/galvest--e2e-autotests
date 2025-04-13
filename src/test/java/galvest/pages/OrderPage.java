package galvest.pages;

import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    //TODO Поменять локатор
    private final SelenideElement btnSendApplication = $x("//form/div[3]/button");


    public OrderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public OrderPage checkAndSetindividualType(String userType) {
        while (!userType.equals(userTypeText.getText())) {
            this.userType.click();
            individualType.click();
        }
        return this;
    }

    public OrderPage setInputName(String value) {
        fillingOutInputFields(value, inputName);
        return this;
    }

    public OrderPage setinputPhone(String value) {
        fillingOutInputFields(value, inputPhone);
        return this;
    }

    public OrderPage setinputEmail(String value) {
        fillingOutInputFields(value, inputEmail);
        return this;
    }

    public OrderPage setDeliveryOption() {
        if (!cbPickUp.isSelected()) {
            cbPickUp.click();
        }
        return this;
    }

    public OrderPage setComment(String value) {
        fillingOutInputFields(value, inputComment);
        return this;
    }

    public OrderPage confirmOrder() {
        System.out.println(orderConfirmationText.getText());
        return this;
    }

    public OrderPage sendApplication() {
        btnSendApplication.click();
        return this;
    }
}
