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


public class ProductsPage {
	
	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();
	

	@FindBy (xpath= ".//*[@id='result_0']/div/div/div/div[2]/div[1]/a/h2")
	private WebElement product;
	
	public ProductsPage(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
		
	
	
	public ProductsPage isLoaded(){
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(product), driver, 30)){
			throw new FrameworkException("Not able to load Products page in 30 seconds");
		}
		return this;
	}
	
	
	public boolean verifyProduct(){
		
		if(product.getText().toLowerCase().contains(prop.getValue(DataEnum.Amazon_product).toLowerCase())){
			sa.assertTrue(true, "Verify product:  "+product.getText());
			return true;
		}		
		sa.assertTrue(false, "Verify product:  "+product.getText());
		return false;				
	}
	
	
	public void goToProductDetailsPage(){
		product.click();
		Set<String> ids = driver.getWindowHandles();
		int count =ids.size();
		if(count>1){
			System.out.println(count);
			Iterator<String> itr = ids.iterator();
			String mainwin = itr.next();
			String  tabwin = itr.next();
			driver.switchTo().window(tabwin);
		}
		sa.assertTrue(true, "Go to product details page");
	}
	
	
	
	
}
	


