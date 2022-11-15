package work.home.pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class LoginPageObjects {
    public LoginPageObjects logout(){
        $(".profile-menu-button").click();
        $(".application-header_profile-logout-button").click();
        return this;
    }
    public LoginPageObjects LoginToCabinet(String name, String pass){
        open("https://lk.rt.ru");
        $("#t-btn-tab-login").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        $("#username").setValue(name);
        $("#password").setValue(pass);
        $("#kc-login").click();
        return this;
    }
    public LoginPageObjects openChat(){
        $("#widget_bar").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }
}