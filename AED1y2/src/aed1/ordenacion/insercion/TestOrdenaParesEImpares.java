package aed1.ordenacion.insercion;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import aed1.commons.Tools;

public class TestOrdenaParesEImpares {
	int[] datos = { 3, 5, 4, 6, 1, 33, 2, 8, 11 };
	OrdenaParesEImpares s;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		s = new OrdenaParesEImpares();
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	public void show(int[] datos) {
		for (int i = 0; i < datos.length; i++) {
			System.out.print(datos[i] + ", ");
		}
	}

	public static boolean sortedParImpar(int[] a) {
		for (int n = 0; n < a.length - 3; n += 2) {
			if (!(a[n] < a[n + 2])) {
				return false;
			}
			if (!(a[n + 1] > a[n + 3])) {
				return false;
			}
		}
		return true;
	}

	@Test
	public final void testSort() {
		assert !sortedParImpar(datos);
		show(datos);
		System.out.println();
		s.sort(datos);
		show(datos);
		assert sortedParImpar(datos);
	}
}
