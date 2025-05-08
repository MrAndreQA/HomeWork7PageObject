package les7PageObjects.utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class RandomUtils {

    private static Faker faker = new Faker(new Locale("eng"));
    private static String selectedState;

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomGender() {
        return faker.options().option(
                faker.demographic().sex(),
                "Other"
        );
    }

    public static String getRandomPhone10Digits() {
        return faker.numerify("##########");
    }

    public static String getRandomDayOfBirth() {
        return String.format("%02d", faker.number().numberBetween(1, 29));
    }

    public static String getRandomMonth() {
        return faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
    }

    public static String getRandomYearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1940, 2010));
    }

    public static String generateDefaultEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomSubject() {
        return faker.options().option(
                "Accounting", "Art", "Biology",
                "Chemistry", "Computer Science", "Commerce",
                "Civics", "English", "Economics", "Hindi",
                "History", "Maths", "Physics"
        );
    }

    public static String getRandomHobby() {
        return faker.options().option(
                "Sports", "Reading", "Music"
        );
    }

    public static String getRandomPicture() {
        return faker.options().option(
                "картинка.jpg", "picture.jpg", "пикче.jpg"
        );
    }

    public static String getFullAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        selectedState = faker.options().option(states);
        return selectedState;
    }

    public static String getRandomCity() {
        return switch (selectedState) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("Unknown state: " + selectedState);
        };
    }
}