package ormeducation.pageobject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ormeducation.commonutils.CommonUtils;

public class AdminPage {
	private final WebDriver driver;
	private CommonUtils commonUtils;
	private LoginPage loginPage;

	public void testLogin() throws InterruptedException {
		loginPage.doLogin("Admin", "admin123");

		loginPage.clickAdminButton();
		Thread.sleep(2000);
	}

	public AdminPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//li[contains(@class, 'oxd-topbar-body-nav-tab')][4]/span")
	private WebElement qualificationBtn;

	@FindBy(how = How.XPATH, using = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Education']")
	private WebElement educationBtn;

	@FindBy(how = How.XPATH, using = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
	private WebElement txtEducation;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
	private WebElement saveBtn;

	//	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/span")
	//	private WebElement alreadyExistsBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
	private WebElement txtEdit;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
	private WebElement editedSavedBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/button")
	private WebElement deleteSelectBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
	private WebElement yesBtn;

	public void addNewEducation(String education) throws InterruptedException {
		commonUtils.waitForElement(driver, qualificationBtn, 10);
		qualificationBtn.click();
		Thread.sleep(2000);

		commonUtils.waitForElement(driver, educationBtn, 10);
		educationBtn.click();
		Thread.sleep(2000);

		commonUtils.waitForElement(driver, addBtn, 10);
		addBtn.click();
		Thread.sleep(2000);

		commonUtils.waitForElement(driver, txtEducation, 10);
		txtEducation.sendKeys(education);
		Thread.sleep(2000);

		commonUtils.waitForElement(driver, saveBtn, 10);
		saveBtn.click();
		Thread.sleep(10000);

		try {
			WebElement alreadyExistsBtn = driver
					.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/span"));
			commonUtils.waitForElement(driver, alreadyExistsBtn, 2);
			String msg = alreadyExistsBtn.getText();
			if (msg.equals("Already exists")) {
				String newValue = RandomStringUtils.randomAlphabetic(4);
				commonUtils.waitForElement(driver, txtEducation, 5);
				txtEducation.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
				txtEducation.sendKeys(newValue);
				Thread.sleep(2000);
				commonUtils.waitForElement(driver, saveBtn, 10);
				saveBtn.click();
				Thread.sleep(10000);

				driver.quit();
			}

		}

		catch (Exception e) {

		}

	}

	public void editEducation(String inputValue, String editedValue) throws InterruptedException {
		try {
			commonUtils.waitForElement(driver, qualificationBtn, 10);

			qualificationBtn.click();
			Thread.sleep(2000);

			commonUtils.waitForElement(driver, educationBtn, 10);
			educationBtn.click();
			Thread.sleep(2000);
			String xpath = String.format(
					"//div[contains(@class, 'oxd-table-row') and .//div[contains(text(), '%s')]]//button[contains(@class, 'oxd-icon-button')][2]",
					inputValue);
			WebElement editBtn = driver.findElement(By.xpath(xpath));
			commonUtils.waitForElement(driver, editBtn, 10);
			editBtn.click();
			Thread.sleep(2000);
			commonUtils.waitForElement(driver, txtEdit, 10);
			txtEdit.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			Thread.sleep(1000);
			txtEdit.sendKeys(editedValue);
			commonUtils.waitForElement(driver, editedSavedBtn, 10);
			editedSavedBtn.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			String newValue = RandomStringUtils.randomAlphabetic(4);

			commonUtils.waitForElement(driver, addBtn, 10);
			addBtn.click();
			Thread.sleep(2000);

			commonUtils.waitForElement(driver, txtEducation, 10);
			txtEducation.sendKeys(newValue);
			Thread.sleep(2000);

			commonUtils.waitForElement(driver, saveBtn, 10);
			saveBtn.click();
			Thread.sleep(10000);
			editEducation(newValue, "EFGH");
		}
	}

	public void deleteEducation(String deleteValue) throws InterruptedException {
		commonUtils.waitForElement(driver, qualificationBtn, 10);
		qualificationBtn.click();
		Thread.sleep(2000);

		commonUtils.waitForElement(driver, educationBtn, 10);
		educationBtn.click();
		Thread.sleep(5000);
		try {
			String xpath = String.format(
					"//div[contains(text(), '%s')]/ancestor::div[contains(@class, 'oxd-table-row')]/descendant::span[contains(@class, 'oxd-checkbox-input')]/i[contains(@class, 'bi-check')]",
					deleteValue);

			WebElement checkbox = driver.findElement(By.xpath(xpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
			commonUtils.scrollUp(driver);
			commonUtils.waitForElement(driver, deleteSelectBtn, 10);
			deleteSelectBtn.click();
			Thread.sleep(2000);
			commonUtils.waitForElement(driver, yesBtn, 10);
			yesBtn.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			String newValue = RandomStringUtils.randomAlphabetic(4);
			commonUtils.waitForElement(driver, addBtn, 10);
			addBtn.click();
			Thread.sleep(2000);

			commonUtils.waitForElement(driver, txtEducation, 10);
			txtEducation.sendKeys(newValue);
			Thread.sleep(2000);

			commonUtils.waitForElement(driver, saveBtn, 10);
			saveBtn.click();
			Thread.sleep(5000);
			deleteEducation(newValue);

		}
	}
}
