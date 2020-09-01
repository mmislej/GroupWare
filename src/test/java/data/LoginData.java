package data;

import java.util.Properties;

//Clase biblioteca con datos de usuarios

public class LoginData {
	public String usuario;
	public String contraseña;

	// Constructor
	private LoginData(String u, String c) {
		this.usuario = u;
		this.contraseña = c;

	}

	// selector de datos por int
	public static LoginData get(int n, Properties prop) {
		LoginData data = new LoginData("", "");
		data.usuario = prop.getProperty("user" + n);
		data.contraseña = prop.getProperty("pass" + n);

		return data;
	}

}
