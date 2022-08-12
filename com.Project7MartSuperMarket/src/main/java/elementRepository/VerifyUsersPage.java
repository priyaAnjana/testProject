package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelReadClass;
import utility.GeneralUtilities;

public class VerifyUsersPage {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExcelReadClass erc= new ExcelReadClass();

	public VerifyUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//*[text()='Verify Users']")
	WebElement verifyUsers;

	@FindBy(xpath = "//h1[text()='List Users']")
	WebElement listUsersText;

	@FindBy(xpath = "//*[text()=' Search']")
	WebElement searchButton;

	@FindBy(xpath = "//input[@id='un']")
	WebElement typeName;

	@FindBy(name= "Search")
	WebElement newSearchButton;

	@FindBy(xpath ="//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	WebElement roshanJohnNameText;

	@FindBy(xpath = "//input[@id='ph']")
	WebElement phoneNumberfield;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	WebElement anipNameText;

	public void clickOnverifyUsers()
	{
		gl.clickElement(verifyUsers);
	}

	public String readUserName(int r,int c) throws IOException
	{
		return erc.readStringData(r, c);
	}

	public String readPassword(int r,int c) throws IOException
	{
		return erc.readStringData(r, c) ;
	}

	public boolean isListUsersTextdisplayedOrNot()
	{
		return gl.isDisplayedMethod(listUsersText);
	}

	public void clickOnSearchButton()
	{
		gl.clickElement(searchButton); 
	}

	public void typeName(String name)
	{
		gl.TextType(typeName, name);
	}

	public void clickOnNewSearchButton()
	{
		gl.clickElement(newSearchButton);
	}

	public String getRoshanJohnNameText()
	{
		return gl.getTextMethod(roshanJohnNameText);
	}

	public void scrollToName()
	{
		gl.scrollToFindAnElement(driver, roshanJohnNameText);
	}

	public void typePhoneNumber(String number)
	{
		gl.TextType(phoneNumberfield, number);
	}

	public void scrollToAniNameText()
	{
		gl.scrollToFindAnElement(driver,anipNameText);
	}

	public String getAniName()
	{
		return gl.getTextMethod(anipNameText);
	}

}
