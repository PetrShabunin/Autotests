package work.home.tests;

import com.codeborne.pdftest.assertj.Assertions;
import com.codeborne.selenide.Condition;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {
    @Test
    void gitHubSearch(){
        open("https://github.com/");
        $("[data-scoped-placeholder=Search]").setValue("selenide").pressEnter();
        $$(".repo-list-item").first().$("a").click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("soft");
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(Condition.text("com.codeborne.selenide.junit5.SoftAssertsExtension"));
    }
}
