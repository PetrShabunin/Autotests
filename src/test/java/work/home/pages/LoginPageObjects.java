package work.home.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageObjects {
    public LoginPageObjects openPageRT(){
        open("https://front-spectrs-staging.apps.okd.stage.digital.rt.ru");
        return this;
    }
//    public LoginPageObjects choseAuthMethod(){
//        $("#t-btn-tab-login").click();
//        return this;
//    }
    public LoginPageObjects setUserName(String value){
        $("[data-test-id=userEmail]").setValue(value);
        return this;
    }
    public LoginPageObjects logout(){
        $(".profile-menu-button").click();
        $(".application-header_profile-logout-button").click();
        return this;
    }
    public LoginPageObjects setUserPass(String value){
        $(byText("Пароль")).setValue(value);
        return this;
    }
    public LoginPageObjects loginButtonClick(){
        $("[class=sc-dAlyuH]").click();
        return this;
    }
}