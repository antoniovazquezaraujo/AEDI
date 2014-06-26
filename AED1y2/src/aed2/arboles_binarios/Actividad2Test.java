package aed2.arboles_binarios;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import arbolBinario.ArbolBinario;
import arbolBinario.EnlazadoArbolBinario;

public class Actividad2Test {
	ArbolBinario<Integer> arbol;

	@Before
	public void setUp() throws Exception {
		arbol = new EnlazadoArbolBinario<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		arbol = null;
	}

	@Test
	public void testSumaElementos() {
		assert (Actividad2.sumaElementos(arbol) == 0);
	}

	@Test
	public void testNumNodos() {
		fail("Not yet implemented");
	}

	@Test
	public void testPromedio() {
		fail("Not yet implemented");
	}

	@Test
	public void testCopia() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumHojas() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarHojas() {
		fail("Not yet implemented");
	}

	@Test
	public void testFrontera() {
		fail("Not yet implemented");
	}

	@Test
	public void testReconstruir() {
		fail("Not yet implemented");
	}

	@Test
	public void testReconstruir2() {
		fail("Not yet implemented");
	}

	@Test
	public void testIdenticos() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompleto() {
		fail("Not yet implemented");
	}

	@Test
	public void testPodar() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsCamino() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisualizarNivel() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisualizarPalabras() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsBusqueda() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsMonton() {
		fail("Not yet implemented");
	}

	@Test
	public void testArbolExpresion() {
		fail("Not yet implemented");
	}

	@Test
	public void testMisterio() {
		fail("Not yet implemented");
	}

	@Test
	public void testPreorden() {
		fail("Not yet implemented");
	}

	@Test
	public void testInorden() {
		fail("Not yet implemented");
	}

	@Test
	public void testPostorden() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
