package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Класс для управления веб драйвера
 * @author Andrey_Zhizhov
 */
public class DriverManager {

    private WebDriver driver;
    private static DriverManager INSTANCE = null;
    private static final String pathToChromeDriver = "src/main/resources/drivers/chromedriver.exe"; // путь до файла драйвера

    /***
     *
     */
    private DriverManager() {
    }

    /***
     * Метод ленивой инициализации DriverManager
     * @return DriverManager - возвращает DriverManager
     */
    public static DriverManager getDriverManager(){
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    /***
     * Метод ленивой инициализации вебдрайвера
     * @return WebDriver - возвращает WebDriver
     */
    public WebDriver getDriver(){
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    /***
     * Метод закрывает сессию драйвера и браузера
     */
    public void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /***
     * Метод инициализации веб драйвера
     */
    private void initDriver() {
        System.setProperty("webdriver.chromedriver.driver", pathToChromeDriver);
        driver = new ChromeDriver();
    }
}
