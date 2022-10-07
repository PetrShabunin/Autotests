package work.home.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationFormPages {
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
    public void openPage() {
        open("/automation-practice-form");
    }

    public void FirstName(String value) {
        $("#firstName").setValue(value);
    }
}