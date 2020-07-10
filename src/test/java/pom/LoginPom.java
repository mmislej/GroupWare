package pom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;

public class LoginPom extends BasePom {

	public LoginPom() {

		open();
		driver.get("http://egroupware.cursos.ces.com.uy/egroupware/login.php?cd=1&domain=default");
		waitTime(3);

	}

	public void login(String usuario, String clave) {

		driver.findElement(By.name("login")).sendKeys(usuario);
		driver.findElement(By.name("passwd")).sendKeys(clave);
		driver.findElement(By.name("submitit")).click();
		waitTime(3);
	}

	public void logout() {
		driver.findElement(By.linkText("Logout")).click();
		waitTime(3);

	}

	public String logoutMessage() {

		return driver.findElement(By.id("loginCdMessage")).getText();
	}

	public String getContenido() {

		return driver.findElement(By.id("topmenu")).getText();
	}

	public static AltaProyectoPom getProjectsPage() {

		// Click al botón de proyecto
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[4]/a")).click();

		return new AltaProyectoPom();
	}

}
