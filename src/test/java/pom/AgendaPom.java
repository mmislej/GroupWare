package pom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;

import data.ContactData;
import data.MemberData;

public class AgendaPom extends BasePom {

	public String parentWinHandle;

	public AgendaPom() {
		open();
		assertEquals("Addressbook [mmislej] mmislej User", driver.findElement(By.id("divAppboxHeader")).getText());
	}

	public String cambioAgenda() {

		parentWinHandle = driver.getWindowHandle();
		waitTime(3);

		driver.findElement(By.id("exec[nm][add]")).click();
		waitTime(3);
		Set<String> winHandles = driver.getWindowHandles();

		System.out.println("Cantidad de ventanas " + winHandles.size());
		// Loop through all handles
		for (String handle : winHandles) {

			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);
			}
		}

		waitTime(3);
		return parentWinHandle;
	}

	public void cambioAgendaRetorno() {

		driver.switchTo().window(parentWinHandle);

	}

	public void eliminarContacto(String first_name, String last_name) {
		waitTime(3);

		driver.findElement(By.xpath("//*[@id=\"exec[nm][rows][1][id]\"]/tbody/tr[1]/td/span[text()='" + last_name.trim()
				+ ", " + first_name.trim() + "']/../../../../../../td[6]/table/tbody/tr/td/a/img[@title=\"Delete\"]"))
				.click();

	}

	public void eliminarContacto(ContactData data) {
		this.eliminarContacto(data.first_name, data.last_name);

	}

	public void verContacto(String first_name, String last_name) {
		waitTime(3);
		parentWinHandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//*[@id=\"exec[nm][rows][1][id]\"]/tbody/tr[1]/td/span[text()='" + last_name.trim()
				+ ", " + first_name.trim() + "']/../../../../../../td[6]/table/tbody/tr/td/a/img[@title=\"View\"]"))
				.click();

	}

	public void verContacto(ContactData data) {
		this.verContacto(data.first_name, data.last_name);
	}

	public String validarVentanaEmergente() {
		return driver.findElement(By.id("addressbook.edit.general-tab")).getText();

	}

	public String validarContacto() {
		waitTime(3);
		return driver.findElement(By.xpath("//*[@id=\"divAppbox\"]/table/tbody/tr/td/form[1]/div/table/tbody/tr[1]/td[1]")).getText();
	}

	public void validaSave() {
		driver.findElement(By.id("exec[button][save]")).getText();
	}

	public void buscarContacto(String first_name) {
		waitTime(3);

		driver.findElement(By.name("exec[nm][search]")).sendKeys(first_name);
		driver.findElement(By.name("exec[nm][start_search]")).click();

	}

	public void buscarContacto(ContactData data) {
		this.buscarContacto(data.first_name);
	}

	// trae datos de la clase AgendaData
	public void contactDataCompleta(ContactData data) {
		this.contactDataCompleta(data.prefix, data.first_name, data.middle_Name, data.last_name, data.suffix,
				data.title, data.role, data.room, data.organisation, data.department, data.street, data.city,
				data.postalCode, data.country, data.addressbook, data.business, data.mobile_phone, data.prIvate,
				data.url, data.privAte, data.e_mail, data.privatE);
	}

	private void contactDataCompleta(String prefix, String first_name, String middle_Name, String last_name,
			String suffix, String title, String role, String room, String organisation, String department,
			String street, String city, String postalCode, String country, String addressbook, String business,
			String mobile_phone, String prIvate, String url, String privAte, String e_mail, String privatE) {

		waitTime(3);

		driver.findElement(By.name("exec[n_fn]")).click();
		driver.findElement(By.name("exec[n_prefix]")).sendKeys(prefix.trim());
		driver.findElement(By.name("exec[n_given]")).sendKeys(first_name.trim());
		driver.findElement(By.name("exec[n_middle]")).sendKeys(middle_Name.trim());
		driver.findElement(By.name("exec[n_family]")).sendKeys(last_name.trim());
		driver.findElement(By.name("exec[n_suffix]")).sendKeys(suffix.trim());
		driver.findElement(
				By.xpath("//*[@id=\"addressbook.edit.general\"]//table[@class=\"editname\"]//*[@id=\"exec[]\"]"))
				.click();

		waitTime(3);
		driver.findElement(By.name("exec[title]")).sendKeys(title);
		driver.findElement(By.name("exec[role]")).sendKeys(role);
		driver.findElement(By.name("exec[room]")).sendKeys(room);

		driver.findElement(By.name("exec[org_name]")).sendKeys(organisation);
		driver.findElement(By.name("exec[org_unit]")).sendKeys(department);
		driver.findElement(By.name("exec[adr_one_street]")).sendKeys(street);
		driver.findElement(By.name("exec[adr_one_locality]")).sendKeys(city);
		driver.findElement(By.name("exec[adr_one_postalcode]")).sendKeys(postalCode);
		driver.findElement(By.name("exec[adr_one_countryname]")).sendKeys(country);

		driver.findElement(By.name("exec[tel_work]")).sendKeys(business);
		driver.findElement(By.name("exec[tel_cell]")).sendKeys(mobile_phone);
		driver.findElement(By.name("exec[tel_home]")).sendKeys(prIvate);

		driver.findElement(By.name("exec[url]")).sendKeys(url);
		driver.findElement(By.name("exec[url_home]")).sendKeys(privAte);
		driver.findElement(By.name("exec[email]")).sendKeys(e_mail);
		driver.findElement(By.name("exec[email_home]")).sendKeys(privatE);

		waitTime(3);
		driver.findElement(By.name("exec[button][save]")).click();

	}

	// toma mensaje
	public String redMessage() {
		waitTime(3);
		return driver.findElement(By.id("msg")).getText();

	}

}
