package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.VerifyUsersPage;

public class ExecuteVerifyUsersPage extends BaseClass{

	LoginPage lp;
	VerifyUsersPage vup;

	@Test(priority = 1,groups = {"functional"})
	public void verifyListUsersPageIsDisplayedWhileClickingOnVerifyUsers() throws IOException 
	{ 
		lp = new LoginPage(driver);
		vup =new VerifyUsersPage(driver);
		lp.enterUserName(vup.readUserName(0, 1));
		lp.enterPassword(vup.readPassword(1, 1));
		lp.clickOnLogin();
		vup.clickOnverifyUsers();

		boolean text = vup.isListUsersTextdisplayedOrNot();
		Assert.assertTrue(text);

	}

	@Test(priority = 2,groups = {"search"})
	public void verifyTheUserCanSearchAUserByUsingName() throws IOException
	{
		lp= new LoginPage(driver);
		vup =new VerifyUsersPage(driver);
		lp.enterUserName(vup.readUserName(0, 1));
		lp.enterPassword(vup.readPassword(1, 1));
		lp.clickOnLogin();
		vup.clickOnverifyUsers();
		vup.clickOnSearchButton();
		vup.typeName("Roshan John");
		vup.clickOnNewSearchButton();
		vup.scrollToName();

		String expectedName = "Roshan John";
		String actualName = vup.getRoshanJohnNameText();
		Assert.assertEquals(actualName, expectedName);

	}

	@Test(priority = 3,groups = {"search"})
	public void verifyUserCanSearchAUserByUsingPhoneNumber() throws IOException
	{
		lp= new LoginPage(driver);
		vup =new VerifyUsersPage(driver);
		lp.enterUserName(vup.readUserName(0, 1));
		lp.enterPassword(vup.readPassword(1, 1));
		lp.clickOnLogin();
		vup.clickOnverifyUsers();
		vup.clickOnSearchButton();
		vup.typePhoneNumber("8589063132");
		vup.clickOnNewSearchButton();
		vup.scrollToAniNameText();

		String expectedNameText = "Ani P";
		String actualNameText = vup.getAniName();
		Assert.assertEquals(actualNameText,expectedNameText);
	}
}
