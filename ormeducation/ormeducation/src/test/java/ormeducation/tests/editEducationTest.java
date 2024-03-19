package ormeducation.tests;

import org.testng.annotations.Test;

public class editEducationTest extends BaseTest {
	@Test
	public void testEditEducation() throws InterruptedException {
		loginPage.doLogin("Admin", "admin123");

		loginPage.clickAdminButton();
		Thread.sleep(2000);
		adminPage.editEducation("ABCD", "EFGH");
	}
}
