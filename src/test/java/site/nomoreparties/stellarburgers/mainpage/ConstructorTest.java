package site.nomoreparties.stellarburgers.mainpage;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import site.nomoreparties.stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

@RunWith(Parameterized.class)
public class ConstructorTest {

    private final String driver;

    public ConstructorTest(String driver) {
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
    @DisplayName("Проверка перехода к вкладке \"Булки\"")
    public void checkBunsTabIsSelectedTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        SelenideElement element = mainPage.getBunsTabElement();
        element.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName("Проверка перехода к вкладке \"Соусы\"")
    public void checkSauceTabIsSelectedTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickSaucesTab();
        SelenideElement element = mainPage.getSaucesTabElement();
        element.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName("Проверка перехода к вкладке \"Начинки\"")
    public void checkFillingsTabIsSelectedTest() {
        MainPage mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.clickFillingsTab();
        SelenideElement element = mainPage.getFillingsTabElement();
        element.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

}
