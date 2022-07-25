package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends BasePage{

    @FindBy(xpath="//button[contains(@class,'menutoggle icon-view-')]")
    public WebElement ActionItemButton;

    @FindBy(xpath="(//ul[starts-with(@id,'menu')]//button)[1]")
    public WebElement DailyActionButton;

    @FindBy(xpath="(//ul[starts-with(@id,'menu')]//button)[2]")
    public WebElement WeeklyActionButton;

    @FindBy(xpath="(//ul[starts-with(@id,'menu')]//button)[3]")
    public WebElement MonthlyActionButton;

    @FindBy(xpath="//div[@class='fc-timegrid fc-timeGridDay-view fc-view']")
    public WebElement DailyCalendarView;

    @FindBy(xpath="//div[@class='fc-timegrid fc-timeGridWeek-view fc-view']")
    public WebElement WeeklyCalendarView;

    @FindBy(xpath="//div[@class='fc-daygrid fc-dayGridMonth-view fc-view']")
    public WebElement MonthlyCalendarView;

    @FindBy(xpath="//button[@class='button primary new-event']")
    public WebElement NewEventButton;

    @FindBy(xpath="//input[@placeholder='Event title']")
    public WebElement EventTitleInputBox;

    @FindBy(xpath="(//div[@class='property-title-time-picker']//input)[1]")
    public WebElement DateInputBox;

    @FindBy(xpath="(//div[@class='property-title-time-picker']//input)[2]")
    public WebElement DateInputBox2;

    @FindBy(xpath="//input[@id='allDay']")
    public WebElement AllDayButton;

    @FindBy(xpath="//td[@title='2022-07-30']")
    public WebElement ThirtiethDayButton;

    @FindBy(xpath="//td[@title='2022-07-31']")
    public WebElement ThirtyFirstDayButton;

    @FindBy(xpath="//td[@title='2022-08-15']")
    public WebElement DayAugustFifteenthButton;

    @FindBy(xpath="//div[@class='fc-event-title fc-sticky']")
    public WebElement createdEventTitle1;

    @FindBy(xpath="(((//table[@class='fc-scrollgrid-sync-table']/tbody/tr)[5]/td)[6]//a)")
    public WebElement ThirtiethDayLink;

    @FindBy(xpath="//div[@class='fc-event-title fc-sticky']")
    public WebElement createdEventTitle2;

    @FindBy(xpath="//a[@data-recurrence-id='1659139200']")
    public WebElement createdEventLink1;

    @FindBy(xpath="((//table[@class='fc-scrollgrid-sync-table']/tbody/tr)[3]/td)//a")
    public WebElement FifteenthDayLink;

    @FindBy(xpath="//a[@data-recurrence-id='1660561200']")
    public WebElement createdEventLink2;

    @FindBy(xpath="((//table[@class='fc-scrollgrid-sync-table']/tbody/tr)[1]/td)[7]//a")
    public WebElement FirstDayLink;

    @FindBy(xpath="//a[@data-recurrence-id='1672549200']")
    public WebElement createdEventLink3;

    @FindBy(xpath="//div[@class='fc-event-title fc-sticky']")
    public WebElement createdEventTitle3;

    @FindBy(xpath="(//button[contains(@class,'menutoggle--default-icon')])[4]")
    public WebElement eventActionItemButton;

    @FindBy(xpath="(//button[@class='primary'])[1]")
    public WebElement SaveButton;

    @FindBy(xpath="//span[@class='action-button__icon icon-delete']/..")
    public WebElement DeleteButton;

    @FindBy(xpath="//button[@title='Next month']")
    public WebElement NextMonthButton;

    @FindBy(xpath="(//div[@class='datepicker-button-section']/button)[2]")
    public WebElement DatePickerButton;


    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
