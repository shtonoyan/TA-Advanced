package org.example.ui.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.core.CustomLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;


public class DriverManager {
    private static WebDriver driver = null;
    private DriverManager(){
    }

    public static void initDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void quitDriver() {
        CustomLogger.log("Quitting Driver");
        driver.quit();
        driver = null;
    }
}
