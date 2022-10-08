package work.home.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {
public ResultsTableComponent checkResult (String key, String value){
    $(".table-responsive").$(byText(key)).parent().shouldHave(Condition.text(value));
    return this;
}
}


