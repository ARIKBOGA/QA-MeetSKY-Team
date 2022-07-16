package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Create contact')]")
    public WebElement createContactButton;

    @FindBy(xpath ="//div[@class='action-item header-menu']//button")
    public WebElement threeDotsMenuButton;

    @FindBy(xpath = "//button[@class='icon action-item__menutoggle icon-picture-force-white']")
    public WebElement changePictureButton;

    @FindBy(xpath = "//div[@class='contact-header-avatar__photo']")
    public WebElement profilePicture;

    @FindBy(id = "contact-fullname")
    public WebElement newContactFullnameInput;

    @FindBy(id = "contact-org")
    public WebElement companyInput;

    @FindBy(id = "contact-title")
    public WebElement titleInput;

    @FindBy(xpath = "//section[1]//h3//div[2]")
    public List<WebElement> presentInputs;

    @FindBy(xpath = "//input[@placeholder='Choose property type']")
    public WebElement propertiesMenuLink;

    //use title attribute to get the value
    @FindBy(xpath = "//span[contains(text(),'Choose property type')]/../..//li//div")
    public List<WebElement> propertiesToBeSelected;

    @FindBy(xpath = "//div[contains(text(),'Post office box')]/following-sibling::input")
    public WebElement postOfficeBoxInput;

    @FindBy(xpath = "//div[contains(text(),'Address')]/following-sibling::input")
    public WebElement addressInput;

    @FindBy(xpath = "//div[contains(text(),'Extended address')]/following-sibling::input")
    public WebElement extendedAddressInput;

    @FindBy(xpath = "//div[contains(text(),'Postal code')]/following-sibling::input")
    public WebElement postalCodeInput;

    @FindBy(xpath = "//div[contains(text(),'City')]/following-sibling::input")
    public WebElement cityInput;

    @FindBy(xpath = "//div[contains(text(),'State or province')]/following-sibling::input")
    public WebElement stateOrProvinceInput;

    @FindBy(xpath = "//div[contains(text(),'Country')]/following-sibling::input")
    public WebElement countryInput;

    @FindBy(xpath = "//div[contains(text(),'Nickname')]/../following-sibling::div//input")
    public WebElement nicknameInput;

    @FindBy(xpath = "//div[contains(text(),'Timezone')]/../following-sibling::div//input")
    public WebElement timezoneMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Timezone')]/../following-sibling::div//li//div")
    public List<WebElement> timezoneOptions; // use getAttribute("title")

    @FindBy(xpath = "(//div[contains(text(),'Social network')]/../following-sibling::div//input)[2]")
    public WebElement socialNetworkInput;

    @FindBy(xpath = "//div[contains(text(),'Spoken languages')]/../following-sibling::div//input")
    public WebElement spokenLanguagesMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Spoken languages')]/../following-sibling::div//li//div")
    public List<WebElement> spokenLanguagesOptions; // use getAttribute("title")

    @FindBy(xpath = "(//div[contains(text(),'Phone')]/../..//input)[1]")
    public WebElement phoneTypeMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Phone')]/../..//div[@class='name-parts']")
    public WebElement phoneTypeOptions;

    @FindBy(xpath = "(//div[contains(text(),'Phone')]/../following-sibling::div//input)[2]")
    public WebElement phoneInput;

    @FindBy(xpath = "(//div[contains(text(),'Email')]/../following-sibling::div//input)[2]")
    public WebElement emailInput;

    @FindBy(xpath = "//div[contains(text(),'Location')]/../following-sibling::div//input")
    public WebElement locationInput;

    @FindBy(xpath = "(//div[contains(text(),'Instant messaging')]/../following-sibling::div//input)[2]")
    public WebElement instantMessagingInput;

    @FindBy(xpath = "(//div[contains(text(),'Federated Cloud ID')]/../following-sibling::div//input)[2]")
    public WebElement federatedCloudIDInput;

    @FindBy(xpath = "//div[contains(text(),'Anniversary')]/../following-sibling::div//input")
    public WebElement anniversaryDateInput; // "Mmm d, yyyy" format (Mmm in letters)

    @FindBy(xpath = "//div[contains(text(),'Birthday')]/../following-sibling::div//input")
    public WebElement birthdayDateInput; // "Mmm d, yyyy" format (Mmm in letters)

    @FindBy(xpath = "//div[contains(text(),'Date of death')]/../following-sibling::div//input")
    public WebElement dateOfDeathInput;  // "Mmm d, yyyy" format (Mmm in letters)

    @FindBy(xpath = "//div[contains(text(),'Website')]/../following-sibling::div//input")
    public WebElement websiteInput;

    @FindBy(xpath = "(//div[contains(text(),'Related contacts')]/../following-sibling::div//input)[2]")
    public WebElement relatedContactsInput;

    @FindBy(xpath = "//div[contains(text(),'Relationship to you')]/../following-sibling::div//input")
    public WebElement relationshipToYouMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Relationship to you')]/../following-sibling::div//li//div")
    public List<WebElement> relationshipToYouOptions; // use getAttribute("title")

    @FindBy(xpath = "//div[contains(text(),'Gender')]/..//input")
    public WebElement genderMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Gender')]/..//li//div")
    public List<WebElement> genderOptions; // use getAttribute("title")

    @FindBy(id = "textarea")
    public WebElement notesTextArea;

    @FindBy(xpath = "//div[contains(text(),'Groups')]/..//input")
    public WebElement groupsMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Groups')]/../..//div[@class='name-parts']")
    public List<WebElement> groupsOptions; // use getAttribute("title")

    @FindBy(xpath = "//div[contains(text(),'Groups')]/..//span[@class='multiselect__tag']/span")
    public List<WebElement> selectedGroups; // use getText()



    //div[contains(text(),'Timezone')]/../following-sibling::div//input

    public ContactsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}