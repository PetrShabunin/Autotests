package work.home.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase{
    @BeforeAll
    static void configurations() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1600x1080";
//        Configuration.timeout = 10000;
//        Configuration.pollingInterval = 3000;
    }
}
