package work.home.pages;

import static com.codeborne.selenide.Selenide.*;

public class loginPageObjects {
    public loginPageObjects openPageRT(){
        open("https://lk.rt.ru");
        return this;
    }
    public loginPageObjects choseAuthMethod(){
        $("#t-btn-tab-login").click();
        return this;
    }
    public loginPageObjects setUsername(String value){
        $("#username").setValue(value);
        return this;
    }
    public loginPageObjects logout(){
        $(".profile-menu-button").click();
        $(".application-header_profile-logout-button").click();
        return this;
    }
    public loginPageObjects setUserPass(String value){
        $("#password").setValue(value);
        return this;
    }
    public loginPageObjects loginButtonClick(){
        $("#kc-login").click();
        return this;
    }
}