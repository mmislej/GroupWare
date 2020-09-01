package pom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;

import config.Config;
import data.LoginData;

// Clase Page object para Login

public class LoginPom extends BasePom {

	//Abre página E groupware
	
	public LoginPom() {

		open();
		driver.get("http://egroupware.cursos.ces.com.uy/egroupware/login.php?cd=1&domain=default");
		waitTime(3);

	}
	
	// Método loguea la cuenta

	public void login(String usuario, String clave) {

		driver.findElement(By.name("login")).sendKeys(usuario);
		driver.findElement(By.name("passwd")).sendKeys(clave);
		driver.findElement(By.name("submitit")).click();
		waitTime(3);
	}
	
	// Desloguea la cuenta

	public void logout() {
		driver.findElement(By.linkText("Logout")).click();
		waitTime(3);

	}
	
	// Búsca elemento logout

	public String logoutMessage() {

		return driver.findElement(By.id("loginCdMessage")).getText();
	}

	
	// obtiene contenido elemento para validar nombre de usuario
	public String getContenido() {

		return driver.findElement(By.id("topmenu")).getText();
	}

	// Click al botón de página de gestión de los proyectos
	public static ProyectManagerPom getProjectsPage() {

		// Click al botón de proyecto
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[4]/a")).click();

		return new ProyectManagerPom();
	}
	
	// Click al botón de página de agenda
		public static AgendaPom getAgendasPage() {

			// Click al botón de proyecto
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/a")).click();

			return new AgendaPom();
		}

	// trae datos de la clase LoginData (Clase biblioteca)
	public void login(LoginData data) {
		this.login(data.usuario, data.contraseña);

	}

}
