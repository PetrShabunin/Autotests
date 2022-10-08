package work.home.pages.components;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CalendarComponent {

    public CalendarComponent setDate(String month, String year, String day){
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month").$(withText(day)).click();
        return this;
    }

}