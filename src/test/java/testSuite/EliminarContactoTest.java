package testSuite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import config.Config;
import data.ContactData;
import data.LoginData;
import pom.AgendaPom;
import pom.LoginPom;

public class EliminarContactoTest {

	AgendaPom agendaPage;

	LoginPom loginPage;

	static Properties propL;
	static Properties propC;
	static Properties eleProp;
	
	@BeforeAll
	public static void beforeAll() {
		
		propL = Config.get(Config.CASOS_LOGIN);
		propC = Config.get(Config.CASOS_AGREGARCONTACTO);
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
		loginPage.goAgendaPage(data);
		agendaPage = loginPage.getAgendasPage();
		

	}

	@AfterEach
	public void stopSelenium() {
		loginPage.close();
	}

	@Tag("run")
	@Test
	public void testEliminarContacto() throws InterruptedException {
		ContactData data = ContactData.get(1, propC, eleProp);
		
		agendaPage.eliminarContacto(data);
		assertEquals(agendaPage.valRedMessage(eleProp), agendaPage.redMessage(eleProp));

	}
	

}
