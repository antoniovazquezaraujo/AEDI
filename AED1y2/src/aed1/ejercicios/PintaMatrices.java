package aed1.ejercicios;

public class PintaMatrices {
	public static void rellenar(int[][] matriz, int columna, int fila,
			int nuevoColor) {
		int col = columna;
		int color = matriz[fila][col];
		int colorMatriz = matriz[fila][col];
		do {
			colorMatriz = matriz[fila][col];
			matriz[fila][col] = nuevoColor;
			col++;
		} while (colorMatriz == color && col < matriz[0].length);

		int f = fila;
		col = columna;
		do {
			matriz[f][col] = nuevoColor;
			f++;
			colorMatriz = matriz[f][col];
		} while (colorMatriz == color && f < matriz.length);
	}

	public static void llenar(int datos[][]) {
		for (int n = 0; n < datos.length; n++) {
			for (int m = 0; m < datos[n].length; m++) {
				datos[n][m] = n / 2 % 8;
			}
		}
	}

	public static void mostrar(int datos[][]) {
		System.out.println("------------------------");
		for (int n = 0; n < datos.length; n++) {
			for (int m = 0; m < datos[0].length; m++) {
				System.out.print(datos[n][m] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}

	public static void main(String[] args) {
		int matriz[][] = new int[20][20];
		llenar(matriz);
		mostrar(matriz);
		rellenar(matriz, 4, 4, 8);
		mostrar(matriz);
	}
}
