package pom;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePom {

	protected static WebDriver driver = null;

	protected void open() {
		if (driver == null) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Majulera\\Desktop\\EclipseWorkbench\\GroupWare\\Tema_5_en_adelante\\GroupWare\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			waitTime(3);
		}

	}

	public void waitTime(int i) {
		waitTime(Duration.ofSeconds(i));
		
	}

	public void waitTime(Duration duration) {

		try {
			WebDriverWait wt = new WebDriverWait(driver, duration.toSeconds() - 1, 1);

			wt.ignoring(NoSuchElementException.class);

			wt.until(ExpectedConditions.urlToBe(this.getClass().getName()));

		} catch (TimeoutException e) {

		}
	}

	public void close() {
		if (driver != null) {
			driver.close();
			driver = null;
		}
	}

}
