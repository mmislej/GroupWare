package data;

import java.util.Properties;

public class ContactData {

	// Attributes

	public String prefix;
	public String first_name;
	public String middle_Name;
	public String last_name;
	public String suffix;

	public String title;
	public String role;
	public String room;
	public String organisation;
	public String department;
	public String street;
	public String postalCode;
	public String city;
	public String country;
	public String addressbook;
	

	public String business;
	public String mobile_phone;
	public String prIvate;
	public String url;
	public String privAte;
	public String e_mail;
	public String privatE;

	// Constructor
	private ContactData(String a, String b, String c, String d, String e, String f, String g, String h, String i,
			String j, String k, String l, String m, String n, String o, String p, String q, String r, String s,
			String t, String u, String v) {

		this.prefix = a;
		this.first_name = b;
		this.middle_Name = c;
		this.last_name = d;
		this.suffix = e;
		this.title = f;
		this.role = g;
		this.room = h;
		this.organisation = i;
		this.department = j;
		this.street = k;
		this.postalCode = o;
		this.city = l;
		this.country = m;
		this.addressbook = n;
		
		this.business = p;
		this.mobile_phone = q;
		this.prIvate = r;
		this.url = s;
		this.privAte = t;
		this.e_mail = u;
		this.privatE = v;
	}

	// Selector de datos por Int
	public static ContactData get(int n, Properties prop) {
		ContactData data = new ContactData("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "");

		data.prefix = prop.getProperty("prefix_" + n);
		data.first_name = prop.getProperty("first_name_" + n);
		data.middle_Name = prop.getProperty("middle_Name_" + n);
		data.last_name = prop.getProperty("last_name_" + n);
		data.suffix = prop.getProperty("suffix_" + n);
		data.title = prop.getProperty("title_" + n);
		data.role = prop.getProperty("role_" + n);
		data.room = prop.getProperty("room_" + n);
		data.organisation = prop.getProperty("organisation_" + n);
		data.department = prop.getProperty("department_" + n);
		data.street = prop.getProperty("street_" + n);
		data.city = prop.getProperty("city_" + n);
		data.country = prop.getProperty("country_" + n);
		data.addressbook = prop.getProperty("addressbook_" + n);
		data.postalCode = prop.getProperty("postalCode_" + n);
		data.business = prop.getProperty("business_" + n);
		data.mobile_phone = prop.getProperty("mobile_phone_" + n);
		data.prIvate = prop.getProperty("prIvate_" + n);
		data.url = prop.getProperty("url_" + n);
		data.privAte = prop.getProperty("privAte_" + n);
		data.e_mail = prop.getProperty("e_mail_" + n);
		data.privatE = prop.getProperty("privatE_" + n);

		return data;
	}
}
