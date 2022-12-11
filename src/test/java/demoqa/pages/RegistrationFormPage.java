package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.Calendar;
import demoqa.pages.components.ResultModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private Calendar calendar = new Calendar();
    private ResultModal resultModal = new ResultModal();
    private final static String TITLE_TEXT = "Student Registration Form";

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit")
                    ;


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value){
        $(firstNameInput).setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value){
        $(lastNameInput).setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value){
        $(emailInput).setValue(value);
        return this;
    }

    public RegistrationFormPage setGenderWrapper(String value){
        $(genderWrapper).$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String value){
        $(phoneNumberInput).setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthdate(String year, String month, String day){
        $(dateOfBirthInput).click();
        calendar.setDate(year,month,day);
        return this;
    }

    public RegistrationFormPage setSubjects(String value){
        $(subjectsInput).setValue(value).pressTab();
        return this;
    }

    public RegistrationFormPage setHobbies(String value){
        $(hobbiesWrapper).$(byText(value)).click();
        return this;
    }


    public RegistrationFormPage uploadPicture(String path) {
        $(uploadPictureButton).uploadFile(new File(path));
        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        $(addressInput).setValue(address);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        $(stateInput).setValue(state).pressTab();
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        $(cityInput).setValue(city).pressTab();
        return this;
    }

    public RegistrationFormPage submit() {
        $(submitButton).click();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultModal.checkResult(key,value);
        return this;
    }

    public RegistrationFormPage checkResultsVisible() {
        resultModal.checkResultsVisible();
        return this;
    }
}
