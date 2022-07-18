package com.meetsky.step_definitions;

import com.meetsky.pages.CalendarPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Calendar_StepDefinitions {

    protected LoginPage loginPage = new LoginPage();

    @When("User enters {string} and {string} and clicks on login button")
    public void userEntersAndAndClicksOnLoginButton(String username, String password) {
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.loginButton.click();
    }

    @When("User clicks on calendar page link")
    public void user_clicks_on_calendar_page_link() {

    }
    @When("User clicks on action item button")
    public void user_clicks_on_action_item_button() {

    }
    @Then("User should be display daily calendar view")
    public void user_should_be_display_daily_calendar_view() {

    }

}
