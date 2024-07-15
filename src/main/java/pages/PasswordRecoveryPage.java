package pages;

import elements.TextElement;

/**
 * Класс страницы восстановления пароля
 * Предоставляет методы для взаимодействия с элементами страницы
 */
public class PasswordRecoveryPage {
    private final TextElement infoTitle = TextElement.byClass("info-title");

    /**
     * Возвращает содержимое текстового элемента infoTitle
     * @return текст информационного заголовка
     */
    public String getInfoTitleText() {
        return infoTitle.getText();
    }
}
