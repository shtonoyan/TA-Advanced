package org.example.core;

import lombok.experimental.UtilityClass;
import org.example.ui.webdriver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@UtilityClass
public class Wait {
    private final int DEFAULT_TIMEOUT = 30;

    public void waitElementVisibility(WebElement element) {
        CustomLogger.log("Waiting element visibility...");
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitListToBePopulated(List<WebElement> elements) {
        CustomLogger.log("Waiting the list not to be empty...");
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitElementToBeClickable(WebElement element) {
        CustomLogger.log("Waiting element to be clickable...");
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void fluentWaitForElement(WebElement element){
        FluentWait fluentWait = new FluentWait<WebElement>(element)
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
                .pollingEvery(Duration.ofMillis(10))
                .withMessage("Could not find");
    }
}
