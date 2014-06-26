package aed1.busqueda.binaria;

public class Binaria {
	public static int search(int elemento, int[] datos) {
		int inicio = 0;
		int fin = datos.length - 1;
		int medio;
		while (inicio <= fin) {
			medio = (inicio + fin) / 2;
			if (datos[medio] < elemento)
				inicio = medio + 1;
			else if (datos[medio] > elemento)
				fin = medio - 1;
			else
				return medio;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] n = { 1, 3, 5, 7, 9 };
		assert (search(1, n) != -1);
		assert (search(3, n) != -1);
		assert (search(5, n) != -1);
		assert (search(7, n) != -1);
		assert (search(9, n) != -1);
		for (int i = 0; i < 100; i++) {
			assert (search(10 + i, n) == -1);
		}
		System.out.println("OK");
	}
}
