package webpages;

import omelet.common.ExpectedConditionExtended;
import omelet.data.IProperty;
import omelet.driver.DriverUtility;
import omelet.exception.FrameworkException;
import omelet.testng.support.SAssert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.DataEnum;


public class LoginPage {
	
	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();
	

	@FindBy (xpath= "//*[@id='ap_email']")
	private WebElement txtEmailOrMobileNum;

	@FindBy (xpath= "//*[@id='ap_password']")
	private WebElement txtPassword;
	
	@FindBy (xpath= "//*[@id='signInSubmit']")
	private WebElement btnLogin;
	
	
	public LoginPage(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
		
	
	
	public LoginPage isLoaded(){
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(btnLogin), driver, 30)){
			throw new FrameworkException("Not able to load Amazon Login page in 30 seconds");
		}
		return this;
	}
	
		
	public boolean loginUser() throws InterruptedException{
		txtEmailOrMobileNum.sendKeys(prop.getValue(DataEnum.Amazon_emailid));
		txtPassword.sendKeys(prop.getValue(DataEnum.Amazon_password));
		btnLogin.click();
		sa.assertTrue(true, "Login as UserId: "+prop.getValue(DataEnum.Amazon_emailid)+", Password: "+prop.getValue(DataEnum.Amazon_password));	
		return true;
	}
}
