package orangehrm.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage {
	private final WebDriver driver;

	public EmployeePage(WebDriver driver) {
		this.driver = driver;
	}

	public void addNewEmployee(String firstName, String middleName, String lastName) {
		// Navigate to the employee page and perform actions to add a new employee
		driver.findElement(By.id("app")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Fill in the required details
		driver.findElement(By.name("firstName")).sendKeys(firstName);
		driver.findElement(By.name("middleName")).sendKeys(middleName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		// Click Save
		driver.findElement(By.id("btnSave")).click();
	}
}
