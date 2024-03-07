package orangehrm.tests;

import org.testng.annotations.Test;

public class AddEmployeeTest extends BaseTest {

	@Test
	public void testAddNewEmployee() throws InterruptedException {
		loginPage.doLogin("Admin", "admin123");

		loginPage.clickPimButton();
		Thread.sleep(2000);

		employeePage.addNewEmployee("akash", "van", "lane");
	}

}
