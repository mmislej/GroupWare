package testSuite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import data.LoginData;
import pom.LoginPom;

public class LoginTest {

	LoginPom page;
	
	
	
	@BeforeEach
	public void startSelenium() {
		page = new LoginPom();
		
	}

	@AfterEach
	public void stopSelenium() {
		 page.close();
	}

	@Test
	public void verificaLogin() throws InterruptedException {
		LoginData  data = LoginData.get(1);
		
		page.login(data.usuario, data.contraseña);
		
		String contenido = page.getContenido();
				
		page.logout();
		assertNotNull(contenido, "El contenido de la página se encuentra vacío");
		assertTrue(contenido.contains(data.usuario));
		
	}
	
	@Test
	public void verificaLogout() throws InterruptedException {
		LoginData  data = LoginData.get(2);
		
		page.login(data.usuario, data.contraseña);
		page.logout();
		
		assertEquals("You have been successfully logged out", page.logoutMessage());
	}

	
}