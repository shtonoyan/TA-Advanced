package tests.cucumbertests.stepdeffinitions;

import io.cucumber.java.en.Then;
import org.example.ui.pages.LaunchesPage;

import java.util.List;

public class FiltersPresenceSteps {
    LaunchesPage launchesPage = new LaunchesPage();
    @Then("Filter is displayed")
    public void isFilterDisplayed(io.cucumber.datatable.DataTable dataTable){
        List<String> filters = dataTable.asList(String.class);
        for (String filterName:filters
             ) {
            launchesPage.isFilterDisplayed(filterName);
        }
    }
}
