package com.meetsky.step_definitions;

import com.github.javafaker.Faker;
import com.google.common.collect.FluentIterable;
import com.meetsky.pages.BasePage;
import com.meetsky.pages.FilesFavoritesPage;
import com.meetsky.pages.FilesPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.module.Configuration;
import java.util.List;

public class FilesStepDefinitions {
    LoginPage loginPage = new LoginPage();
    FilesPage filesPage = new FilesPage();
    BasePage basePage = new BasePage();
    FilesFavoritesPage filesFavoritesPage = new FilesFavoritesPage();

    @And("user click on the three dots next to chosen file")
    public void userClickOnTheThreeDotsNextToChosenFile() {
        filesPage.threeDotNextToFile.click();
    }


    @And("user clicks on Add to favorites button")
    public void user_clicks_on_add_to_favorites_button() {
        filesPage.addToFavoritesDropDown.click();
    }

    @And("user clicks on Favorites tab at the left menu")
    public void user_clicks_on_favorites_tab_at_the_left_menu() {
        filesPage.favoritesButton.click();
    }

    @Then("user can see that the file is listed at the Favorites tab")
    public void user_can_see_that_the_file_is_listed_at_the_favorites_tab() {
        Assert.assertTrue(filesPage.favorited.isDisplayed());
    }


    @Given("User clicks on Files button on top header menu")
    public void userClicksOnFilesButtonOnTopHeaderMenu() {
        basePage.filesPageLink.click();
    }

    @And("User navigates to Favorites page")
    public void userNavigatesToFavoritesPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("favoritesPage"));
    }


    @And("user clicks on Rename button and rename the file as {string} and see the new name")
    public void userClicksOnRenameButtonAndRenameTheFileAsAndSeeTheNewName(String arg0) {

        Faker faker = new Faker();
        arg0 = faker.name().fullName();
        filesFavoritesPage.reName.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(arg0 + Keys.ENTER).perform();
        String rename = filesFavoritesPage.fileName.getText();
        Assert.assertEquals(rename.contains(arg0), true);
    }

    @And("user click on the three dots next to any file in the FavPage")
    public void userClickOnTheThreeDotsNextToAnyFileInTheFavPage() {
        filesFavoritesPage.threeDotNextToName.click();
    }


    @Then("user can see the file name as {string}")
    public void userCanSeeTheFileNameAs(String arg0) {
        String rename = filesFavoritesPage.fileName.getText();
        Assert.assertEquals(rename.contains(arg0), true);
    }

    @And("user clicks on Details button")
    public void userClicksOnDetailsButton() {
        filesFavoritesPage.detailsButton.click();
    }

    @And("user clicks on Comments button")
    public void userClicksOnCommentsButton() {
        filesFavoritesPage.commentTabView.click();
    }


    @And("user clicks on New Comment text filed and types {string}")
    public void userClicksOnNewCommentTextFiledAndTypes(String arg0) {
        filesFavoritesPage.writeComment.sendKeys(arg0);
    }

    @And("User clicks the arrow")
    public void userClicksTheArrow() {
        filesFavoritesPage.postCommentArrow.click();
    }

    @Then("user can see that the comment is posted")
    public void userCanSeeThatTheCommentIsPosted() {
        filesFavoritesPage.commentTabView.click();
        String newComment = filesFavoritesPage.commentPosted.getText();
        Assert.assertTrue(newComment.contains("New comment Added"));
    }

    @And("user clicks to three dot next to Name")
    public void userClicksToThreeDotNextToName() {
        filesFavoritesPage.threeDotNextToName.click();
    }

    @And("user clicks on Delete comment button")
    public void userClicksOnDeleteCommentButton() {
        filesFavoritesPage.deleteComment.click();
    }

    @Then("user can see that the comment is deleted")
    public void userCanSeeThatTheCommentIsDeleted() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/apps/files/?dir=/&view=favorites");
        String pageSources = Driver.getDriver().getPageSource();
        Assert.assertFalse(pageSources.contains("New comment Added"));
    }


    @And("user clicks to three dot next to Name to move to comment")
    public void userClicksToThreeDotNextToNameToMoveToComment() {
        filesFavoritesPage.threeDotToToMoveComment.click();
    }


    @And("user clicks to three dot next to Name on comment section")
    public void userClicksToThreeDotNextToNameOnCommentSection() {
        filesFavoritesPage.ThreeDotNextToNameOnCommentSection.click();
    }

    @And("user clicks on remove from favorites button")
    public void userClicksOnRemoveFromFavoritesButton() {
        filesFavoritesPage.removeFromFavorites.click();
    }

    @And("user click on the three dots to removeFrom favorites")
    public void userClickOnTheThreeDotsToRemoveFromFavorites() {
        filesFavoritesPage.threeDotToToMoveComment.click();
    }

}







