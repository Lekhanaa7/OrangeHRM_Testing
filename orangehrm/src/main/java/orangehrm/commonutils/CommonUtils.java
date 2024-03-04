package orangehrm.commonutils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	private final WebDriver driver;

	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}

	public static void waitForElement(WebDriver driver, WebElement webElement, int timeUnit_sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeUnit_sec));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
}
