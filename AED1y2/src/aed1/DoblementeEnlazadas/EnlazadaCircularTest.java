package aed1.DoblementeEnlazadas;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnlazadaCircularTest {
	EnlazadaCircular<Integer> lista;

	@Before
	public void setUp() throws Exception {
		lista = new EnlazadaCircular<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		lista = null;
	}

	@Test
	public void testEnlazadaCircular() {
		assertTrue(lista.getFin() == null);
	}

	@Test
	public void testContar() {
		lista.insertar(234);
		assertTrue(lista.contar(234) == 1);
		lista.insertar(234);
		assertTrue(lista.contar(234) == 2);
		lista.insertar(234);
		assertTrue(lista.contar(234) == 3);
		lista.insertar(234);
		assertTrue(lista.contar(234) == 4);
		lista.insertar(234);
		assertTrue(lista.contar(234) == 5);
	}

	@Test
	public void testPrimero() {
		lista.insertar(234);
		assertTrue(lista.primero() == 234);
		lista.insertar(123);
		assertTrue(lista.primero() == 234);
	}

	@Test
	public void testInsertar() {
		lista.insertar(234);
		assertTrue(lista.contar(234) == 1);
		lista.insertar(567);
		assertTrue(lista.contar(567) == 1);
		lista.insertar(567);
		assertTrue(lista.contar(567) == 2);
	}

	@Test
	public void testBorrarPrimero() {
		lista.insertar(234);
		assertTrue(!lista.isEmpty());
		lista.borrarPrimero();
		assertTrue(lista.isEmpty());
		lista.insertar(234);
		lista.insertar(234);
		lista.borrarPrimero();
		assertTrue(!lista.isEmpty());
		lista.borrarPrimero();
		assertTrue(lista.isEmpty());
	}
}
