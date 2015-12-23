package tests;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;
import org.testng.annotations.Test;
import common.PageObjectFactory;

// To work with omelet framework go to : http://springer-opensource.github.io/omelet/Quick-Start

public class UserLoginTest {
	
	SAssert sassert = new SAssert();

	@Test(dataProviderClass = omelet.data.DataProvider.class, dataProvider = "XmlData",
			groups ={"All","SmokeTest", "UserLoginTest"})
	public void userLoginTest(IBrowserConf browserConf, IProperty prop) throws InterruptedException {
	
		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		pof.amezonHomePage().Accessurl().isLoaded();
		pof.amezonHomePage().clickSignIn();
		pof.loginPage().isLoaded().loginUser();
		pof.userWelcomePage().verifyLogin();
		sassert.assertAll();		
	}

}
