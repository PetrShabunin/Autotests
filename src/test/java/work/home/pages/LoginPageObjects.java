package work.home.pages;

import static com.codeborne.selenide.Selenide.*;

public class LoginPageObjects {
    public LoginPageObjects openPageRT(){
        open("https://lk.rt.ru");
        return this;
    }
    public LoginPageObjects choseAuthMethod(){
        $("#t-btn-tab-login").click();
        return this;
    }
    public LoginPageObjects setUsername(String value){
        $("#username").setValue(value);
        return this;
    }
    public LoginPageObjects logout(){
        $(".profile-menu-button").click();
        $(".application-header_profile-logout-button").click();
        return this;
    }
    public LoginPageObjects setUserPass(String value){
        $("#password").setValue(value);
        return this;
    }
    public LoginPageObjects loginButtonClick(){
        $("#kc-login").click();
        return this;
    }
}