package aed1.ordenacion.insercion;

import aed1.commons.Tools;

public class Insercion {
	public static void sort(int[] aux) {
		for (int i = 1; i < aux.length; i++) {
			int elem = aux[i];
			int j = (i - 1);

			while ((j >= 0) && (elem < aux[j])) {
				aux[j + 1] = aux[j--];
			}
			aux[j + 1] = elem;
		}
	}

	public static void main(String[] args) {
		int[] a = { 3, 4, 34, 2, 1, 6 };
		sort(a);
		assert (Tools.sorted(a));
		System.out.println("OK");
	}

}
