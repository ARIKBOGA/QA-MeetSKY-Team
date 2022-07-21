package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends BasePage{


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

    @FindBy(xpath="//div[@class='fc-timegrid fc-timeGridDay-view fc-view']")
    public WebElement DailyCalendarView;

    @FindBy(xpath="//div[@class='fc-timegrid fc-timeGridWeek-view fc-view']")
    public WebElement WeeklyCalendarView;

    @FindBy(xpath="//div[@class='fc-daygrid fc-dayGridMonth-view fc-view']")
    public WebElement MonthlyCalendarView;







    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
