package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {
    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[contains(@class,\"sort-indicator icon-triangle-s\")]")
    public WebElement ascendingSortingTick;
    @FindBy(xpath = "//span[contains(@class,\"sort-indicator icon-triangle-n\")]")
    public WebElement descendingSortingTick;

    @FindBy(xpath = "//span[contains(@class,\"sort-indicator icon-triangle-\")]")
    public WebElement sortingTick;



    @FindBy(xpath = "//span[contains(@class,\"sort-indicator icon-triangle-\")]/../span")
    public WebElement sortingType;


    @FindBy(xpath = "//span[.='Name']")
    public WebElement nameText;

    @FindBy(xpath = "//a[@class=\"size sort columntitle\"]//span[.='Size']")
    public WebElement sizeText;

    @FindBy(xpath = "//th[@id=\"headerDate\"]//a//span[.='Modified']")
    public WebElement modifiedText;

    @FindBy(xpath = "//tr[@data-id and @data-type=\"file\"]")
    public List<WebElement> filesNameList;

    @FindBy(xpath = "//tr[@data-id and @data-type=\"dir\"]")
    public List<WebElement> foldersNameList;

    @FindBy(xpath = "//tr[@data-id]")
    public List<WebElement> filesAndFoldersNameList;

    @FindBy(xpath = "//td[@class=\"filesummary\"]")
    public WebElement summary;

    @FindBy(xpath = "//tr[@data-id][last()]")
    public WebElement filesAndFoldersLastItemName;






}
