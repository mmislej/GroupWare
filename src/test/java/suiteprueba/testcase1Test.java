package suiteprueba;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class testcase1Test {
	@Tag("ok")
	@Test
	public void test1() {
		
		System.out.println("testcase 1 prueba 1");	
		
	}
	@Tag("error")
	@Test
	public void test2() {
		System.out.println("testcase 1 prueba 2");
	}

}
