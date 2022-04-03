package site.nomoreparties.stellarburgers.registrationpage;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import site.nomoreparties.stellarburgers.pageobject.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

@RunWith(Parameterized.class)
public class RegistrationPageTests {

    Faker faker = new Faker();
    final String email = faker.internet().emailAddress();
    final String password = faker.internet().password();
    final String name = faker.name().name();

    private String driver;

    public RegistrationPageTests(String driver) {
        this.driver = driver;
    }

    @Parameterized.Parameters
    public static Object[][] getDriverForTests() {
        return new Object[][]{
                {"src/resourses/chromedriver.exe"},
                {"src/resourses/yandexdriver.exe"}
        };
    }

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", driver);
    }

    @After
    public void tearDown() {
        closeWindow();
    }

    @Test
    public void userCanBeRegisteredTest(){
        RegistrationPage registrationPage = open(RegistrationPage.REGISTRATION_URL, RegistrationPage.class);
        registrationPage.userRegistration(name, email, password);
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkHeadingEntranceExistance();
    }

    @Test
    public void userCanNotBeRegisteredWithIncorrectPasswordTest(){
        RegistrationPage registrationPage = open(RegistrationPage.REGISTRATION_URL, RegistrationPage.class);
        registrationPage.userRegistration(name, email, "qwert");
        registrationPage.checkTextOfIncorrectPasswordHint();
    }

}
