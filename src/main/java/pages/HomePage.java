package pages;

import elements.TextElement;

/**
 * Класс домашней страницы сайта, на которую пользователь попадает после авторизации
 * Предоставляет методы для взаимодействия с элементами страницы
 */
public class HomePage {
    private final TextElement profileNameTextElement = TextElement.byClass("avatar-full-name");

    /**
     * Вохвращает содержимое текстового элемента profileNameTextElement
     * @return имя профиля авторизованного пользователя
     */
    public String getProfileName() {
        return profileNameTextElement.getText();
    }
}
