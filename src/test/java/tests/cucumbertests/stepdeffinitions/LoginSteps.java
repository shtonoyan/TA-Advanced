package tests.cucumbertests.stepdeffinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.PropertyReader;
import org.example.ui.pages.LoginPage;
import org.example.ui.webdriver.WebDriverManager;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("I have the login page loaded")
    public void openLoginPage() {
        loginPage.open();
    }

    @When("I complete the username field with {string}")
    public void completeUserName(String username) {
        loginPage.completeLogin(username);
    }

    @And("I complete the password field with {string}")
    public void completePassword(String password) {
        loginPage.completePassword(password);
    }

    @And("I click the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I am successfully logged in to the application")
    public void verifyLogin() {
        loginPage.userLoggedIn();
    }

    @Then("An error message is being shown")
    public void verifyErrorMessage() {
        loginPage.verifyErrorMessage();
    }
}
