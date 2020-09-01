package suiteprueba;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class testcase2Test {
	
	@Tag("error")
	@Test
	public void test1() {
		
		System.out.println("testcase 2 prueba 1");	
		
	}
	@Tag("ok")
	@Test
	public void test2() {
		System.out.println("testcase 2 prueba 2");
	}

}


