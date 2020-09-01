package suiteprueba;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;


//Norma para uso: clases de prueba con Test al final y Metodos comienzan con test
@RunWith(JUnitPlatform.class)
@SelectClasses({
	suiteprueba.testcase1Test.class,
	suiteprueba.testcase2Test.class
})

public class testSuitePorClase {
	


}
