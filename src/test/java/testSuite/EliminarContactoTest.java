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

	@BeforeAll
	public static void beforeAll() {
		System.out.println("entra en metodo carga de archivos");
		propL = Config.get(Config.CASOS_LOGIN);
		propC = Config.get(Config.CASOS_AGREGARCONTACTO);
		//System.out.println("sale en metodo carga de archivos");
	}

	@BeforeEach
	public void startSelenium() {
		//System.out.println("metodo navegación a agenda");
		loginPage = new LoginPom();
		LoginData data = LoginData.get(1, propL);
		loginPage.login(data.usuario, data.contraseña);
		String contenido = loginPage.getContenido();
		assertTrue(contenido.contains(data.usuario));
		agendaPage = LoginPom.getAgendasPage();
		//System.out.println("sale navegación a agenda");

	}

	@AfterEach
	public void stopSelenium() {
		loginPage.close();
	}

	@Tag("run")
	@Test
	public void testEliminarContacto() throws InterruptedException {
		//System.out.println("prueba eliminar");
		ContactData data = ContactData.get(1, propC);
		agendaPage.popUpCompletar(data);
		//System.out.println("prueba eliminar fin");
		assertEquals("1 contact(s) deleted", agendaPage.redMessage());

	}
	// parametrizar xpath para campo nombre y apellido

}
