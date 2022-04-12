package site.nomoreparties.stellarburgers.registrationpage;

import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import com.model.Tokens;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import site.nomoreparties.stellarburgers.pageobject.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@RunWith(Parameterized.class)
public class RegistrationPageTest {

    UserOperations userOperations = new UserOperations();
    Faker faker = new Faker();
    final String email = faker.internet().emailAddress();
    final String password = faker.internet().password();
    final String name = faker.name().name();

    private String driver;

    public RegistrationPageTest(String driver) {
        this.driver = driver;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
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
        userOperations.authorize(email, password);
        userOperations.delete();
        closeWindow();
    }

    @Test
    @DisplayName("Проверка успешной регистрации пользователя")
    public void userCanBeRegisteredTest(){
        RegistrationPage registrationPage = open(RegistrationPage.REGISTRATION_URL, RegistrationPage.class);
        registrationPage.userRegistration(name, email, password);
        LoginPage loginPage = page(LoginPage.class);
        SelenideElement element = loginPage.getHeadingEntranceElement();
        element.shouldBe(visible);
    }

    @Test
    @DisplayName("Проверка текста ошибки при регистрации с некорректным паролем")
    public void userCanNotBeRegisteredWithIncorrectPasswordTest(){
        RegistrationPage registrationPage = open(RegistrationPage.REGISTRATION_URL, RegistrationPage.class);
        registrationPage.userRegistration(name, email, "qwert");
        SelenideElement element = registrationPage.getIncorrectPasswordHintElement();
        element.shouldHave(text("Некорректный пароль"));
    }

}
