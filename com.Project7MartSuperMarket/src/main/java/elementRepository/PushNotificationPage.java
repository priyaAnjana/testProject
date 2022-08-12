package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelReadClass;
import utility.GeneralUtilities;

public class PushNotificationPage {

	WebDriver driver;

	GeneralUtilities gl = new GeneralUtilities();
	ExcelReadClass erc = new ExcelReadClass();

	public PushNotificationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public String readUserName(int r,int c) throws IOException
	{
		return erc.readStringData(r, c);
	}

	public String readPassWord(int r,int c) throws IOException
	{
		return erc.readStringData(r, c);
	}

	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushNotification;
	
	@FindBy(xpath = "//h1[text()='Push Notifications']")
	WebElement pushNotificationText;
	
	@FindBy(id = "title")
	WebElement notificationTitle;
	
	@FindBy(id = "description")
	WebElement notificationDescription;
	
	@FindBy(name = "create")
	WebElement sendButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	
	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetButton;
	
	public void clickOnPushNotification()
	{
		gl.clickElement(pushNotification);
	}
	
	public boolean isPushNotificationtextDisplayed()
	{
		return gl.isDisplayedMethod(pushNotificationText);
	}
	
	public void typeNotificationTitle(String title)
	{
		gl.TextType(notificationTitle,title);
	}
	
	public void typeDescription(String description)
	{
		gl.TextType(notificationDescription, description);
	}
	
	public void clickOnSendButton()
	{
		gl.clickElement(sendButton);
	}
	
	public boolean isAlertTextDisplayed()
	{
		return gl.isDisplayedMethod(alertText);
	}
	
	public boolean IsResetButtonVisible()
	{
		return gl.isDisplayedMethod(resetButton);
	}

}
