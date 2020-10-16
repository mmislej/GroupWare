package pom;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;

import config.Config;
import data.LoginData;

// Clase Page object para Login

public class LoginPom extends BasePom {
	
	public String usuario;
	
	 

	// Abre página E groupware

	public LoginPom() {

		open();
		driver.get("http://egroupware.cursos.ces.com.uy/egroupware/login.php?cd=1&domain=default");
		waitTime(3);

	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------	
	//Login
	public void ingresaUsuario(String usuario, String eleuser) {
		
		driver.findElement(By.name(eleuser)).sendKeys(usuario);
		waitTime(2);
	}
	
	public void ingresaPass(String clave, String elePass) {
		
		driver.findElement(By.name(elePass)).sendKeys(clave);
		waitTime(2);
	}
	
	public void clickLogin(String eleLogin) {
		
		driver.findElement(By.name(eleLogin)).click();
		waitTime(3);	
	}
	
	
	public void ingresaUsuario(LoginData data) {
		this.ingresaUsuario(data.usuario, data.eleUsuario);	
		
	}
	
	public void ingresaPass(LoginData data) {
		this.ingresaPass(data.contraseña, data.eleContraseña);	
		
	}
	public void clickLogin(LoginData data) {
		this.clickLogin(data.eleLogin);
		
	}
	
	
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------	
	

	// LOGOUT

	public void logout(String eleLogout) {
		driver.findElement(By.linkText(eleLogout)).click();
		waitTime(3);
	}	
		public void logout(LoginData data) {
			this.logout(data.eleLogout);	

	}
//-----------------------------------------------------------------------------------------------------------------------------------------------------	
	// Búsca elemento logout

	public String logoutMessage(String eleLogoutMessage) {

		return driver.findElement(By.id(eleLogoutMessage)).getText();
	}
	
	public void logoutMessage(LoginData data) {
		this.logoutMessage(data.eleLogoutMessage);
	
	}

	// obtiene contenido elemento para validar nombre de usuario
	public String getContenido(String eleTopMenu) {

		return driver.findElement(By.id(eleTopMenu)).getText();
	}
	
	public String getContenido(LoginData data) {
		return this.getContenido(data.eleTopmenu);
	
	}
//-----------------------------------------------------------------------------------------------------------------------------------------------------
	// Click al botón de página de gestión de los proyectos
	public void  goProyectPage(String eleBotonProyecto,String validaProyectPage,String eleValidaProyect) {

		// Click al botón de proyecto
		waitTime(3);
		driver.findElement(By.xpath(eleBotonProyecto)).click();
		assertEquals(validaProyectPage, driver.findElement(By.id(eleValidaProyect)).getText());
	
	}
	
	public void goProyectPage(LoginData data) {
		this.goProyectPage(data.eleBotonProyecto, data.validaProyectPage,data.eleValidaProyect);
	}
	
	public static  ProyectManagerPom getProjectsPage() {
	
		return new ProyectManagerPom();
	}
	

	
	
	public void  goAgendaPage(String eleBotonAgenda,String validaAgendaPage,String stringEsperadoAgenda) {

		// Click al botón de proyecto
		driver.findElement(By.xpath(eleBotonAgenda)).click();
		String actualString = driver.findElement(By.xpath(validaAgendaPage)).getText();

		String expectedString = stringEsperadoAgenda;

		assertTrue(actualString.contains(expectedString));

		
	}
	
	public void goAgendaPage(LoginData data) {
		this.goAgendaPage(data.eleBotonAgenda, data.validaAgendaPage,data.stringEsperadoAgenda);
	}
	
	public static  AgendaPom getAgendaPage() {
	
		return new AgendaPom();
	}

	

}
