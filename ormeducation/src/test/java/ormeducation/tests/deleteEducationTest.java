package ormeducation.tests;

import org.testng.annotations.Test;

public class deleteEducationTest extends BaseTest {
	@Test
	public void testDeleteEducation() throws InterruptedException {
		loginPage.doLogin("Admin", "admin123");

		loginPage.clickAdminButton();
		Thread.sleep(2000);
		adminPage.deleteEducation("ABCD");
		;
	}

}
