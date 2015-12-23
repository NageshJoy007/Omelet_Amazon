package tests;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;

import org.testng.annotations.Test;

import common.PageObjectFactory;





public class AddProductToCartTest {
	
	SAssert sassert = new SAssert();

	@Test(dataProviderClass = omelet.data.DataProvider.class, dataProvider = "XmlData",groups ={"All", "SmokeTest", "AddProductToCartTest"})
	public void addProductToCartTest(IBrowserConf browserConf, IProperty prop) {
	
		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		
		pof.amezonHomePage().Accessurl().isLoaded();
		pof.amezonHomePage().searchProduct();
		pof.productsPage().isLoaded().verifyProduct();
		pof.productsPage().goToProductDetailsPage();
		pof.productDetailsPage().isLoaded().addProductToCart();
		pof.productDetailsPage().goToCart();
		pof.cartPage().isLoaded().verifyProductInCart();

		sassert.assertAll();
	}
	

}
