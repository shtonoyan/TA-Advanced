package org.example.core;

import lombok.experimental.UtilityClass;
import org.example.ui.webdriver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
@UtilityClass
public class Action {

    public void dragAndDrop(WebElement sourceElement, WebElement target) {
        Wait.waitElementVisibility(sourceElement);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.dragAndDrop(sourceElement, target);
    }

    public void scrollToWebElement(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickWithJs(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
    }

    public void scrollIntoViewPoint(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", element);

    }
}
