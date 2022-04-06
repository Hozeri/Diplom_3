package site.nomoreparties.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {

    //локатор кнопки "Войти" на странице восстановления пароля
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement forgotPasswordPageEntranceButton;

    //переменная для хранения url страницы восстановления пароля
    public static final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //метод клика по кнопке "Вход" на странице регистрации
    @Step
    public void clickForgotPasswordPageEntranceButton() {
        forgotPasswordPageEntranceButton.click();
    }

}
