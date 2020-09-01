package testSuite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import config.Config;
import data.LoginData;
import pom.LoginPom;

// Clase prueba
public class LoginTest {

	LoginPom page;

	static Properties prop;

	@BeforeAll
	public static void beforeAll() {
		prop = Config.get(Config.CASOS_LOGIN);

	}

	// Creamos instancia de driver
	@BeforeEach
	public void startSelenium() {
		page = new LoginPom();

	}

	// Apagamos driver
	@AfterEach
	public void stopSelenium() {
		page.close();
	}

	// Prueba login
	@Test
	public void verificaLogin() throws InterruptedException {
		LoginData data = LoginData.get(1, prop);

		page.login(data);

		String contenido = page.getContenido();

		page.logout();
		assertNotNull(contenido, "El contenido de la página se encuentra vacío");
		assertTrue(contenido.contains(data.usuario));

	}

	// Prueba Logout
	@Test
	public void verificaLogout() throws InterruptedException {
		LoginData data = LoginData.get(2, prop);

		page.login(data.usuario, data.contraseña);
		page.logout();

		assertEquals("You have been successfully logged out", page.logoutMessage());
	}

}