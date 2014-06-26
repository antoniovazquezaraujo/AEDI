package aed1.busqueda.lineal;

public class Lineal {
	public static int search(int elemento, int[] datos) {
		int i = 0;
		int n = datos.length - 1;
		while (i < n && datos[i] != elemento) {
			i++;
		}
		if (datos[i] == elemento) {
			return i;
		} else {
			return -1;
		}
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
