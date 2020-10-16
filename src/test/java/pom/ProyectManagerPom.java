package pom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;

import data.ContactData;
import data.LoginData;
import data.MemberData;
import data.ProjectData;

public class ProyectManagerPom extends BasePom {

	public ProyectManagerPom() {
		open();
		
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void presionarAdd(String eleAddButton) {

		// Click al Botón add
		driver.findElement(By.id(eleAddButton)).click();

	}
	public void presionarAdd(ProjectData data) {
		this.presionarAdd(data.eleAddButton);	
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public String cabezalMensajeAgregaProyecto(Properties eleProp) {
		return eleProp.getProperty("eleValidaCabezalMensaje");
	}
	
	
	public String cabezalMensajeVerProyecto(Properties eleProp) {
		return eleProp.getProperty("eleValidaCabezalMensajeVer");
	}
	
	public String cabezalMensajeValida(Properties eleProp) {
		return driver.findElement(By.id(eleProp.getProperty("eleCabezalMensaje"))).getText();
		
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	

	public void ingresaTitulo(String title, String eleIngresaTitulo) {
		waitTime(1);
		driver.findElement(By.name(eleIngresaTitulo)).sendKeys(title);	
	}
	
	public void ingresaTitulo(ProjectData data) {
		this.ingresaTitulo(data.title, data.eleIngresaTitulo);
	}
	
	public void ingresaComienzo(String startDate, String eleIngresaComienzo) {
		waitTime(1);
		driver.findElement(By.name(eleIngresaComienzo)).sendKeys(startDate);	
	}
	
	public void ingresaComienzo(ProjectData data) {
		this.ingresaComienzo(data.startDate, data.eleIngresaComienzo);
	}

	public void ingresaFin(String endDate, String eleIngresaFin) {
		waitTime(1);
		driver.findElement(By.name(eleIngresaFin)).sendKeys(endDate);	
	}
	
	public void ingresaFin(ProjectData data) {
		this.ingresaFin(data.endDate, data.eleIngresaFin);
	}
	
	public void ingresaTimes(String times, String eleIngresaTimes) {
		waitTime(1);
		driver.findElement(By.name(eleIngresaTimes)).sendKeys(times);	
	}
	
	public void ingresaTimes(ProjectData data) {
		this.ingresaTimes(data.times, data.eleIngresaTimes);
	}
	
	public void ingresaTimeUnit(String timeUnit, String eleIngresaTimeUnit) {
		waitTime(1);
		driver.findElement(By.name(eleIngresaTimeUnit)).sendKeys(timeUnit);	
	}
	
	public void ingresaTimeUnit(ProjectData data) {
		this.ingresaTimeUnit(data.timeUnit, data.eleIngresaTimeUnit);
	}
	
	public void ingresaStatus(String status, String eleIngresaStatus) {
		waitTime(1);
		driver.findElement(By.name(eleIngresaStatus)).sendKeys(status);	
	}
	
	public void ingresaStatus(ProjectData data) {
		this.ingresaStatus(data.status, data.eleIngresaStatus);
	}
	
	public void clickSaveButton(String eleSaveButton) {
		waitTime(1);
		driver.findElement(By.name(eleSaveButton)).click();
	}
	
	public void clickSaveButton(ProjectData data) {
		this.clickSaveButton(data.eleSaveButton);
	}
	
	
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Toma mensaje al guardar para luego validar en tests
	public String saveMessage(Properties eleProp) {
		waitTime(3);
		return driver.findElement(By.id(eleProp.getProperty("eleRedSaveMessage"))).getText();
	}
	
	public String validaMensajeSaveMessage(Properties eleProp) {
		return eleProp.getProperty("valRedSaveMessage");
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void fillSearchBox(String eleSearchBox, String title) {
		waitTime(1);
		driver.findElement(By.name(eleSearchBox)).sendKeys(title);
	}
	
	public void fillSearchBox(ProjectData data) {
		this.fillSearchBox(data.eleSearchBox, data.title);
	}
	
	
	public void clickSearchButton(String eleSearchButton) {
		waitTime(1);
		driver.findElement(By.name(eleSearchButton)).click();
	}
	
	public void clickSearchButton(ProjectData data) {
		this.clickSaveButton(data.eleSearchButton);
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void chequearTodos(String eleChequearTodos) {
		waitTime(3);

		driver.findElement(By.name(eleChequearTodos)).click();
		waitTime(3);
	}
	
	public void eliminarChequeados(String eleDeletechequeados) {
		waitTime(3);
		
		driver.findElement(By.id(eleDeletechequeados)).click();
		waitTime(3);
	}
	
	public void chequearTodos(ProjectData data) {
		this.chequearTodos(data.eleChequearTodos);	
	}
	public void eliminarChequeados(ProjectData data) {
			this.eliminarChequeados(data.eleDeletechequeados);	
	}
	
	public void clickDelete(String title, String elePathBuscaEnTablaYDel1, String elePathBuscaEnTablaYDel2) {
		
		waitTime(3);
		driver.findElement(By.xpath(elePathBuscaEnTablaYDel1 + title.trim() + elePathBuscaEnTablaYDel2)).click();
	}
	
	public void clickDelete(ProjectData data) {
		this.clickDelete(data.title, data.elePathBuscaEnTablaYDel1, data.elePathBuscaEnTablaYDel2);	
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public String validaTitle(Properties eleProp) {
		waitTime(1);
		return driver.findElement(By.id(eleProp.getProperty("eleValidaTitle"))).getText();
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void clickView(String title, String elePathBuscaEnTablaYVer1, String elePathBuscaEnTablaYVer2) {
		
		waitTime(3);
		driver.findElement(By.xpath(elePathBuscaEnTablaYVer1 + title.trim() + elePathBuscaEnTablaYVer2)).click();
		waitTime(3);
	}
	
	public void clickView(ProjectData data) {
		this.clickView(data.title, data.elePathBuscaEnTablaYVer1, data.elePathBuscaEnTablaYVer2);	
	}
	
	
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// validaciones de info de proyecto

	public String proyectoViewValidaTitle(Properties eleProp) {

		return  driver.findElement(By.xpath(eleProp.getProperty("eleProyectoViewValidaTitle"))).getText();
	}
	
	

	public String proyectoViewValidaStartDate(Properties eleProp) {

		return driver.findElement(By.id(eleProp.getProperty("eleProyectoViewValidaStartDate"))).getText();
	}
	
	

	public String proyectoViewValidaEndDate(Properties eleProp) {

		return driver.findElement(By.id(eleProp.getProperty("eleProyectoViewValidaEndDate"))).getText();
	}
	
	

	public String proyectoViewValidaStatus(Properties eleProp) {

		return driver.findElement(By.xpath(eleProp.getProperty("eleProyectoViewValidaStatus"))).getText();
	}
	
	
	
	

}
