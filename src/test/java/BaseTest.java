import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;

/**
 * Абстрактный класс тестов
 * Описывает действия, выполняемые перед всеми тестами, перед и после каждого теста
 */
public class BaseTest {
    private final static String PROPERTIES_PATH = "config.properties";
    private final static String URL_PROPERTY = "web.url";
    private final static String BROWSER_PROPERTY = "web.browser";
    private final static String RESOLUTION_PROPERTY = "web.resolution";
    protected final static String USER_LOGIN_PROPERTY = "user.login";
    protected final static String USER_PASSWORD_PROPERTY = "user.password";
    private final static String CONFIG_TIMEOUT_PROPERTY = "config.timeout";
    private static final String CONFIG_PAGE_TIMEOUT_PROPERTY = "config.pageLoadTimeout";
    private static final String CONFIG_PAGE_LOAD_STRATEGY_PROPERTY = "config.pageLoadStrategy";

    protected final static Properties properties = new Properties();

    /**
     * Инициализация всех параметров из конфига перед всеми тестами
     */
    @BeforeAll
    public static void setup() {
        try {
            FileInputStream fis = new FileInputStream(PROPERTIES_PATH);
            properties.load(fis);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * Установка настроек и запуск браузера с переходом по заданному url перед каждым тестом
     */
    @BeforeEach
    public void setupThis() {
        Configuration.browser = properties.getProperty(BROWSER_PROPERTY);
        Configuration.browserSize = properties.getProperty(RESOLUTION_PROPERTY);
        Configuration.timeout = Long.parseLong(properties.getProperty(CONFIG_TIMEOUT_PROPERTY));
        Configuration.pageLoadTimeout = Long.parseLong(properties.getProperty(CONFIG_PAGE_TIMEOUT_PROPERTY));
        Configuration.pageLoadStrategy = properties.getProperty(CONFIG_PAGE_LOAD_STRATEGY_PROPERTY);
        Selenide.open(properties.getProperty(URL_PROPERTY));
    }

    /**
     * Очистка окружения после каждого теста
     */
    @AfterEach
    public void tearThis() {
        closeWebDriver();
    }
}
