package site.nomoreparties.stellarburgers.accountpage;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import site.nomoreparties.stellarburgers.pageobject.AccountPage;
import site.nomoreparties.stellarburgers.pageobject.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;

@RunWith(Parameterized.class)
public class AccountTest {

    UserOperations userOperations = new UserOperations();
    Map<String, String> userData = userOperations.register();
    String userEmail = userData.get("email");
    String userPassword = userData.get("password");

    private String driver;

    public AccountTest(String driver) {
        this.driver = driver;
    }

    @Parameterized.Parameters(name = "Драйвер : {0}")
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
    @DisplayName("Открытие личного кабинета через клик по кнопке \"Личный кабинет\" в хидере")
    public void checkAccountButtonOpensAccountPageTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        mainPage.clickAccountButton();
        AccountPage accountPage = page(AccountPage.class);
        SelenideElement element = accountPage.getProfileLinkElement();
        element.shouldBe(visible);
    }

    @Test
    @DisplayName("Открытие конструктора через клик по лого \"Stellar Burgers\" в хидере")
    public void checkHeaderLogoButtonOpensConstructorTest() {
        LoginPage loginPage = open(LoginPage.LOGIN_URL, LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        MainPage mainPage = page(MainPage.class);
        mainPage.clickAccountButton();
        SelenideElement element = mainPage.clickHeaderLogoButtonAndGetHeadingMakeABurgerElement();
        element.shouldBe(visible);
    }

    @Test
    @DisplayName("Открытие конструктора через клик по кнопке \"Конструктор\" в хидере")
    public void checkHeaderConstructorButtonOpensConstructorTest() {
        LoginPage loginPage = open(LoginPage.LOGIN_URL, LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        MainPage mainPage = page(MainPage.class);
        mainPage.clickAccountButton();
        SelenideElement element = mainPage.clickHeaderConstructorButtonAndGetHeadingMakeABurgerElement();
        element.shouldBe(visible);
    }

    @Test
    @DisplayName("Выход из личного кабинета через клик по кнопке \"Выход\"")
    public void checkLogoffButtonOpensLoginPageTest() {
        LoginPage loginPage = open(LoginPage.LOGIN_URL, LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        MainPage mainPage = page(MainPage.class);
        mainPage.clickAccountButton();
        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickLogoffButton();
        SelenideElement element = loginPage.getHeadingEntranceElement();
        element.shouldBe(visible);
    }

}
