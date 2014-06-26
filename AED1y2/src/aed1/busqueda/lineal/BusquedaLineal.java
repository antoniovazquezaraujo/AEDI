package aed1.busqueda.lineal;

public class BusquedaLineal {

	static int buscar(int a, int datos[]) {
		int i;
		for (i = 0; i < datos.length && datos[i] != a; i++) {

		}
		if (i == datos.length) {
			return -1;
		} else {
			return i;
		}
	}

	static int buscar2(int a, int datos[]) {
		int i;
		for (i = 0; i < datos.length && datos[i] != a; i++) {

		}
		if (i == datos.length) {
			return -1;
		} else {
			return i;
		}
	}

	public static void main(String[] args) {
		int datos[] = { 1, 2, 3, 4, 3, 2, 3, 5, 6 };
		assert (buscar(3, datos) != -1);
		assert (buscar(333, datos) == -1);
		System.out.println("OK");
	}
}
