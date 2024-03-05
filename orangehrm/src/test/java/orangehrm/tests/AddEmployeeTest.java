package orangehrm.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import orangehrm.commonutils.CommonUtils;
import orangehrm.pageobject.EmployeePage;
import orangehrm.pageobject.LoginPage;

public class AddEmployeeTest {
	private WebDriver driver;
	private EmployeePage employeePage;
	private LoginPage loginPage;

	@BeforeMethod
	public void setUp() throws IOException {
		driver = CommonUtils.createDriver(LoginPage.loadProperties());

		loginPage = new LoginPage(driver);
		employeePage = new EmployeePage(driver);
		loginPage.browserSetup(driver);
		employeePage.browserSetup(driver);

	}

	@Test
	public void testAddNewEmployee() throws InterruptedException {
		loginPage.doLogin("Admin", "admin123");

		loginPage.clickPimButton();
		Thread.sleep(2000);

		employeePage.addNewEmployee("aksh", "mak", "kan");
	}

	@AfterMethod
	public void tearDown() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.closeBrowser();
	}
}
