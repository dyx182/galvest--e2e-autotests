package galvest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;



public class TestBase {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        //System.setProperty("webdriver.chrome.driver", "путь/к/драйверу");
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000; // 10 секунд
        Configuration.browser = "chrome";
    }

    @BeforeEach
    public void setUpTest() {
        Configuration.headless = false; // без GUI
        Configuration.holdBrowserOpen = false; // не закрывать браузер после теста
        Configuration.screenshots = false; // отключить скриншоты при падении
        Configuration.reportsFolder = "target/selenide-reports";
    }


    @AfterEach
    public void tearDown() {
    }
}


