package com.meetsky.step_definitions;

import com.meetsky.pages.ContactsPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Contacts_StepDefinition {

    private static ContactsPage contactsPage = new ContactsPage();
    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Then("User goes to Contacts page")
    public void user_goes_to_page() {
        contactsPage.contactsPageLink.click();
    }

    @Given("User selects all properties to fill out")
    public void user_selects_all_properties_to_fill_out() {

        selectUnselectedInputs(contactsPage.presentInputs, contactsPage.propertiesToBeSelected);

        contactsPage.propertiesMenuLink.click();

        contactsPage.propertiesToBeSelected.forEach(element -> System.out.println(element.getAttribute("title")));

    }

    private static void selectUnselectedInputs(List<WebElement> alreadySelected, List<WebElement> toBeSelected) {

        List<String> textOfAlreadySelected = alreadySelected
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        System.out.println(textOfAlreadySelected);
        System.out.println(toBeSelected.stream().map(p -> p.getAttribute("title")).collect(Collectors.toList()));

        List<WebElement> loopList = new ArrayList<>(toBeSelected);

        loopList.stream()
                .filter(element -> !textOfAlreadySelected.contains(element.getAttribute("title")))
                .forEach(element -> {
                    contactsPage.propertiesMenuLink.click();
                    BrowserUtils.waitFor(2);
                    element.click();
                    System.out.println(element.getAttribute("title"));
                });

    }
}