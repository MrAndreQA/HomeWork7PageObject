package tests;

import les7PageObjects.pages.components.TableWindowComponent;
import les7PageObjects.testData.PracticeFormTestData;
import org.junit.jupiter.api.*;
import les7PageObjects.pages.RegistrationPage;


public class HomeWork8PageObjectWithDataGenerationTest extends TestBase {

    private PracticeFormTestData data;
    @BeforeEach
    void generateTestData() {
        data = new PracticeFormTestData();
    }

    @Test
    @DisplayName("Practice Form: отправка формы при заполнении всех полей")
    void fillAllFieldsInPracticeFormTest() {
        new RegistrationPage().openPage()
                .clearBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setUserEmail(data.userEmail)
                .setGender(data.userGender)
                .setUserNumber(data.userNumber)
                .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                .setSubject(data.subject)
                .setHobbies(data.hobby)
                .setPicture(data.pictureFileName)
                .setCurrentAddress(data.currentAddress)
                .setState(data.state)
                .setCity(data.city)
                .clickSubmitButton();
//*** проверки ***//
        new TableWindowComponent()
                .checkModalHeader("Thanks for submitting the form")
                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.userEmail)
                .checkResult("Gender", data.userGender)
                .checkResult("Mobile", data.userNumber)
                .checkResult("Date of Birth",
                        data.dayOfBirth + " " + data.monthOfBirth + "," + data.yearOfBirth)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobby)
                .checkResult("Picture", data.pictureFileName)
                .checkResult("Address", data.currentAddress)
                .checkResult("State and City", data.state + " " + data.city);
    }

    @Test
    @DisplayName("Practice Form: отправка формы при заполнении только обязательных полей")
    void fillOnlyRequiredFieldsInPracticeFormTest() {
        new RegistrationPage().openPage()
                .clearBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.userGender)
                .setUserNumber(data.userNumber)
                .clickSubmitButton();
                //*** проверки ***
                new TableWindowComponent()
                .checkModalHeader("Thanks for submitting the form")
                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.userGender)
                .checkResult("Mobile", data.userNumber)
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
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setUserNumber(data.userNumber)
                .clickSubmitButton();
                //*** проверки ***
                new TableWindowComponent()
                .checkIsNotVisible_tableWindow();
    }
}