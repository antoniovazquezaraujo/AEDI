package aed1.ordenacion.insercion;

public class OrdenaParesEImpares {
	public static void sort(int[] aux) {
		for (int i = 1; i < aux.length; i += 2) {
			int elem = aux[i];
			int j = (i - 2);

			while ((j >= 0) && (elem > aux[j])) {
				aux[j + 2] = aux[j];
				j -= 2;
			}
			aux[j + 2] = elem;
		}
		for (int i = 0; i < aux.length; i += 2) {
			int elem = aux[i];
			int j = (i - 2);

			while ((j >= 0) && (elem < aux[j])) {
				aux[j + 2] = aux[j];
				j -= 2;
			}
			aux[j + 2] = elem;
		}
	}
}
