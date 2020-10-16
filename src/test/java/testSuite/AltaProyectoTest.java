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
		ProjectData data = ProjectData.get(1, propA, eleProp);
		//projectPage.eliminarChequeados(data);
		//projectPage.eliminarChequeados(data);
		projectPage.clickDelete(data);
		loginPage.close();
	}

	// Test alta proyecto
	@Tag("run")
	@Test
	public void testAltaProyecto() throws InterruptedException {
		
		ProjectData data = ProjectData.get(1, propA, eleProp);
		projectPage.presionarAdd(data);
		assertEquals(projectPage.cabezalMensajeAgregaProyecto(eleProp), projectPage.cabezalMensajeValida(eleProp));
		
		projectPage.ingresaTitulo(data);		
		projectPage.ingresaComienzo(data);
		projectPage.ingresaFin(data);		
		projectPage.ingresaTimes(data);		
		projectPage.ingresaTimeUnit(data);
		projectPage.ingresaStatus(data);		
		projectPage.clickSaveButton(data);
	
		assertEquals(projectPage.validaMensajeSaveMessage(eleProp), projectPage.saveMessage(eleProp));
		projectPage.fillSearchBox(data);
		projectPage.clickSearchButton(data);
		
		assertEquals(data.title, projectPage.validaTitle(eleProp));
	}

	

	

	
	
}
