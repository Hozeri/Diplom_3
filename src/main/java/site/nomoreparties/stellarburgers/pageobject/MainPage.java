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
    @Step("Клик по кнопке \"Войти в аккаунт\"")
    public void clickMainPageEntranceButton() {
        mainPageEntranceButton.click();
    }

    //метод клика по кнопке "Личный Кабинет"
    @Step("Клик по кнопке \"Личный Кабинет\"")
    public void clickAccountButton() {
        accountButton.click();
    }

    //метод получения элемента кнопки "Оформить заказ"
    @Step("Получение элемента кнопки \"Оформить заказ\"")
    public SelenideElement getMakeOrderButtonElement() {
        return makeOrderButton;
    }

    //метод клика по лого Stellar Burgers
    @Step("Клик по лого Stellar Burgers")
    public void clickHeaderLogoButton() {
        headerLogoButton.click();
    }

    //метод клика по кнопке "Конструктор"
    @Step("Клик по кнопке \"Конструктор\"")
    public void clickHeaderConstructorButton() {
        headerConstructorButton.click();
    }

    //метод возврата элемента заголовка "Соберите бургер"
    @Step("Получение элемента заголовка \"Соберите бургер\"")
    public SelenideElement getHeadingMakeABurgerElement() {
        return headingMakeABurger;
    }

    //метод клика по вкладке "Булки"
    @Step("Клик по вкладке \"Булки\"")
    public void clickBunsTab() {
        bunsTab.click();
    }

    //метод клика по вкладке "Соусы"
    @Step("Клик по вкладке \"Соусы\"")
    public void clickSaucesTab() {
        saucesTab.click();
    }

    //метод клика по вкладке "Начинки"
    @Step("Клик по вкладке \"Начинки\"")
    public void clickFillingsTab() {
        fillingsTab.click();
    }

    //метод получение элемента вкладки "Булки"
    @Step("Получение элемента вкладки \"Булки\"")
    public SelenideElement getBunsTabElement() {
        return bunsTab;
    }

    //метод получение элемента вкладки "Соусы"
    @Step("Получение элемента вкладки \"Соусы\"")
    public SelenideElement getSaucesTabElement() {
        return saucesTab;
    }

    //метод получение элемента вкладки "Начинки"
    @Step("Получение элемента вкладки \"Начинки\"")
    public SelenideElement getFillingsTabElement() {
        return fillingsTab;
    }

    //общий метод клика по лого и получения элемента заголовка "Соберите бургер"
    @Step("Клик по лого и получения элемента заголовка \"Соберите бургер\"")
    public SelenideElement clickHeaderLogoButtonAndGetHeadingMakeABurgerElement() {
        clickHeaderLogoButton();
        return getHeadingMakeABurgerElement();
    }

    //общий метод клика по кнопке "Конструктор" и получения элемента заголовка "Соберите бургер"
    @Step("Клик по кнопке \"Конструктор\" и получения элемента заголовка \"Соберите бургер\"")
    public SelenideElement clickHeaderConstructorButtonAndGetHeadingMakeABurgerElement() {
        clickHeaderConstructorButton();
        return getHeadingMakeABurgerElement();
    }


}
