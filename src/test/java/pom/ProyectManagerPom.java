package pom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;

import data.ContactData;
import data.MemberData;
import data.ProjectData;

public class ProyectManagerPom extends BasePom {

	public ProyectManagerPom() {
		open();
		assertEquals("ProjectManager - Projectlist", driver.findElement(By.id("divAppboxHeader")).getText());
	}

	public void irAlta() {

		// Click al Botón add
		driver.findElement(By.id("exec[add]")).click();

	}

	// trae datos de la clase ProyectData para alta (Clase biblioteca)
	public void completaData(ProjectData data) {
		this.completaData(data.title, data.startDate, data.endDate, data.times, data.timeUnit, data.status);

	}

	public String altaMensaje() {
		return driver.findElement(By.id("divAppboxHeader")).getText();
	}

	// Ingresa datos de alta de proyecto
	public void completaData(String title, String startDate, String endDate, String times, String timeUnit,
			String status) {

		waitTime(3);
		// Ingresa datos en pestaña general
		driver.findElement(By.name("exec[pm_title]")).sendKeys(title);
		driver.findElement(By.name("exec[pm_real_start][str]")).sendKeys(startDate);
		driver.findElement(By.name("exec[pm_real_end][str]")).sendKeys(endDate);
		driver.findElement(By.name("exec[pm_used_time][value]")).sendKeys(times);
		driver.findElement(By.name("exec[pm_used_time][unit]")).sendKeys(timeUnit);
		driver.findElement(By.name("exec[pm_completion]")).sendKeys(status);

		driver.findElement(By.name("exec[save]")).click();

	}

	// Toma mensaje al guardar para luego validar en tests
	public String saveMessage() {
		waitTime(3);
		return driver.findElement(By.id("msg")).getText();
	}

	// Toma mensaje alerta nombre de proyecto vacio
	public String emptyMessage() {

		return driver.findElement(By.xpath(
				"/html/body/div[3]/div[4]/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/form/table/tbody/tr[1]/td[4]"))
				.getText();
	}

	// trae datos de la clase ProyectData para buscar (Clase biblioteca)
	public void buscarProyecto(ProjectData data) {
		this.buscarProyecto(data.title, data.startDate, data.endDate, data.times, data.timeUnit, data.status);
	}

	// Búsca un proyecto
	public void buscarProyecto(String title, String startDate, String endDate, String times, String timeUnit,
			String status) {

		waitTime(3);
		driver.findElement(By.name("exec[nm][search]")).sendKeys(title);
		driver.findElement(By.name("exec[nm][start_search]")).click();

		waitTime(3);

		// assertEquals(title, driver.findElement(By.id("1[pm_title]")).getText());

	}

	public void eliminarProyecto() {
		waitTime(3);

		driver.findElement(By.id("exec[nm][rows][check_all]")).click();
		driver.findElement(By.id("exec[delete_checked]")).click();
	}

	public String validaTitle() {
		return driver.findElement(By.id("1[pm_title]")).getText();
	}

	public void irView(ProjectData data) {
		this.irView(data.title);
	}

	// click al botón View
	public void irView(String title) {

		waitTime(3);
		driver.findElement(By.xpath(
				"//*[@id=\"divAppbox\"]/table/tbody/tr/td/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/a/span[text()='"
						+ title.trim() + "']/../../../td[11]/table/tbody/tr/td/a/img[@title='View']"))
				.click();
		waitTime(3);

	}

	// Toma mensaje de ver proyecto para luego validar en tests
	public String verMessage() {
		waitTime(3);
		return driver.findElement(By.id("divAppboxHeader")).getText();
	}

	// click botón editar proyecto
	public void irEdit() {

		waitTime(3);
		driver.findElement(By.xpath(

				"/html/body/div[3]/div[4]/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[11]/table/tbody/tr/td[3]/a"))
				.click();
	}

	// ir a pestaña edit members
	public void irMembers() {

		waitTime(3);
		driver.findElement(By.id("projectmanager.edit.members-tab")).click();
	}

	// Toma mensaje de campo vacio para título
	public String tituloVacio() {

		return driver.findElement(By.xpath(
				"/html/body/div[3]/div[4]/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/form/table/tbody/tr[1]/td[4]/span"))
				.getText();
	}

	// trae nombre del miembro del proyecto
	public String memberName() {

		return driver.findElement(By.xpath(
				"/html/body/div[3]/div[4]/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div[3]/div/table/tbody/tr[2]/td[1]"))
				.getText();
	}

	// validaciones de info de proyecto

	public String proyectoViewValidaTitle() {

		return driver.findElement(By.xpath("//*[@id=\"divAppbox\"]/table/tbody/tr/td/form/table/tbody/tr[1]/td[4]/b"))
				.getText();
	}

	public String proyectoViewValidaStartDate() {

		return driver.findElement(By.xpath("//*[@id=\"pm_real_start\"]")).getText();
	}

	public String proyectoViewValidaEndDate() {

		return driver.findElement(By.xpath("//*[@id=\"pm_real_end\"]")).getText();
	}

	public String proyectoViewValidaStatus() {

		return driver.findElement(By.xpath("//*[@id=\"projectmanager.edit.general\"]/table/tbody/tr[8]/td[2]"))
				.getText();
	}

}
