package aed1.ordenacion.seleccion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSeleccion {
	int[][] datos = { { 3, 2, 4 }, { 6, 7, 1 }, { 9, 11, 14 } };
	Seleccion s;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		s = new Seleccion();
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	public boolean sorted(int[][] a) {
		for (int fila = 0; fila < a.length - 1; fila++) {
			for (int col = 0; col < a.length - 1; col++) {
				if (!(a[fila][col] < a[fila][col + 1])) {
					return false;
				}
			}
		}
		return true;
	}

	@Test
	public final void testSort() {
		assert !sorted(datos);
		s.sort(datos);
		assert sorted(datos);
	}

}
