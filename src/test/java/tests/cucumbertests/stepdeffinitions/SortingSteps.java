package tests.cucumbertests.stepdeffinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ui.pages.LaunchesPage;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;

public class SortingSteps {
    LaunchesPage launchesPage = new LaunchesPage();

    @Given("I navigated to the launches page")
    public void openLaunchesPage() {
        launchesPage.open();
    }

    @When("I click TOTAL column")
    public void clickTotalColumnTitle() {
        launchesPage.sortByTotal();
    }


    @Then("The column is sorted ascendingly by TOTAL numbers")
    public void verifyTableSortedByTotal() {
        List<String> expectedList = launchesPage.getTotalValues();
        Collections.sort(expectedList);
        Assertions.assertEquals(expectedList, launchesPage.getTotalValues());
    }

    @When("I click PASSED column")
    public void clickPassedColumnTitle() {
        launchesPage.sortByPassed();
    }

    @Then("The column is sorted ascendingly by PASSED numbers")
    public void verifyTableSortedByPassed() {
        List<Integer> expectedLIst = launchesPage.getPassedValues();
        Collections.sort(expectedLIst);
        Assertions.assertEquals(expectedLIst, launchesPage.getPassedValues());
    }


    @When("I click FAILED column")
    public void clickFailedColumnTitle() {
        launchesPage.sortByFailed();
    }

    @Then("The column is sorted ascendingly by FAILED numbers")
    public void verifyTableSortedByFailed() {
        List<String> expectedLIst = launchesPage.getFailedValues();
        Collections.sort(expectedLIst);
        Assertions.assertEquals(expectedLIst, launchesPage.getFailedValues());
    }

}
