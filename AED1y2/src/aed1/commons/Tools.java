package aed1.commons;

public class Tools {
	public static boolean sorted(int[] a) {
		for (int n = 0; n < a.length - 1; n++) {
			if (!(a[n] < a[n + 1])) {
				return false;
			}
		}
		return true;
	}

	public static boolean sorted(int[][] a) {
		for (int fila = 0; fila < a.length - 1; fila++) {
			for (int col = 0; col < a.length - 1; col++) {
				if (!(a[fila][col] < a[fila][col + 1])) {
					return false;
				}
			}
		}
		return true;
	}

}
