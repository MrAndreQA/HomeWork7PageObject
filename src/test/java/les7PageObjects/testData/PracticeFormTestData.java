package les7PageObjects.testData;

import les7PageObjects.utils.RandomUtils;

public class PracticeFormTestData {

    public String
            firstName = RandomUtils.getRandomFirstName(),
            lastName = RandomUtils.getRandomLastName(),
            userGender = RandomUtils.getRandomGender(),
            userNumber = RandomUtils.getRandomPhone10Digits(),
            dayOfBirth = RandomUtils.getRandomDayOfBirth(),
            monthOfBirth = RandomUtils.getRandomMonth(),
            yearOfBirth = RandomUtils.getRandomYearOfBirth(),
            userEmail = RandomUtils.generateDefaultEmail(),
            subject = RandomUtils.getRandomSubject(),
            hobby = RandomUtils.getRandomHobby(),
            pictureFileName = RandomUtils.getRandomPicture(),
            currentAddress = RandomUtils.getFullAddress(),
            state = RandomUtils.getRandomState(),
            city = RandomUtils.getRandomCity();
}