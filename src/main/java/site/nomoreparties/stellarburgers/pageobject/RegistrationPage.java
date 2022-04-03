package site.nomoreparties.stellarburgers.pageobject;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class RegistrationPage {

    //локатор поля ввода "Имя"
    @FindBy(how = How.CSS, using = "fieldset:nth-child(1)> div > div > input")
    private SelenideElement userName;

    //локатор поля ввода "Email"
    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) > div > div > input")
    private SelenideElement userEmail;

    //локатор поля ввода "Пароль"
    @FindBy(how = How.CSS, using = "fieldset:nth-child(3) > div > div > input")
    private SelenideElement userPassword;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.CSS, using = "[class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registrationButton;

    //локатор подсказки "Некорректный пароль"
    @FindBy(how = How.CSS, using = "[class='input__error text_type_main-default']")
    private SelenideElement incorrectPasswordHint;

    //локатор кнопки "Войти" на странице регистрации
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement registrationPageEntranceButton;

    //переменная для хранения url страницы регистрации
    public static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";

    //метод заполнения поля ввода "Имя"
    @Step
    public void setUserName(String name) {
        userName.click();
        userName.setValue(name);
    }

    //метод заполнения поля ввода "Email"
    @Step
    public void setUserEmail(String email) {
        userEmail.click();
        userEmail.setValue(email);
    }

    //метод заполнения поля ввода "Пароль"
    @Step
    public void setUserPassword(String password) {
        userPassword.click();
        userPassword.setValue(password);
    }

    //метод клика по кнопке "Зарегистрироваться"
    @Step
    public void clickRegistrationButton() {
        registrationButton.click();
    }

    //метод проверки подсказки "Некорректный пароль"
    @Step
    public void checkTextOfIncorrectPasswordHint() {
        $(incorrectPasswordHint).shouldHave(text("Некорректный пароль"));
    }

    //метод клика по кнопке "Вход" на странице регистрации
    @Step
    public void clickRegistrationPageEntranceButton() {
        $(registrationPageEntranceButton).click();
    }

    //общий метод регистрации пользователя
    @Step
    public void userRegistration(String name, String email, String password) {
        setUserName(name);
        setUserEmail(email);
        setUserPassword(password);
        clickRegistrationButton();
    }

}
