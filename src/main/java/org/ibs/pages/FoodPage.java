package pages;

import org.ibs.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Клас описывающий страницу товара
 * @author Andrey_Zhizhov
 */
public class FoodPage extends BasePage {

    /**
     * Метод приостановки выполнения
     *
     */
    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private DriverManager driver = DriverManager.getDriverManager();

    //Select selectTypeProd = new Select(driver.getDriver().findElement(By.id("type")));
    Select selectTypeProd = new Select(driver.getDriver().findElement(By.xpath("//select[@name='type']")));


    @FindBy(xpath = "//div/h5[.='Список товаров']")
    WebElement title; // список товаров

    @FindBy(xpath = "//button[@type = 'button' and .='Добавить']")
    WebElement buttonAdd; //кнопка Добавить

    @FindBy(xpath = "//div[@class='modal-dialog']//h5[.='Добавление товара']")
    WebElement titleAddingProducts; // всплывающее окно Добавление товара

    @FindBy(xpath = "//input[@id='name']")
    WebElement clickFieldName; //кликт по полю Наименование

    @FindBy(xpath = "//input[@id='name']")
    WebElement fieldName; //поле Наименование

    @FindBy(xpath = "//select[@id='type']")
    WebElement selectType; // селектор выбота типа

    @FindBy(xpath = "//input[@id='exotic' and @type='checkbox']")
    WebElement checkBoxExotic; // чекбокс экзотик

    @FindBy(xpath = "//button[.='Сохранить']")
    WebElement buttonSave; // кнопка сохранить

    @FindBy(xpath = "//th[@scope='row' and .='5']")
    WebElement row; // строка с номером

    @FindBy(xpath = "//th[@scope='row' and .='5']/following::td[1]")
    WebElement foodName; // название товара в таблице

    @FindBy(xpath = "//th[@scope='row' and .='5']/following::td[2]")
    WebElement foodType; // тип товара в таблице

    @FindBy(xpath = "//th[@scope='row' and .='5']/following::td[3]")
    WebElement trueFalseExotic; // значение флага экзотик

    @FindBy(xpath = "//a[@id='reset' and .='Сброс данных']")
    WebElement elementReset; // сброс данных

    /**
     *Проверка открытия страницы, путём проверки title страницы
     * @return FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage checkOpenFoodPage() {
        Assertions.assertEquals(
                "Список товаров", title.getText(), "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }

    /**
     * Проверка присутствия на странице кнопки Добавить
     * @return FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage checkBtnAdd() {
        Assertions.assertEquals("Добавить", buttonAdd.getText(), "Кнопка отсутствует на странице");
        return this;
    }

    /**
     * Клин по кнопке Добавить
     * @return FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage clickBtnAdd() {
        buttonAdd.click();
        return this;
    }

    /**
     * Проверка открытия окна Добавления товара
     * @return FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage checkOpenAddingProduct() {
        Assertions.assertEquals("Добавление товара", titleAddingProducts.getText(), "Всплывающее окно Добавление товара отсутствует");
        return this;
    }

    public FoodPage clickFieldName() {
        clickFieldName.click();
        return this;
    }

    /**
     * Метод заполнения полей
     * @param value     - значение вводимое в поле
     * @return FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage fillField(String value) {
        fillInputField(fieldName,value);
        return this;
    }

    /**
     * Клик на всплывающем списке Тип
     * @return FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage clickButtonProduct() {
        selectType.click();
        return this;
    }

    public  FoodPage setTypeFruit() {
        selectTypeProd.selectByValue("FRUIT");
        return this;
    }

    public  FoodPage setTypeVEGETABLE() {
        selectTypeProd.selectByValue("VEGETABLE");
        return this;
    }

    /**
     * Выбор тип товара
     * @param value - значение вводимое в поле
     * @return FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage setSelectType(String value) {
        if (value.equals("Фрукт")) {
            setTypeFruit();
            return this;
        }
        if (value.equals("Овощ")) {
            setTypeVEGETABLE();
            return this;
        }
        Assertions.fail("Значение '" + value + "' отсутствует в выборе " + " 'Тип'");
        return this;
    }
//    public FoodPage setSelectType(String value) {
//        sleep();
//        System.out.println(value);
//        sleep();
//        switch (value) {
//            //case ("Овощ") : selectTypeProd.selectByValue("VEGETABLE");
//            case "Овощ" : setTypeVEGETABLE();
//            break;
//            case "Фрукт" : setTypeFruit();
//            break;
//            default:
//                Assertions.fail("Значение '" + value + "' отсутствует в выборе " + " 'Тип'");
//        }
//        Assertions.fail("Поле '" + value + "' было заполнено некорректно");
//        return this;
//    }

    /**
     * Установка значения чек бокса
     * @param value - признак экзотик
     * @return FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage setCheckBoxExotic(Boolean value) {
        if (value) {
            checkBoxExotic.click();
            return this;
        }
        return this;
    }

    /**
     * Метод запонения окна товара
     * @param nameProd  - название товара
     * @param nameType  - тип товара
     * @param isExotic  - признак экзотик
     * @return  FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage addingProduct(String nameProd, String nameType, boolean isExotic) {
        clickFieldName();
        fillField(nameProd);
        clickButtonProduct();
        setSelectType(nameType);
        setCheckBoxExotic(isExotic);
        return this;
    }

    /**
     * Клик по кнопке сохранить
     * @return FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage clickButtonSave() {
        buttonSave.click();
        return this;
    }

    /**
     * Клик по элементу меню Сброс данных
     */
    public void clickButtonReset() {
        sleep();
        elementReset.click();
    }

    /**
     * Проверка добавление новой (5-й) строки
     * @return FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage checkAddRow(int value) {
        sleep();
        Assertions.assertEquals(Integer.toString(value), row.getText(), "Новая строка не добавилась / отсутствует");
        return this;
    }

    /**
     * Проверка соответствия добавленог товара
     * @param nameProd  - наименование товара
     * @param typeProd  - тип товара
     * @param isExotic    - экзотик?
     * @return FoodPage - т.е. остаемся на этой странице
     */
    public FoodPage checkAdd(String nameProd, String typeProd, boolean isExotic) {
        String exotic = "";
        if (isExotic) {
            exotic = "true";
        }
        else {
            exotic = "false";
        }
        Assertions.assertEquals(nameProd, foodName.getText(), "Название товара не соответствует");
        Assertions.assertEquals(typeProd, foodType.getText(), "Тип товара не соответствует");
        Assertions.assertEquals(exotic, trueFalseExotic.getText(), "Признак 'Экзотик' не соответствует");
        return this;
    }
}
