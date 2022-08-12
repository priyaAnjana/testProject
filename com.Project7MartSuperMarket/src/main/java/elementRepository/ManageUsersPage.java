package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelReadClass;
import utility.GeneralUtilities;

public class ManageUsersPage {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExcelReadClass erc =new ExcelReadClass();

	public ManageUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public String readUserName(int r,int c) throws IOException
	{
		return erc.readStringData(r, c);
	}

	public String readPassword(int r,int c) throws IOException
	{
		return erc.readStringData(r, c);
	}

	@FindBy(xpath = "//p[text()='Manage Users']")
	WebElement manageUsers;

	@FindBy(xpath = "//h1[text()='List Users']")
	WebElement listUsersText;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//input[@id='un']")
	WebElement typeName;

	@FindBy(name = "Search")
	WebElement newSearchButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	WebElement alenName;

	@FindBy(xpath = "//input[@id='ut']")
	WebElement emailId;

	@FindBy(xpath = "(//a[@class='btn btn-sm btn-danger btn-rounded'])[2]")
	WebElement status;

	@FindBy(xpath = "(//li[@class='page-item'])[1]")
	WebElement paginationTwo;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement statusChangeAlert;

	public void clickOnManageUsers()
	{
		gl.clickElement(manageUsers);
	}

	public boolean IsListUserstextIsdispalyed()
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

	public void scrollToAllenName()
	{
		gl.scrollToFindAnElement(driver, alenName);
	}

	public String alenNameText()
	{
		return gl.getTextMethod(alenName);
	}

	public void typeEmailId(String id)
	{
		gl.TextType(emailId, id);
	}

	public void scrollInToSoftWareTesterStatus()
	{
		gl.scrollToFindAnElement(driver, status);
	}

	public void clickOnSofteWareTesterStatus()
	{
		gl.scriptExecutorToClick(driver, status);
	}

	public void scrolltoPaginationTwo()
	{
		gl.scrollToFindAnElement(driver, paginationTwo);
	}

	public void clickOnPaginationTwo()

	{
		gl.scriptExecutorToClick(driver, paginationTwo);
	}

	public boolean IsStatusChangeAlertDispalyed()
	{
		return gl.isDisplayedMethod(statusChangeAlert);
	}

}
