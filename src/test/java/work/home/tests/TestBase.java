package work.home.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import work.home.helpers.Attach;
import work.home.pages.LoginPageObjects;

public class TestBase {
    LoginPageObjects loginPageObjects = new LoginPageObjects();
    @BeforeAll
    static void configurations() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 3000;
        Configuration.browserSize = "1600x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
    @AfterEach
    void endScenario(){
        loginPageObjects.logout();
//        Selenide.clearBrowserCookies();
//        Selenide.clearBrowserLocalStorage();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
