package testSuite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import config.Config;
import data.LoginData;
import data.ProjectData;
import pom.LoginPom;
import pom.ProyectManagerPom;

public class VerProyectoTest {
	
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

		projectPage = loginPage.getProjectsPage();

	}

	@AfterEach
	public void stopSelenium() {
		loginPage.close();
	}
	// test ver proyecto no anda
		
		@Test
		public void verProyectoTest() throws InterruptedException {
			ProjectData data = ProjectData.get(2, propA);
			projectPage.buscarProyecto(data);
			projectPage.irView();
			assertEquals("ProjectManager - View project", projectPage.verMessage());
		}

}
