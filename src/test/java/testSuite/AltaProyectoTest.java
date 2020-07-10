package testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.LoginData;
import data.ProyectoData;
import pom.AltaProyectoPom;
import pom.LoginPom;

public class AltaProyectoTest {

	AltaProyectoPom projectPage;

	LoginPom loginPage;

	@BeforeEach
	public void startSelenium() {
		loginPage = new LoginPom();
		LoginData data = LoginData.get(1);
		loginPage.login(data.usuario, data.contraseña);
		
		projectPage = loginPage.getProjectsPage();

	}

	@AfterEach
	public void stopSelenium() {
		loginPage.close();
	}

	@Test
	public void altaProyecto() throws InterruptedException {

		projectPage.irAlta();
		projectPage.darAlta(ProyectoData.get(1));
	}

}
