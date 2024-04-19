package org.ibs.steps;


import io.cucumber.java.ru.*;
import org.ibs.managers.DriverManager;
import org.ibs.managers.PageManager;

import java.time.Duration;

public class step {

    private static final PageManager app = PageManager.getPageManager();
    private static final DriverManager driverManager = DriverManager.getDriverManager();


    @И("Открыть странице по адресу {}")
    public void openHomePage(String homePageURL) {
        driverManager.getDriver(homePageURL);
        driverManager.getDriver().manage().window().maximize(); // обязательно делаем максимальное окно
        // не явные ожидания
        driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @И("нажимаем на строку Песочница")
    public void clickSandBox() {
        app.getHomePage().clickButtonSandBox();
    }

    @И("в выпадающем списка нажимаем на Товары")
    public void clickProduct() {
        app.getHomePage().clickButtonProduct();
        checkOpenFoodPage();
    }

    @И("видим список товаров")
    public void viewProduct() {
        //
    }

    /**
     * проверка на открытие стриницы с товарами
     */
    public void checkOpenFoodPage() {
        app.getFoodPage().checkOpenFoodPage();
    }

    @И("нажимаем на кнопку Добавить")
    public void clickAdd() {
        app.getFoodPage().clickBtnAdd();
    }

    @И("открывается окно Добавления товара")
    public void checkAddProd() {
        //
    }

    @И("кликаем по полю Наименование")
    public void clickFieldName() {
        app.getFoodPage().clickFieldName();
    }

    @И("вводим название {}")
    public void fillField(String name) {
        app.getFoodPage().fillField(name);
    }

    @И("кликаем по выпадающему списку Тип")
    public void clickListProduct() {
        app.getFoodPage().clickButtonProduct();
    }

    @И("выбираем тип {}")
    public void setSelectType(String typeFood) {
        typeFood.toLowerCase();
        if (typeFood.equals("овощ")) {
            app.getFoodPage().setTypeVEGETABLE();
        }
        if (typeFood.equals("фрукт")) {
            app.getFoodPage().setTypeFruit();
        }
    }

    @И("кликаем по чек-боксу Экзотический")
    public void setCheckBoxExotic() {
        app.getFoodPage().setCheckBoxExotic(true);
    }

    @И("нажимаем на кнопку Сохранить")
    public void ckickBtnSave() {
        app.getFoodPage().clickButtonSave();
    }

    @И("проверяем, что товар добавился в список товаров")
    public void viewProd1() {
        //
    }

    @И("проверем, что добавленный товар удалился")
    public void viewProd2() {
        //
    }

    @И("в выпадающес списке нажимаем Сброс данных")
    public void clickReset() {
        app.getHomePage().clickButtonReset();
    }
}
