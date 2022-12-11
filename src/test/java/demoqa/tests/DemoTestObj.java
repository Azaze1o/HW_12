package demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import demoqa.pages.RegistrationFormPage;
import demoqa.testData.Variables;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DemoTestObj {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";
        // Configuration.holdBrowserOpen = true;

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        if (System.getProperty("remote") != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

            Configuration.browserCapabilities = capabilities;
            Configuration.remote = System.getProperty("remote");
        }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Test
    @Tag("choose_properties")
    void simpleTest(){
        registrationFormPage
                .openPage()
                .setFirstName(Variables.firstName)
                .setLastName(Variables.lastName)
                .setEmail(Variables.email)
                .setGenderWrapper(Variables.gender)
                .setPhoneNumber(Variables.number)
                .setAddress(Variables.address)
                .setBirthdate(Variables.year,Variables.month,Variables.day)
                .setHobbies(Variables.hobbies)
                .uploadPicture(Variables.picturePath)
                .setSubjects(Variables.subjects)
                .setState(Variables.state)
                .setCity(Variables.city)
                .submit()

                .checkResultsVisible()
                .checkResult("Student Name", Variables.firstName + " " + Variables.lastName)
                .checkResult("Student Email", Variables.email)
                .checkResult("Gender", Variables.gender)
                .checkResult("Mobile", Variables.number)
                .checkResult("Date of Birth",Variables.birthDay)
                .checkResult("Subjects", Variables.subjects)
                .checkResult("Hobbies", Variables.hobbies)
                .checkResult("Address", Variables.address)
                .checkResult("Picture", Variables.picture)
                .checkResult("State and City", Variables.state+" "+ Variables.city);

    }
}
