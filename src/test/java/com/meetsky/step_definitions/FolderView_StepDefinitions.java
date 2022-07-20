package com.meetsky.step_definitions;

import com.meetsky.pages.FilesPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FolderView_StepDefinitions {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
    Actions actions = new Actions(Driver.getDriver());

    FilesPage filesPage = new FilesPage();

    List<String> expectedFoldersNameList = new ArrayList<>();
    List<String> expectedFilesNameList = new ArrayList<>();
    List<String> expectedFullFilesAndFoldersTogether = new ArrayList<>();


    List<String> ActualNamesList = new ArrayList<>();

    @Given("User clicks Name link")
    public void user_clicks_name_link() {

        filesPage.nameText.click();


    }


    @Then("User sees Files and Folders in an order according to their Names")
    public void userSeesFilesAndFoldersInAnOrderAccordingToTheirNames() {
        String sortingIndicator = filesPage.sortingTick.getAttribute("class");
        System.out.println("sortingIndicator = " + sortingIndicator);

        wait.until(ExpectedConditions.visibilityOf(filesPage.summary));

        actions.moveToElement(filesPage.summary).perform();


        if (sortingIndicator.endsWith("-n")) {// -n  indicate it is ascending  else descending
            for (WebElement webElement : filesPage.foldersNameList) {
                expectedFoldersNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            Collections.sort(expectedFoldersNameList);
            for (WebElement webElement : filesPage.filesNameList) {
                expectedFilesNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            Collections.sort(expectedFilesNameList);
            expectedFoldersNameList.addAll(expectedFilesNameList);

            expectedFullFilesAndFoldersTogether = expectedFoldersNameList;


        } else {
            for (WebElement webElement : filesPage.filesNameList) {
                expectedFilesNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            Collections.reverse(expectedFilesNameList.stream().sorted().collect(Collectors.toList()));

            for (WebElement webElement : filesPage.foldersNameList) {
                expectedFoldersNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            Collections.reverse(expectedFoldersNameList.stream().sorted().collect(Collectors.toList()));
            expectedFilesNameList.addAll(expectedFoldersNameList);
            expectedFullFilesAndFoldersTogether=expectedFilesNameList;
        }

        for (WebElement webElement : filesPage.filesAndFoldersNameList) {
            ActualNamesList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
        }
        System.out.println("ActualNamesList = " + ActualNamesList);
        System.out.println("expectedFullFilesAndFoldersTogether = " + expectedFullFilesAndFoldersTogether);
        Assert.assertEquals(ActualNamesList,expectedFullFilesAndFoldersTogether);


    }
}
