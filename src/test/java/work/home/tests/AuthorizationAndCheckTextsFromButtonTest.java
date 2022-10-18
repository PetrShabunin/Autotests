package work.home.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import work.home.data.MenuButtonsData;
import work.home.pages.LoginPageObjects;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationAndCheckTextsFromButtonTest extends TestBase {
    LoginPageObjects loginPageObjects = new LoginPageObjects();
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
        loginPageObjects
                .openPageRT()
                .choseAuthMethod()
                .setUsername("rtkid_1665832683250")
                .setUserPass("Test1234!")
                .loginButtonClick();
        $$(".application-header_bottom_navigation a").find(text(menuButtonsData)).click();
        $$(".application-header_sector-links a").filter(visible)
                .shouldHave(CollectionCondition.texts(topButtonsTexts));
    }
    @EnumSource(MenuButtonsData.class)
    @ParameterizedTest(name = "Проверка текста у кнопоки: {0}")
    void checkMenuButtonsTexts(MenuButtonsData menuButtonsData){
        loginPageObjects
                .openPageRT()
                .choseAuthMethod()
                .setUsername("rtkid_1665832683250")
                .setUserPass("Test1234!")
                .loginButtonClick();
        $$(".application-header_bottom_navigation a").find(text(menuButtonsData.getDesc())).shouldBe(visible);

    }
}
