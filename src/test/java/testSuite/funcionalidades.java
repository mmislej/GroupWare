package testSuite;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class funcionalidades {
    WebDriver driver;

    public funcionalidades()
    {
        System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    

    public void close()
    {
        driver.close();
    }

    public void login(String usuario, String clave)
    {
        driver.get("http://egroupware.cursos.ces.com.uy/login.php");
        driver.findElement(By.name("login")).sendKeys(usuario);
	driver.findElement(By.name("passwd")).sendKeys(clave);
        driver.findElement(By.name("submitit")).click();
    }

    public void logout()
    {
        driver.findElement(By.linkText("Logout")).click();
        assertEquals("You have been successfully logged out", driver.findElement(By.id("loginCdMessage")).getText());
    }

}
