package elements;

/**
 * Класс элемента кнопки веб-страницы.
 * Предоставляет методы для создания и взаимодействия с элементом.
 */
public class Button extends BaseElement {
    private static final String buttonTag = "button";

    protected Button(String xPath) {
        super(xPath);
    }

    protected Button(String paramName, String paramValue) {
        super(buttonTag, paramName, paramValue);
    }

    protected Button(String tag, String paramName, String paramValue) {
        super(tag, paramName, paramValue);
    }

    /**
     * Создание кнопки по её атрибуту id
     * @param id - значение атрибута id
     * @return экземпляр класса кнопки
     */
    public static Button byId(String id) {
        return new Button(ID_PARAM, id);
    }

    /**
     * Нажатие на кнопку с предварительным ожиданием её видимости
     */
    public void click() {
        shouldBeVisible();
        element.click();
    }
}
