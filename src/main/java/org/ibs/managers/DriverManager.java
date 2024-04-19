package org.ibs.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

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
            //initDriver();
            initDriverForJenkins();
        }
        return driver;
    }

    public WebDriver getDriver(String url){
        if (driver == null) {
            //initDriver();
            initDriverForJenkins(url);
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

    /**
     * Метод инициализации для jenkins
     */
    private void  initDriverForJenkins(String url){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("109.0");
        capabilities.setCapability("enableVNC",true);
        capabilities.setCapability("enableVideo",false);
        try {
            driver = new RemoteWebDriver(URI.create(url).toURL(),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

}
