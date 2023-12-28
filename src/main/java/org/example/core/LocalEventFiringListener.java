package org.example.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class LocalEventFiringListener implements WebDriverListener {
    public void beforeClick(WebElement element) {
        CustomLogger.log("Going to click");
    }

    public void afterClick(WebElement element) {
        CustomLogger.log("Element clicked");

    }

    public void beforeFindElement(WebDriver driver, By locator) {
        CustomLogger.log("Looking for element " + locator.toString());
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        CustomLogger.log("Found element " + result.toString());
    }
}
