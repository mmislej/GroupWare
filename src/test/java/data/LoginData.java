package data;

import java.util.Properties;

//Clase biblioteca con datos de usuarios

public class LoginData {
	public String usuario;
	public String contraseña;
	
	public String eleUsuario;
	public String eleContraseña;
	public String eleLogin;
	public String eleLogout;
	public String eleLogoutMessage;
	public String eleTopmenu;
	public String eleBotonProyecto;
	public String validaProyectPage;
	public String eleValidaProyect;
	
	public String eleBotonAgenda;
	public String validaAgendaPage;
	public String stringEsperadoAgenda;
	
	// Constructor
	private LoginData(String u, String c, String eleU, String eleC, String eleL, String eleOut, String eleOutMes, String eleTopM, String eleBotP, 
			String valiProPage, String eleValP, String elebotAge, String valAgePag, String StrEspAge) {
		
		this.usuario = u;
		this.contraseña = c;
		this.eleUsuario = eleU;
		this.eleContraseña = eleC;
		this.eleLogin = eleL;
		this.eleLogout = eleOut;
		this.eleLogoutMessage = eleOutMes;
		this.eleTopmenu = eleTopM;
		this.eleBotonProyecto= eleBotP;
		this.validaProyectPage= valiProPage;
		this.eleValidaProyect= eleValP;
		
		this.eleBotonAgenda = elebotAge;
		this.validaAgendaPage =  valAgePag;
		this.stringEsperadoAgenda = StrEspAge;
	}

	// selector de datos por int
	public static LoginData get(int n, Properties prop, Properties eleProp) {
		LoginData data = new LoginData("", "", "", "", "", "", "", "", "", "", "", "", "", "");
		data.usuario = prop.getProperty("user" + n);
		data.contraseña = prop.getProperty("pass" + n);
		
		data.eleUsuario = eleProp.getProperty("eleUsuario");
		data.eleContraseña = eleProp.getProperty("elePass");
		data.eleLogin = eleProp.getProperty("eleLogin");
		
		data.eleLogout = eleProp.getProperty("eleLogout");
		data.eleLogoutMessage = eleProp.getProperty("eleLogoutMessage");
		data.eleTopmenu = eleProp.getProperty("eleTopmenu");
		
		data.eleBotonProyecto = eleProp.getProperty("eleBotonProyecto");
		data.validaProyectPage = eleProp.getProperty("validaProyectPage");
		data.eleValidaProyect = eleProp.getProperty("eleValidaProyect");
		
		data.eleBotonAgenda = eleProp.getProperty("eleBotonAgenda");
		data.validaAgendaPage = eleProp.getProperty("validaAgendaPage");
		data.stringEsperadoAgenda = eleProp.getProperty("stringEsperadoAgenda");
		
		return data;
	}

}
