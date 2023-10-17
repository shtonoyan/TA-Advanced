package org.example.ui.pages;

import com.codeborne.selenide.Selenide;
import org.example.core.PropertyReader;

public abstract class BasePage {
    protected final String baseUrl = PropertyReader.getProperty("baseUrl");
    protected abstract String getCurrentPageUrl();
    public String getPageUrl(){
        return baseUrl + getCurrentPageUrl();
    }

    public void open(){
        Selenide.open(getPageUrl());
    }

}
