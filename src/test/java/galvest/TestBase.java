package galvest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestBase {



    @BeforeEach
    public void setUp() {
        System.setProperty("WebDriver.chrome.driver", "drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");

    }


    @AfterEach
    public void tearDown() {
    }
}


