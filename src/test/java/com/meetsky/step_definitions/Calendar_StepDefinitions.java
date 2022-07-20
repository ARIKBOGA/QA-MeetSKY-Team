package com.meetsky.step_definitions;

import com.meetsky.pages.CalendarPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

public class Calendar_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    CalendarPage calendarPage = new CalendarPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @When("User enters {string} and {string} and clicks on login button")
    public void userEntersAndAndClicksOnLoginButton(String username, String password) {
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.loginButton.click();
    }

    @When("User clicks on calendar page link")
    public void user_clicks_on_calendar_page_link() {
        calendarPage.calendarPageLink.click();

    }
    @When("User clicks on action item button")
    public void user_clicks_on_action_item_button() {
        calendarPage.ActionItemButton.click();
        calendarPage.DailyActionButton.click();

    }
    @Then("User should be display daily calendar view")
    public void user_should_be_display_daily_calendar_view() {


    }

}
