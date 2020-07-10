package data;

public class LoginData {
	public String usuario;
	public String contraseña;

	private LoginData(String u, String c) {
		this.usuario = u;
		this.contraseña = c;

	}

	public static LoginData get(int test) {
		LoginData data = new LoginData("", "");
		switch (test) {
		case 1:
			data.usuario = "mmislej";
			data.contraseña = "mmislej";
			break;
		case 2:
			data.usuario = "dcurbelo";
			data.contraseña = "dcurbelo";
			break;

		}

		return data;
	}

}
