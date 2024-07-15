package elements;

/**
 * Класс элемента кнопки веб-страницы с тегом div.
 * Предоставляет методы для создания и взаимодействия с элементом.
 */
public class DivButton extends Button {
    private static final String divTag = "div";

    protected DivButton(String xPath) {
        super(xPath);
    }

    protected DivButton(String paramName, String paramValue) {
        super(divTag, paramName, paramValue);
    }

    /**
     * Создание кнопки по названию класса
     * @param className - название класса
     * @return экземпляр класса кнопки
     */
    public static DivButton byClass(String className) {
        return new DivButton(CLASS_PARAM, className);
    }

    /**
     * Создание кнопки по полному XPath
     * @param xPath - xPath элемента
     * @return экземпляр класса кнопки
     */
    public static DivButton byFullXPath(String xPath) {
        return new DivButton(xPath);
    }
}
