package orangehrm.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import orangehrm.commonutils.CommonUtils;

public class EmployeePage {
	private final WebDriver driver;
	private CommonUtils commonUtils;
	private LoginPage loginPage;

	public static void browserSetup(WebDriver driver) {

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public void testLogin() throws InterruptedException {
		loginPage.doLogin("Admin", "admin123");

		loginPage.clickPimButton();
		Thread.sleep(2000);
	}

	public EmployeePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a")
	private WebElement addEmp;

	@FindBy(how = How.CSS, using = "[name= 'firstName']")
	private WebElement txtFirstName;

	@FindBy(how = How.CSS, using = "[name= 'middleName']")
	private WebElement txtMiddleName;

	@FindBy(how = How.CSS, using = "[name= 'lastName']")
	private WebElement txtLastName;

	@FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
	private WebElement saveBtn;

	public void addNewEmployee(String firstName, String middleName, String lastName) throws InterruptedException {
		commonUtils.waitForElement(driver, addEmp, 10);
		addEmp.click();
		Thread.sleep(2000);
		commonUtils.waitForElement(driver, txtFirstName, 10);
		txtFirstName.sendKeys(firstName);
		commonUtils.waitForElement(driver, txtMiddleName, 10);
		txtMiddleName.sendKeys(middleName);
		commonUtils.waitForElement(driver, txtLastName, 10);
		txtLastName.sendKeys(lastName);
		commonUtils.waitForElement(driver, saveBtn, 10);
		saveBtn.click();
		Thread.sleep(10000);
	}

}
