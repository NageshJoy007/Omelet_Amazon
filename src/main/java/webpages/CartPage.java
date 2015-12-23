package webpages;

import java.util.List;
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


public class CartPage {
	
	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();
	

	@FindBy(xpath = "//span[@class='a-size-medium sc-product-title a-text-bold']")
	List<WebElement> productsInCart;
	
	public CartPage(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
		
	
	
	public CartPage isLoaded(){
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(productsInCart), driver, 15)){
			throw new FrameworkException("Not able to load Cart page in 15 seconds");
		}
		return this;
	}
	
	
	public boolean verifyProductInCart(){
		
		for (WebElement product : productsInCart) 
			if(product.getText().toLowerCase().contains(prop.getValue(DataEnum.Amazon_product).toLowerCase())){
				sa.assertTrue(true, "Verify product in cart");
				return true;
			}	
		sa.assertTrue(false, "Verify product in cart");
		return false;				
	}
	
	
	
	
}
	


