package galvest.pages;


import galvest.pages.base_pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static galvest.TestData.BASE_URL;


public class MainPage extends BasePage {

    @FindBy(css = "a.cat1 span")
    private WebElement btnCatOne;

    private Header header = new Header(driver, wait);

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public Header getHeader() {
        return header;
    }

    public MainPage open() {
        driver.navigate().to(BASE_URL);
        return new MainPage(driver, wait);
    }

//    // Нажатие анкерные составы на главной
//    public MainPage clickButtonProductOne() {
//        btnCatOne.click();
//        return this;
//    }

    public MainPage checkSendMessage() {
        getSendMessage().isDisplayed();
        return this;
    }
}