package testSuite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import config.Config;
import data.LoginData;
import data.MemberData;
import data.ProjectData;
import pom.LoginPom;
import pom.ProyectManagerPom;

public class AgregarMiembroTest {
	
	ProyectManagerPom projectPage;

	LoginPom loginPage;
	
	static Properties propL;
	static Properties propA;
	static Properties propM;
	
	@BeforeAll
	public static void beforeAll() {
		propL = Config.get(Config.CASOS_LOGIN);
		propA = Config.get(Config.CASOS_ALTAPROYECTO);
		propM = Config.get(Config.CASOS_AGREGARMIEMBRO);

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
	
	// Test agregar miembros
	
		@Test
		public void agregarMiembroTest() throws InterruptedException {
			ProjectData data = ProjectData.get(1, propA);
			MemberData dataM = MemberData.get(1, propM);
			projectPage.buscarProyecto(data);
			projectPage.irEdit();
			projectPage.irMembers();
			projectPage.memberDataCompleta(dataM);
			assertEquals("Project saved", projectPage.saveMessage());
			// para validar que se agrego miembro
			projectPage.reBuscarProyecto();
			projectPage.irView();
			projectPage.irMembers();
			assertEquals(dataM.member, projectPage.memberName());
		}


}
