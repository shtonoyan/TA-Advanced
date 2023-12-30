package org.example.ui.pages.seleniumpages;

import org.example.core.Action;
import org.example.core.Wait;
import org.example.ui.PagePaths;
import org.example.ui.webdriver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class DashboardPage extends BaseSeleniumPage {
    private String deleteIconXpath = "//a[text()='%s']/ancestor::div[@class='gridRow__grid-row--X9wIq']/descendant::i[@class='icon__icon--coE7b icon__icon-delete--lwBwP']";
    private String editIconXpath = "//a[text()='%s']/ancestor::div[@class='gridRow__grid-row--X9wIq']/descendant::i[@class='icon__icon--coE7b icon__icon-pencil--hZNP6']";
    private String dashboardDescriptionXpath = "//a[text()='%s']/following-sibling::div[1]";
    @FindBy(css = ".addDashboardButton__add-dashboard-btn--acseh")
    private WebElement addNewDashboardButton;

    @FindBy(css = "[placeholder='Enter dashboard name']")
    private WebElement dashboardNameField;

    @FindBy(css = "[placeholder='Enter dashboard description']")
    private WebElement dashboardDescriptionField;

    @FindBy(xpath = "//*[text()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//button[text()='Update']")
    private WebElement updateButton;

    @FindBy(xpath = "//a[@class='gridCell__grid-cell--EIqeC gridCell__align-left--DFXWN dashboardTable__name--t2a89']")
    private List<WebElement> dashboards;

    @FindBy(xpath = "//button[text() = 'Delete']")
    private WebElement deleteButton;


    @Override
    protected String getCurrentPagePath() {
        return PagePaths.DASHBOARD;
    }

    public void clickAddNewDashboardButton() {
        Wait.waitElementToBeClickable(addNewDashboardButton);
        addNewDashboardButton.click();
    }

    public void enterDashboardName(String name) {
        Wait.waitElementVisibility(dashboardNameField);
        dashboardNameField.sendKeys(name);
    }

    public void enterDashboardDescription(String description) {
        dashboardDescriptionField.sendKeys(description);
    }

    public void createDashboard() {
        addButton.click();
    }

    public List<String> dashboardNames() {
        Wait.waitElementVisibility(addNewDashboardButton);
        return dashboards.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void deleteDashboard(String name) {
        WebElement deleteIcon = DriverManager.getDriver().findElement(By.xpath(String.format(deleteIconXpath, name)));
        Wait.waitElementToBeClickable(deleteIcon);
        deleteIcon.click();
        Wait.waitElementToBeClickable(deleteButton);
        Action.clickWithJs(deleteButton);
    }

    public void editDashboardDescription(String name) {
        WebElement editIcon = DriverManager.getDriver().findElement(By.xpath(String.format(editIconXpath, name)));
        Wait.waitElementToBeClickable(editIcon);
        editIcon.click();
        Wait.waitElementToBeClickable(editIcon);
        Action.clickWithJs(editIcon);
        enterDashboardDescription("edited");
        Wait.waitElementToBeClickable(updateButton);
        updateButton.click();
    }

    public String getDashboardDescription(String name) {
        Wait.waitElementToBeClickable(addNewDashboardButton);
        WebElement element = DriverManager.getDriver().findElement(By.xpath(String.format(dashboardDescriptionXpath, name)));
        return element.getText();
    }
}
