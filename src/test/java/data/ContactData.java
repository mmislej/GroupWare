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
	
	public String eleClickAddContact;
	
	public String eleFn;
	public String elePrefix;
	public String eleGiven;
	public String eleMiddle;
	public String eleFamily;
	public String eleSuffix;
	public String eleOkButton;

	public String eleTitle;
	public String eleRole;
	public String eleRoom;

	public String eleName;
	public String eleUnit;
	public String eleStreet;
	public String eleLocality;
	public String elePostalcode;
	public String eleCountryname;

	public String eleWork;
	public String eleCell;
	public String eleHome1;

	public String eleUrl;
	public String eleHome2;
	public String eleEmail;
	public String eleEHome;
	
	public String eleSaveButtom2;
	
	public String pathVerContacto1;
	public String pathVerContacto2;
	public String pathVerContacto3;
	
	public String pathDelContacto1;
	public String pathDelContacto2;
	public String pathDelContacto3;
	

	// Constructor
	private ContactData(String a, String b, String c, String d, String e, String f, String g, String h, String i,
			String j, String k, String l, String m, String n, String o, String p, String q, String r, String s,
			String t, String u, String v, String eleA, String eleB, String eleC, String eleD, String eleE, 
			String eleF, String eleG, String eleH, String eleI, String eleJ, String eleK, String eleL, String eleM, 
			String eleN, String eleO, String eleP, String eleQ, String eleR, String eleS, String eleT, String eleU, 
			String eleV, String eleW, String eleX, String eleY, String eleZ, String eleAA, String eleAB, String eleAC) {

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
		
		this.eleClickAddContact = eleA;
		
		this.eleFn = eleB;
		this.elePrefix = eleC;
		this.eleGiven = eleD;
		this.eleMiddle = eleE;
		this.eleFamily = eleF;
		this.eleSuffix = eleG;
		this.eleOkButton = eleH;

		this.eleTitle = eleI;
		this.eleRole = eleJ;
		this.eleRoom = eleI;

		this.eleName = eleJ;
		this.eleUnit = eleK;
		this.eleStreet = eleL;
		this.eleLocality = eleM;
		this.elePostalcode = eleN;
		this.eleCountryname = eleO;
				 
		this.eleWork = eleP;
		this.eleCell = eleQ;
		this.eleHome1 = eleR;

		this.eleUrl = eleS;
		this.eleHome2 = eleT;
		this.eleEmail = eleU;
		this.eleEHome = eleV;
		
		this.eleSaveButtom2 = eleW;
	
		this.pathVerContacto1 = eleX;
		this.pathVerContacto2 = eleY;
		this.pathVerContacto3 = eleZ;
		
		this.pathDelContacto1 = eleAA;
		this.pathDelContacto2 = eleAB;
		this.pathDelContacto3 = eleAC;
	}

	// Selector de datos por Int
	public static ContactData get(int n, Properties prop, Properties eleProp) {
		ContactData data = new ContactData("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "");

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
		
		data.eleClickAddContact = eleProp.getProperty("eleClickAddContact");
		
		data.eleFn = eleProp.getProperty("eleFn");
		data.elePrefix = eleProp.getProperty("elePrefix");
		data.eleGiven = eleProp.getProperty("eleGiven");
		data.eleMiddle = eleProp.getProperty("eleMiddle");
		data.eleFamily = eleProp.getProperty("eleFamily");
		data.eleSuffix = eleProp.getProperty("eleSuffix");
		data.eleOkButton = eleProp.getProperty("eleOkButton");

		data.eleTitle = eleProp.getProperty("eleTitle");
		data.eleRole = eleProp.getProperty("eleRole");
		data.eleRoom = eleProp.getProperty("eleRoom");

		data.eleName = eleProp.getProperty("eleName");
		data.eleUnit = eleProp.getProperty("eleUnit");
		data.eleStreet = eleProp.getProperty("eleStreet");
		data.eleLocality = eleProp.getProperty("eleLocality");
		data.elePostalcode = eleProp.getProperty("elePostalcode");
		data.eleCountryname = eleProp.getProperty("eleCountryname");

		data.eleWork = eleProp.getProperty("eleWork");
		data.eleCell = eleProp.getProperty("eleCell");
		data.eleHome1 = eleProp.getProperty("eleHome1");

		data.eleUrl = eleProp.getProperty("eleUrl");
		data.eleHome2 = eleProp.getProperty("eleHome2");
		data.eleEmail = eleProp.getProperty("eleEmail");
		data.eleEHome = eleProp.getProperty("eleEHome");
		
		data.eleSaveButtom2 = eleProp.getProperty("eleSaveButtom2");
		
		data.pathVerContacto1 = eleProp.getProperty("pathVerContacto1");
		data.pathVerContacto2 = eleProp.getProperty("pathVerContacto2");
		data.pathVerContacto3 = eleProp.getProperty("pathVerContacto3");
		
		data.pathDelContacto1 = eleProp.getProperty("pathDelContacto1");
		data.pathDelContacto2 = eleProp.getProperty("pathDelContacto2");
		data.pathDelContacto3 = eleProp.getProperty("pathDelContacto3");

		return data;
	}
}
