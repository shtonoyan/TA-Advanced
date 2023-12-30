package org.example.ui.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.example.core.CustomLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverManager {
    @Getter
    private static WebDriver driver = null;

    private DriverManager() {
    }

    public static void initDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }
    }

    public static void quitDriver() {
        CustomLogger.log("Quitting Driver");
        driver.quit();
        driver = null;
    }
}
