package org.example.ui.webdriver;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;


public class WebDriverManager {
    public static void configure(){
        Configuration.browser= Browsers.CHROME;
        Configuration.browserSize = "1920x1080";
    }
    public static void close(){
        Selenide.closeWebDriver();
    }


}
