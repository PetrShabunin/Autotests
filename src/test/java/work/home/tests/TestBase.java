package work.home.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import work.home.pages.LoginPageObjects;

public class TestBase {
    LoginPageObjects loginPageObjects = new LoginPageObjects();
    @BeforeAll
    static void configurations() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1600x1080";
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 3000;
    }
    @AfterEach
    void endScenario(){
        loginPageObjects.logout();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
