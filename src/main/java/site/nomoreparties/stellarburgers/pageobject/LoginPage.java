package site.nomoreparties.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    //локатор заголовка "Вход"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement headingEntrance;

    //локатор поля ввода "Email"
    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input")
    private SelenideElement userEmail;

    //локатор поля ввода "Пароль"
    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement userPassword;

    //локатор кнопки "Вход"
    @FindBy(how = How.CSS, using = "[class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement loginButton;

    //переменная для хранения url страницы восстановления пароля
    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    //метод получения элемента заголовка "Вход"
    @Step("Получение элемента заголовка \"Вход\"")
    public SelenideElement getHeadingEntranceElement() {
        return headingEntrance;
    }

    //метод заполнения поля ввода "Email"
    @Step("Заполнение поля ввода \"Email\"")
    public void setUserEmail(String email) {
        userEmail.click();
        userEmail.setValue(email);
    }

    //метод заполнения поля ввода "Пароль"
    @Step("Заполнение поля ввода \"Пароль\"")
    public void setUserPassword(String password) {
        userPassword.click();
        userPassword.setValue(password);
    }

    //метод клика по кнопке "Вход"
    @Step("Клик по кнопке \"Вход\"")
    public void clickLoginButton() {
        loginButton.click();
    }

    //общий метод логина пользователя
    @Step("Логин пользователя")
    public void loginUser(String email, String password) {
        setUserEmail(email);
        setUserPassword(password);
        clickLoginButton();
    }

}
