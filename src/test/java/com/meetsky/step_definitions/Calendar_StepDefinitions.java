package com.meetsky.step_definitions;

import com.meetsky.pages.CalendarPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
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
    public void userClicksOnCalendarPageLink () {
            calendarPage.calendarPageLink.click();
        }

    @And("User clicks on action item and then daily action button")
    public void userClicksOnActionItemAndThenDailyActionButton () throws InterruptedException {
        wait(20);
            calendarPage.ActionItemButton.click();
            calendarPage.DailyActionButton.click();
        }

    @Then("User should be display daily calendar view")
    public void user_should_be_display_daily_calendar_view () {
            Assert.assertTrue((calendarPage.DailyCalendarView).isDisplayed());
        }

    @When("User clicks on action item  and weekly action button")
    public void userClicksOnActionItemAndWeeklyActionButton () {
            calendarPage.ActionItemButton.click();
            calendarPage.WeeklyActionButton.click();
        }

    @Then("User should be display weekly calendar view")
    public void userShouldBeDisplayWeeklyCalendarView () {
            Assert.assertTrue((calendarPage.WeeklyCalendarView).isDisplayed());
        }

    @When("User clicks on action item and monthly action button")
    public void userClicksOnActionItemAndMonthlyActionButton () {
            calendarPage.ActionItemButton.click();
            calendarPage.WeeklyActionButton.click();
        }

    @Then("User should be display monthly calendar view")
    public void userShouldBeDisplayMonthlyCalendarView () {
            Assert.assertTrue((calendarPage.MonthlyCalendarView).isDisplayed());
        }

    @When("User clicks on new event button on the left side")
    public void userClicksOnNewEventButtonOnTheLeftSide() {
        calendarPage.NewEventButton.click();
    }
}