package ormeducation.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ormeducation.commonutils.CommonUtils;
import ormeducation.pageobject.AdminPage;
import ormeducation.pageobject.LoginPage;

public class BaseTest {
	protected WebDriver driver;
	protected LoginPage loginPage;
	private CommonUtils commonUtils;
	protected AdminPage adminPage;

	@BeforeMethod
	public void setUp() throws IOException {
		driver = CommonUtils.createDriver(LoginPage.loadProperties());
		loginPage = new LoginPage(driver);
		adminPage = new AdminPage(driver);
		commonUtils.browserSetup(driver);
	}

	@AfterMethod
	public void tearDown() {

		loginPage.closeBrowser();
	}

}
