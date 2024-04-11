package org.ibs.managers;

import org.ibs.pages.FoodPage;
import org.ibs.pages.HomePage;

/**
 * @author Andrey_Zhizhov
 * Класс для управления страницами
 */
public class PageManager {
    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private HomePage homePage;

    /**
     * Страничка с товаром
     */
    private FoodPage foodPage;


    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link HomePage}
     *
     * @return StartPage
     */
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    /**
     * Ленивая инициализация {@link FoodPage}
     *
     * @return InsurancePage
     */
    public FoodPage getFoodPage() {
        if (foodPage == null) {
            foodPage = new FoodPage();
        }
        return foodPage;
    }
}
