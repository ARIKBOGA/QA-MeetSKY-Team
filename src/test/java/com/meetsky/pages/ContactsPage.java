package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage extends BasePage{

    @FindBy(xpath = "//section[1]//h3//div[2]")
    public List<WebElement> presentInputs;

    @FindBy(xpath = "//input[@placeholder='Choose property type']")
    public WebElement propertiesMenuLink;

    //use title attribute to get the value
    @FindBy(xpath = "//span[contains(text(),'Choose property type')]/../..//li//div")
    public List<WebElement> propertiesToBeSelected;

    public ContactsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}