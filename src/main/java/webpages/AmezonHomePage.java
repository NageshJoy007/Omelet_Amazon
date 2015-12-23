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


public class AmezonHomePage {
	
	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();
	

	@FindBy (xpath= "//*[@id='twotabsearchtextbox']")
	private WebElement searchBox;

	@FindBy (xpath= "//input[@value='Go']")
	private WebElement btnGo;
	
	@FindBy (xpath= "//*[@id='nav-link-yourAccount']/span[1]")
	private WebElement linkHelloSignIn;
	
	@FindBy (xpath= "//*[@id='nav-flyout-ya-signin']/a/span")
	private WebElement btnSignIn;
	
	
	
	
	public AmezonHomePage(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
		
	
	public AmezonHomePage Accessurl(){
		driver.get(prop.getValue(DataEnum.Amazon_url));
		sa.assertTrue(true, "Access url: "+ prop.getValue(DataEnum.Amazon_url));
		return this;
	}
	
	
	public AmezonHomePage isLoaded(){
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(linkHelloSignIn), driver, 30)){
			throw new FrameworkException("Not able to load Amazon Home page in 30 seconds");
		}
		return this;
	}
	
	
	public boolean searchProduct(){
		
		searchBox.sendKeys(prop.getValue(DataEnum.Amazon_product));
		btnGo.click();
		sa.assertTrue(true, "Search product: "+prop.getValue(DataEnum.Amazon_product));
		return true;
	}
	
	public boolean clickSignIn(){
		/*Actions actions = new Actions(driver);
		actions.moveToElement(linkHelloSignIn).moveToElement(btnSignIn).click();*/
		linkHelloSignIn.click();
		sa.assertTrue(true, "Click on SignIn button");
		return true;
	}
	

}
