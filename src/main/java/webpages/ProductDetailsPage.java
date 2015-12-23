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


public class ProductDetailsPage {
	
	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();
	

	@FindBy (xpath= "//*[@id='add-to-cart-button']")
	private WebElement btnAddToCart;
	
	@FindBy (xpath= "//*[@id='add-to-wishlist-button-submit']")
	private WebElement btnAddToWishList;
	
	
	
	@FindBy (xpath= "//*[@id='nav-cart']")
	private WebElement btnCart;
	
	
	public ProductDetailsPage(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
		
	
	
	public ProductDetailsPage isLoaded(){
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(btnAddToCart), driver, 30)){
			throw new FrameworkException("Not able to load ProductDetails page in 30 seconds");
		}
		return this;
	}
	
	
	public boolean addProductToCart(){
		btnAddToCart.click();
		sa.assertTrue(true, "Add product to cart");
		return true;
	}
	
	public boolean goToCart(){
		btnCart.click();
		sa.assertTrue(true, "Go to 'Cart'");
		return true;
	}
	
	public boolean addProductToWishList(){
		btnAddToWishList.click();
		sa.assertTrue(true, "Add product to wish list");
		return true;
	}
	
	
	
}
	


