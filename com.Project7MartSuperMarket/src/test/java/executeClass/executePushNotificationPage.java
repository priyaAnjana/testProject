package executeClass;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.PushNotificationPage;

public class executePushNotificationPage extends BaseClass {

	LoginPage lp;
	PushNotificationPage pnp;

	@Test(priority = 1,groups = {"functional"})
	public void verifyPushNotificationPageIsDisplayedWhileClickingOnPushNotification() throws IOException 
	{
		lp = new LoginPage(driver);
		pnp = new PushNotificationPage(driver);

		lp.enterUserName(pnp.readUserName(0, 1));
		lp.enterPassword(pnp.readPassWord(1, 1));
		lp.clickOnLogin();
		pnp.clickOnPushNotification();

		boolean text = pnp.isPushNotificationtextDisplayed();
		Assert.assertTrue(text);
	}

	@Test(priority = 2,groups = {"send"})
	public void verifyTheAdminCanSendANotificationSuccessfullyOrNot() throws IOException
	{
		lp = new LoginPage(driver);
		pnp = new PushNotificationPage(driver);

		lp.enterUserName(pnp.readUserName(0, 1));
		lp.enterPassword(pnp.readPassWord(1, 1));
		lp.clickOnLogin();
		pnp.clickOnPushNotification(); 
		pnp.typeNotificationTitle("Alert Message");
		pnp.typeDescription("Successfully Completed Your Activity");
		pnp.clickOnSendButton();

		boolean alertText = pnp.isAlertTextDisplayed();
		Assert.assertTrue(alertText);
	}

	@Test(priority =3,groups = {"functional"})
	public void verifyTheResetButtonIsVisibleOrNot() throws IOException
	{
		lp = new LoginPage(driver);
		pnp = new PushNotificationPage(driver);

		lp.enterUserName(pnp.readUserName(0, 1));
		lp.enterPassword(pnp.readPassWord(1, 1));
		lp.clickOnLogin();
		pnp.clickOnPushNotification(); 

		boolean resetButton = pnp.IsResetButtonVisible();
		Assert.assertTrue(resetButton);
	}
}
