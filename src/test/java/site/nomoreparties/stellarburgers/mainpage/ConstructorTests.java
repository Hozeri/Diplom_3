package site.nomoreparties.stellarburgers.mainpage;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import site.nomoreparties.stellarburgers.pageobject.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

@RunWith(Parameterized.class)
public class ConstructorTests {

    UserOperations userOperations = new UserOperations();
    Map<String, String> userData = userOperations.register();
    String userEmail = userData.get("email");
    String userPassword = userData.get("password");

    private String driver;

    public ConstructorTests(String driver) {
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
    public void checkBunsTabIsSelectedTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        mainPage.checkBunsTabIsSelected();
    }

    @Test
    public void checkSauceTabIsSelectedTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickSaucesTab();
        mainPage.checkSaucesTabIsSelected();
    }

    @Test
    public void checkFillingsTabIsSelectedTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickFillingsTab();
        mainPage.checkFillingsTabIsSelected();
    }

}
