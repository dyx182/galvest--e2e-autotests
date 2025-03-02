package galvest.pages;

import galvest.pages.base_pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends BasePage {

    @FindBy(xpath = "//div[@class='jq-selectbox__select']")
    private WebElement userType;

    @FindBy(xpath = "//div[@class='jq-selectbox__select-text']")
    private WebElement userTypeText;

    @FindBy(xpath = "//li[(@data-jqfs-class='phys')]")
    private WebElement individualType;

    @FindBy(xpath = "//form/div[1]//div[1]/input")
    private WebElement inputName;

    @FindBy(xpath = "//div[1]/div[2]/div[2]/input")
    private WebElement inputPhone;

    @FindBy(xpath = "//div[1]/div[2]/div[3]/input")
    private WebElement inputEmail;

    @FindBy(xpath = "//textarea[@name='comment']")
    private WebElement inputComment;

    @FindBy(xpath = "//label[@for='order1']")
    private WebElement cbPickUp;

    @FindBy(xpath = "//div//div[3]//label")
    private WebElement cbPersonalData;

    @FindBy(xpath = "//div[2]/div/div/h4")
    private WebElement orderConfirmationText;

    @FindBy(xpath = "//form/div[3]/button")
    private WebElement btnSendApplication;

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
