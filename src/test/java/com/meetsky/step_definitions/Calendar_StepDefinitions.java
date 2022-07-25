package com.meetsky.step_definitions;

import com.meetsky.pages.CalendarPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.BrowserUtils;
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
    public void userClicksOnActionItemAndThenDailyActionButton () {

            calendarPage.ActionItemButton.click();
            calendarPage.DailyActionButton.click();
            BrowserUtils.waitFor(2);
        }

    @Then("User should be display daily calendar view")
    public void user_should_be_display_daily_calendar_view () {
            Assert.assertTrue((calendarPage.DailyCalendarView).isDisplayed());
        }

    @When("User clicks on action item  and weekly action button")
    public void userClicksOnActionItemAndWeeklyActionButton () {

            calendarPage.ActionItemButton.click();
            calendarPage.WeeklyActionButton.click();
            BrowserUtils.waitFor(2);
        }

    @Then("User should be display weekly calendar view")
    public void userShouldBeDisplayWeeklyCalendarView () {
            Assert.assertTrue((calendarPage.WeeklyCalendarView).isDisplayed());
        }

    @When("User clicks on action item and monthly action button")
    public void userClicksOnActionItemAndMonthlyActionButton () {
            calendarPage.ActionItemButton.click();
            calendarPage.MonthlyActionButton.click();
            BrowserUtils.waitFor(2);
        }

    @Then("User should be display monthly calendar view")
    public void userShouldBeDisplayMonthlyCalendarView () {
            Assert.assertTrue((calendarPage.MonthlyCalendarView).isDisplayed());
        }

    @When("User clicks on new event button on the left side")
    public void userClicksOnNewEventButtonOnTheLeftSide() {
        calendarPage.NewEventButton.click();
    }

    @And("User types {string}, {string}, {string}  as event")
    public void userTypesAsEvent(String title, String startDate, String endDate) {
        calendarPage.EventTitleInputBox.clear();
        calendarPage.EventTitleInputBox.sendKeys(title);
        calendarPage.DateInputBox.clear();
        calendarPage.DateInputBox.sendKeys(startDate);
        calendarPage.DateInputBox2.clear();
        calendarPage.DateInputBox2.sendKeys(endDate);
        calendarPage.SaveButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("User should be able to create new event")
    public void userShouldBeAbleToCreateNewEvent() {
        String expectEventTitle1 ="vacation";
        String expectEventTitle2 ="sprint planning";
        String expectEventTitle3 ="report date";
        calendarPage.ActionItemButton.click();
        calendarPage.MonthlyActionButton.click();
        calendarPage.ThirtiethDayLink.click();
        BrowserUtils.sleep(3);
        Assert.assertTrue(calendarPage.createdEventTitle1.isDisplayed());
        Assert.assertEquals(expectEventTitle1,calendarPage.createdEventTitle1.getText());

        calendarPage.ActionItemButton.click();
        calendarPage.MonthlyActionButton.click();
        calendarPage.NextMonthButton.click();
        calendarPage.FifteenthDayLink.click();
        Assert.assertTrue(calendarPage.createdEventTitle2.isDisplayed());
        Assert.assertEquals(expectEventTitle1,calendarPage.createdEventTitle2.getText());

        calendarPage.ActionItemButton.click();
        calendarPage.MonthlyActionButton.click();

        while(!(calendarPage.DatePickerButton.getText()).equals("January 2023")){
            calendarPage.NextMonthButton.click();
        }

        calendarPage.FirstDayLink.click();
        Assert.assertTrue(calendarPage.createdEventTitle3.isDisplayed());
        Assert.assertEquals(expectEventTitle1,calendarPage.createdEventTitle3.getText());


    }
}