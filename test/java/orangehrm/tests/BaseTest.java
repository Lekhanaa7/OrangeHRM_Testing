package orangehrm.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import orangehrm.commonutils.CommonUtils;
import orangehrm.pageobject.EditEmployeePage;
import orangehrm.pageobject.EmployeePage;
import orangehrm.pageobject.LoginPage;

public class BaseTest {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected EmployeePage employeePage;
	protected EditEmployeePage editEmployeePage;

	@BeforeMethod
	public void setUp() throws IOException {
		driver = CommonUtils.createDriver(LoginPage.loadProperties());
		loginPage = new LoginPage(driver);
		employeePage = new EmployeePage(driver);
		editEmployeePage = new EditEmployeePage(driver);
		loginPage.browserSetup(driver);
		employeePage.browserSetup(driver);
		editEmployeePage.browserSetup(driver);
	}

	@AfterMethod
	public void tearDown() {

		loginPage.closeBrowser();
	}

}
