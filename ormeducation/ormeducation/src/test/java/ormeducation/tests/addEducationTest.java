package ormeducation.tests;

import org.testng.annotations.Test;

public class addEducationTest extends BaseTest {
	@Test
	public void testEducation() throws InterruptedException {
		loginPage.doLogin("Admin", "admin123");

		loginPage.clickAdminButton();
		Thread.sleep(2000);
		adminPage.addNewEducation("ABCD");
	}
}
