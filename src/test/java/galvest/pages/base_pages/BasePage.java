package galvest.pages.base_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    @FindBy(xpath = "//jdiv[@class='hoverArea__cMvXG']")
    private WebElement sendMessage;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSendMessage() {
        return sendMessage;
    }

    protected void fillingOutInputFields(String value, WebElement input) {
        try {
            for (char c : value.toCharArray()) {
                input.sendKeys(String.valueOf(c));
                Thread.sleep(30);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}