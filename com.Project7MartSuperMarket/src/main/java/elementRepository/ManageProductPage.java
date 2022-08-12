package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelReadClass;
import utility.ExplicitWaitClass;
import utility.GeneralUtilities;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ewc =new ExplicitWaitClass();
	ExcelReadClass erc = new ExcelReadClass();

	public ManageProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//p[text()='Manage Product']")
	WebElement ManageProduct;

	@FindBy(xpath = "//h1[text()='List Products']")
	WebElement listProductText;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(id = "title")
	WebElement title;

	@FindBy(xpath = "//*[text()=' Others']")
	WebElement radioButtonOthers;

	@FindBy(id = "cat_id")
	WebElement category;

	@FindBy(xpath = "(//select[@class='form-control selectpicker'])[2]")
	WebElement subCategory;

	@FindBy(id = "purpose1")
	WebElement priceType;

	@FindBy(id = "p_minimum")
	WebElement minimumPiece;

	@FindBy(id = "p_max")
	WebElement maximumQuanityCanOrder;

	@FindBy(id ="p_price")
	WebElement price;

	@FindBy(id = "p_stock")
	WebElement stockAvailability;

	@FindBy(id ="main_img")
	WebElement image;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successfulSaveAlert;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//input[@name='un']")
	WebElement productTitle;
	@FindBy(xpath = "//input[@name='cd']")
	WebElement productCode;

	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement newSearchButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	WebElement textAlmond;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement almondDeleteButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement DeleteAmondAlertText;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[1]")
	WebElement EliteCakeText;

	@FindBy(name = "Reset")
	WebElement resetButton;

	@FindBy(xpath = "//h4[text()='Search List Products']")
	WebElement resetSearchListProductText;

	@FindBy(xpath = "(//a[@class='page-link'])[37]")
	WebElement paginationLastButton;

	@FindBy(xpath = "//button[text()='P4']")
	WebElement beetrootLastItemOfTable;

	public void clickOnManageProduct()
	{
		gl.clickElement(ManageProduct);
	}

	public boolean isListProductTextDisplay()
	{
		return gl.isDisplayedMethod(listProductText);
	}

	public void clickOnNewButton()
	{
		gl.clickElement(newButton);
	}

	public void typeTile(String text)
	{
		gl.TextType(title, text);
	}

	public void clickOnRadioButtonOthers() 
	{
		gl.clickElement(radioButtonOthers);
	}

	public void clickOncategoryDropDown()
	{
		gl.clickElement(category);
	}

	public void dropdownSelectByIndexCategory() 
	{
		gl.selectByIndexDorpDown(category, 4);
	}

	public void ClickOnSubCategory()
	{
		gl.scriptExecutorToClick(driver, subCategory);
	}

	public void dropDownSelectByValueSubCategory()
	{
		gl.selectByValueDorpDown(subCategory, "46");
	}

	public void clickOnPriceType()
	{
		gl.clickElement(priceType);
	}

	public void dropDownSelectByIndexMinimumPiece()
	{
		gl.selectByIndexDorpDown(minimumPiece, 3);
	}

	public void typeMaximumQuantityCanOrder()
	{
		gl.TextType(maximumQuanityCanOrder, "3");
	}

	public void scrollToElement()
	{
		gl.scrollToFindAnElement(driver, price);
	}

	public void typePrice(String pp)
	{
		gl.TextType(price, pp);
	}

	public void typeStockAvailability(String stock)
	{
		gl.TextType(stockAvailability, stock);
	}

	public void clickOnImage()
	{
		gl.scriptExecutorToClick(driver, image);
	}

	public void uploadImage()
	{
		gl.TextType(image, "C:\\Users\\JITHIN NAIR\\git\\project\\com.grocery7MartApp\\src\\main\\resources\\Almond.jpg");
	}

	public void clickOnSaveButton()
	{
		gl.scriptExecutorToClick(driver, saveButton);
	}

	public boolean isSuccessfulSavealertDisplayed()
	{
		return gl.isDisplayedMethod(successfulSaveAlert);
	}

	public void clickOnSearchButton()
	{
		gl.clickElement(searchButton);
	}

	public void typeProductTitle(String title)
	{
		gl.TextType(productTitle, title);
	}

	public void clickOnNewSearchButton()
	{
		gl.clickElement(newSearchButton);
	}

	public String getAlmondText()
	{
		return gl.getTextMethod(textAlmond);
	}

	public void clickOnAlmondDeleteButton()
	{
		gl.scriptExecutorToClick(driver,almondDeleteButton);
	}

	public void acceptDeleteAlmondAlert()
	{
		gl.acceptAlertMsg(driver);
	}

	public boolean isDeleteAlmondAlertTextDisplayed()
	{
		return gl.isDisplayedMethod(DeleteAmondAlertText);
	}

	public String getTextEliteCakeText()
	{
		return gl.getTextMethod(EliteCakeText);
	}
	public void typeProductCode(String code)
	{
		gl.TextType(productCode, code);
	}
	public void waitSleep() throws InterruptedException
	{
		gl.addThredSleep();
	}

	public void presenceOfElementLocated()
	{
		ewc.waitPresenceOfElementLocated(driver,"//button[@class='btn btn-danger']");
	}

	public String readProductName(int r,int c) throws IOException
	{
		return erc.readStringData(r, c);
	}

	public String readUserName(int r,int c) throws IOException
	{
		return erc.readStringData(r, c);
	}

	public String readPassWord(int r,int c) throws IOException
	{
		return erc.readStringData(r, c);
	}

	public void clickOnResetButton() 
	{
		gl.clickElement(resetButton);
	}

	public boolean isResetSearchListProduct()
	{
		return gl.isDisplayedMethod(resetSearchListProductText);
	}

	public void scrollinToThePaginationLastButton()
	{
		gl.scrollToFindAnElement(driver, paginationLastButton);
	}

	public void clickOnPaginationLastButton()
	{
		gl.scriptExecutorToClick(driver, paginationLastButton);
	}

	public String beetRootLastItemOfTable()
	{
		return gl.getTextMethod(beetrootLastItemOfTable);
	}

	public void scrollToBeetRoort()
	{
		gl.scrollToFindAnElement(driver, beetrootLastItemOfTable);
	}
}
