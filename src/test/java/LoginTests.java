import org.junit.jupiter.api.Test;
import pages.PasswordRecoveryPage;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс тестов страницы авторизации
 */
public class LoginTests extends BaseTest {

    private static final String PROFILE_NAME = "Фомина Елена Сергеевна";
    private static final String SOME_PASSWORD = "1234";
    private static final String INFO_TITLE_TEXT = "Восстановление пароля";

    /**
     * Проверка авторизации
     */
    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillLogin(properties.getProperty(USER_LOGIN_PROPERTY));
        loginPage.fillPassword(properties.getProperty(USER_PASSWORD_PROPERTY));
        HomePage homePage = loginPage.clickLoginButton();
        assertEquals(homePage.getProfileName(), PROFILE_NAME);
    }

    /**
     * Проверка работы кнопки показать\скрыть пароль
     */
    @Test
    public void showPasswordTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillPassword(SOME_PASSWORD);
        assertFalse(loginPage.isPasswordVisible());
        loginPage.clickShowPasswordButton();
        assertTrue(loginPage.isPasswordVisible());
    }

    /**
     * Проверка работы кнопки перехода на страницу восстановления пароля
     */
    @Test
    public void checkForgotPswPageTest() {
        LoginPage loginPage = new LoginPage();
        PasswordRecoveryPage forgotPswPage = loginPage.clickForgotPswButton();
        assertEquals(forgotPswPage.getInfoTitleText(), INFO_TITLE_TEXT);
    }
}
