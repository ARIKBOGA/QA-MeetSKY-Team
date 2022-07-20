package com.meetsky.step_definitions;

import com.meetsky.pages.ContactsPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Contacts_StepDefinition {

    private static ContactsPage contactsPage = new ContactsPage();
    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    private static int totalContacts;
    private static WebElement contactWillBeDeleted;

    @Then("User goes to Contacts page")
    public void user_goes_to_page() {
        contactsPage.contactsPageLink.click();
    }

    @Given("User clicks to new contact button")
    public void userClicksToNewContactButton() {
        contactsPage.newContactButton.click();
    }


    @And("User fills {string} {string} {string} {string} {string} {string} {string} {string} {string} properties out")
    public void userFillsPropertiesOut(String fullname, String company, String title, String phone, String email, String birthday, String gender, String city, String country) {
        selectUnselectedInputs();
        wait.until(ExpectedConditions.visibilityOf(contactsPage.birthdayDateInput));
        contactsPage.newContactFullnameInput.sendKeys(fullname);
        contactsPage.companyInput.sendKeys(company);
        contactsPage.titleInput.sendKeys(title);
        contactsPage.phoneTypeMenuLink.click();
        contactsPage.phoneTypeOptions.get(new Random().nextInt(12)).click();
        contactsPage.phoneInput.sendKeys(phone);
        contactsPage.emailTypeMenuLink.click();
        contactsPage.emailTypeOptions.get(new Random().nextInt(3)).click();
        contactsPage.emailInput.sendKeys(email);
        contactsPage.birthdayDateInput.sendKeys(birthday);
        contactsPage.genderMenuLink.click();
        contactsPage.genderOptions.get(gender.equals("Female") ? 0 : 1).click();
        contactsPage.cityInput.sendKeys(city);
        contactsPage.countryInput.sendKeys(country);
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

    @Given("User clicks to All contacts link")
    public void userClicksToLink() {
        totalContacts = contactsPage.contactsInTheMiddleColumn.size();
        contactsPage.allContactsLink.click();
    }

    @Then("User should be able to see all contacts in the middle column")
    public void userShouldBeAbleToSeeAllContactsInTheMiddleColumn() {
        int middleColumnCount = contactsPage.contactsInTheMiddleColumn.size();
        int allContactsNumber = Integer.parseInt(contactsPage.numberOfContacts.getText());
        assertThat(middleColumnCount, is(equalTo(allContactsNumber)));
    }

    @Then("User should be able to se the correct number near the “All Contacts” tab")
    public void userShouldBeAbleToSeTheCorrectNumberNearTheAllContactsTab() {
        int middleColumnCount = contactsPage.contactsInTheMiddleColumn.size();
        int allContactsNumber = Integer.parseInt(contactsPage.numberOfContacts.getText());
        assertThat(allContactsNumber, is(equalTo(middleColumnCount)));
    }

    @And("User clicks to a random contact in the middle column")
    public void userClicksToARandomContactInTheMiddleColumn() {
        contactWillBeDeleted = contactsPage.contactsInTheMiddleColumn
                .get(new Random().nextInt(contactsPage.contactsInTheMiddleColumn.size()));
        totalContacts = contactsPage.contactsInTheMiddleColumn.size();
        contactWillBeDeleted.click();
    }

    @And("User clicks to Change Picture button")
    public void userClicksToChangePictureButton() {
        contactsPage.changePictureButton.click();
    }

    @And("User clicks to Choose From File button")
    public void userClicksToChooseFromFileButton() {
        contactsPage.chooseFromFilesButton.click();
    }

    @And("User selects a jpeg file by clicking")
    public void userSelectsAJpegFileByClicking() {
        contactsPage.pictureWillBeSelected.click();
    }

    @And("User clicks to Choose button")
    public void userClicksToChooseButton() {
        contactsPage.chooseButton.click();
    }

    @Then("User should be able to see the PP has been changed")
    public void userShouldBeAbleToSeeThePPHasBeenChanged() {
        contactsPage.profilePicture.click();
        wait.until(ExpectedConditions.visibilityOf(contactsPage.expandedProfilePicture));
        Assert.assertTrue(contactsPage.expandedProfilePicture.isDisplayed());
    }

    @And("User clicks to Three dot menu link")
    public void userClicksToThreeDotMenuLink() {
        contactsPage.threeDotsMenuButton.click();
    }

    @And("User clicks to Delete button")
    public void userClicksToDeleteButton() {
        contactsPage.deleteContactButton.click();
    }

    @Then("User should be able to see the contact has been deleted")
    public void userShouldBeAbleToSeeTheContactHasBeenDeleted() {
        Assert.assertFalse(contactsPage.contactsInTheMiddleColumn.contains(contactWillBeDeleted));
        Assert.assertEquals(totalContacts - 1, contactsPage.contactsInTheMiddleColumn.size());
    }
}