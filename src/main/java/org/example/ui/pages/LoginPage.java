package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.core.CustomLogger;
import org.example.ui.PagePaths;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.name;

public class LoginPage extends BasePage {
    private final SelenideElement loginField = $(name("login"));
    private final SelenideElement passwordField = $(name("password"));
    private final SelenideElement loginButton = Selenide.$(Selectors.byText("Login"));

    @Step("Complete the username")
    public void completeLogin(String login) {
        loginField.setValue(login);
        CustomLogger.log("Completed the username");
    }

    @Step("Complete the password")
    public void completePassword(String password) {
        passwordField.setValue(password);
        CustomLogger.log("Completed the password");
    }

    @Step("Click Login button")
    public void clickLoginButton() {
        loginButton.shouldBe(visible);
        loginButton.click();
        CustomLogger.log("Clicking the login button");
    }

    @Override
    protected String getCurrentPageUrl() {
        return PagePaths.LOGIN_PAGE;
    }
}
