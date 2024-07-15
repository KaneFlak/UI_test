package elements;

/**
 * Класс элемента поля ввода веб-страницы.
 * Предоставляет методы для создания и взаимодействия с элементом.
 */
public class Input extends BaseElement {
    private static final String INPUT_TAG = "input";
    private static final String TYPE_ATTRIBUTE = "type";
    public static final String TEXT_TYPE = "text";
    public static final String PASSWORD_TYPE = "password";

    protected Input(String paramName, String paramValue) {
        super(INPUT_TAG, paramName, paramValue);
    }

    /**
     * Создание поля ввода по атрибуту name
     * @param name - значение атрибута
     * @return экземпляр класса поля ввода
     */
    public static Input byName(String name) {
        return new Input(NAME_PARAM, name);
    }

    /**
     * Заполнение поля ввода заданным текстом
     * @param text - текст для заполнения
     */
    public void fill(String text) {
        shouldBeVisible();
        element.setValue(text);
    }

    /**
     * Получение типа поля вввода
     * @return TEXT_TYPE или PASSWORD_TYPE
     */
    public String getType() {
        return element.getAttribute(TYPE_ATTRIBUTE);
    }
}
