package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    private static final Faker faker = new Faker(new Locale("en"));

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{
                "Новосибирск", "Москва", "Томск", "Кемерово", "Уфа", "Омск", "Самара",
                "Пермь", "Ижевск", "Красноярск", "Хабаровск", "Барнаул", "Санкт-Петербург"
        };

        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }

        public static String getRandomPhone() {
            String phone = faker.phoneNumber().phoneNumber();
            return phone;
        }

        public static String getRandomName() {
            String name = faker.name().name();
            return name;
        }

        public static String getRandomCity() {
            String city = faker.address().city();
            return city;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }

}
