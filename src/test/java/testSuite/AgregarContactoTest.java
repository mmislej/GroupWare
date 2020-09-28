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
import pom.ProyectManagerPom;

public class AgregarContactoTest {

	AgendaPom agendaPage;

	LoginPom loginPage;

	static Properties propL;
	static Properties propC;

	@BeforeAll
	public static void beforeAll() {
		propL = Config.get(Config.CASOS_LOGIN);
		propC = Config.get(Config.CASOS_AGREGARCONTACTO);
	}

	@BeforeEach
	public void startSelenium() {
		loginPage = new LoginPom();
		LoginData data = LoginData.get(1, propL);
		loginPage.login(data.usuario, data.contraseña);
		String contenido = loginPage.getContenido();
		assertTrue(contenido.contains(data.usuario));
		agendaPage = LoginPom.getAgendasPage();

	}

	@AfterEach
	public void stopSelenium() {
		loginPage.close();
	}

	@Tag("run")
	@Test
	public void testAgregarContacto() throws InterruptedException {
		ContactData data = ContactData.get(1, propC);
		agendaPage.cambioAgenda();
		assertEquals("General", agendaPage.validarVentanaEmergente());
		agendaPage.contactDataCompleta(data);
		agendaPage.cambioAgendaRetorno();
		assertEquals("Contact saved", agendaPage.redMessage());
		agendaPage.verContacto(data);
		assertEquals(data.organisation+": "+data.last_name.trim()+", "+data.first_name.trim(), agendaPage.validarContacto());
		

	}
	

	
	
	
}
