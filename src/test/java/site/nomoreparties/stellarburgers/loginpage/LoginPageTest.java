package site.nomoreparties.stellarburgers.loginpage;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.junit4.DisplayName;
import site.nomoreparties.stellarburgers.pageobject.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.pageobject.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.MainPage;
import site.nomoreparties.stellarburgers.pageobject.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;

@RunWith(Parameterized.class)
public class LoginPageTest {

    UserOperations userOperations = new UserOperations();
    Map<String, String> userData = userOperations.register();
    String userEmail = userData.get("email");
    String userPassword = userData.get("password");

    private String driver;

    public LoginPageTest(String driver) {
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
        closeWindow();
    }

    @Test
    @DisplayName("Вход в личный кабинет через кнопку \"Войти в аккаунт\"")
    public void userCanLoginThroughMainPageEntranceButtonTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickMainPageEntranceButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        SelenideElement element = mainPage.getMakeOrderButtonElement();
        element.shouldBe(visible);
    }

    @Test
    @DisplayName("Вход в личный кабинет через кнопку \"Личный кабинет\"")
    public void userCanLoginThroughAccountButtonTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        SelenideElement element = mainPage.getMakeOrderButtonElement();
        element.shouldBe(visible);
    }

    @Test
    @DisplayName("Вход в личный кабинет через кнопку \"Войти\" на странице регистрации")
    public void userCanLoginThroughRegistrationPageEntranceButtonTest() {
        RegistrationPage registrationPage = open(RegistrationPage.REGISTRATION_URL, RegistrationPage.class);
        registrationPage.clickRegistrationPageEntranceButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        MainPage mainPage = page(MainPage.class);
        SelenideElement element = mainPage.getMakeOrderButtonElement();
        element.shouldBe(visible);
    }

    @Test
    @DisplayName("Вход в личный кабинет через кнопку \"Войти\" на странице восстановления пароля")
    public void userCanLoginThroughForgotPasswordPageEntranceButtonTest() {
        ForgotPasswordPage forgotPasswordPage = open(ForgotPasswordPage.FORGOT_PASSWORD_URL, ForgotPasswordPage.class);
        forgotPasswordPage.clickForgotPasswordPageEntranceButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        MainPage mainPage = page(MainPage.class);
        SelenideElement element = mainPage.getMakeOrderButtonElement();
        element.shouldBe(visible);
    }
}
