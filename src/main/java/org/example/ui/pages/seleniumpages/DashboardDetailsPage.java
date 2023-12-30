package org.example.ui.pages.seleniumpages;

import org.example.core.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardDetailsPage extends BaseSeleniumPage{
    @FindBy(xpath = "//*[text()='Add new widget']")
    private WebElement addNewWidgetButton;
    @Override
    protected String getCurrentPagePath() {
        return null;
    }

    public void clickAddNewWidgetButton(){
        Wait.waitElementToBeClickable(addNewWidgetButton);
        addNewWidgetButton.click();
    }
}
