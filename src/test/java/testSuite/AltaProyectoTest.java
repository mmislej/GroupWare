package testSuite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

import config.Config;
import data.LoginData;
import data.MemberData;
import data.ProjectData;
import pom.ProyectManagerPom;
import pom.LoginPom;

public class AltaProyectoTest {

	ProyectManagerPom projectPage;

	LoginPom loginPage;

	static Properties propL;
	static Properties propA;

	@BeforeAll
	public static void beforeAll() {
		propL = Config.get(Config.CASOS_LOGIN);
		propA = Config.get(Config.CASOS_ALTAPROYECTO);

	}

	@BeforeEach
	public void startSelenium() {
		loginPage = new LoginPom();
		LoginData data = LoginData.get(1, propL);
		loginPage.login(data.usuario, data.contraseña);
		String contenido = loginPage.getContenido();
		assertTrue(contenido.contains(data.usuario));
		projectPage = loginPage.getProjectsPage();

	}

	@AfterEach
	public void stopSelenium() {
		loginPage.close();
	}

	// Test alta proyecto
	@Tag("run")
	@Test
	public void testAltaProyecto() throws InterruptedException {

		projectPage.irAlta();
		assertEquals("ProjectManager - Add project", projectPage.altaMensaje());
		ProjectData data = ProjectData.get(1, propA);
		projectPage.completaData(data);
		assertEquals("Project saved", projectPage.saveMessage());
	}

	
	
}
