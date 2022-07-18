package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {


    @FindBy(xpath="//button[@class='button primary new-event']")
    public WebElement NewEventButton;

    @FindBy(xpath="//button[@class='icon action-item__menutoggle icon-view-module']")
    public WebElement ActionItemButton;

    @FindBy(xpath="(//ul[@id='menu-moilt']//button)[1]")
    public WebElement DailyActionButton;

    @FindBy(xpath="(//ul[@id='menu-moilt']//button)[2]")
    public WebElement WeeklyActionButton;

    @FindBy(xpath="(//ul[@id='menu-moilt']//button)[3]")
    public WebElement MonthlyActionButton;






    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
