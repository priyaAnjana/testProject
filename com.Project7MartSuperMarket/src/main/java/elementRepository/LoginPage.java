package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();

	@FindBy(xpath="(//input[@class='form-control'])[1]")
	WebElement userName;

	@FindBy(name="password")
	WebElement passWord;

	@FindBy(xpath="//button[text()='Sign In']")
	WebElement loginButton;

	@FindBy(xpath="//label[@for='remember']")
	WebElement rememberMeCheckBox;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMsg;

	@FindBy(xpath="(//a[@class='nav-link'])[2]")
	WebElement actualUserName;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void enterUserName(String uName)
	{
		gl.TextType(userName, uName);
	}

	public void enterPassword(String pass)
	{
		gl.TextType(passWord, pass);
	}

	public void clickOnLogin()
	{
		gl.clickElement(loginButton);
	}

	public boolean isrememberMeSelected()
	{
		return	gl.isSelectedMethod(rememberMeCheckBox);
	}

	public String getUrlOftheLogin()
	{
		return gl.getcurrentUrl(driver);
	}

	public boolean isalertmsgDisplayed()

	{
		return gl.isDisplayedMethod(alertMsg);
	}

	public String getactualUser()
	{
		return gl.getTextMethod(actualUserName);
	}

}
