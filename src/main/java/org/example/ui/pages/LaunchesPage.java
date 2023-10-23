package org.example.ui.pages;

import com.codeborne.selenide.*;
import org.example.ui.PagePaths;

import java.util.List;
import java.util.stream.Collectors;

public class LaunchesPage extends BasePage{
    private final ElementsCollection total = Selenide.$$x("//a[@statuses='PASSED,FAILED,SKIPPED,INTERRUPTED']");
    private final ElementsCollection passed = Selenide.$$x("//a[@statuses='PASSED']");
    private final ElementsCollection failed = Selenide.$$x("//a[@statuses='FAILED,INTERRUPTED']");
    private final ElementsCollection skipped = Selenide.$$x("//a[@statuses='SKIPPED']");

    @Override
    protected String getCurrentPageUrl() {
        return PagePaths.LAUNCHES;
    }

    public void isFilterDisplayed(String text){
        Selenide.$(Selectors.byText(text)).shouldBe(Condition.visible);
    }
    public void sortByTotal(){
        Selenide.$x("//span[text()='total']/following-sibling::span/ancestor::div[@class='headerCell__title-container--Bt3as']").shouldBe(Condition.enabled).click();
    }

    public void sortByPassed(){
        Selenide.$x("//span[text()='passed']/following-sibling::span/ancestor::div[@class='headerCell__title-container--Bt3as']").shouldBe(Condition.enabled).click();
    }

    public void sortByFailed(){
        Selenide.$x("//span[text()='failed']/following-sibling::span/ancestor::div[@class='headerCell__title-container--Bt3as']").shouldBe(Condition.enabled).click();
    }

    public List<String> getTotalValues(){
        total.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return total.stream().map(SelenideElement::getText).collect(Collectors.toList());
    }

    public List<Integer> getPassedValues(){
        passed.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return passed.stream().map(SelenideElement::getText).map(Integer::valueOf).collect(Collectors.toList());
    }

    public List<String> getFailedValues(){
        failed.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return failed.stream().map(SelenideElement::getText).collect(Collectors.toList());
    }
}
