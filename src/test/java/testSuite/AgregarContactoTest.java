package testSuite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

		agendaPage = LoginPom.getAgendasPage();

	}

	@AfterEach
	public void stopSelenium() {
		loginPage.close();
	}
	
	@Test
	public void swichDeVentanaTest() throws InterruptedException {
		ContactData data = ContactData.get(1, propC);
		agendaPage.cambioAgenda();
		agendaPage.contactDataCompleta(data);
		agendaPage.cambioAgendaRetorno();
		assertEquals("Contact saved", agendaPage.messageSaved());
		
		 
	}
}
