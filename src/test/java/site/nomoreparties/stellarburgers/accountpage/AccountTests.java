package site.nomoreparties.stellarburgers.accountpage;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
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

@RunWith(Parameterized.class)
public class AccountTests {

    UserOperations userOperations = new UserOperations();
    Map<String, String> userData = userOperations.register();
    String userEmail = userData.get("email");
    String userPassword = userData.get("password");

    private String driver;

    public AccountTests(String driver) {
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
    public void checkAccountButtonOpensAccountPageTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        mainPage.clickAccountButton();
        AccountPage accountPage = page(AccountPage.class);
        accountPage.checkHeadingProfileExistance();
    }

    @Test
    public void checkHeaderLogoButtonOpensConstructorTest() {
        LoginPage loginPage = open(LoginPage.LOGIN_URL, LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        MainPage mainPage = page(MainPage.class);
        mainPage.clickAccountButton();
        mainPage.clickHeaderLogoButtonAndCheckHeadingMakeABurgerExists();
    }

    @Test
    public void checkHeaderConstructorButtonOpensConstructorTest() {
        LoginPage loginPage = open(LoginPage.LOGIN_URL, LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        MainPage mainPage = page(MainPage.class);
        mainPage.clickAccountButton();
        mainPage.clickHeaderConstructorButtonAndCheckHeadingMakeABurgerExists();
    }

    @Test
    public void checkLogoffButtonOpensLoginPageTest() {
        LoginPage loginPage = open(LoginPage.LOGIN_URL, LoginPage.class);
        loginPage.loginUser(userEmail, userPassword);
        MainPage mainPage = page(MainPage.class);
        mainPage.clickAccountButton();
        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickLogoffButton();
        loginPage.checkHeadingEntranceExistance();
    }

}
