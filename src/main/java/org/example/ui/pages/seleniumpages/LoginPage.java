package org.example.ui.pages.seleniumpages;

import io.qameta.allure.Step;
import org.example.core.CustomLogger;
import org.example.core.Wait;
import org.example.ui.PagePaths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage extends BaseSeleniumPage {
    @FindBy(css = "[name='login']")
    private WebElement loginField;

    @FindBy(css = "[name='password']")
    private WebElement passwordField;
    @FindBy(css = "[type='submit']")
    private WebElement loginButton;
    @Override
    protected String getCurrentPagePath() {
        return PagePaths.LOGIN_PAGE;
    }

    @Step("Complete the username")
    public void completeLogin(String login) {
        Wait.waitElementVisibility(loginField);
        loginField.sendKeys(login);
        CustomLogger.log("Completed the username");
    }

    @Step("Complete the password")
    public void completePassword(String password) {
        Wait.waitElementVisibility(passwordField);
        passwordField.sendKeys(password);
        CustomLogger.log("Completed the password");
    }

    @Step("Click Login button")
    public void clickLoginButton() {
        Wait.waitElementToBeClickable(loginButton);
        loginButton.click();
        CustomLogger.log("Clicking the login button");
    }

    @Step("Click Login button")
    public boolean loginButtonIsDisplayed() {
        return loginButton.isDisplayed();
    }


}
