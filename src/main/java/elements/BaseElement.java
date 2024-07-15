package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Абстрактный класс элемента страницы.
 * Содержит общие для элементов методы и конструкторы
 */
public class BaseElement {
    protected final SelenideElement element;
    protected final String xPath;

    protected static final String ONE_PARAM_X_PATH_PATTERN = "//%s[@%s='%s']";
    protected static final String CLASS_PARAM = "class";
    protected static final String NAME_PARAM = "name";
    protected static final String ID_PARAM = "id";

    /**
     * Конструктор через полный XPath элемента
     * @param fullXPath - XPath элемента
     */
    protected BaseElement(String fullXPath) {
        xPath = fullXPath;
        element = $x(xPath);
    }

    /**
     * Конструктор через тип элемента и значение его атрибута
     * @param elementType - тип элемента
     * @param paramName - название атрибута
     * @param paramValue - значение атрибута
     */
    protected BaseElement(String elementType, String paramName, String paramValue) {
        xPath = String.format(ONE_PARAM_X_PATH_PATTERN, elementType, paramName, paramValue);
        element = $x(xPath);
    }

    /**
     * Геттер xPath элемента, по которому тот был создан
     * @return xPath элемента
     */
    public String getXPath() {
        return xPath;
    }

    /**
     * Возвращает текст элемента, при условии, что тот видимый
     * @return текст элемента
     */
    public String getText() {
        shouldBeVisible();
        return element.getText();
    }

    /**
     * Проверка и ожидание видимости элемента
     */
    public void shouldBeVisible() {
        element.shouldBe(Condition.visible);
    }
}
