package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int days) {
        String date = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        Faker faker = new Faker(Locale.forLanguageTag(locale));
        String city = faker.address().cityName();
        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(Locale.forLanguageTag(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(Locale.forLanguageTag(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo((generateCity(locale)), generateName(locale), generatePhone(locale));
            return user;
        }
    }


    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
