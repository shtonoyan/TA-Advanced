package org.example.ui.pages.seleniumpages;

import org.example.core.LocalEventFiringListener;
import org.example.core.PropertyReader;
import org.example.ui.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;

public abstract class BaseSeleniumPage {
    protected static final String BASE_URL = PropertyReader.getProperty("baseUrl");

    protected abstract String getCurrentPagePath();

    protected WebDriver driver;

    public BaseSeleniumPage() {
        WebDriver webDriver = DriverManager.getDriver();
        LocalEventFiringListener listener = new LocalEventFiringListener();
        driver = new EventFiringDecorator(listener).decorate(webDriver);
        PageFactory.initElements(driver, this);
    }

    protected String getPageUrl() {
        return BASE_URL + getCurrentPagePath();
    }

    public void openPage() {
        driver.get(getPageUrl());
    }

}
