package aed1.ordenacion.mergesort;

public class MergeSort {

	public static boolean arrayOrdenado(int[] v) {
		for (int n = 0; n < v.length - 1; n++) {
			if (v[n] > v[n + 1]) {
				return false;
			}
		}
		return true;
	}

	private static void merge(int[] a, int bajo, int medio, int alto) {
		int i = bajo;
		int finBajo = medio - 1;
		int j = medio;
		int k = 0;
		int[] tmp = new int[alto - bajo + 1];
		// va metiendo siempre el menor de los dos
		while ((i <= finBajo) && (j <= alto)) {
			if (a[i] <= a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}
		// mete los elementos que sobran
		while (i <= finBajo) {
			tmp[k++] = a[i++];
		}
		while (j <= alto) {
			tmp[k++] = a[j++];
		}
		// copia el resultado
		for (k = 0, i = bajo; i <= alto; i++, k++) {
			a[i] = tmp[k];
		}
	}

	public static void mergeSort(int[] a, int bajo, int alto) {
		if (bajo < alto) {
			int medio = (alto + bajo) / 2;
			mergeSort(a, bajo, medio);
			mergeSort(a, medio + 1, alto);
			merge(a, bajo, medio + 1, alto);
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 3, 5, 7, 6, 9, 1, 2, 3, 2, 1 };
		assert (!arrayOrdenado(a));
		mergeSort(a, 0, a.length - 1);
		assert (arrayOrdenado(a));
	}
}