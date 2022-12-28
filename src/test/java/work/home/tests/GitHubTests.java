package work.home.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {
    @Test
    void cartUnregistered(){
        open("https://github.com/");
        $("[data-scoped-placeholder=Search]").setValue("selenide").pressEnter();
        $$(".repo-list-item").first().$("a").click();
        $("#wiki-tab").click();
        $(byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(Condition.text("com.codeborne.selenide.junit5.SoftAssertsExtension"));
    }
}
