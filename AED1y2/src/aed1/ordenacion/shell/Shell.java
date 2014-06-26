package aed1.ordenacion.shell;

import aed1.commons.Tools;

public class Shell {
	public static void sort(int[] array) {
		int intervalo = array.length / 2;
		while (intervalo > 0) {
			for (int i = intervalo; i < array.length; i++) {
				int rightElement = array[i];
				int leftPos = i - intervalo;
				while ((leftPos > -1) && (rightElement < array[leftPos])) {
					array[leftPos + intervalo] = array[leftPos];
					leftPos -= intervalo;
				}
				array[leftPos + intervalo] = rightElement;
			}
			intervalo /= 2;
		}
	}

	public static void main(String[] args) {
		int[] a = { 3, 4, 34, 2, 1, 6 };
		sort(a);
		assert (Tools.sorted(a));
		System.out.println("OK");
	}
}
