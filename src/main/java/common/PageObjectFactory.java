package common;


import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.driver.Driver;

import org.openqa.selenium.WebDriver;

import webpages.AmezonHomePage;
import webpages.CartPage;
import webpages.LoginPage;
import webpages.ProductDetailsPage;
import webpages.ProductsPage;
import webpages.UserWelcomePage;

public class PageObjectFactory {

	
	private WebDriver driver;
	private IProperty prop;
	
	private AmezonHomePage	amezonHomePage;
	private ProductsPage	productsPage;
	private ProductDetailsPage productDetailsPage;
	private CartPage cartPage;
	private LoginPage loginPage;
	private UserWelcomePage userWelcomePage;
	
	public PageObjectFactory(IBrowserConf browserConf, IProperty prop){
		this.prop = prop;
		driver = Driver.getDriver(browserConf);
		driver.manage().window().maximize();
		
	}
	
	
	public AmezonHomePage amezonHomePage(){
		if(null==amezonHomePage)
			amezonHomePage = new AmezonHomePage(driver,prop);
		return amezonHomePage;
	}
	
	public ProductsPage productsPage(){
		if(null==productsPage)
			productsPage = new ProductsPage(driver,prop);		
		return productsPage;
	}
	
	public ProductDetailsPage productDetailsPage(){
		if(null==productDetailsPage)
			productDetailsPage = new ProductDetailsPage(driver,prop);		
		return productDetailsPage;
	}
	public CartPage cartPage(){
		if(null==cartPage)
			cartPage = new CartPage(driver,prop);		
		return cartPage;
	}
	
	public LoginPage loginPage(){
		if(null==loginPage)
			loginPage = new LoginPage(driver,prop);		
		return loginPage;
	}

	public UserWelcomePage userWelcomePage(){
		if(null==userWelcomePage)
			userWelcomePage = new UserWelcomePage(driver,prop);		
		return userWelcomePage;
	}
	
	
	
	
}
