package tests;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;
import org.testng.annotations.Test;
import common.PageObjectFactory;


public class FailLoginForReportTest {
	
	SAssert sassert = new SAssert();

	@Test(dataProviderClass = omelet.data.DataProvider.class, dataProvider = "XmlData",
			groups ={"All","SmokeTest", "FailLoginForReportTest"})
	public void failLoginForReportTest(IBrowserConf browserConf, IProperty prop) throws InterruptedException {
	
		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		pof.amezonHomePage().Accessurl().isLoaded();
		pof.amezonHomePage().clickSignIn();
		pof.loginPage().isLoaded().loginUser();
		pof.userWelcomePage().verifyLogin();
		sassert.assertAll();
		
	}
	

}
