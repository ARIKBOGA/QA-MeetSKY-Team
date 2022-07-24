package com.meetsky.step_definitions;

import com.meetsky.pages.LoginPage;
import com.meetsky.pages.Serpil_ProfileSettingsPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfileSettings_StepDefinitions {

LoginPage loginPage= new LoginPage();
Serpil_ProfileSettingsPage profileSettingsPage= new Serpil_ProfileSettingsPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("login_page_url"));
        BrowserUtils.waitForPageToLoad(20);
        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle= "Meetsky - QA";
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Given("user enters valid credentials")
    public void user_enters_valid_credentials() {
      loginPage.usernameBox.sendKeys(ConfigurationReader.getProperty("valid_username"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("valid_password"));
        loginPage.loginButton.click();
    }
    @Then("user should see homepage")
    public void user_should_see_homepage (){
        String actualLink= Driver.getDriver().getCurrentUrl();
        String expectedLink="https://qa.meetsky.net/index.php/apps/";
        Assert.assertTrue(actualLink.contains(expectedLink));

    }
    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        String actualLink= Driver.getDriver().getCurrentUrl();
        String expectedLink="https://qa.meetsky.net/index.php/apps/";
        Assert.assertTrue(actualLink.contains(expectedLink));
    }
    @When("user clicks on account menu")
    public void user_clicks_on_account_menu() {
    profileSettingsPage.accountMenu.click();
    }
    @When("user clicks on accountMenuSettingsButton")
    public void user_clicks_on_account_menu_settings_button() {
        profileSettingsPage.accountMenuSettingsButton.click();
    }
    @Then("user should see full name Title")
    public void user_should_see_full_name_title() {
        String expectedFullNameTitle= "Full name";
        String actualFullNameTitle= profileSettingsPage.fullNameTitle.getText();
        Assert.assertEquals(expectedFullNameTitle,actualFullNameTitle);

    }
    @Then("user should see email title")
    public void user_should_see_email_title() {
String  expectedEmailTitle= "Email";
String actualEmailTitle= profileSettingsPage.emailTitle.getText();
Assert.assertEquals(expectedEmailTitle, actualEmailTitle);
    }
    @Then("user should see phone number title")
    public void user_should_see_phone_number_title() {
String expectedPhoneNumberTitle= "Phone number";
String actualPhoneNumberTitle= profileSettingsPage.phoneNumberTitle.getText();
Assert.assertEquals(expectedPhoneNumberTitle,actualPhoneNumberTitle);
    }


    @Then("user should see {string} inside the full name box and on the profile")
    public void user_should_see_inside_the_full_name_box_and_on_the_profile(String newFullName) {
Assert.assertEquals(newFullName, "newEmployee");
    }


    @When("user enters a new full name {string} inside full name box")
    public void userEntersANewFullNameInsideFullNameBox(String newFullName) {
        profileSettingsPage.profileSettingsNameBox.sendKeys("newEmployee");
    }

    @Then("user should see new Full name {string} inside the full name box and on the profile")
    public void userShouldSeeNewFullNameInsideTheFullNameBoxAndOnTheProfile(String newFullName) {
        newFullName= "newEmployee";
        String actualNameOnProfile= profileSettingsPage.accountMenuUsername.getText();
        Assert.assertEquals(newFullName,actualNameOnProfile);
    }

    @When("user clicks on phoneOptionsButton")
    public void user_clicks_on_phone_options_button() {
        profileSettingsPage.phoneOptionsButton.click();
    }


    @When("user selects phonePrivateOption")
    public void user_selects_phone_private_option() {
        profileSettingsPage.phonePrivateOption.click();

    }
    @Then("user should see notice message as {string}")
    public void user_should_see_notice_message_as(String noticeMessage) {
       String actualNoticeMessage=  Driver.getDriver().getTitle();
       Assert.assertEquals(noticeMessage,actualNoticeMessage);

    }
    @And("user enters valid password in the AuthenticationInputBox")
    public void userEntersValidPasswordInTheAuthenticationInputBox() {
profileSettingsPage.phoneAuthenticationInputBox.sendKeys(ConfigurationReader.getProperty("valid_password"));
    }
    @Then("user clicks on confirm button")
    public void user_clicks_on_confirm_button() {
profileSettingsPage.phoneAuthenticationConfirmButton.click();
    }
    @Then("phone should be private")
    public void phone_should_be_private() {


    }




    @Then("user should see the current local time under the local dropdown")
    public void user_should_see_the_current_local_time_under_the_local_dropdown() {
    WebElement localTime= Driver.getDriver().findElement(By.xpath("//span[@id='localeexample-time']"));


    }



}
