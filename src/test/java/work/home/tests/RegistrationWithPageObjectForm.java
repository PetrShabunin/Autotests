package work.home.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import work.home.pages.RegistrationFormPages;

public class RegistrationWithPageObjectForm {
    String firstName = "Petr";
    String lastName = "Petr 2";
    String email = "Petr@email.com";
    String phoneNumber = "9990000000";
    String day = "23";
    String month = "June";
    String year = "1999";
    String subject = "Maths";
    String hobbies = "Music";
    String address = "some address";
    String state = "Haryana";
    String city = "Panipat";
    String sex = "Female";
    String file = "test.png";
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();
    @BeforeAll
    static void configurations(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1600x1080";
    }
    @Test
    void registrationFormTest(){
        registrationFormPages
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(sex)
                .setNumber(phoneNumber)
                .setBirthDate(month, year, day)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setPicture(file)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()
                .checkResults("Student Name", firstName+ " " +lastName)
                .checkResults("Student Email", email);
    }
}
