package work.home.tests.utils;

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

    public static String getRandomEmail() {
        return getRandomString(10) + "@test.com";
    }

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomPhone() {
        return getRandomLong(9000000000L, 9999999999L).toString();
    }

    public static String getRandomDay() {
        return getRandomLong(1L, 28L).toString();
    }

    public static String getRandomYear() {
        return getRandomLong(1900L, 2020L).toString();
    }

    public enum Month {
        January,
        February,
        March,
        April,
        May,
        June,
        July,
        August,
        September,
        October,
        November,
        December;

        public static Month getRandomMonth() {
            int monthPick = new Random().nextInt(Month.values().length);
            return Month.values()[monthPick];
        }
    }
    public enum Hobbies {
        Sports,
        Reading,
        Music;

        public static Hobbies getRandomHobbies() {
            int hobbiesPick = new Random().nextInt(Hobbies.values().length);
            return Hobbies.values()[hobbiesPick];
        }
    }
}
