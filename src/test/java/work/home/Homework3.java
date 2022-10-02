package work.home;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Homework3 {
    String name = "Petr";
    String lastName = "Petr 2";
    String email = "Petr@email.com";
    String number = "9990000000";
    String day = "23";
    String month = "June";
    String year = "1996";
    String subject = "Maths";
    String hobbies = "Music";
    String address = "some address";
    String state = "Haryana";
    String city = "Panipat";
    String sex = "Male";
    String file = "test.png";

    @BeforeAll
    static void Configurations(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1600x1080";
    }

    @Test
    void RegistrationForm(){
        open("/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(sex)).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month").$(withText(day)).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(withText(hobbies)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/"+file));
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(withText(state)).click();
        $("#city").click();
        $(withText(city)).click();
        $("#submit").click();

        //валидация данных

        $(".modal-body").shouldHave(Condition.text(name+ " " +lastName));
        $(".modal-body").shouldHave(Condition.text(email));
        $(".modal-body").shouldHave(Condition.text(sex));
        $(".modal-body").shouldHave(Condition.text(number));
        $(".modal-body").shouldHave(Condition.text(day+ " " +month+ "," +year));
        $(".modal-body").shouldHave(Condition.text(subject));
        $(".modal-body").shouldHave(Condition.text(hobbies));
        $(".modal-body").shouldHave(Condition.text(file));
        $(".modal-body").shouldHave(Condition.text(address));
        $(".modal-body").shouldHave(Condition.text(state+ " " +city));
    }
}
