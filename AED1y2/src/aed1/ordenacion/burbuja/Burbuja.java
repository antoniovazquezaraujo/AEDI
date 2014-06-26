package aed1.ordenacion.burbuja;

import aed1.commons.Tools;

public class Burbuja {
	public static void sort(int[] aux) {
		for (int pasada = 0; pasada < aux.length - 1; pasada++) {
			for (int j = 0; j < (aux.length - pasada - 1); j++) {
				if (aux[j] > aux[j + 1]) {
					int temp = aux[j];
					aux[j] = aux[j + 1];
					aux[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 3, 4, 34, 2, 1, 6 };
		sort(a);
		assert (Tools.sorted(a));
		System.out.println("OK");
	}
}
