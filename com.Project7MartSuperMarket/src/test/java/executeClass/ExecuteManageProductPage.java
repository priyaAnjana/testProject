package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

public class ExecuteManageProductPage extends BaseClass {
	LoginPage lp;
	ManageProductPage mpp;

	@Test(priority = 1,groups = {"functional"})
	public void verifyListOfProductPageIsDisplayedWhileClickingOnManageProduct() throws IOException 
	{
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUserName(mpp.readUserName(0, 1));
		lp.enterPassword(mpp.readPassWord(1, 1));
		lp.clickOnLogin();
		mpp.clickOnManageProduct();

		boolean text = mpp.isListProductTextDisplay();
		Assert.assertTrue(text);
	}

	@Test(priority = 2,groups = {"create"})
	public void verifyUserCanAddNewProductOrNot() throws InterruptedException, IOException
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin();

		mpp = new ManageProductPage(driver);
		mpp.clickOnManageProduct();
		mpp.clickOnNewButton();
		mpp.typeTile(mpp.readProductName(2, 1));
		mpp.clickOnRadioButtonOthers();
		mpp.clickOncategoryDropDown();
		mpp.dropdownSelectByIndexCategory();
		mpp.waitSleep();
		mpp.ClickOnSubCategory();
		mpp.dropDownSelectByValueSubCategory();
		mpp.clickOnPriceType();
		mpp.dropDownSelectByIndexMinimumPiece();
		mpp.typeMaximumQuantityCanOrder();
		mpp.scrollToElement();
		mpp.typePrice("200");
		mpp.typeStockAvailability("10");
		mpp.clickOnImage();
		mpp.uploadImage();
		mpp.presenceOfElementLocated();
		mpp.clickOnSaveButton();

		boolean alertText = mpp.isSuccessfulSavealertDisplayed();
		Assert.assertTrue(alertText);
	}

	@Test(priority = 3,groups = {"search"})
	public void verifyUserCanSearchAProductByUsingProductCode()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin();

		mpp = new ManageProductPage(driver);
		mpp.clickOnManageProduct();
		mpp.clickOnSearchButton();
		mpp.typeProductCode("848");
		mpp.clickOnNewSearchButton();


		String expectedText = "Elite Cup Cake P848 Combo";
		String actualText = mpp.getTextEliteCakeText();
		Assert.assertEquals(actualText,expectedText);
	}

	@Test(priority = 4,groups = {"delete"})
	public void verifyTheUserCanDeleteTheCreatedProductOrNot()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin();

		mpp = new ManageProductPage(driver);
		mpp.clickOnManageProduct();
		mpp.clickOnSearchButton();
		mpp.typeProductTitle("Almond Gold");
		mpp.clickOnNewSearchButton();
		mpp.clickOnAlmondDeleteButton();
		mpp.acceptDeleteAlmondAlert();

		boolean alertText = mpp.isDeleteAlmondAlertTextDisplayed();
		Assert.assertTrue(alertText);
	}

	@Test(priority = 5,groups = {"functional"})
	public void verifyTheReSetButtonIsWorkingFineOrNot() throws IOException 
	{
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUserName(mpp.readUserName(0, 1));
		lp.enterPassword(mpp.readPassWord(1, 1));
		lp.clickOnLogin();
		mpp.clickOnManageProduct();
		mpp.clickOnSearchButton();
		mpp.typeProductCode("848");
		mpp.clickOnNewSearchButton();
		mpp.clickOnResetButton();

		boolean text = mpp.isResetSearchListProduct();
		Assert.assertFalse(text);

	}
	@Test(priority = 6,groups = {"navigate"})
	public void verifyTheUserCanNavigateToTheLastPageByClickingOnLastButton() throws IOException, InterruptedException
	{
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUserName(mpp.readUserName(0, 1));
		lp.enterPassword(mpp.readPassWord(1, 1));
		lp.clickOnLogin();
		mpp.clickOnManageProduct();
		mpp.scrollinToThePaginationLastButton();
		mpp.waitSleep();
		mpp.clickOnPaginationLastButton();
		mpp.scrollToBeetRoort();

		String expectedLastItem = "P4";
		String actualLastItem =mpp.beetRootLastItemOfTable();
		Assert.assertEquals(actualLastItem,expectedLastItem);
	}



}
