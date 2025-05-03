package tests;

import les7PageObjects.pages.TextBoxPage;
import org.junit.jupiter.api.*;
import static les7PageObjects.testData.TextBoxTestData.*;

public class TextBoxHomeWork7WithPomTests extends TestBase {

    @Test
    @DisplayName("Отправка формы Text Box - с заполнением всех полей")
    void fillFormTextBoxWithPomTest() {
        new TextBoxPage().openPage()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmitButton()
        // *** Проверки ***//
                .checkNameResult(fullName)
                .checkEmailResult(email)
                .checkCurrentAddressResult(currentAddress)
                .checkPermanentAddressResult(permanentAddress);
    }
}