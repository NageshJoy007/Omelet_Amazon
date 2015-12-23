package webpages;

import omelet.common.ExpectedConditionExtended;
import omelet.data.IProperty;
import omelet.driver.DriverUtility;
import omelet.exception.FrameworkException;
import omelet.testng.support.SAssert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.DataEnum;


public class UserWelcomePage {
	
	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();
	

	@FindBy (xpath= "//*[@id='nav-link-yourAccount']/span[1]")
	private WebElement linkHello;


	
	public UserWelcomePage(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
		
	
	
	public UserWelcomePage isLoaded(){
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(linkHello), driver, 30)){
			throw new FrameworkException("Not able to load Amazon UserWelcome page in 30 seconds");
		}
		return this;
	}
	
		
	public boolean verifyLogin(){
	
	if(null != DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(linkHello), driver, 30)){
		if(linkHello.getText().toLowerCase().contains(prop.getValue(DataEnum.Amazon_userfirstname).toLowerCase())){
			sa.assertTrue(true, "Verify login by searching user first name");
			return true;
		}	
	}
	sa.assertTrue(false, "Verify login by searching user first name");		
	return false;
	
	}
	
	
	
	
	
}
