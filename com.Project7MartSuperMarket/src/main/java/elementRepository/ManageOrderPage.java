package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExplicitWaitClass;
import utility.GeneralUtilities;

public class ManageOrderPage {
	WebDriver driver;

	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ewc= new ExplicitWaitClass();

	public ManageOrderPage(WebDriver driver)
	{
		this.driver =driver; 
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//p[text()='Manage Orders']")
	WebElement manageOrders;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement orderId;

	@FindBy(name = "Search")
	WebElement newSearchButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[1]")
	WebElement orderIdSearchresult;

	@FindBy(xpath = "//a[@class='btn btn-block btn-outline-info btn-sm']")
	WebElement viewButton;

	@FindBy(xpath = "//h1[text()='Order Details']")
	WebElement orderDetailsText;

	public void clickOnManageOrder()
	{
		gl.clickElement(manageOrders);
	}

	public void clickOnsearchbutton()
	{
		gl.clickElement(searchButton);
	}

	public void typeOrderId(String id)
	{
		gl.TextType(orderId, id);
	}

	public void clickONewSeacrchButton()
	{
		gl.clickElement(newSearchButton);
	}

	public String getTextOfOrderIdsearchresult() 
	{
		return gl.getTextMethod(orderIdSearchresult);
	}

	public void clickOnViewButton()
	{
		gl.scriptExecutorToClick(driver, viewButton);
	}

	public void scrollIntoViewElement()
	{
		gl.scrollToFindAnElement(driver, viewButton);
	}

	public boolean isOrderDeatilsDisplayed()
	{
		return gl.isDisplayedMethod(orderDetailsText);
	}

	public void elementTOBeClick()
	{
		ewc.waitElementToBEClickable(driver, viewButton);
	}
}
