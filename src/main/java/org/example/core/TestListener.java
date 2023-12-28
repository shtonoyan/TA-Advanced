package org.example.core;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.example.ui.webdriver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result.getName());
    }

    @SneakyThrows
    public void takeScreenshot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
//Saving the screenshot in desired location
        File source = screenshot.getScreenshotAs(OutputType.FILE);
//Path to the location to save screenshot
        FileUtils.copyFile(source, new File("./SeleniumScreenshots/Screen.png"));
    }
}
