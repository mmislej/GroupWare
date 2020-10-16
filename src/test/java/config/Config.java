package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class Config {

	public final static String GENERAL = "src\\test\\resources\\config.properties";
	public final static String CASOS_LOGIN = "src\\test\\resources\\casos_login.properties";
	public final static String CASOS_ALTAPROYECTO = "src\\test\\resources\\casos_altaProyecto.properties";
	public final static String CASOS_AGREGARMIEMBRO = "src\\test\\resources\\casos_agregarMiembro.properties";
	public final static String CASOS_AGREGARCONTACTO = "src\\test\\resources\\casos_agregarContacto.properties";
	public final static String ELEMENTOS = "src\\test\\resources\\elementos.properties";
	
	private static Map<String, Properties> cache = new LinkedHashMap();

	public static Properties get(String s) {

		Properties prop = cache.get(s);
		if (prop == null) {
			
			prop = new Properties();
			
			try {
				
				InputStream input = new FileInputStream(s);
				prop.load(input);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cache.put(s,prop);

		}

		return prop;
	}

}
