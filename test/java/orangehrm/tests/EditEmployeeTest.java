package orangehrm.tests;

import org.testng.annotations.Test;

public class EditEmployeeTest extends BaseTest {
	@Test
	public void testEditEmployee() throws InterruptedException {
		loginPage.doLogin("Admin", "admin123");

		loginPage.clickPimButton();
		Thread.sleep(2000);

		editEmployeePage.editEmployee("middlename");
	}

}
