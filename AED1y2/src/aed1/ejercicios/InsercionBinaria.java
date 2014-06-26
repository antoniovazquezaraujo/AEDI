package aed1.ejercicios;

public class InsercionBinaria {
	public static int searchAndInsert(int[] datos, int elemento, int max) {
		int inicio = 0;
		int fin = max;
		int medio = 0;
		while (inicio <= fin) {
			medio = (inicio + fin) / 2;
			if (datos[medio] < elemento) {
				inicio = medio + 1;
			} else if (datos[medio] > elemento) {
				fin = medio - 1;
			} else {
				return medio;
			}
		}
		for (int n = max - 1; n > medio; n--) {
			datos[n] = datos[n - 1];
		}
		datos[medio] = elemento;
		return medio;
	}

	public static void main(String[] args) {
		int[] n = { 1, 3, 5, 7, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		assert (searchAndInsert(n, 1, 5) == 0);
		assert (searchAndInsert(n, 2, 5) == 1);
		assert (searchAndInsert(n, 10, 6) == 6);
		assert (searchAndInsert(n, 14, 7) == 7);

		System.out.println("OK");

	}
}
