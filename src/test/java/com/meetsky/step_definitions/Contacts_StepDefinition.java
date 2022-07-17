package com.meetsky.step_definitions;

import com.meetsky.pages.ContactsPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @Given("User fills all properties out")
    public void userFillsAllPropertiesOut() {
        selectUnselectedInputs();
    }

    private static void selectUnselectedInputs() {

        // find unselected inputs for info of new contact and get them into a list of String
        List<String> willClicked = new ArrayList<>(List.copyOf(contactsPage.propertiesToBeSelected
                .stream()
                .filter(element ->
                        !BrowserUtils
                                .getElementsText(contactsPage.presentInputs)
                                .contains(element.getAttribute("title"))
                )
                .map(element -> element.getAttribute("title"))
                .collect(Collectors.toList())));

        // click to every unselected element.
        // We use nested loop and an independent string list to manipulate it during loop to be able to avoid jump one element without clicking.
        // Once we click an element from the list it is getting removed from the list. So, the list is dynamic.
        for (String s : willClicked) {
            for (WebElement element : contactsPage.propertiesToBeSelected) {
                if (element.getAttribute("title").equals(s)) {
                    wait.until(ExpectedConditions.elementToBeClickable(contactsPage.propertiesMenuLink));
                    contactsPage.propertiesMenuLink.click();
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    element.click();
                    break;
                }
            }
        }

    }
}