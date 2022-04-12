package site.nomoreparties.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {

    //локатор заголовка "Профиль"
    @FindBy(how = How.CSS, using = "[class = 'Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9']")
    private SelenideElement linkProfile;

    //локатор кнопки "Выход"
    @FindBy(how = How.CSS, using = "[class = 'Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement logoffButton;

    //метод получения элемента ссылки "Профиль"
    @Step("Получение элемента ссылки \"Профиль\"")
    public SelenideElement getProfileLinkElement() {
        return linkProfile;
    }

    //метод клика по кнопке "Выход"
    @Step("Клик по кнопке \"Выход\"")
    public void clickLogoffButton() {
        logoffButton.click();
    }

}
