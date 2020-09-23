package pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Config;

//Clase de seteo 

public abstract class BasePom {

	protected static WebDriver driver = null;

	// Constructor driver
	protected void open() {
		if (driver == null) {
			Properties config = Config.get(Config.GENERAL);
			String browser = config.getProperty("browser", "Browser no definido");
			
			String driverRootChrome = config.getProperty("driverRootChrome", "Ruta no definida");
			String driverRootFirefox = config.getProperty("driverRootFirefox", "Ruta no definida");
			
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			
			if ("chrome".equals(browser)) {
				System.setProperty("webdriver.chrome.driver", driverRootChrome);
				driver = new ChromeDriver(dc);
			} else if ("firefox".equals(browser)) {
				System.out.println("Firefox");
				System.setProperty("webdriver.gecko.driver", driverRootFirefox);
				driver = new FirefoxDriver(dc);
			} else {
				throw new IllegalArgumentException("El navegador " + browser + " no es soportado");
			}
			waitTime(3);

		}
		
			

	}

	
	

	// Método de espera puede cambiar la unidad de tiempo
	public void waitTime(int i) {
		waitTime(Duration.ofSeconds(i));

	}

	// Método de espera base
	public void waitTime(Duration duration) {

		try {
			WebDriverWait wt = new WebDriverWait(driver, duration.toSeconds() - 1, 1);

			wt.ignoring(NoSuchElementException.class);

			wt.until(ExpectedConditions.urlToBe(this.getClass().getName()));

		} catch (TimeoutException e) {

		}
	}

	// Método cerrar driver
	public void close() {
		if (driver != null) {
			driver.close();
			driver = null;
		}
	}

	public static void readPropertiesFile() {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("src\\test\\resources\\config.properties");
			prop.load(input);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
