package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.DashBoardPage;
import elementRepository.LoginPage;

public class ExecuteDashBoardPage extends BaseClass {

	DashBoardPage db;
	LoginPage lp;

	@Test(priority =1,groups  ={"functional"})
	public void dashBoardIsVisibleAfterSuccessfulLogin() throws IOException 
	{
		lp= new LoginPage(driver);
		db = new DashBoardPage(driver);
		lp.enterUserName(db.readUserName(0, 1));
		lp.enterPassword(db.readPassWord(1, 1));
		lp.clickOnLogin();

		String actualDashBoardText = "Dashboard";
		String expectedDashBoardText = db.getTextDashBoard();
		Assert.assertEquals(actualDashBoardText, expectedDashBoardText);
	}

	@Test(priority =2,groups  ={"functional"})
	public void isManagePageTileVisibleOrNot()
	{
		lp= new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin();
		db = new DashBoardPage(driver);
		boolean tile = db.getManagePageTile();
		Assert.assertTrue(tile);
	}

	@Test(priority = 3,groups  ={"functional"})
	public void manageUsersMoreInfoArrowClicableOrNot()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin();
		db = new DashBoardPage(driver);
		db.clickOnMoreInfo();

		String expectedText = "List Users";
		String actualText = db.getListUsersText();
		Assert.assertEquals(actualText, expectedText);
	}
}
