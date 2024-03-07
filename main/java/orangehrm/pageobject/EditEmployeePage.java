package orangehrm.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import orangehrm.commonutils.CommonUtils;

public class EditEmployeePage {
	private LoginPage loginPage;
	private final WebDriver driver;
	private CommonUtils commonUtils;

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

	public EditEmployeePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
	private WebElement hintEmployeeName;

	@FindBy(how = How.XPATH, using = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' and @data-v-408b665e='']")
	private WebElement searchButton;

	@FindBy(how = How.XPATH, using = "//button[contains(@class, 'oxd-icon-button') and contains(@class, 'oxd-table-cell-action-space')]/i[contains(@class, 'oxd-icon') and contains(@class, 'bi-pencil-fill')]\r\n"
			+ "")
	private WebElement editButton;

	@FindBy(how = How.CSS, using = "[name= 'middleName']")
	private WebElement editMiddleName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button")
	private WebElement saveButton;

	public void editEmployee(String middleName) throws InterruptedException {
		commonUtils.waitForElement(driver, hintEmployeeName, 10);
		hintEmployeeName.sendKeys("akash");
		commonUtils.waitForElement(driver, searchButton, 10);
		searchButton.click();
		Thread.sleep(2000);
		commonUtils.scrollDown(driver);
		commonUtils.waitForElement(driver, editButton, 10);
		editButton.click();
		Thread.sleep(5000);
		commonUtils.waitForElement(driver, editMiddleName, 10);
		editMiddleName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		Thread.sleep(2000);
		editMiddleName.sendKeys(middleName);
		Thread.sleep(3000);
		commonUtils.scrollDown(driver);
		commonUtils.waitForElement(driver, saveButton, 10);
		saveButton.click();
		Thread.sleep(10000);

	}

}
