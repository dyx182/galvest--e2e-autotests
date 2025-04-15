package galvest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
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
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @BeforeEach
    public void setUpTest() {
        Configuration.headless = false; // без GUI
        Configuration.holdBrowserOpen = false; // не закрывать браузер после теста
        Configuration.screenshots = true; // отключить скриншоты при падении
        Configuration.reportsFolder = "target/selenide-reports";
    }


    @AfterEach
    public void tearDown() {
    }
}


