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
	public void testAgregarContacto() throws InterruptedException {
		ContactData data = ContactData.get(1, propC, eleProp);
		
		agendaPage.parentHandle();
		agendaPage.clickAddContact(data);
		agendaPage.switchHandle();
		
		assertEquals(agendaPage.valPopUp(eleProp), agendaPage.validarVentanaEmergente(eleProp));
		
		//agendaPage.contactDataCompleta(data);
		
		agendaPage.clickNameBox(data);
		agendaPage.ingresaPrefix(data);
		agendaPage.ingresaFirstName(data);
		agendaPage.ingresaMiddleName(data);
		agendaPage.ingresaLastName(data);
		agendaPage.ingresaSuffix(data);
		agendaPage.clickOkButton(data);
		agendaPage.ingresaTitle(data);
		agendaPage.ingresaRole(data);
		agendaPage.ingresaRoom(data);
		agendaPage.ingresaOrganization(data);
		agendaPage.ingresaDepartament(data);
		agendaPage.ingresaStreet(data);
		agendaPage.ingresaCity(data);
		agendaPage.ingresaPostalCode(data);
		agendaPage.ingresaCountry(data);
		agendaPage.ingresaWork(data);
		agendaPage.ingresaCellPhone(data);
		agendaPage.ingresaPhone(data);
		agendaPage.ingresaUrl(data);
		agendaPage.ingresaUrlHome(data);
		agendaPage.ingresaEmail(data);
		agendaPage.ingresaHomeEmail(data);
		agendaPage.clickSaveButtom(data);
		
		
		
		
		
		agendaPage.cambioAgendaRetorno();
		assertEquals(agendaPage.validaMensajeSaveMessage(eleProp), agendaPage.redMessage(eleProp));
		agendaPage.verContacto(data);
		assertEquals(data.organisation + ": " + data.last_name.trim() + ", " + data.first_name.trim(),
				agendaPage.validarContacto(eleProp));

	}

}
