package work.home.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import work.home.data.MenuButtonsData;
import work.home.pages.LoginPageObjects;
import java.io.*;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthorizationAndCheckTextsFromButtonTest extends TestBase {
    LoginPageObjects loginPageObjects = new LoginPageObjects();
    ClassLoader cl = AuthorizationAndCheckTextsFromButtonTest.class.getClassLoader();
    @AfterEach
    void endScenario(){
        loginPageObjects.logout();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
    static Stream<Arguments> buttonsDataName(){
        return Stream.of(
                Arguments.of(MenuButtonsData.MAIN.getDesc(), List.of("Для меня", "Для бизнеса", "Для операторов", "Блог")),
                Arguments.of(MenuButtonsData.BONUSES.getDesc(), List.of("Для меня", "Для бизнеса", "Для операторов", "Блог"))
        );
    }
    @MethodSource("buttonsDataName")
    @ParameterizedTest(name = "Проверка отображения кнопок топ-бара для кнопки меню: {0}")
    void checkTopButtonsTexts(String menuButtonsData, List<String> topButtonsTexts){
        loginPageObjects.LoginToCabinet("rtkid_1665832683250", "Test1234!");
        $$(".application-header_bottom_navigation a").find(text(menuButtonsData)).click();
        $$(".application-header_sector-links a").filter(visible)
                .shouldHave(CollectionCondition.texts(topButtonsTexts));
    }
    @EnumSource(MenuButtonsData.class)
    @ParameterizedTest(name = "Проверка текста у кнопоки: {0}")
    void checkMenuButtonsTexts(MenuButtonsData menuButtonsData){
        loginPageObjects.LoginToCabinet("rtkid_1665832683250", "Test1234!");
        $$(".application-header_bottom_navigation a").find(text(menuButtonsData.getDesc())).shouldBe(visible);
    }
    @Test
    void checkPrivatePolicy() throws Exception {
        loginPageObjects.LoginToCabinet("rtkid_1665832683250", "Test1234!");
        File privatePolicyFile = $(byText("Политикой конфиденциальности")).scrollTo().download();
        PDF pdf = new PDF(privatePolicyFile);
        assertThat(pdf.text).contains("Политика конфиденциальности сервиса «Личный кабинет абонента-физического лица»");
        }
    @Test
    void uploadFileInChat(){
        loginPageObjects
                .LoginToCabinet("rtkid_1665832683250", "Test1234!")
                .openChat();
        $("input[type = file]").uploadFromClasspath("test.png");
        $(".name").shouldHave(text("test"));
        $("#widget_closeChat").click();
    }
    @Test
    void zipTest() throws Exception {
        InputStream is = cl.getResourceAsStream("TestFile.zip");
        ZipInputStream zis = new ZipInputStream(is);
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println(entry.getName());
            //String entryName = entry.getName();
        }
    }

}

