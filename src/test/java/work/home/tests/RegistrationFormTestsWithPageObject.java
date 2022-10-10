package work.home.tests;

import org.junit.jupiter.api.Test;
import work.home.pages.RegistrationFormPages;

public class RegistrationFormTestsWithPageObject extends TestBase {
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();
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
