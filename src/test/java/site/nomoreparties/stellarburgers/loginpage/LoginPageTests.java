package site.nomoreparties.stellarburgers.loginpage;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
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

@RunWith(Parameterized.class)
public class LoginPageTests {

    UserOperations userOperations = new UserOperations();
    Map<String, String> userData = userOperations.register();
    String userEmail = userData.get("email");
    String userPassword = userData.get("password");

    private String driver;

    public LoginPageTests(String driver) {
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
    public void userCanLoginThroughMainPageEntranceButtonTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickMainPageEntranceButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        mainPage.checkMakeOrderButtonExists();
    }

    @Test
    public void userCanLoginThroughAccountButtonTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        mainPage.checkMakeOrderButtonExists();
    }

    @Test
    public void userCanLoginThroughRegistrationPageEntranceButtonTest() {
        RegistrationPage registrationPage = open(RegistrationPage.REGISTRATION_URL, RegistrationPage.class);
        registrationPage.clickRegistrationPageEntranceButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        MainPage mainPage = page(MainPage.class);
        mainPage.checkMakeOrderButtonExists();
    }

    @Test
    public void userCanLoginThroughForgotPasswordPageEntranceButtonTest() {
        ForgotPasswordPage forgotPasswordPage = open(ForgotPasswordPage.FORGOT_PASSWORD_URL, ForgotPasswordPage.class);
        forgotPasswordPage.clickForgotPasswordPageEntranceButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        MainPage mainPage = page(MainPage.class);
        mainPage.checkMakeOrderButtonExists();
    }
}
