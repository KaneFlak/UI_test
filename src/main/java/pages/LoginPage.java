package pages;

import elements.Button;
import elements.Input;
import elements.DivButton;

/**
 * Класс страницы авторизации.
 * Предоставляет методы для взаимодействия с элементами страницы
 */
public class LoginPage {
    private final Input loginInput = Input.byName("user");
    private final Input passwordInput = Input.byName("password");
    private final Button loginButton = Button.byId("button_submit_login_form");
    private final Button showPasswordButton = Button.byId("show_password");
    private final DivButton forgotPasswordDivButton =
            DivButton.byFullXPath("//a[@class='mira-default-login-page-link']//child::div");

    /**
     * Заполняет поле ввода логина пользователя
     * @param login - логин пользователя
     */
    public void fillLogin(String login) {
        loginInput.fill(login);
    }

    /**
     * Заполняет поле ввода пароля
     * @param password - пароль пользователя
     */
    public void fillPassword(String password) {
        passwordInput.fill(password);
    }

    /**
     * Нажатие на кнопку авторизации
     * @return экземпляр класса домашней страницы
     */
    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage();
    }

    /**
     * Проверка видимости пароля в поле ввода passwordInput
     * @return - true, если пароль виден для пользователя, иначе false
     */
    public boolean isPasswordVisible() {
        return passwordInput.getType().equals(Input.TEXT_TYPE);
    }

    /**
     * Нажатие на кнопку показать\скрыть пароль
     */
    public void clickShowPasswordButton() {
        showPasswordButton.click();
    }

    /**
     * Нажатие на кнопку "Забыли пароль"
     * @return экземпляр класса страницы восстановления пароля
     */
    public PasswordRecoveryPage clickForgotPswButton() {
        forgotPasswordDivButton.click();
        return new PasswordRecoveryPage();
    }
}
