package executeClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;

public class ExecuteLoginPage extends BaseClass {

	LoginPage lp;

	@Test(priority = 1,groups  ={"functional"})
	public void verifyLoginPageIsvisibleWhileLaunchingTheApplication()
	{
		lp = new LoginPage(driver);

		String expectedUrl = "http://groceryapp.uniqassosiates.com/admin/login";
		String actualUrl = lp.getUrlOftheLogin();
		Assert.assertEquals(actualUrl,expectedUrl);
	}


	@Test(priority =3 ,dataProvider = "DataProvider1",dataProviderClass = DataProviderClass.class,groups  ={"login"} )
	public void verifysuccessfulLogin(String name, String pass)
	{
		lp = new LoginPage(driver);
		lp.enterUserName(name);
		lp.enterPassword(pass);
		lp.clickOnLogin();
		String expectedUserName = "Admin";
		String actualUserName = lp.getactualUser();
		Assert.assertEquals(expectedUserName,actualUserName);
	}

	@Test(priority =2,groups = {"functional"})
	public void isrememberMeCheckBoxSelectedOrNot()
	{
		lp = new LoginPage(driver);

		boolean checkBox = lp.isrememberMeSelected();
		Assert.assertFalse(checkBox);

	}

	@Test(priority =4, dataProvider = "DataProvider",dataProviderClass = DataProviderClass.class,groups  ={"login"})
	public void verifyUnsuccessfulLogin(String name, String pass)
	{
		lp = new LoginPage(driver);
		lp.enterUserName(name);
		lp.enterPassword(pass);
		lp.clickOnLogin();
		boolean actualalertMsg2 = lp.isalertmsgDisplayed();
		Assert.assertTrue(actualalertMsg2);
	}

}
