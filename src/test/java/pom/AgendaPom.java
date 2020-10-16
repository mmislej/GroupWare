package pom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;

import data.ContactData;
import data.MemberData;
import data.ProjectData;

public class AgendaPom extends BasePom {

	public String parentWinHandle;

	public AgendaPom() {
		open();
		assertEquals("Addressbook [mmislej] mmislej User", driver.findElement(By.id("divAppboxHeader")).getText());
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public String parentHandle() {
		parentWinHandle = driver.getWindowHandle();
		waitTime(3);
		return parentWinHandle;
	}

	public void clickAddContact(String eleClickAddContact) {
		driver.findElement(By.id("exec[nm][add]")).click();
		waitTime(3);

	}

	public void clickAddContact(ContactData data) {
		this.clickAddContact(data.eleClickAddContact);
	}

	public void switchHandle() {

		Set<String> winHandles = driver.getWindowHandles();

		// Loop through all handles
		for (String handle : winHandles) {

			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}

	public String valPopUp(Properties eleProp) {
		waitTime(1);
		return eleProp.getProperty("valGeneral");
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void cambioAgendaRetorno() {

		driver.switchTo().window(parentWinHandle);

	}

	public void eliminarContacto(String first_name, String last_name, String pathDelContacto1, String pathDelContacto2,
			String pathDelContacto3) {
		waitTime(3);

		driver.findElement(
				By.xpath(pathDelContacto1 + last_name.trim() + pathDelContacto2 + first_name.trim() + pathDelContacto3))
				.click();

	}

	public void eliminarContacto(ContactData data) {
		this.eliminarContacto(data.first_name, data.last_name, data.pathDelContacto1, data.pathDelContacto2,
				data.pathDelContacto3);

	}

	public void verContacto(String first_name, String last_name, String pathVerContacto1, String pathVerContacto2,
			String pathVerContacto3) {

		waitTime(3);
		driver.findElement(
				By.xpath(pathVerContacto1 + last_name.trim() + pathVerContacto2 + first_name.trim() + pathVerContacto3))
				.click();

	}

	public void verContacto(ContactData data) {
		this.verContacto(data.first_name, data.last_name, data.pathVerContacto1, data.pathVerContacto2,
				data.pathVerContacto3);
	}

	public String validarVentanaEmergente(Properties eleProp) {
		return driver.findElement(By.id(eleProp.getProperty("tabGeneral"))).getText();

	}

	public String validarContacto(Properties eleProp) {
		waitTime(3);
		return driver.findElement(By.xpath(eleProp.getProperty("eleValidarContacto"))).getText();
	}

	public String valRedMessage(Properties eleProp) {
		waitTime(1);
		return eleProp.getProperty("valRedMessageCD");
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	

//--	
	public void clickNameBox(String eleFn) {//
		waitTime(1);
		driver.findElement(By.name(eleFn)).click();
	}

	public void clickNameBox(ContactData data) {//
		this.clickNameBox(data.eleFn);
	}

//---	
	public void ingresaPrefix(String elePrefix, String prefix) {//
		waitTime(1);
		driver.findElement(By.name(elePrefix)).sendKeys(prefix.trim());
	}

	public void ingresaPrefix(ContactData data) {
		this.ingresaPrefix(data.elePrefix, data.prefix);
	}

//---	
	public void ingresaFirstName(String eleGiven, String first_name) {//
		waitTime(1);
		driver.findElement(By.name(eleGiven)).sendKeys(first_name.trim());
	}

	public void ingresaFirstName(ContactData data) {
		this.ingresaFirstName(data.eleGiven, data.first_name);
	}

//---	
	public void ingresaMiddleName(String eleMiddle, String middle_Name) {//
		waitTime(1);
		driver.findElement(By.name(eleMiddle)).sendKeys(middle_Name.trim());
	}

	public void ingresaMiddleName(ContactData data) {
		this.ingresaMiddleName(data.eleMiddle, data.middle_Name);
	}

//---	
	public void ingresaLastName(String eleFamily, String last_name) {//
		waitTime(1);
		driver.findElement(By.name(eleFamily)).sendKeys(last_name.trim());
	}

	public void ingresaLastName(ContactData data) {
		this.ingresaLastName(data.eleFamily, data.last_name);
	}

//---	
	public void ingresaSuffix(String eleSuffix, String suffix) {
		waitTime(1);
		driver.findElement(By.name(eleSuffix)).sendKeys(suffix.trim());
	}

	public void ingresaSuffix(ContactData data) {
		this.ingresaSuffix(data.eleSuffix, data.suffix);
	}

//---	
	public void clickOkButton(String eleOkButton) {
		waitTime(1);
		driver.findElement(By.xpath(eleOkButton)).click();
	}

	public void clickOkButton(ContactData data) {
		this.clickOkButton(data.eleOkButton);
	}

//---
	public void ingresaTitle(String eleTitle, String title) {
		waitTime(1);
		driver.findElement(By.name(eleTitle)).sendKeys(title);
	}

	public void ingresaTitle(ContactData data) {
		this.ingresaTitle(data.eleTitle, data.title);
	}

//---
	public void ingresaRole(String eleRole, String role) {
		waitTime(1);
		driver.findElement(By.name(eleRole)).sendKeys(role);
	}

	public void ingresaRole(ContactData data) {
		this.ingresaRole(data.eleRole, data.role);
	}

//---
	public void ingresaRoom(String eleRoom, String room) {
		waitTime(1);
		driver.findElement(By.name(eleRoom)).sendKeys(room);
	}

	public void ingresaRoom(ContactData data) {
		this.ingresaRoom(data.eleRoom, data.room);
	}

//----
	public void ingresaOrganization(String eleName, String organisation) {
		waitTime(1);
		driver.findElement(By.name(eleName)).sendKeys(organisation);
	}

	public void ingresaOrganization(ContactData data) {
		this.ingresaOrganization(data.eleName, data.organisation);
	}

//---
	public void ingresaDepartament(String eleUnit, String department) {
		waitTime(1);
		driver.findElement(By.name(eleUnit)).sendKeys(department);
	}

	public void ingresaDepartament(ContactData data) {
		this.ingresaDepartament(data.eleUnit, data.department);
	}

//---
	public void ingresaStreet(String eleStreet, String street) {
		waitTime(1);
		driver.findElement(By.name(eleStreet)).sendKeys(street);
	}

	public void ingresaStreet(ContactData data) {
		this.ingresaStreet(data.eleStreet, data.street);
	}

//---
	public void ingresaCity(String eleLocality, String city) {
		waitTime(1);
		driver.findElement(By.name(eleLocality)).sendKeys(city);
	}

	public void ingresaCity(ContactData data) {
		this.ingresaCity(data.eleLocality, data.city);
	}

//---	
	public void ingresaPostalCode(String elePostalcode, String postalCode) {
		waitTime(1);
		driver.findElement(By.name(elePostalcode)).sendKeys(postalCode);
	}

	public void ingresaPostalCode(ContactData data) {
		this.ingresaPostalCode(data.elePostalcode, data.postalCode);
	}

//---
	public void ingresaCountry(String eleCountryname, String country) {
		waitTime(1);
		driver.findElement(By.name(eleCountryname)).sendKeys(country);
	}

	public void ingresaCountry(ContactData data) {
		this.ingresaCountry(data.eleCountryname, data.country);
	}

	public void ingresaWork(String eleWork, String business) {
		waitTime(1);
		driver.findElement(By.name(eleWork)).sendKeys(business);
	}

	public void ingresaWork(ContactData data) {
		this.ingresaWork(data.eleWork, data.business);
	}

//---	
	public void ingresaCellPhone(String eleCell, String mobile_phone) {
		waitTime(1);
		driver.findElement(By.name(eleCell)).sendKeys(mobile_phone);
	}

	public void ingresaCellPhone(ContactData data) {
		this.ingresaCellPhone(data.eleCell, data.mobile_phone);
	}

//---
	public void ingresaPhone(String eleHome1, String prIvate) {
		waitTime(1);
		driver.findElement(By.name(eleHome1)).sendKeys(prIvate);
	}

	public void ingresaPhone(ContactData data) {
		this.ingresaPhone(data.eleHome1, data.prIvate);
	}

//---
	public void ingresaUrl(String eleUrl, String url) {
		waitTime(1);
		driver.findElement(By.name(eleUrl)).sendKeys(url);
	}

	public void ingresaUrl(ContactData data) {
		this.ingresaUrl(data.eleUrl, data.url);
	}

//---
	public void ingresaUrlHome(String eleHome2, String privAte) {
		waitTime(1);
		driver.findElement(By.name(eleHome2)).sendKeys(privAte);
	}

	public void ingresaUrlHome(ContactData data) {
		this.ingresaUrlHome(data.eleHome2, data.privAte);
	}

//---
	public void ingresaEmail(String eleEmail, String e_mail) {
		waitTime(1);
		driver.findElement(By.name(eleEmail)).sendKeys(e_mail);
	}

	public void ingresaEmail(ContactData data) {
		this.ingresaEmail(data.eleEmail, data.e_mail);
	}

//---
	public void ingresaHomeEmail(String eleEHome, String privatE) {
		waitTime(1);
		driver.findElement(By.name(eleEHome)).sendKeys(privatE);
	}

	public void ingresaHomeEmail(ContactData data) {
		this.ingresaHomeEmail(data.eleEHome, data.privatE);
	}

//---	
	public void clickSaveButtom(String eleSaveButtom2) {
		waitTime(1);
		driver.findElement(By.name(eleSaveButtom2)).click();
	}

	public void clickSaveButtom(ContactData data) {
		this.clickSaveButtom(data.eleSaveButtom2);
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------	

	// toma mensaje
	public String redMessage(Properties eleProp) {
		waitTime(3);
		return driver.findElement(By.id(eleProp.getProperty("eleRedSaveMessage"))).getText();

	}

	public String validaMensajeSaveMessage(Properties eleProp) {
		return eleProp.getProperty("valRedSaveMessage2");
	}

}
