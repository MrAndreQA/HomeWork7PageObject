package les7PageObjects.testData;

import com.github.javafaker.Faker;
import les7PageObjects.utils.RandomUtils;
import java.util.Locale;

public class PracticeFormTestData {

    static Faker faker = new Faker(new Locale("ru"));

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userGender = RandomUtils.getRandomGender(),
            userNumber = faker.number().digits(10),
            dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28)),
            monthOfBirth = RandomUtils.getRandomMonth(),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1950, 2008)),
            userEmail = RandomUtils.getRandomEmail(),
            subject = RandomUtils.getRandomSubject(),
            hobby = RandomUtils.getRandomHobby(),
            pictureFileName = RandomUtils.getRandomPicture(),
            currentAddress = faker.address().fullAddress(),
            state = RandomUtils.getRandomState(),
            city = RandomUtils.getRandomCity();
}