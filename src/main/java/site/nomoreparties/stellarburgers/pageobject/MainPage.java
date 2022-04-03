package site.nomoreparties.stellarburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    //локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.CSS, using = "[class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement mainPageEntranceButton;

    //локатор кнопки "Личный Кабинет"
    @FindBy(how = How.CSS, using = "a[href='/account']")
    private SelenideElement accountButton;

    //локатор кнопки "Оформить заказ"
    @FindBy(how = How.CSS, using = "[class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement makeOrderButton;

    //локатор логотипа Stellar Burgers
    @FindBy(how = How.CSS, using = "div>a[href='/']")
    private SelenideElement headerLogoButton;

    //локатор кнопки "Конструктор"
    @FindBy(how = How.CSS, using = "li>a[href='/']")
    private SelenideElement headerConstructorButton;

    //локатор заголовка "Соберите бургер"
    @FindBy(how = How.CSS, using = "[class = 'text text_type_main-large mb-5 mt-10']")
    private SelenideElement headingMakeABurger;

    //локатор вкладки "Булки"
    @FindBy(how = How.XPATH, using = ".//main/section[1]/div[1]/div[1]")
    private SelenideElement bunsTab;

    //локатор вкладки "Соусы"
    @FindBy(how = How.XPATH, using = ".//main/section[1]/div[1]/div[2]")
    private SelenideElement saucesTab;

    //локатор вкладки "Начинки"
    @FindBy(how = How.XPATH, using = ".//main/section[1]/div[1]/div[3]")
    private SelenideElement fillingsTab;

    //переменная для хранения url главной страницы
    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site";

    //метод клика по кнопке "Войти в аккаунт"
    @Step
    public void clickMainPageEntranceButton() {
        $(mainPageEntranceButton).click();
    }

    //метод клика по кнопке "Личный Кабинет"
    @Step
    public void clickAccountButton() {
        $(accountButton).click();
    }

    //метод проверки существования кнопки "Оформить заказ"
    @Step
    public void checkMakeOrderButtonExists() {
        $(makeOrderButton).exists();
    }

    //метод клика по лого Stellar Burgers
    @Step
    public void clickHeaderLogoButton() {
        $(headerLogoButton).click();
    }

    //метод клика по кнопке "Конструктор"
    @Step
    public void clickHeaderConstructorButton() {
        $(headerConstructorButton).click();
    }

    //метод проверки существования заголовка "Соберите бургер"
    @Step
    public void checkHeadingMakeABurgerExists() {
        $(headingMakeABurger).exists();
    }

    //метод клика по вкладке "Булки"
    @Step
    public void clickBunsTab() {
        $(bunsTab).click();
    }

    //метод клика по вкладке "Соусы"
    @Step
    public void clickSaucesTab() {
        $(saucesTab).click();
    }

    //метод клика по вкладке "Соусы"
    @Step
    public void clickFillingsTab() {
        $(fillingsTab).click();
    }

    //метод проверки того, что вкладка "Булки" выбрана
    @Step
    public void checkBunsTabIsSelected() {
        $(bunsTab).shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
    }

    //метод проверки того, что вкладка "Соусы" выбрана
    @Step
    public void checkSaucesTabIsSelected() {
        $(saucesTab).shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
    }

    //метод проверки того, что вкладка "Начинки" выбрана
    @Step
    public void checkFillingsTabIsSelected() {
        $(fillingsTab).shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
    }

    //общий метод клика по лого и проверки существования заголовка "Соберите бургер"
    @Step
    public void clickHeaderLogoButtonAndCheckHeadingMakeABurgerExists() {
        clickHeaderLogoButton();
        checkHeadingMakeABurgerExists();
    }

    //общий метод клика по кнопке "Конструктор" и проверки существования заголовка "Соберите бургер"
    @Step
    public void clickHeaderConstructorButtonAndCheckHeadingMakeABurgerExists() {
        clickHeaderConstructorButton();
        checkHeadingMakeABurgerExists();
    }


}
