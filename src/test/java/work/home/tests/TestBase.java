package work.home.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import work.home.tests.utils.RandomUtils;

import java.util.Locale;

public class TestBase extends RandomUtils {
    Faker faker = new Faker(new Locale("ru"));
    String firstName = getRandomString(8),
            lastName = getRandomString(8),
            email = getRandomEmail(),
            phoneNumber = getRandomPhone(),
            day = getRandomDay(),
            month = String.valueOf(Month.getRandomMonth()),
            year = getRandomYear(),
            subject = "Maths",
            hobbies = String.valueOf(Hobbies.getRandomHobbies()),
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Panipat",
            sex = "Female",
            file = "test.png";
    @BeforeAll
    static void configurations() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1600x1080";
    }
}
