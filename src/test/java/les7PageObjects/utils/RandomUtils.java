package les7PageObjects.utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static String selectedState = "Здесь будет сохранено название выбранного State";
    static String resultingCity = "Здесь будет сохранено название City после выполнения метода - getRandomCity()";

    public static String getRandomString(int len) {
//  String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    public static String getRandomItemFromArrayState(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        selectedState = array[index];
        return array[index];
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return getRandomItemFromArray(months);
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@yandex.ru";
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Accounting", "Art", "Biology",
                "Chemistry", "Computer Science", "Commerce",
                "Civics", "English", "Economics", "Hindi",
                "History", "Maths", "Physics"};
        return getRandomItemFromArray(subjects);
    }

    public static String getRandomPicture() {
        String[] subjects = {"картинка.jpg", "picture.jpg", "пикче.jpg"};
        return getRandomItemFromArray(subjects);
    }

    public static String getRandomState() {
        String[] states = {
                "NCR",
                "Uttar Pradesh",
                "Haryana",
                "Rajasthan"};
        return getRandomItemFromArrayState(states);
    }

    public static String getRandomCity() {
        String[] citiesOfNcr = {"Delhi", "Gurgaon", "Noida"};
        String[] citiesOfUttarPradesh = {"Agra", "Lucknow", "Merrut"};
        String[] citiesOfHaryana = {"Karnal", "Panipat"};
        String[] citiesOfRajasthan = {"Jaipur", "Jaiselmer"};
        switch (selectedState) {
            case "NCR" -> resultingCity = getRandomItemFromArray(citiesOfNcr);
            case "Uttar Pradesh" -> resultingCity = getRandomItemFromArray(citiesOfUttarPradesh);
            case "Haryana" -> resultingCity = getRandomItemFromArray(citiesOfHaryana);
            case "Rajasthan" -> resultingCity = getRandomItemFromArray(citiesOfRajasthan);
        }
        return resultingCity;
    }
}