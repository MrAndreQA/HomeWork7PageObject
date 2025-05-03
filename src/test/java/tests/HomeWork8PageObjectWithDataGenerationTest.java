package tests;

import les7PageObjects.pages.components.TableWindowComponent;
import org.junit.jupiter.api.*;
import les7PageObjects.pages.RegistrationPage;
import static les7PageObjects.testData.PracticeFormTestData.*;

public class HomeWork8PageObjectWithDataGenerationTest extends TestBase {

    @Test
    @DisplayName("Practice Form: отправка формы при заполнении всех полей")
    void fillAllFieldsInPracticeFormTest() {
        new RegistrationPage().openPage()
                .clearBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbies(hobby)
                .setPicture(pictureFileName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();
                //*** проверки ***//
                new TableWindowComponent()
                .checkModalHeader("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", pictureFileName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    @DisplayName("Practice Form: отправка формы при заполнении только обязательных полей")
    void fillOnlyRequiredFieldsInPracticeFormTest() {
        new RegistrationPage().openPage()
                .clearBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .clickSubmitButton();
                //*** проверки ***
                new TableWindowComponent()
                .checkModalHeader("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResultEmpty("Student Email")
                .checkResultEmpty("Subjects")
                .checkResultEmpty("Hobbies")
                .checkResultEmpty("Picture")
                .checkResultEmpty("Address")
                .checkResultEmpty("State and City");
    }

    @Test
    @DisplayName("Practice Form: негативный тест - попытка отправить форму при незаполненном чек-боксе Sex")
    void fillPracticeFormNegativeTest() {
        new RegistrationPage().openPage()
                .clearBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(userNumber)
                .clickSubmitButton();
                //*** проверки ***
                new TableWindowComponent()
                .checkIsNotVisible_tableWindow();
    }
}