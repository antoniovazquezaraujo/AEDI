package aed1.ordenacion.seleccion;

import aed1.commons.Tools;

public class Seleccion {
	public static void recorrer(int[][] aux) {
		for (int fila = 0; fila < aux.length; fila++) {
			for (int col = 0; col < aux[0].length; col++) {
				System.out.println("En la pos " + fila + ", " + col + " est�: "
						+ aux[fila][col]);
			}
		}
	}

	public static void sort(int[][] datos) {
		for (int fila = 0; fila < datos.length; fila++) {
			int filaMenor = fila;
			for (int col = 0; col < datos[0].length; col++) {
				int colMenor = col;
				for (int f = fila; f < datos.length; f++) {
					for (int c = col; c < datos[0].length; c++) {
						if (datos[f][c] < datos[filaMenor][colMenor]) {
							filaMenor = f;
							colMenor = c;
						}
					}
				}
				if (filaMenor != fila || colMenor != col) {
					int temp = datos[fila][col];
					datos[fila][col] = datos[filaMenor][colMenor];
					datos[filaMenor][colMenor] = temp;
				}
			}
		}
	}
}