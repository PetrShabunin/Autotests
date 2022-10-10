package work.home.tests.utils;

import com.github.javafaker.Faker;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomString(int length) {
        String SALTCHARS = "aAbBcCdDeEfFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }
    public static String getRandomEmail(){
        return getRandomString(10) + "@test.com";
    }
    public static Long getRandomLong(Long min, Long max){
        return ThreadLocalRandom.current().nextLong(min, max);
    }
    public static String getRandomPhone(){
        return getRandomLong(9000000000L, 9999999999L).toString();
    }
}
