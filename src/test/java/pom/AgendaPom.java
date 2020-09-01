package pom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;

import data.ContactData;
import data.MemberData;

public class AgendaPom extends BasePom {
	
	public String parentWinHandle;

	public AgendaPom() {
		open();
		assertEquals("Addressbook", driver.findElement(By.id("divAppboxHeader")).getText());
	}

	public String cambioAgenda() {

		parentWinHandle = driver.getWindowHandle();
		waitTime(3);
		System.out.println("Primera "+parentWinHandle);
		driver.findElement(By.id("exec[nm][add]")).click();
		waitTime(3);
		Set<String> winHandles = driver.getWindowHandles();
		
		System.out.println("Cantidad de ventanas "+ winHandles.size());
		// Loop through all handles
		for (String handle : winHandles) {
			System.out.println("Segunda "+winHandles);
			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);
			}
		}
		

		waitTime(3);
		return parentWinHandle;
	}
	public void cambioAgendaRetorno() {
		//parentWinHandle = parentWinHandle;// +"&msg=Contact+saved";
		System.out.println("Al salir "+parentWinHandle);
		driver.switchTo().window(parentWinHandle);
		

	}

	// trae datos de la clase AgendaData
	public void contactDataCompleta(ContactData data) {
		this.contactDataCompleta(data.prefix, data.first_name, data.middle_Name, data.last_name, data.suffix,
				data.title, data.role, data.room, data.organisation, data.department, data.street, data.city, data.postalCode,
				data.country, data.addressbook, data.business, data.mobile_phone, data.prIvate, data.url,
				data.privAte, data.e_mail, data.privatE);
	}

	private void contactDataCompleta(String prefix, String first_name, String middle_Name, String last_name,
			String suffix, String title, String role, String room, String organisation, String department,
			String street, String city, String postalCode, String country, String addressbook, String business,
			String mobile_phone, String prIvate, String url, String privAte, String e_mail, String privatE) {
		
		waitTime(3);
		
		driver.findElement(By.name("exec[n_fn]")).click();
		driver.findElement(By.name("exec[n_prefix]")).sendKeys(prefix);
		driver.findElement(By.name("exec[n_given]")).sendKeys(first_name);
		driver.findElement(By.name("exec[n_middle]")).sendKeys(middle_Name);
		driver.findElement(By.name("exec[n_family]")).sendKeys(last_name);
		driver.findElement(By.name("exec[n_suffix]")).sendKeys(suffix);
		driver.findElement(By.xpath("//*[@id=\"addressbook.edit.general\"]//table[@class=\"editname\"]//*[@id=\"exec[]\"]")).click();
		
		System.out.println("Bloque 1");
		
		waitTime(3);
		driver.findElement(By.name("exec[title]")).sendKeys(title);
		driver.findElement(By.name("exec[role]")).sendKeys(role);
		driver.findElement(By.name("exec[room]")).sendKeys(room);
		
		System.out.println("Bloque 2");
		
		driver.findElement(By.name("exec[org_name]")).sendKeys(organisation);
		driver.findElement(By.name("exec[org_unit]")).sendKeys(department);
		driver.findElement(By.name("exec[adr_one_street]")).sendKeys(street);
		driver.findElement(By.name("exec[adr_one_locality]")).sendKeys(city);
		driver.findElement(By.name("exec[adr_one_postalcode]")).sendKeys(postalCode);
		driver.findElement(By.name("exec[adr_one_countryname]")).sendKeys(country);
		//driver.findElement(By.name("exec[member][1]")).sendKeys(addressbook);
		
		System.out.println("Bloque 3");
		
		driver.findElement(By.name("exec[tel_work]")).sendKeys(business);
		driver.findElement(By.name("exec[tel_cell]")).sendKeys(mobile_phone);
		driver.findElement(By.name("exec[tel_home]")).sendKeys(prIvate);
		
		System.out.println("Bloque 4");
		
		driver.findElement(By.name("exec[url]")).sendKeys(url);
		driver.findElement(By.name("exec[url_home]")).sendKeys(privAte);
		driver.findElement(By.name("exec[email]")).sendKeys(e_mail);
		driver.findElement(By.name("exec[email_home]")).sendKeys(privatE);
		
		System.out.println("Bloque 5");
		
		waitTime(3);
		driver.findElement(By.name("exec[button][save]")).click();
		
		System.out.println("Termina");
	}	
	

	//toma mensaje 
	public String messageSaved() {
		
		return driver.findElement(By.id("msg")).getText();
		
	}
	
	/*public void cambioAgenda() {

		String parentWinHandle = driver.getWindowHandle();
		waitTime(3);
		driver.findElement(By.id("exec[nm][add]")).click();
		waitTime(3);
		Set<String> winHandles = driver.getWindowHandles();
		// Loop through all handles
		for (String handle : winHandles) {
			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);
			}
		}
		driver.findElement(By.id("exec[n_fn]")).click();
		driver.findElement(By.id("exec[n_given]")).sendKeys("test");
		waitTime(5);
	}*/

}
