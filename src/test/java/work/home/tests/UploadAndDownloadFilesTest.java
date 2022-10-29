package work.home.tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;
import work.home.pages.LoginPageObjects;
import java.io.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UploadAndDownloadFilesTest extends TestBase {
    LoginPageObjects loginPageObjects = new LoginPageObjects();
    @Test
    void checkPrivatePolicy() throws Exception {
        loginPageObjects.LoginToCabinet("rtkid_1665832683250", "Test1234!");
        File privatePolicyFile = $(byText("Политикой конфиденциальности")).scrollTo().download();
        PDF pdf = new PDF(privatePolicyFile);
        assertThat(pdf.text).contains("Политика конфиденциальности сервиса «Личный кабинет абонента-физического лица»");
        }
    @Test
    void uploadFileInChat() {
        loginPageObjects
                .LoginToCabinet("rtkid_1665832683250", "Test1234!")
                .openChat();
        $("input[type = file]").uploadFromClasspath("test.png");
        $(".name").shouldHave(text("test"));
        $("#widget_closeChat").click();
    }
}

