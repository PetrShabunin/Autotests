package work.home.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationFormPages {
    //переменные
    static String sex = "Female"; // можно ли добиться того же но более красиво? чтобы меняя одну переменную в этом файле - менялось и в другом
    public static String gender(){
        return sex;
    }

    public SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput =  $("#lastName"),
            userEmailInput =  $("#userEmail"),
            userGenderChoise =  $("#genterWrapper");


    public RegistrationFormPages openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPages firstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPages lastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPages userEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationFormPages userGender(String sex){
        userGenderChoise.$(byText(sex)).click();
        return this;
    }

}