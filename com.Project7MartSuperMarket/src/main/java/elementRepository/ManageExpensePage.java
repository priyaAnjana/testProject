package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;

public class ManageExpensePage {
	WebDriver driver;

	GeneralUtilities gl = new GeneralUtilities();

	public ManageExpensePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}

	@FindBy(xpath = "(//i[@class='fas fa-angle-left right'])[1]")
	WebElement manageExpense;

	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement expenseCategory;

	@FindBy(xpath = "//h1[text()='Expense Category']")
	WebElement expenseCategorytext;

	@FindBy(xpath = "//*[text()=' New']")
	WebElement newButton;

	@FindBy(id = "name")
	WebElement title;

	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement searchTitle;

	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[1]")
	WebElement newSearchButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	WebElement searchMobilePhone;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editIcon;

	@FindBy(id = "name")
	WebElement editTitle;

	@FindBy(name = "Update")
	WebElement updateButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlertMsg;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deletealertMsg;



	public void clickOnManageExpense()
	{
		gl.clickElement(manageExpense);
	}

	public void clickOnExpenseCategory()
	{
		gl.clickElement(expenseCategory);
	}

	public boolean getTextExpenseCatogory()
	{
		return gl.isDisplayedMethod(expenseCategorytext);
	}

	public void clickOnNewButton()
	{
		gl.clickElement(newButton);
	}

	public void sendKeysTitle(String text)
	{
		gl.TextType(title, text);
	}

	public void clickOnSaveButton()
	{
		gl.clickElement(saveButton);
	}

	public boolean isAlerttextDisplayed()
	{
		return gl.isDisplayedMethod(alertText);
	}

	public void clickOnSearchButton()
	{
		gl.clickElement(searchButton);
	}

	public void typeSearchTitle (String text)
	{
		gl.TextType(searchTitle, text);
	}

	public void clickOnNewSearchButton()
	{
		gl.clickElement(newSearchButton);
	}

	public String getTextMobilePhone()
	{
		return gl.getTextMethod(searchMobilePhone);
	}

	public void ClickOnEditIcon()
	{
		gl.clickElement(editIcon);
	}

	public void clearEdittitle()
	{
		gl.clearElement(editTitle);
	}

	public void editTitle(String text) 
	{
		gl.TextType(editTitle, text);
	}

	public void clickOnUpdateButton() 
	{
		gl.clickElement(updateButton);
	}

	public boolean isUpdateAlertMsgDisplayed()
	{
		return gl.isDisplayedMethod(updateAlertMsg);
	}

	public void clickOnDeleteButton()
	{
		gl.clickElement(deleteButton);
	}

	public void acceptAlertMsg()
	{
		gl.acceptAlertMsg(driver);
	}

	public boolean isdeleteAlertMsgDisplayedOrNot()
	{
		return gl.isDisplayedMethod(deletealertMsg);
	}
}
