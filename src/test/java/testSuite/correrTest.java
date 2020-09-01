package testSuite;



import java.util.Properties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import config.Config;

public class correrTest {
	
	static Properties props;
	
	@BeforeAll
	public static void beforeAll() {
		props = Config.get(Config.CASOS_LOGIN);
		
	}
	


	@Test
	public void syso() {
	
		Properties props = Config.get(Config.GENERAL);
		System.out.println(props.getOrDefault("Browser", "No recibió Browser"));
	}
	
	@Test
	public void syso2() {
	
		
		System.out.println(props.getOrDefault("Nombre1", "No hay nombre"));
	}
	@Test
	public void syso3() {
	
		
		System.out.println(props.getOrDefault("Nombre2", "No hay nombre"));
	}
}

