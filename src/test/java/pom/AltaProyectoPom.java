package pom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;

import data.ProyectoData;

public class AltaProyectoPom extends BasePom {
	
	public AltaProyectoPom() {
		open();
		assertEquals("ProjectManager - Projectlist", driver.findElement(By.id("divAppboxHeader")).getText());
	}
	
	public void irAlta() {
		
		
		// Click al Botón add
		driver.findElement(By.id("exec[add]")).click();
		assertEquals("ProjectManager - Add project", driver.findElement(By.id("divAppboxHeader")).getText());
		// Ingresar datos

	}

	public void darAlta(ProyectoData data) {
		waitTime(3);
		
	}

}
