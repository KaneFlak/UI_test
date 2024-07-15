package elements;

/**
 * Класс текстового элемента веб-страницы с тегом div.
 * Предоставляет методы для создания и взаимодействия с элементом.
 */
public class TextElement extends BaseElement {
    private static final String divTag = "div";

    protected TextElement(String paramName, String paramValue) {
        super(divTag, paramName, paramValue);
    }

    /**
     * Создает экземпляр текстового элемента по названию класса
     * @param className - название класса
     * @return экземпляр класса текстового элемента
     */
    public static TextElement byClass(String className) {
        return new TextElement(CLASS_PARAM, className);
    }
}
