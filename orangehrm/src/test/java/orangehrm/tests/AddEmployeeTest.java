package orangehrm.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import orangehrm.pageobject.EmployeePage;

public class AddEmployeeTest {
	private WebDriver driver;
	private EmployeePage employeePage;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Lekhana\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		employeePage = new EmployeePage(driver);
	}

	@Test
	public void testAddNewEmployee() {
		employeePage.addNewEmployee("John", "Middle", "Doe");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
