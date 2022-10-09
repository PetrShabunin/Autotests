package work.home.pages;

import com.codeborne.selenide.SelenideElement;
import work.home.pages.components.CalendarComponent;
import work.home.pages.components.ResultsTableComponent;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPages {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput =  $("#lastName"),
            userEmailInput =  $("#userEmail"),
            userGenderChoise =  $("#genterWrapper");
    public RegistrationFormPages openPage() {
        open("/automation-practice-form");
        return this;
    }
    public RegistrationFormPages setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPages setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPages setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationFormPages setGender(String value){
        userGenderChoise.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPages setNumber(String value){
        $("#userNumber").setValue(value);
        return this;
    }
    public RegistrationFormPages setBirthDate(String month, String year, String day){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(month, year, day);
        return this;
    }
    public RegistrationFormPages setSubject(String value){
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }
    public RegistrationFormPages setHobbies(String value){
        $("#hobbiesWrapper").$(withText(value)).click();
        return this;
    }
    public RegistrationFormPages setPicture(String value){
        $("#uploadPicture").uploadFile(new File("src/test/resources/"+value));
        return this;
    }
    public RegistrationFormPages setAddress(String value){
        $("#currentAddress").setValue(value);
        return this;
    }
    public RegistrationFormPages setState(String value){
        $("#state").click();
        $(withText(value)).click();
        return this;
    }
    public RegistrationFormPages setCity(String value){
        $("#city").click();
        $(withText(value)).click();
        return this;
    }
    public RegistrationFormPages submit(){
        $("#submit").click();
        return this;
    }
    public RegistrationFormPages checkResults(String key, String value){
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}