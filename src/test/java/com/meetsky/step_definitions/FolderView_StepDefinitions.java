package com.meetsky.step_definitions;

import com.meetsky.pages.FilesPage;
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

public class FolderView_StepDefinitions {
    List<Integer> SizeListBeforeClick = new ArrayList<>();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
    Actions actions = new Actions(Driver.getDriver());

    FilesPage filesPage = new FilesPage();

    @Given("User clicks Name link")
    public void user_clicks_name_link() {

        filesPage.nameText.click();


    }


    @Then("User sees Files and Folders in an order according to their Names")
    public void userSeesFilesAndFoldersInAnOrderAccordingToTheirNames() {
        List<String> expectedFoldersNameList = new ArrayList<>();
        List<String> expectedFilesNameList = new ArrayList<>();
        List<String> expectedList;
        List<String> ActualNamesList = new ArrayList<>();
        String sortingIndicator = filesPage.sortingTick.getAttribute("class");
        System.out.println("sortingIndicator = " + sortingIndicator);

        wait.until(ExpectedConditions.visibilityOf(filesPage.summary));

        actions.moveToElement(filesPage.summary).perform();


        if (sortingIndicator.endsWith("-n")) {// -n  indicates it is ascending , else descending
            for (WebElement webElement : filesPage.foldersNameList) {
                expectedFoldersNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            Collections.sort(expectedFoldersNameList);
            for (WebElement webElement : filesPage.filesNameList) {
                expectedFilesNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            Collections.sort(expectedFilesNameList);
            expectedFoldersNameList.addAll(expectedFilesNameList);

            expectedList = expectedFoldersNameList;


        } else {
            for (WebElement webElement : filesPage.filesNameList) {
                expectedFilesNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            Collections.reverse(expectedFilesNameList.stream().sorted().collect(Collectors.toList()));

            for (WebElement webElement : filesPage.foldersNameList) {
                expectedFoldersNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            expectedFoldersNameList= expectedFoldersNameList.stream().sorted().collect(Collectors.toList());
            Collections.reverse(expectedFoldersNameList);
            expectedFilesNameList.addAll(expectedFoldersNameList);
            expectedList = expectedFilesNameList;
        }

        for (WebElement webElement : filesPage.filesAndFoldersNameList) {
            ActualNamesList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
        }
        System.out.println("ActualNamesList = " + ActualNamesList);
        System.out.println("expectedFullFilesAndFoldersTogether = " + expectedList);
        Assert.assertEquals(ActualNamesList, expectedList);


    }

    @Given("User clicks Size link")
    public void userClicksSizeLink() {

        wait.until(ExpectedConditions.visibilityOf(filesPage.summary));

        actions.moveToElement(filesPage.summary).perform();
        for (WebElement webElement : filesPage.sizeList) {
            SizeListBeforeClick.add(Integer.valueOf(webElement.getText().replaceAll("[^0-9]", "")));
        }
        System.out.println("SizeListBeforeClick = " + SizeListBeforeClick);
        filesPage.sizeText.click();
    }

    @Then("User sees Files and Folders in an order according to their Size")
    public void userSeesFilesAndFoldersInAnOrderAccordingToTheirSize() {
        wait.until(ExpectedConditions.visibilityOf(filesPage.summary));

        actions.moveToElement(filesPage.summary).perform();

        String sortingIndicator = filesPage.sortingTick.getAttribute("class");
        System.out.println("sortingIndicator = " + sortingIndicator);

        List<Integer> sizeListAfterClick = new ArrayList<>();
        for (WebElement webElement : filesPage.sizeList) {
           sizeListAfterClick.add(Integer.valueOf(webElement.getText().replaceAll("[^0-9]", ""))) ;
        }

        if (sortingIndicator.endsWith("-n")) {
           Collections.sort(SizeListBeforeClick);

            System.out.println("SizeListBeforeClick = " + SizeListBeforeClick);
            System.out.println("sizeListAfterClick = " + sizeListAfterClick);
            Assert.assertEquals(SizeListBeforeClick,sizeListAfterClick);

        } else {
          SizeListBeforeClick = SizeListBeforeClick.stream().sorted().collect(Collectors.toList());
            Collections.reverse(SizeListBeforeClick);

            System.out.println("SizeListBeforeClick = " + SizeListBeforeClick);
            System.out.println("sizeListAfterClick = " + sizeListAfterClick);

            Assert.assertEquals(SizeListBeforeClick,sizeListAfterClick);
        }


    }
}
