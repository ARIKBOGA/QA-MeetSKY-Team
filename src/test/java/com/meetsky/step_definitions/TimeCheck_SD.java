package com.meetsky.step_definitions;

import com.meetsky.pages.BasePage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeCheck_SD {

    BasePage basePage = new BasePage();

    @Given("user is on th homepage")
    public void userIsOnThHomepage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("apps/files"));
    }

    @When("user clicks on account menu")
    public void userClicksOnAccountMenu() {
        BrowserUtils.verifyElementDisplayed(basePage.topRightSettingsExpandButton);
        basePage.topRightSettingsExpandButton.click();
    }

    @And("user clicks on accountMenuSettingsButton")
    public void userClicksOnAccountMenuSettingsButton() {
        BrowserUtils.verifyElementDisplayed(basePage.accountMenuSettingsButton);
        basePage.accountMenuSettingsButton.click();

    }

    @Then("user should see the current local time under the local dropdown")
    public void userShouldSeeTheCurrentLocalTimeUnderTheLocalDropdown() {

        WebElement webElement = Driver.getDriver().findElement(By.xpath("//span[@id='localeexample-time']"));
        LocalDateTime now = LocalDateTime.now();

        System.out.println("webElement.getText() = " + webElement.getAttribute("innerText"));
        System.out.println("now = " + now.toString().substring(11, 19));

        String actualTime = webElement.getText();

        actualTime = actualTime.endsWith("AM") ? actualTime.substring(0, actualTime.length() - 3)
                : Integer.parseInt(actualTime.substring(0, 2)) + 12 + actualTime.substring(2, actualTime.length() - 3);


        Assert.assertEquals(now.toString().substring(11, 19), actualTime);

    }
}
