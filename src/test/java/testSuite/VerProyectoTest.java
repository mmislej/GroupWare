package testSuite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
	static Properties eleProp;
	
	@BeforeAll
	public static void beforeAll() {
		propL = Config.get(Config.CASOS_LOGIN);
		propA = Config.get(Config.CASOS_ALTAPROYECTO);
		eleProp = Config.get(Config.ELEMENTOS);

	}

	@BeforeEach
	public void startSelenium() {
		loginPage = new LoginPom();
		LoginData data = LoginData.get(1, propL, eleProp);
		loginPage.ingresaUsuario(data);
		loginPage.ingresaPass(data);
		loginPage.clickLogin(data);
		String contenido = loginPage.getContenido(data);
		assertTrue(contenido.contains(data.usuario));
		loginPage.goProyectPage(data);
		projectPage = loginPage.getProjectsPage();

	}

	@AfterEach
	public void stopSelenium() {
		loginPage.close();
	}

	// test ver proyecto no anda
	@Tag("run")
	@Test
	public void testVerProyecto() throws InterruptedException {
		
		ProjectData data = ProjectData.get(2, propA, eleProp);
		projectPage.fillSearchBox(data);
		projectPage.clickSearchButton(data);
		
		assertEquals(data.title, projectPage.validaTitle(eleProp));
		projectPage.clickView(data);
		assertEquals(projectPage.cabezalMensajeVerProyecto(eleProp), projectPage.cabezalMensajeValida(eleProp));
		assertEquals(data.title, projectPage.proyectoViewValidaTitle(eleProp));
		assertEquals(data.startDate, projectPage.proyectoViewValidaStartDate(eleProp));
		assertEquals(data.endDate, projectPage.proyectoViewValidaEndDate(eleProp));
		assertEquals(data.status+"%", projectPage.proyectoViewValidaStatus(eleProp));
	}
	


}
