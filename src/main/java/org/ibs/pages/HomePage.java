package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Стартовая стриница приложения
 * @author Andrey_Zhizhov
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@id = 'navbarDropdown']")
    WebElement elementSandbox; // Песочница

    @FindBy(xpath = "//a[.= 'Товары']")
    WebElement elementProduct; // товары

    @FindBy(xpath = "//a[@id='reset' and .='Сброс данных']")
    WebElement elementReset; // сброс данных


    /**
     * Клик по веб элементу Песочница
     *
     */
    public HomePage clickButtonSandBox() {
        elementSandbox.click();
        return this;
    }

    /**
     * Клик по элементу меню Товары
     */
    public HomePage clickButtonProduct() {
        elementProduct.click();
        return this;
    }

    /**
     * Клик по элементу меню Сброс данных
     */
    public HomePage clickButtonReset() {
        elementReset.click();
        return this;
    }
}
